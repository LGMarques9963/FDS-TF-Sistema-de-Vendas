package com.cavaleirosDaNoite.demo.Persistencia.dao_interfaces;

import com.cavaleirosDaNoite.demo.Dominio.Entidades.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IRepClientes extends CrudRepository<Cliente, Long> {

}
