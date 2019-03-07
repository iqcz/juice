package crazy.thread;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {

    public static final int THREAD_COUNT = 50; // how to evaluate this thread number?

    /**
     * 从文件中读取要更新的content id，然后使用线程池对content id 进行数据库的更新。
     */
//    public static void runMultiThread() {
//	long begin = System.currentTimeMillis();
//	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(THREAD_COUNT);
//	try {
//	    URL url = getClass().getClassLoader().getResource(fileName);
//	    String[] contentIds = Files.toString(new File(url.getFile()), Charset.forName("UTF-8")).split("\n");
//	    for (int i = 0; i < contentIds.length; i++) {
//		logger.info("-------------id:" + contentIds[i] + "-----");
//		String vId = contentIds[i];
//		fixedThreadPool.execute(new Runnable() {
//		    @Override
//		    public void run() {
//			long start = System.currentTimeMillis();
//			UpdateResult result = Util.update(vId, null, null, null, null, "normal");
//			long cost = System.currentTimeMillis() - start;
//			logger.info("updated youku id:{},cost:{} ms", result.getVideoId(), cost);
//		    }
//		});
//	    }
//	} catch (IOException e) {
//	    e.printStackTrace();
//	    logger.error("update error e:{}", e.getMessage());
//	}
//	logger.info("update task finished cost:{} ms", System.currentTimeMillis() - begin);
//    }
}
