package crazy;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/** 计算从Java纪元开始到当前日期（0:0:0) 的秒数。
 * 注意时区的问题。
 * @author i324779
 *
 */
public class DateTimeAPISample {

    public static void main(String[] args) {
	
	LocalDateTime now = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
	ZonedDateTime zoneDateTime = ZonedDateTime.of(now, ZoneId.of("Asia/Shanghai"));
	System.out.println(zoneDateTime.toEpochSecond());
	
	// yesterday
	System.out.println(zoneDateTime.toEpochSecond() - 86400); // seconds in one day.
    }
}
