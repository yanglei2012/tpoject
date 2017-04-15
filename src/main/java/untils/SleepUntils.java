package untils;

import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/15.
 */
public class SleepUntils {
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(SleepUntils.class);
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
