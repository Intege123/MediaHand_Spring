package com.intege.mediahand.core;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javafx.application.Application;

@SpringBootApplication
@EntityScan(MediaHandApplication.BASE_PACKAGE)
@EnableJpaRepositories(MediaHandApplication.BASE_PACKAGE)
@ComponentScan(MediaHandApplication.BASE_PACKAGE)
@EnableTransactionManagement
public class MediaHandApplication {

    public static final String BASE_PACKAGE = "com.intege.*";

    public static void main(String[] args) {
        Application.launch(JfxMediaHandApplication.class, args);
    }

    @Bean
    public TaskExecutor thumbnailGenerationExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setWaitForTasksToCompleteOnShutdown(false);
        executor.initialize();

        return executor;
    }
    
}
