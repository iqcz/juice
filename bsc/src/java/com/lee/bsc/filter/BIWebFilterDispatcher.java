package com.lee.bsc.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts2.dispatcher.FilterDispatcher;


public class BIWebFilterDispatcher extends FilterDispatcher {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
			ServletException {
		super.doFilter(req, resp, chain);
	}

}
