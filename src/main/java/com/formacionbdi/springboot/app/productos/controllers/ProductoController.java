package com.formacionbdi.springboot.app.productos.controllers;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
