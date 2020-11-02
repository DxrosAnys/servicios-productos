package com.formacionbdi.springboot.app.productos.controllers;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.ProductoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductoController {

    private final Environment env;

    @Value("${server.port}")
    private Integer port;

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService, Environment env) {
        this.productoService = productoService;
        this.env = env;
    }

    @GetMapping("/list")
    public List<Producto> listar(){
        return productoService.findALl().stream().map(producto -> {
       //     producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
            producto.setPort(port);
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("list/{id}")
    public Producto detalle(@PathVariable Long id) {

         Producto producto = productoService.findById(id);
       //  producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        producto.setPort(port);

//        try {
//            Thread.sleep(2000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        boolean ok = false;
//        if(ok == false){
//            throw new Exception("No se puedo cargar el producto");
//        }
        return producto;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto editar (@PathVariable("id") Long id, @RequestBody Producto producto){
        Producto productoDb = productoService.findById(id);
        productoDb.setNombre(producto.getNombre());
        productoDb.setPrecio(producto.getPrecio());
        return productoService.save(productoDb);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarProducto(@PathVariable("id") Long id){
        productoService.deleteById(id);
    }
}
