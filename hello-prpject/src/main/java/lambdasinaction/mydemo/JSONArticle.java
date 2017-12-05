package lambdasinaction.mydemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * @author i324779
 *         文章存在多P的情况,前端传递一个json结构字符串,每P之间添加分隔符,最后存成一个文本.
 *         从后台传递给前端时,做相反的操作,把一个文本使用分隔符分隔,最后组成json结构的字符串.
 *         因为存在特殊字符的问题,组装json对象会有问题,所以前端js使用encodeURI方法进行加密,
 *         Java使用URLDecoder进行解密.
 *         相反,后台一个文本需要转化为json对象,在转换过程中,存在特殊字符的问题,
 *         需要Java使用URLEncoder进行加密,到前端使用decodeURIComponent解密.
 *         这里有个问题,需要对txt和title先加密,如果不加密的话,『"』会转义为『\"』,
 *         然后再对整个json进行加密,如果不对整个json再加密的话,还会出现『"』会转义为『\"』的情况.
 *         前端需要解密两次.
 */
public class JSONArticle {
    private static final Logger log = LoggerFactory.getLogger(JSONArticle.class);

    private static final String ENCODE_SPACE = "%20";
    private static final String UTF_8 = "UTF-8";
    private static String PAGE_START = "[NextPage]";
    private static String PAGE_END = "[/NextPage]";

    /**
     * 转换包含多P文章列表的 json 结构字符串,最后合为一个字符串
     *
     * @param bodyList 文章(包含多P)的json结构的字符串
     * @return 多P文章合为一个字符串
     */
    public static String flatArticleList(String bodyList) throws UnsupportedEncodingException {
	bodyList = bodyList.replaceAll("&quot;", "\"");
	StringBuilder flattedArticles = new StringBuilder();

	// 字符串转换为json对象
	JSONObject jsonObject = JSON.parseObject(bodyList);
	JSONArray articles = jsonObject.getJSONArray("bodyList");

	for (int i = 0; i < articles.size(); i++) {
	    JSONObject article = articles.getJSONObject(i);
	    // 序号
	    String orderId = article.getString("orderId");
	    // 文章标题
	    String title = URLDecoder.decode(article.getString("title"), UTF_8);
	    // 文章正文
	    String txt = URLDecoder.decode(article.getString("txt"), UTF_8);

	    if (!Strings.isNullOrEmpty(txt)) {
		flattedArticles.append(txt).append(PAGE_START).append(title).append(PAGE_END);
	    }
	}
	
	// TODO 需要考虑没有分P的情况 也需要拼成json结构，只不过是没有标题和排序

	return flattedArticles.toString();
    } // end method flatArticleList

    /**
     * 把文章（包括多P）字符串, 转换成json结构的字符串.
     * 注意,加密了两次
     *
     * @param articles 文章内容
     * @return 两次加密后的json结构字符串
     * @throws UnsupportedEncodingException
     */
    public static String transferArticleJson(String articles) throws UnsupportedEncodingException {
	JSONObject json = new JSONObject();
	JSONArray bodyJson = new JSONArray();

	Iterable<String> values = Splitter.on(PAGE_END).omitEmptyStrings().split(articles);
	Iterator<String> iterator = values.iterator();

	for (int i = 0; iterator.hasNext(); i++) {
	    String article = iterator.next();

	    int index = article.indexOf(PAGE_START);
	    if (index != -1) {
		JSONObject articleJson = new JSONObject();
		String txt = article.substring(0, index);
		String title = article.substring(index + PAGE_START.length());

		articleJson.put("orderId", i);
		// Java加密会把空格转化为『+』,在这里做替换.
		articleJson.put("title", URLEncoder.encode(title, UTF_8).replace("+", ENCODE_SPACE));
		articleJson.put("txt", URLEncoder.encode(txt, UTF_8).replace("+", ENCODE_SPACE));

		bodyJson.add(articleJson);
	    }
	}
	json.put("bodyList", bodyJson);

	return URLEncoder.encode(json.toJSONString(), UTF_8).replace("+", ENCODE_SPACE);
    } // end method transferArticleJson
} // end method JSONArticle