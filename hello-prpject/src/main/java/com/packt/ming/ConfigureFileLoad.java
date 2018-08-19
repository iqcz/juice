package com.packt.ming;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LiYanxue
 * Created on 2018-08-19
 */
public class ConfigureFileLoad {

    private static Logger logger = LoggerFactory.getLogger(ConfigureFileLoad.class);

    /**
     * 从配置文件中读取日志存放路径.
     *
     * @return
     */
    private String loadLogPath() {
        InputStream inputStream = ConfigureFileLoad.class
                .getResourceAsStream("/config/system.properties");
        Properties props = new Properties();
        try {
            props.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error("Occur error when load system.properties.");
            e.printStackTrace();
        }

        return props.getProperty("sensitiveWord.log.path");
    } // end method loadLogPath
}
