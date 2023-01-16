package com.developer.heart.arquivosflatleitorspringbatch.reader;

import com.developer.heart.arquivosflatleitorspringbatch.dto.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class FlatFileReaderConfig {

    @Bean
    @StepScope
    FlatFileItemReader<Cliente> flatFileItemReader(@Value("#{jobParameters['arquivoClientes']}") Resource resource) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("flatFileItemReader")
                .resource(resource)
                .fixedLength()
                .columns(new Range[]{new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 43)})
                .names("nome", "sobrenome", "idade", "email")
                .targetType(Cliente.class)
                .build();

    }


    @Bean
    @StepScope
    FlatFileItemReader<Cliente> flatFileDelimitedReader(@Value("#{jobParameters['arquivoClientes']}") Resource resource) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("flatFileDelimitedReader")
                .resource(resource)
                .delimited()
                .names("nome", "sobrenome", "idade", "email")
                .targetType(Cliente.class)
                .build();

    }

}
