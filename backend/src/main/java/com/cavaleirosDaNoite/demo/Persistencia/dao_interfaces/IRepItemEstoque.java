package com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces;

import org.springframework.data.repository.CrudRepository;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.ItemEstoque;    


public interface IRepItemEstoque extends CrudRepository<ItemEstoque, Long> {

}