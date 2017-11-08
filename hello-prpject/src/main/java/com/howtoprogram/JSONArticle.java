package com.howtoprogram;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.jeecms.cms.action.member.ContributeAct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Map;

/**
 * @author i324779
 *         <p>
 *         文章存在多P的情况,前端传递一个json结构的数组,每P之间添加分隔符,最后存成一个文本.
 *         从后台传递给前端时,做相反的操作,把一个文本使用分隔符分隔,最后组成json结构的数组.
 *         因为前端传递的文本有很多特殊字符，例如英文的双引号，导致解析JSON失败，
 *         所以前端先用encodeUIR()方法对文本进行编码，
 *         后台再解码。
 */
public class JSONArticle {
    private static final Logger log = LoggerFactory.getLogger(JSONArticle.class);

    public static void main(String[] args) throws UnsupportedEncodingException {
	String body = "{\"bodyList\":[{\"txt\":\"<p> </p>\\r\\n<p>（1）网络（另一个很难取舍的名字是病毒） </p>\\r\\n<p>  <img height=\\\"413\\\" src=\\\"http://songshuhui.net/wp-content/uploads/2010/11/network.jpg\\\" width=\\\"739\\\" alt=\\\"\\\" />   </p>\\r\\n<p>悬停标题：“配合杀毒软件使用效果更佳”</p>\\r\\n<p> </p>\\r\\n<p>汉化注：悬停标题，是欧美漫画作者在作品中隐藏彩蛋的一种方式，一般是一段只有将鼠标在图片上稍微悬停才会出现的隐藏文字。也就是说藏在漫画后面等你看完之后发现的文字（tucao）。你能想象许多精彩的包袱就被这么埋没，是一件多么奢侈的事情吗？只是限于转载网站功能，汉化组将标题翻译后放在漫画下边，虽然比起原版，这不够酷~~~~~~~~~~~~</p>\\r\\n<p> </p>\\r\\n<p>原作：<a href=\\\"http://xkcd.com/350/\\\" rel=\\\"nofollow\\\">XKCD</a></p>\\r\\n<p>汉化：Ent</p>\\r\\n<p>xkcd是由美国网络漫画家兰德尔·门罗创作的系列漫画，其衍生作品还包括What if系列，都发布在作者的网站：xkcd.com。科学松鼠会在遵守作者要求的情况下，定期发布志愿者编译的作品。感谢门罗，感谢译者，感谢xkcd让你永远想不到的下一个笑点。</p>\\r\\n<p>科学松鼠会：http://songshuhui.net/</p>\\r\\n<p> </p>\\r\\n<p> \",\"orderId\":0,\"title\":\"（1）网络（另一个很难取舍的名字是病毒）\"},{\"txt\":\"</p>\\r\\n<p> </p>\\r\\n<p>（2）玻璃项链</p>\\r\\n<p><img height=\\\"602\\\" src=\\\"http://songshuhui.net/wp-content/uploads/2010/11/the_glass_necklace.jpg\\\" width=\\\"490\\\" alt=\\\"\\\" />”好看，而且增加25%的闪电魔法伤害。“</p>\\r\\n<p>悬停标题：“可你却说这只是玻璃而已”</p>\\r\\n<p>汉化注：悬停标题，是欧美漫画作者在作品中隐藏彩蛋的一种方式，一般是一小段只有将鼠标在图片上稍微悬停才会出现的隐藏文字。也就是说藏在漫画后面等你看完 之后发现的文字（tucao）。你能想象许多精彩的包袱就被这么埋没，是一件多么奢侈的事情吗？只是限于转载网站功能，汉化组将标题翻译后放在漫画下边， 虽然比起原版，这不够酷~~~~~~~~~~~~</p>\\r\\n<p> </p>\\r\\n<p> \",\"orderId\":1,\"title\":\"（2）[科学追女]玻璃项链\"},{\"txt\":\"</p>\\r\\n<p> </p>\\r\\n<p>（3）量纲分析</p>\\r\\n<p><img height=\\\"524\\\" src=\\\"http://songshuhui.net/wp-content/uploads/2010/11/dimensional_analysis1.png\\\" width=\\\"544\\\" alt=\\\"\\\" /></p>\\r\\n<p>悬停标题：“也可能是地心的压强会略微上升”</p>\\r\\n<p> </p>\\r\\n<p>注：量纲分析（dimensional analysis）：指的是一物理量的单位，分解为基本物理单位，相乘后所得的乘积。这些基本物理单位并不必然采用国际单位制或者其他单位制，而是可以用 抽象符号来表示。这些基本物理单位包括了长度、时间、质量、温度、电流、光强度、物质的量。</p>\\r\\n<p> </p>\\r\\n<p>汉化注：悬停标题，是欧美漫画作者在作品中隐藏彩蛋的一种方式，一般是一小段只有将鼠标在图片上稍微悬停才会出现的隐藏文字。也就是说藏在漫画后面等你看完 之后发现的文字（tucao）。你能想象许多精彩的包袱就被这么埋没，是一件多么奢侈的事情吗？只是限于转载网站功能，汉化组将标题翻译后放在漫画下边， 虽然比起原版，这不够酷~~~~~~~~~~~~</p>\\r\\n<p>\",\"orderId\":2,\"title\":\"（3）量纲分析\"}]}";
	// System.out.println(JSONArticle.flatArticleList(body));
	// System.out.println(JSONArticle.flatArticleList1(body));

	String url = "%3Cp%3E%20%3C/p%3E%0D%0A%3Cp%3E%EF%BC%881%EF%BC%89%E7%BD%91%E7%BB%9C%EF%BC%88%E5%8F%A6%E4%B8%80%E4%B8%AA%E5%BE%88%E9%9A%BE%E5%8F%96%E8%88%8D%E7%9A%84%E5%90%8D%E5%AD%97%E6%98%AF%E7%97%85%E6%AF%92%EF%BC%89%20%3C/p%3E%0D%0A%3Cp%3E%20%20%3Cimg%20height=%22413%22%20src=%22http://songshuhui.net/wp-content/uploads/2010/11/network.jpg%22%20width=%22739%22%20alt=%22%22%20/%3E%20%20%20%3C/p%3E%0D%0A%3Cp%3E%E6%82%AC%E5%81%9C%E6%A0%87%E9%A2%98%EF%BC%9A%E2%80%9C%E9%85%8D%E5%90%88%E6%9D%80%E6%AF%92%E8%BD%AF%E4%BB%B6%E4%BD%BF%E7%94%A8%E6%95%88%E6%9E%9C%E6%9B%B4%E4%BD%B3%E2%80%9D%3C/p%3E%0D%0A%3Cp%3E%20%3C/p%3E%0D%0A%3Cp%3E%E6%B1%89%E5%8C%96%E6%B3%A8%EF%BC%9A%E6%82%AC%E5%81%9C%E6%A0%87%E9%A2%98%EF%BC%8C%E6%98%AF%E6%AC%A7%E7%BE%8E%E6%BC%AB%E7%94%BB%E4%BD%9C%E8%80%85%E5%9C%A8%E4%BD%9C%E5%93%81%E4%B8%AD%E9%9A%90%E8%97%8F%E5%BD%A9%E8%9B%8B%E7%9A%84%E4%B8%80%E7%A7%8D%E6%96%B9%E5%BC%8F%EF%BC%8C%E4%B8%80%E8%88%AC%E6%98%AF%E4%B8%80%E6%AE%B5%E5%8F%AA%E6%9C%89%E5%B0%86%E9%BC%A0%E6%A0%87%E5%9C%A8%E5%9B%BE%E7%89%87%E4%B8%8A%E7%A8%8D%E5%BE%AE%E6%82%AC%E5%81%9C%E6%89%8D%E4%BC%9A%E5%87%BA%E7%8E%B0%E7%9A%84%E9%9A%90%E8%97%8F%E6%96%87%E5%AD%97%E3%80%82%E4%B9%9F%E5%B0%B1%E6%98%AF%E8%AF%B4%E8%97%8F%E5%9C%A8%E6%BC%AB%E7%94%BB%E5%90%8E%E9%9D%A2%E7%AD%89%E4%BD%A0%E7%9C%8B%E5%AE%8C%E4%B9%8B%E5%90%8E%E5%8F%91%E7%8E%B0%E7%9A%84%E6%96%87%E5%AD%97%EF%BC%88tucao%EF%BC%89%E3%80%82%E4%BD%A0%E8%83%BD%E6%83%B3%E8%B1%A1%E8%AE%B8%E5%A4%9A%E7%B2%BE%E5%BD%A9%E7%9A%84%E5%8C%85%E8%A2%B1%E5%B0%B1%E8%A2%AB%E8%BF%99%E4%B9%88%E5%9F%8B%E6%B2%A1%EF%BC%8C%E6%98%AF%E4%B8%80%E4%BB%B6%E5%A4%9A%E4%B9%88%E5%A5%A2%E4%BE%88%E7%9A%84%E4%BA%8B%E6%83%85%E5%90%97%EF%BC%9F%E5%8F%AA%E6%98%AF%E9%99%90%E4%BA%8E%E8%BD%AC%E8%BD%BD%E7%BD%91%E7%AB%99%E5%8A%9F%E8%83%BD%EF%BC%8C%E6%B1%89%E5%8C%96%E7%BB%84%E5%B0%86%E6%A0%87%E9%A2%98%E7%BF%BB%E8%AF%91%E5%90%8E%E6%94%BE%E5%9C%A8%E6%BC%AB%E7%94%BB%E4%B8%8B%E8%BE%B9%EF%BC%8C%E8%99%BD%E7%84%B6%E6%AF%94%E8%B5%B7%E5%8E%9F%E7%89%88%EF%BC%8C%E8%BF%99%E4%B8%8D%E5%A4%9F%E9%85%B7~~~~~~~~~~~~%3C/p%3E%0D%0A%3Cp%3E%20%3C/p%3E%0D%0A%3Cp%3E%E5%8E%9F%E4%BD%9C%EF%BC%9A%3Ca%20href=%22http://xkcd.com/350/%22%20rel=%22nofollow%22%3EXKCD%3C/a%3E%3C/p%3E%0D%0A%3Cp%3E%E6%B1%89%E5%8C%96%EF%BC%9AEnt%3C/p%3E%0D%0A%3Cp%3Exkcd%E6%98%AF%E7%94%B1%E7%BE%8E%E5%9B%BD%E7%BD%91%E7%BB%9C%E6%BC%AB%E7%94%BB%E5%AE%B6%E5%85%B0%E5%BE%B7%E5%B0%94%C2%B7%E9%97%A8%E7%BD%97%E5%88%9B%E4%BD%9C%E7%9A%84%E7%B3%BB%E5%88%97%E6%BC%AB%E7%94%BB%EF%BC%8C%E5%85%B6%E8%A1%8D%E7%94%9F%E4%BD%9C%E5%93%81%E8%BF%98%E5%8C%85%E6%8B%ACWhat%20if%E7%B3%BB%E5%88%97%EF%BC%8C%E9%83%BD%E5%8F%91%E5%B8%83%E5%9C%A8%E4%BD%9C%E8%80%85%E7%9A%84%E7%BD%91%E7%AB%99%EF%BC%9Axkcd.com%E3%80%82%E7%A7%91%E5%AD%A6%E6%9D%BE%E9%BC%A0%E4%BC%9A%E5%9C%A8%E9%81%B5%E5%AE%88%E4%BD%9C%E8%80%85%E8%A6%81%E6%B1%82%E7%9A%84%E6%83%85%E5%86%B5%E4%B8%8B%EF%BC%8C%E5%AE%9A%E6%9C%9F%E5%8F%91%E5%B8%83%E5%BF%97%E6%84%BF%E8%80%85%E7%BC%96%E8%AF%91%E7%9A%84%E4%BD%9C%E5%93%81%E3%80%82%E6%84%9F%E8%B0%A2%E9%97%A8%E7%BD%97%EF%BC%8C%E6%84%9F%E8%B0%A2%E8%AF%91%E8%80%85%EF%BC%8C%E6%84%9F%E8%B0%A2xkcd%E8%AE%A9%E4%BD%A0%E6%B0%B8%E8%BF%9C%E6%83%B3%E4%B8%8D%E5%88%B0%E7%9A%84%E4%B8%8B%E4%B8%80%E4%B8%AA%E7%AC%91%E7%82%B9%E3%80%82%3C/p%3E%0D%0A%3Cp%3E%E7%A7%91%E5%AD%A6%E6%9D%BE%E9%BC%A0%E4%BC%9A%EF%BC%9Ahttp://songshuhui.net/%3C/p%3E%0D%0A%3Cp%3E%20%3C/p%3E%0D%0A%3Cp%3E";
	String urlStr = URLDecoder.decode(url, "UTF-8");
	System.out.println(urlStr);
    }

    /**
     * @param articles
     * @return
     */
    public static String transferArticleJson(String articles) {
	JSONObject json = new JSONObject();
	JSONArray bodyJson = new JSONArray();

	Iterable<String> values = Splitter.on(VideoUtil.PAGE_END).omitEmptyStrings().split(articles);
	Iterator<String> iterator = values.iterator();

	for (int i = 0; iterator.hasNext(); i++) {
	    String article = iterator.next();

	    int index = article.indexOf(VideoUtil.PAGE_START);
	    if (index != -1) {
		JSONObject articleJson = new JSONObject();
		String txt = article.substring(0, index);
		String title = article.substring(index + VideoUtil.PAGE_START.length());

		articleJson.put("orderId", i);
		articleJson.put("title", title);
		articleJson.put("txt", txt);
		bodyJson.add(articleJson);
	    }
	}
	json.put("bodyList", bodyJson);

	return json.toJSONString();
    } // end method transferArticleJson

    /**
     * @param bodyList
     * @return
     */
    public static String flatArticleList(String bodyList) {
	bodyList = bodyList.replaceAll("&quot;", "\"");
	StringBuilder flattedArticles = new StringBuilder();

	bodyList = CharMatcher.BREAKING_WHITESPACE.replaceFrom(bodyList, "");

	JSONObject jsonObject = JSON.parseObject(bodyList);
	JSONArray articles = jsonObject.getJSONArray("bodyList");
	System.out.println(articles);

	for (int i = 0; i < articles.size(); i++) {
	    JSONObject article = articles.getJSONObject(i);
	    String orderId = article.getString("orderId");
	    String title = "";
	    String txt = "";
	    try {
		title = URLDecoder.decode(article.getString("title"), "UTF-8");
		txt = URLDecoder.decode(article.getString("txt"), "UTF-8");
	    } catch (UnsupportedEncodingException e) {
		log.error("文章字段decode出错.");
	    }

	    flattedArticles.append(txt).append(VideoUtil.PAGE_START).append(title).append(VideoUtil.PAGE_END);
	}

	return flattedArticles.toString();

    } // end method flatArticleList

    public static String flatArticleList1(String bodyList) {
	// bodyList = bodyList.replaceAll("&quot;", "\"");
	StringBuilder flattedArticles = new StringBuilder();

	bodyList = CharMatcher.BREAKING_WHITESPACE.replaceFrom(bodyList, ' ');

	org.json.JSONObject jsonObject = new org.json.JSONObject(bodyList);
	org.json.JSONArray articles = jsonObject.getJSONArray("bodyList");
	System.out.println(articles);

	for (int i = 0; i < articles.length(); i++) {
	    org.json.JSONObject article = articles.getJSONObject(i);
	    // String orderId = article.getString("orderId");
	    String title = article.getString("title");
	    String txt = article.getString("txt");

	    flattedArticles.append(txt).append(VideoUtil.PAGE_START).append(title).append(VideoUtil.PAGE_END);
	}

	return flattedArticles.toString();
    } // end method flatArticleList
} // end method JSONArticle
