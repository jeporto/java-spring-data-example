package br.com.jeporto.car.app;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("br.com.jeporto.car")
@EntityScan("br.com.jeporto.car")
@ComponentScan("br.com.jeporto.car")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}