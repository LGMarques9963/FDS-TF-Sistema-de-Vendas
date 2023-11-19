package com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces;

import org.springframework.data.repository.CrudRepository;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Estoque;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemEstoque;    

import java.util.List;

public interface IRepItemEstoque extends CrudRepository<ItemEstoque, Long> {

}