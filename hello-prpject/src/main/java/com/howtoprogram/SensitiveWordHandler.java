package com.howtoprogram;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;

/**
 * @author LiYanxue
 * Created on 2018-09-03
 */
public class SensitiveWordHandler {

    /**
     * 检测文本中是否包含敏感词,并放到JSON中.
     *
     * @param sensitiveWordJson 包含有敏感词的JSON对象
     * @param text              需要检查是否包含敏感词的文本
     * @param sensitivities     所有敏感词列表
     * @param jsonKey           指定是标题,标签,简介还是文章正文中包含了敏感词
     */
    public void findSensitiveWord(JSONObject sensitiveWordJson, String text,
            List<Map<String, String>> sensitivities, String jsonKey) {
        if (!Strings.isNullOrEmpty(text)) {
            List<String> titleSensitiveWord = sensitivities.stream()
                    .parallel()
                    .filter(cms -> text.contains(cms.get("SensitiveWord"))) // 敏感词
                    .map(sw -> sw.get("SensitiveWord"))
                    .distinct()
                    .collect(Collectors.toList());

            JSONArray arr = sensitiveWordJson.getJSONArray(jsonKey);
            if (null == arr) {
                arr = new JSONArray();
            }

            arr.addAll(titleSensitiveWord);

            if (!arr.isEmpty()) {
                sensitiveWordJson.put(jsonKey, arr);
            }
        }
    } // end method findSensitiveWord
}
