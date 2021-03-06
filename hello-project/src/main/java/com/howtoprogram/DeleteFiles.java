package com.howtoprogram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;

/**
 * @author i324779
 */
public class DeleteFiles {

    private static final int SECONDS_OF_DAY = 86400;

    // TODO 添加log jar包。
    /**
     * 删除最近修改时间在10天之前的文件
     * 可以指定删除文件的类型
     * 以及删除文件的时间
     *
     * @param fileType 要删除的文件类型
     * @param days     指定要删除几天之前的天数
     */
    private void deletePreviousFiles(final String fileType, int days) {
        Path path = Paths.get("ContentStatistics");

        // 创建目录
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // object for iterating through a directory's contents
            Files.newDirectoryStream(path).forEach(csvFile -> {
                try {
                    if (!Files.isDirectory(csvFile)) {
                        FileTime fileTime = Files.getLastModifiedTime(csvFile);
                        // 1天(d)=86400秒(s)
                        Instant lastTenDays = Instant.now().minusSeconds(SECONDS_OF_DAY * days);
                        if (csvFile.toString().contains(fileType)) {
                            if (fileTime.toInstant().isBefore(lastTenDays)) {
                                Files.deleteIfExists(csvFile);
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // end method deletePreviousFiles

}