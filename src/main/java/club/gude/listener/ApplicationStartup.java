package club.gude.listener;

import club.gude.api.token.TokenApi;
import club.gude.entity.token.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * @Author Gude
 * @Date 2016/4/4.
 */
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = LoggerFactory.getLogger(ApplicationStartup.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

//
//            final TokenApi tokenApi=TokenApi.getInstance();
//            ScheduledExecutorService service= Executors.newSingleThreadScheduledExecutor();
//            service.scheduleWithFixedDelay(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println(tokenApi.getToken().getAccess_token());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            },0,1, TimeUnit.SECONDS);
//            tokenApi.setExpired_time(5);

    }
}
