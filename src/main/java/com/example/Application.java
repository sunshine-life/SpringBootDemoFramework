package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.servlet.MultipartConfigElement;


@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
//@ActiveProfiles("test")
public class Application {
	
	protected static Logger logger=LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
        SpringApplicationBuilder application = new SpringApplicationBuilder();
               /*
                * Banner.Mode.OFF:关闭;
                * Banner.Mode.CONSOLE:控制台输出，默认方式;
                * Banner.Mode.LOG:日志输出方式;
                */
        application.sources(Application.class)
                .run(args);
		logger.info("SpringBoot Start Success");
	}
}
