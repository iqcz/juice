/**
 * 删除最近修改时间在10天之前的文件
 */
private void deletePreviousFiles() {
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
                    Instant lastTenDays = Instant.now().minusSeconds(86400 * 10); // 1天(d)=86400秒(s)
                    if (csvFile.toString().contains(".csv")) {
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

