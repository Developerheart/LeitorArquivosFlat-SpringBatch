package com.developer.heart.arquivosflatleitorspringbatch.writer;

import com.developer.heart.arquivosflatleitorspringbatch.dto.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FlatItemWriterConfig {

    @Bean
    ItemWriter<Cliente> flatFileItemWriter() {
        return list -> list.forEach(System.out::println);
    }

}
