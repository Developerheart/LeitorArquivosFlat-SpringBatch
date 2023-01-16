package com.developer.heart.arquivosflatleitorspringbatch.reader;

import com.developer.heart.arquivosflatleitorspringbatch.dto.Cliente;
import com.developer.heart.arquivosflatleitorspringbatch.dto.Transacao;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

public class FlatFileReadCompostObjectReader implements ItemStreamReader, ResourceAwareItemReaderItemStream {

    private Object objectAtual;
    private final FlatFileItemReader<Object> delegate;

    public FlatFileReadCompostObjectReader(FlatFileItemReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (objectAtual == null)
            objectAtual = delegate.read(); // ler objeto
        Cliente cliente = (Cliente) objectAtual;
        objectAtual = null;
        if (cliente != null) {
            while (peek() instanceof Transacao) {
                cliente.getTransacoes().add((Transacao) objectAtual);
            }
        }
        return cliente;
    }

    private Object peek() throws Exception {
        objectAtual = delegate.read();// leitura do proximo item;
        return objectAtual;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    @Override
    public void setResource(Resource resource) {
        delegate.setResource(resource);
    }
}
