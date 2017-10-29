package com.howtoprogram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;

public class DeleteFiles {

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
		LOGGER.error("创建目录失败.");
		e.printStackTrace();
	    }
	}

	try {
	    // object for iterating through a directory's contents
	    Files.newDirectoryStream(path).forEach(csvFile -> {
		try {
		    if (!Files.isDirectory(csvFile)) {
			FileTime fileTime = Files.getLastModifiedTime(csvFile);
			Instant lastTenDays = Instant.now().minusSeconds(86400 * days); // 1天(d)=86400秒(s)
			if (csvFile.toString().contains(fileType)) {
			    if (fileTime.toInstant().isBefore(lastTenDays)) {
				LOGGER.info("Deleted file: " + csvFile);
				Files.deleteIfExists(csvFile);
			    }
			}
		    }
		} catch (IOException e) {
		    LOGGER.error("删除文件失败.");
		    e.printStackTrace();
		}
	    });
	} catch (IOException e) {
	    e.printStackTrace();
	}
    } // end method deletePreviousFiles

}