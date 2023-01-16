package com.developer.heart.arquivosflatleitorspringbatch.step;

import com.developer.heart.arquivosflatleitorspringbatch.dto.Cliente;
import com.developer.heart.arquivosflatleitorspringbatch.reader.FlatFileReadCompostObjectReader;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FlatItemStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    Step flatItemStep(@Qualifier("flatFileMultiplyFormatsReder") FlatFileItemReader flatFileMultiplyFormatsReder, ItemWriter<Cliente> flatFileItemWriter, JobExecutionListener flatItemJobExecutionListener) {
        return stepBuilderFactory
                .get("flatItemStepCD")
                .listener(flatItemJobExecutionListener)
                .<Cliente, Cliente>chunk(1)
                .reader(new FlatFileReadCompostObjectReader(flatFileMultiplyFormatsReder))
                .writer(flatFileItemWriter)
                .build();
    }

}
