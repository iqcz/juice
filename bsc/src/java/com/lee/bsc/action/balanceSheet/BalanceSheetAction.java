package com.lee.bsc.action.balanceSheet;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lee.bsc.BIException;
import com.lee.bsc.action.BIBaseAction;
import com.lee.bsc.bean.SearchPageBean;
import com.lee.bsc.common.Constant;
import com.lee.bsc.db.bo.BalanceSheet;
import com.lee.bsc.service.BalanceSheetService;

public class BalanceSheetAction extends BIBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 433917146546398164L;

	private static Logger logger = Logger.getLogger(BalanceSheetAction.class);

	private BalanceSheetService balanceSheetService;

	public BalanceSheetService getBalanceSheetService() {
		return balanceSheetService;
	}

	public void setBalanceSheetService(BalanceSheetService balanceSheetService) {
		this.balanceSheetService = balanceSheetService;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 
	 * @param searchPageBean
	 * @return
	 */
	public String getAllBalanceSheet(SearchPageBean searchPageBean) {
		logger.debug("get all balance sheet.");

		String loginId = searchPageBean.getUserBean().getUserId();

		try {
			List<BalanceSheet> list = balanceSheetService.getAllBalanceSheet(loginId);
			searchPageBean.setPageRecords(list);
		} catch (BIException ex) {
			this.handleException(ex);
		}
		if (this.hasActionErrors()) {
			return ERROR;
		}

		logger.debug("end to run.");

		return SUCCESS;
	}

	public String maintainBalanceSheet(SearchPageBean searchPageBean) {
		logger.debug("start");

		Map<String, String> conditions = searchPageBean.getConditions();
		String operation = conditions.get("operation");
		String seqNo = conditions.get("seqNo");
		// ...

		BalanceSheet bs = new BalanceSheet();
		bs.setSeqNo(Integer.parseInt(seqNo.equals(Constant.EMPTY) ? "0" : seqNo));
		// bs.set
		bs.setUpdateUserId(searchPageBean.getUserBean().getUserId());

		try {
			operateBalanceSheet(operation, bs);
		} catch (BIException biEx) {
			this.handleException(biEx);
			return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

		logger.debug("end");
		return SUCCESS;
	}

	/**
	 * 
	 * @param operation
	 * @param balanceSheet
	 * @throws BIException
	 */
	private void operateBalanceSheet(String operation, BalanceSheet balanceSheet) throws BIException {
		if (Constant.OPERATE_TYPE_ADD.equalsIgnoreCase(operation)) {
			balanceSheetService.addBalanceSheet(balanceSheet);
		} else if (Constant.OPERATE_TYPE_UPDATE.equalsIgnoreCase(operation)) {
			balanceSheetService.updateBalanceSheet(balanceSheet);
		} else if (Constant.OPERATE_TYPE_DELETE.equalsIgnoreCase(operation)) {
			balanceSheetService.deleteBalanceSheet(balanceSheet);
		}
	}

	/**
	 * Exception may contain error or warning, need to separately handle them.
	 * 
	 * @param ex
	 */
	private void handleException(BIException ex) {
		if (null == ex) {
			return;
		}

		if (0 == ex.getErrorLevel()) {
			// error message.
			super.addActionError(ex.getErrorCode());
		} else if (1 == ex.getErrorLevel()) {
			// warning message.
			super.addActionMessage(ex.getErrorCode());
		}
	}

}
