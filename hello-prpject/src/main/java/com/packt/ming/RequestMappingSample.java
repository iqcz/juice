package com.packt.ming;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiYanxue
 * Created on 2018-08-23
 */
public class RequestMappingSample {
/*
    @RequestMapping(value = "/user/getApprovedContentCount.aspx", method = RequestMethod.GET)
    public void getApprovedContentCount(@RequestParam(defaultValue = "0") int userId, HttpServletResponse response) {
        logger.info("获取用户过审稿件数量.");
        int count = contentMng.getApprovedContentCount(userId);
        Map<String, Object> data = new HashMap<>();
        data.put("result", 0);
        data.put("count", count);
        data.put("error_msg", "");
        try {
            ResponseUtils.renderJson(response, JSON.json(data));
        } catch (IOException e) {
            logger.error("获取用户过审稿件数量发生异常.");
        }
    }
    */
}
