package com.lee.util;

import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.builder.StandardToStringStyle;
import org.apache.commons.lang3.builder.ToStringStyle;

public class StringUtil {

    private static final String EMPTY_STRING = "";
    private static final String DEFAULT_DELIMETRE = "-";
    private static final int DEFAULT_MIN_INDEX = 0;
    private static final String SPACE = " ";
    private static final String DATE_PATTERN = "yyyyMMdd";
    private static StandardToStringStyle style;

    public static ToStringStyle getToStringStyle() {
	if (null == style) {
	    style = new StandardToStringStyle();

	    style.setUseShortClassName(true);
	    style.setFieldNameValueSeparator("=");
	    style.setFieldSeparator(SystemUtils.LINE_SEPARATOR + SPACE);
	    style.setFieldSeparatorAtStart(true);
	    style.setContentStart("[");
	    style.setContentEnd(SystemUtils.LINE_SEPARATOR + "}");
	}
	return style;
    }

    /** use apache commons or google guava framework
     * 
     * @param target
     * @return
     */
    @Deprecated
    public static boolean isEmpty(String target) {
	return null == target || 0 == target.trim().length() ? true : false;
    }

}
