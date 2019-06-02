package redisdemo;

/**
 * @author i324779
 */
public class JedisBaseService {

    protected String getFormatKeyStr(String formatStr, Object... vals) {
        return String.format(formatStr, vals);
    }

    protected int getStartIndex(int pageNo, int pageSize) {
        if (pageNo < 1) {
            pageNo = 1;
        }
        return (pageNo - 1) * pageSize;
    }

    protected int getEndIndex(int pageNo, int pageSize) {
        if (pageNo < 1) {
            pageNo = 1;
        }
        return pageNo * pageSize - 1;
    }
}