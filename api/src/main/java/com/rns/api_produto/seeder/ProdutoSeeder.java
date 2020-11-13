package com.rns.api_produto.seeder;

import com.rns.api_produto.model.Produto;
import com.rns.api_produto.service.IProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProdutoSeeder {
    @Autowired
    IProdutoService service;

    @EventListener
    public void seedFilial(ContextRefreshedEvent event) {
        try {
            log.info("Criando produtos....");
            criandoProdutos();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    private void criandoProdutos() {
        for (int i = 1; i < 10; i++) {
            Produto produto = new Produto();
            produto.setNome("Sal produto " + i);
            produto.setLocal("Av dom Luiz - Fortaleza " + i);
            produto.setQuantidade(i+5);
            service.save(produto);
        }
    }
}
