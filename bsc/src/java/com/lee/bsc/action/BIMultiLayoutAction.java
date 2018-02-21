package com.lee.bsc.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lee.bsc.bean.ErrorMessage;
import com.lee.bsc.bean.enumeration.EnumErrorLocation;
import com.lee.util.CollectionUtil;

public class BIMultiLayoutAction extends BIBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -372993698615427306L;

	private Map<EnumErrorLocation, List<ErrorMessage>> locationErrors = new HashMap<EnumErrorLocation, List<ErrorMessage>>();

	@Override
	public void convertErrors(List<ErrorMessage> list) {
		super.convertErrors(list);

		if (CollectionUtil.isValid(list)) {
			for (ErrorMessage em : list) {
				// set error message
				if (null != em) {
					if (null == em.getParams() || 0 == em.getParams().length) {
						em.setErrorMsg(super.getErrorMessage(em.getErrorCode()));
					} else {
						em.setErrorMsg(super.getErrorMessage(em.getErrorCode(), em.getParams()));
					}

					List<ErrorMessage> errorList = null;
					EnumErrorLocation key = em.getErrorLocation();

					// add error to specific location
					if (key != EnumErrorLocation.NONE) {
						if (locationErrors.containsKey(key)) {
							errorList = locationErrors.get(key);
							errorList.add(em);
						} else {
							errorList = new ArrayList<ErrorMessage>();
							errorList.add(em);
							locationErrors.put(key, errorList);
						}
					}
				}
			}

		}
	}

	/**
	 * <tt>getTopErrors</tt> get top page errors.
	 * 
	 * @return
	 */
	public List<ErrorMessage> getTopErrors() {
		List<ErrorMessage> topErrors = locationErrors.get(EnumErrorLocation.Top);

		if (!CollectionUtil.isValid(topErrors)) {
			topErrors = new ArrayList<ErrorMessage>();
		}

		return topErrors;
	}

	/**
	 * <tt>getMiddleErrors</tt> get middle page errors.
	 * 
	 * @return
	 */
	public List<ErrorMessage> getMiddleErrors() {
		List<ErrorMessage> middleErrors = locationErrors.get(EnumErrorLocation.Middle);

		if (!CollectionUtil.isValid(middleErrors)) {
			middleErrors = new ArrayList<ErrorMessage>();
		}

		return middleErrors;
	}

	/**
	 * <tt>geBottomErrors</tt> get Bottom page errors.
	 * 
	 * @return
	 */
	public List<ErrorMessage> getBottomErrors() {
		List<ErrorMessage> bottomErrors = locationErrors.get(EnumErrorLocation.Bottom);

		if (!CollectionUtil.isValid(bottomErrors)) {
			bottomErrors = new ArrayList<ErrorMessage>();
		}

		return bottomErrors;
	}

	/**
	 * whether top page has errors
	 * 
	 * @return true if has, false else.
	 */
	public boolean hasTopErrors() {
		return !getTopErrors().isEmpty();
	}

	/**
	 * whether middle page has errors
	 * 
	 * @return true if has, false else.
	 */
	public boolean hasMiddleErrors() {
		return !getMiddleErrors().isEmpty();
	}

	/**
	 * whether bottom page has errors
	 * 
	 * @return true if has, false else.
	 */
	public boolean hasBottomErrors() {
		return !getBottomErrors().isEmpty();
	}

	public boolean hasLocationErrors() {
		return CollectionUtil.isValid(locationErrors);
	}

}
