package com.lee.bsc.interceptor;

import java.util.List;

import org.apache.log4j.Logger;

import com.lee.bsc.BIException;
import com.lee.bsc.action.BIBaseAction;
import com.lee.bsc.action.LogoutAction;
import com.lee.bsc.action.MainMenuAction;
import com.lee.bsc.action.exception.NotAuthorizedAction;
import com.lee.bsc.action.uploading.FileUploadAction;
import com.lee.bsc.common.Constant;
import com.lee.bsc.db.bo.SecurityPermissions;
import com.lee.bsc.service.GeneralService;
import com.lee.bsc.service.PermissionService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PermissionInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4056101746979674182L;

	private static Logger logger = Logger.getLogger(PermissionInterceptor.class);
	
	private GeneralService generalService;
	
	private PermissionService permissionService;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		logger.info("***Action = " + invocation.getAction().getClass().getName());
		
		BIBaseAction action = (BIBaseAction) invocation.getAction();
		
		boolean isMainAction = action instanceof MainMenuAction ||
								action instanceof FileUploadAction ||
								action instanceof LogoutAction ||
								action instanceof NotAuthorizedAction;
		
		if(!isMainAction) {
			// 1. validate permission, redirect to main menu if no permission.
			
			try {
				List<SecurityPermissions> permissions = this.permissionService.getPermissions(null, true, action.getUser().getUserId());
				
				boolean flag = false;
				for(SecurityPermissions config : permissions) {
					logger.debug("Config action = " + config.getAction() + ", current action = " + action.getClass().getSimpleName());
					if(config.getAction().equals(action.getClass().getSimpleName())) {
						flag = true;
						break;
					}
				}
				
				if(!flag) {
					logger.error("No permission for action: " + action.getClass().getSimpleName());
					return Constant.BI_MAIN;
				} else {
					logger.debug("Permission check fro action :" + action.getClass().getSimpleName() + " passed");
				}
			} catch(BIException ex) {
				return Constant.BI_MAIN;
			}
		}
		
		// validation passed, continue to action.
		String result = invocation.invoke();
		return result;
	}

	public GeneralService getGeneralService() {
		return generalService;
	}

	public void setGeneralService(GeneralService generalService) {
		this.generalService = generalService;
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

}
