package com.rns.api_produto.dao;

import com.rns.api_produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface representa a camada de persistência da entidade Produto. Deve ser injetada <b>exclusivamente</b> em uma
 * camada service.
 */
public interface IProdutoDao extends JpaRepository<Produto, String> {

}
