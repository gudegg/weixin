package club.gude;

import club.gude.config.WechatConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties({WechatConfig.class})
public class WechatApplication  extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WechatApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WechatApplication.class, args);
	}
}
