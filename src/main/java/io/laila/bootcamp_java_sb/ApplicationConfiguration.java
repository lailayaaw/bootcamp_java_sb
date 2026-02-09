package io.laila.bootcamp_java_sb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "config")
@EnableAsync
public class ApplicationConfiguration {

    private String userName;
    private String userPassword;

    @Bean
    public ExternalLibrary externalLibrary() {
        return new ExternalLibrary("Demo External Library");
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public String getUserPassword() {
//        return userPassword;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }

    @Bean(name = "customExecutor")
    public Executor customExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(0);
        executor.setThreadNamePrefix("CustomAsync-");
        executor.initialize();
        return executor;
    }
}

