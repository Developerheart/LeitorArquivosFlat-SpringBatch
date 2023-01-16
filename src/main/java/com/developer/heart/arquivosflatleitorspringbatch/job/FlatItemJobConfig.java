package com.developer.heart.arquivosflatleitorspringbatch.job;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class FlatItemJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;


    @Bean
    Job flatItemJob(Step flatItemStep, JobExecutionListener flatItemExecListener) {
        return jobBuilderFactory
                .get("flatItemJobCD")
                .start(flatItemStep)
                .incrementer(new RunIdIncrementer())
                .listener(flatItemExecListener)
                .build();

    }

}
