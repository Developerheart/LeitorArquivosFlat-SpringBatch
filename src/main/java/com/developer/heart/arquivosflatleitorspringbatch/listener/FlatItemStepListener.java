package com.developer.heart.arquivosflatleitorspringbatch.listener;


import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FlatItemStepListener {

    private static final Logger log = LoggerFactory.getLogger(FlatItemStepListener.class);

    @Bean
    JobExecutionListener flatItemJobExecutionListener() {
        return new JobExecutionListener() {
            @Override
            public void beforeJob(JobExecution jobExecution) {
//                ExecutionContext executionContext = jobExecution.getExecutionContext();
//                executionContext.put("nome", "BORA TAFARREEEEEEL");
//                executionContext.put("casa", "Leonardoo");
                log.info("Iniciando step");
            }

            @Override
            public void afterJob(JobExecution jobExecution) {
                log.info("Finalizando step");
            }
        };
    }

}
