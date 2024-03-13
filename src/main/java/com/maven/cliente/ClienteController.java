package com.maven.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    private List<Cliente> listaClientes=new ArrayList<>();

    @GetMapping("/saludo/{nombre}")
    public String saludo( @RequestParam String nombre){
        return "Hola como estas eres la mas linda, "+ nombre;
    }

    @GetMapping("/despedir")
    public String saludo2( @RequestParam String nombre, 
                           @RequestParam String apellido){
        return "Adios te extrañare: , "+ nombre + " "+ apellido;
    }
    @PostMapping("/cliente")
    public String despedir (@RequestParam String nombre,
                            @RequestParam String apellido,
                            @RequestParam String direccion,
                            @RequestParam String telefono,
                            @RequestParam String email){
        return "Datos del cliene \n"+
                "nombre: "+nombre+" "+apellido+"\n"+
                "email:"+email+"\n"+
                "direccion:"+direccion+"\n"+
                "telefono:"+telefono+"\n";                       
    }
    @PostMapping("/cliente/guardar")
    public String guardarCliente(@RequestBody Cliente cliente){
        return "Datos del cliene \n"+
        "nombre: "+cliente.getNombre()+" "+cliente.getApellido()+"\n"+
        "direccion:"+cliente.getDireccion()+"\n"+
        "telefono:"+cliente.getTelefono()+"\n"+     
        "email:"+cliente.getEmail()+"\n";
    }

    @PostMapping("/cliente/list")
    public List<Cliente> getListClientes(){
        return listaClientes;
    }

    @DeleteMapping("cliente/eliminar")
    public String eliminarCliente(@RequestBody Cliente cliente){
        if (listaClientes.remove(cliente)) {
            return "Se elimino con exito";
        }else {
            return "El cliente se creo con exito";
        }
    }    
}
