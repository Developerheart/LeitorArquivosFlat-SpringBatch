package com.developer.heart.arquivosflatleitorspringbatch.reader;

import com.developer.heart.arquivosflatleitorspringbatch.dto.Cliente;
import com.developer.heart.arquivosflatleitorspringbatch.dto.Transacao;
import org.springframework.batch.item.*;

public class FlatFileReadCompostObjectReader implements ItemStreamReader {

    private Object objectAtual;
    private final ItemStreamReader<Object> delegate;

    public FlatFileReadCompostObjectReader(ItemStreamReader<Object> delegate) {
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
}
