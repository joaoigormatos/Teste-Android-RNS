package com.rns.api_produto.service.impl;

import com.rns.api_produto.dao.IProdutoDao;
import com.rns.api_produto.model.Produto;
import com.rns.api_produto.service.IProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends AbstractGenericServicePersistence<IProdutoDao, Produto, String> implements IProdutoService {


}