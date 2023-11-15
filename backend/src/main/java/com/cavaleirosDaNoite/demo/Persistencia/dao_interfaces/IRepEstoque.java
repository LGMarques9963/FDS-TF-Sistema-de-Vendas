package com.cavaleirosDaNoite.demo.Persistencia.dao;

import org.springframework.data.repository.CrudRepository;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Estoque;

public interface IRepEstoque extends CrudRepository<Estoque, Long> {

}