package com.lee.bsc.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.lee.bsc.bean.MainMenuBean;
import com.lee.bsc.db.bo.SecurityPermissions;
import com.lee.bsc.service.GeneralService;
import com.lee.bsc.service.PermissionService;

public class MainMenuAction extends BIBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -570254742145667132L;

	private static Logger logger = Logger.getLogger(MainMenuAction.class);

	private boolean disableSecurity = false;

	private boolean disableEstimationConfig = false;

	private boolean disableGroupMaintain = false;

	private boolean disableAll = false;

	private MainMenuBean mmbean = new MainMenuBean();

	private PermissionService permissionService;

	private GeneralService generalService;

	@Override
	public String execute() throws Exception {
		logger.debug("***MainMenuAction executed success.");

		return SUCCESS;
	}

	@Override
	public void validate() {
		logger.debug("Start to validate user permission.");
		super.validate();

		if (super.hasErrors()) {
			logger.error("Failed to get permission, so disable all buttons in the main page.");
			disableAll = true;
		} else {
			try {
				/*
				 * if (isBatchRunning()) { logger.error(
				 * "Batch is running, so disable all the buttons in the main page."
				 * ); addActionError(getText("sysError.1009")); disableAll =
				 * true; } if(isInactive()) { logger.error(
				 * "The user is disabled, so disable all buttons in main page."
				 * ); addActionError(getText("sysError.1009")); disableAll =
				 * true; }
				 */
			} catch (Exception e) {

			}
		}

		logger.debug("Finish to validate user permission.");
	}

	@Override
	public void init() {
		logger.debug("Init: " + this.getClass());
		super.init();

		/*
		try {
			List<SecurityPermissions> permissions = permissionService.getPermissions(null, true, this.getUser()
					.getUserId());
			for (SecurityPermissions sp : permissions) {
				mmbean.setPermission(sp.getAction(), true);
			}
		} catch (Exception e) {

		}
		 */
	}

	// isBatchRunning
	// isInactive

	public boolean isDisableSecurity() {
		return disableSecurity;
	}

	public boolean isDisableEstimationConfig() {
		return disableEstimationConfig;
	}

	public boolean isDisableGroupMaintain() {
		return disableGroupMaintain;
	}

	public boolean isDisableAll() {
		return disableAll;
	}

	public MainMenuBean getMmbean() {
		return mmbean;
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public GeneralService getGeneralService() {
		return generalService;
	}

	public void setDisableSecurity(boolean disableSecurity) {
		this.disableSecurity = disableSecurity;
	}

	public void setDisableEstimationConfig(boolean disableEstimationConfig) {
		this.disableEstimationConfig = disableEstimationConfig;
	}

	public void setDisableGroupMaintain(boolean disableGroupMaintain) {
		this.disableGroupMaintain = disableGroupMaintain;
	}

	public void setDisableAll(boolean disableAll) {
		this.disableAll = disableAll;
	}

	public void setMmbean(MainMenuBean mmbean) {
		this.mmbean = mmbean;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public void setGeneralService(GeneralService generalService) {
		this.generalService = generalService;
	}

}
