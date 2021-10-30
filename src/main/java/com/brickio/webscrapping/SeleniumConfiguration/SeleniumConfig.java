package com.brickio.webscrapping.SeleniumConfiguration;

import javax.annotation.PostConstruct;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfig {

    @PostConstruct
    void postConstruct(){
        System.setProperty("webdriver.chrome.driver", "/Users/evannurkholis/chromeDriver/chromedriver");
    }

    @Bean
    public ChromeDriver driver(){
        return new ChromeDriver();
    }
}
