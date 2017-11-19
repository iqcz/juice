package lambdasinaction.mydemo;

public class EndodeAndDecode {
    // <img height="413"
    // src="http://songshuhui.net/wp-content/uploads/2010/11/network.jpg"
    // width="739" alt="

    // %3Cimg+height%3D%22413%22+src%3D%22http%3A%2F%2Fsongshuhui.net%2Fwp-content%2Fuploads%2F2010%2F11%2Fnetwork.jpg%22+width%3D%22739%22+alt%3D%22

    public JSONObject handleDecode() {
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
		articleJson.put("title", URLEncoder.encode(title, "UTF-8").replace("+", "%20"));
		articleJson.put("txt", URLEncoder.encode(txt, "UTF-8").replace("+", "%20"));

		bodyJson.add(articleJson);
	    }
	}
	json.put("bodyList", bodyJson);

	String encodeJson = "";
	try {
	    encodeJson = URLEncoder.encode(json.toJSONString(), "UTF-8").replace("+", "%20");
	} catch (UnsupportedEncodingException e) {
	    log.error("文章字段encode出错.");
	    e.printStackTrace();
	}

	return encodeJson;
    }
}
