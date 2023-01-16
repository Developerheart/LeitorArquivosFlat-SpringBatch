package com.developer.heart.arquivosflatleitorspringbatch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FlatItemWriterConfig {

    @Bean
    ItemWriter<?> flatFileItemWriter() {
        return list -> list.forEach(System.out::println);
    }

}
