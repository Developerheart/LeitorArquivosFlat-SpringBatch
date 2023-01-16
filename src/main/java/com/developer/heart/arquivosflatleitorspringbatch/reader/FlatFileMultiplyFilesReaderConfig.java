package com.developer.heart.arquivosflatleitorspringbatch.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class FlatFileMultiplyFilesReaderConfig {

    @Bean
    @StepScope
    public MultiResourceItemReader flatFileReadMultiplyFilesReader(
            @Value("#{jobParameters['arquivoClientes']}") Resource[] arquivosClientes,
            @Qualifier("flatFileMultiplyFormatsReader") FlatFileItemReader flatFileMultiplyFormatsReader) {
        return new MultiResourceItemReaderBuilder<>()
                .name("multiResourceItemReader")
                .resources(arquivosClientes)
                .delegate(new FlatFileReadCompostObjectReader(flatFileMultiplyFormatsReader))
                .build();

    }


}
