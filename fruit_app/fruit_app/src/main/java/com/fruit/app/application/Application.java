package com.fruit.app.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zoyation on 2017-06-06.
 */
@SpringBootApplication
@ComponentScan("com.fruit.app")
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//    @Bean
//    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                System.out.println("Let's inspect the beans provided by Spring Boot:");
//                String[] beanNames = ctx.getBeanDefinitionNames();
//                Arrays.sort(beanNames);
//                for (String beanName : beanNames) {
//                    System.out.println(beanName);
//                }
//            }
//        };
//    }
}
