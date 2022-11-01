package com.jdr.tfg.modelo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jdr.tfg.modelo.beams.Inmueble;

//? También funcionaba sin @Repository
@Repository
public interface InmuebleRepositorio extends MongoRepository<Inmueble, String> {

}
