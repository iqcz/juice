package concurrency;

/**
 *
 * 使用多线程查询数据，不保证比单线程要快，没有进行过严格测试。
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.mysql.jdbc.Statement;

public class MultiQueryData {

    public static void main(String[] args) {
        Instant allVideosTimeStart = Instant.now();
        long start = System.currentTimeMillis();

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("AvailableProcessors: " + availableProcessors);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(availableProcessors, 100, 200,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));

        System.out.println("activeCountMain1 : " + Thread.activeCount());

        for (int i = 1; i <= 100; i++) {
            MySQL mysql = new MySQL(i);
            executor.execute(mysql);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目："
                    + executor.getQueue().size() + "，已执行完别的任务数目："
                    + executor.getCompletedTaskCount());
        }
        executor.shutdown();
        while (true) {
            if (executor.getActiveCount() == 0) {
                break;
            }
        }
        System.out.println("activeCountMain2 : " + Thread.activeCount());
        long end = System.currentTimeMillis();
        System.out.println("平均每秒可输出: " + 100000 / (end - start) + " 条");

        Instant allVideosTimeEnd = Instant.now();
        System.out.println("审核所有的视频所花费的时间：{}毫秒。"
                + Duration.between(allVideosTimeStart, allVideosTimeEnd).toMillis());
    }
}

class MySQL implements Runnable {

    private Connection con = null;
    private final int taskNum;

    public MySQL(int taskNum) {
        this.taskNum = taskNum;
    }

    private Statement openConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://";
        String username = "root";
        String password = "root";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            return (Statement) con.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类，加载驱动失败");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void run() {
        readMySQL();
    }

    private void readMySQL() {
        ResultSet resultSet = null;
        Statement state = openConnection();
        try {
            resultSet = state.executeQuery("select * from jc_content where content_id between "
                    + ((taskNum - 1) * 1000) + " and " + (taskNum * 1000));
            System.out.println("---------task " + taskNum + "正在执行---------");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int wid = resultSet.getInt(2);
                int username = resultSet.getInt(3);
                int repostscount = resultSet.getInt(4);
                int commentscount = resultSet.getInt(5);
                Date text = resultSet.getDate(6);
                Date createat = resultSet.getDate(7);
                int source = resultSet.getInt(15);
                int lasttime = resultSet.getInt(17);
                System.out.println(id + "\t" + wid + "\t" + username + "\t" + repostscount + "\t"
                        + commentscount + "\t" + text + "\t" + createat + "\t" + source + "\t"
                        + lasttime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                state.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("---------task " + taskNum + "执行完毕---------");
    }
}
