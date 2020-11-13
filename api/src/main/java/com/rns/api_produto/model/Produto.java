package com.rns.api_produto.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "PRODUTO")
public class Produto extends GenericEntity<String>{

    @Id
    private String nome;

    @Column
    private String local;

    @Column
    private int quantidade;


    @Override
    public String getId() {
        return getNome();
    }
}
