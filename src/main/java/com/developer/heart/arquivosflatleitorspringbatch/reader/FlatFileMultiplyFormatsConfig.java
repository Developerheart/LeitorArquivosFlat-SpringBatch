package com.developer.heart.arquivosflatleitorspringbatch.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class FlatFileMultiplyFormatsConfig {


    @StepScope
    @Bean
    FlatFileItemReader<?> flatFileMultiplyFormatsReder(@Value("#{jobParameters['arquivoClientes']}") Resource resource, LineMapper lineMapper) {
        return new FlatFileItemReaderBuilder<>()
                .name("flatFileMultiplyFormatsReder")
                .resource(resource)
                .lineMapper(lineMapper)
                .build();

    }



}
