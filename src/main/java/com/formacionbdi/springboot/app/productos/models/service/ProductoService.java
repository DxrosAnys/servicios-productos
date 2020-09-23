package com.formacionbdi.springboot.app.productos.models.service;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    public List<Producto> findALl();

    public Producto findById(Long id);
}
