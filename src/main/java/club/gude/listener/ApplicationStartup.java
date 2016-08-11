package club.gude.listener;

import club.gude.api.token.TokenApi;
import club.gude.entity.token.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


/**
 * @Author Gude
 * @Date 2016/4/4.
 */
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = LoggerFactory.getLogger(ApplicationStartup.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        TokenApi tokenApi=TokenApi.getInstance();
        try {
            logger.info("监听器:"+tokenApi.getToken().getAccess_token());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
