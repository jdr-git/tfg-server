package com.jdr.tfg.modelo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jdr.tfg.modelo.beams.Usuario;

//? También funcionaba sin @Repository
@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {

}
