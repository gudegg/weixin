package club.gude.api.token;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author Gude
 * @Date 2016/4/6.
 */
public class TokenTask {
    private static final ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
    private static ScheduledFuture<?> scheduledFuture;

    public static void createTask(long expired_time) {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        scheduledFuture = service.scheduleWithFixedDelay(new tokenRunnable(), 0, expired_time, TimeUnit.SECONDS);

    }

    public static class tokenRunnable implements Runnable {

        @Override
        public void run() {
            //反射设置token
            System.out.println("1");
        }
    }
}
