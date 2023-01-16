package com.developer.heart.arquivosflatleitorspringbatch.mapper;

import com.developer.heart.arquivosflatleitorspringbatch.dto.Cliente;
import com.developer.heart.arquivosflatleitorspringbatch.dto.Transacao;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ClienteTransacaoLineMapperConfig {


    @Bean
    public PatternMatchingCompositeLineMapper lineMapper() {
        PatternMatchingCompositeLineMapper mapper = new PatternMatchingCompositeLineMapper();
        mapper.setTokenizers(tokenizers());
        mapper.setFieldSetMappers(fieldSetMappers());
        return mapper;
    }

    private Map<String, FieldSetMapper> fieldSetMappers() {
        Map<String, FieldSetMapper> fieldSetMapper = new HashMap<>();
        fieldSetMapper.put("0*", fieldSetMap(Cliente.class));
        fieldSetMapper.put("1*", fieldSetMap(Transacao.class));
        return fieldSetMapper;

    }

    @SuppressWarnings("rawtypes")
    private FieldSetMapper fieldSetMap(Class objectMapped) {
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(objectMapped);
        return fieldSetMapper;
    }

    private Map<String, LineTokenizer> tokenizers() {
        Map<String, LineTokenizer> tokenizers = new HashMap<>();
        tokenizers.put("0*", clienteLineTokenizer());
        tokenizers.put("1*", transacaoLineTokenizer());
        return tokenizers;
    }

    private LineTokenizer transacaoLineTokenizer() {
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setNames("id", "descricao", "valor");
        delimitedLineTokenizer.setIncludedFields(1, 2, 3);
        return delimitedLineTokenizer;
    }

    private LineTokenizer clienteLineTokenizer() {
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setNames("nome", "sobrenome", "idade", "email");
        delimitedLineTokenizer.setIncludedFields(1, 2, 3, 4);
        return delimitedLineTokenizer;
    }

}
