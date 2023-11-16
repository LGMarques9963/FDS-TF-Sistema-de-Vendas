package com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces;

import org.springframework.data.repository.CrudRepository;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Estoque;

import java.util.List;

public interface
IRepEstoque extends CrudRepository<Estoque, Long> {

    List<Estoque> findByQuantidadeLessThan(int minQuant);
}