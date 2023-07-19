package com.example.demo.controller;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    //importamos el servicio
    @Autowired
    UsuarioServices usuarioServices;

    //Peticion de tipo get ejecuta el metodo obtenerUsuarios
    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioServices.obtenerUsuarios();
    }

    //Peticion de tipo post ejecuta el metodo guardarUsuario
    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioServices.guardarUsuario(usuario);
    }

    //obtener por id
    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return Optional.ofNullable(this.usuarioServices.obtenerPorId(id));
    }

    //obtener por Prioridad
    @GetMapping( path = "/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioServices.obtenerPorPrioridad(prioridad);
    }

    //Eliminar por id
    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioServices.eliminarUsuario(id);
        if (ok){
            return "Se elimino el usuario con id " + id;
        }else{
            return "No se pudo eliminar el usuario con id " + id;
        }
    }
}
