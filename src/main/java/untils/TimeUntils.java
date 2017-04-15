package untils;

import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/15.
 */
public class TimeUntils {
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(TimeUntils.class);

    /**
     * 获取当前时间
     * 默认格式
     *
     * @return
     */
    public static String getCurrentTime() {
        return new SimpleDateFormat("HH:MM:ss").format(new Date());
    }

    /**
     * 获取当前时间
     * 指定格式
     *
     * @param format
     * @return
     */
    public static String getCurrentTime(SimpleDateFormat format) {
        String now = null;
        try {
            now = format.format(new Date());
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
        return now;
    }
}
