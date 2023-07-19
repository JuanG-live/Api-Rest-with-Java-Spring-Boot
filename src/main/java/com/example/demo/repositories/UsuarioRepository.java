package com.example.demo.repositories;

import com.example.demo.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository // Le dice a Spring que esta clase es un repositorio
      public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
      //Buscar por medio de la prioridad para darle diferentes funcionalidades
      //Otros metodos posibles findbyNombre, findByEmail
      public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}
