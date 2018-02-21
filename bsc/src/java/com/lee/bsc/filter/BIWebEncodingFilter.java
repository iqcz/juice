package com.lee.bsc.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.FilterDispatcher;


import com.lee.bsc.common.Constant;
import com.lee.util.StringUtil;

public class BIWebEncodingFilter extends FilterDispatcher {

	private static String PARAM_ENCODING = "encoding";

	private String encoding = Constant.DEFAULT_ENCODING;

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		request.setCharacterEncoding(encoding);
		
		super.doFilter(req, resp, chain);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);

		if (!StringUtil.isEmpty(filterConfig.getInitParameter(PARAM_ENCODING))) {
			encoding = filterConfig.getInitParameter(PARAM_ENCODING);
		}
	}

}
