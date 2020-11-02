package com.formacionbdi.springboot.app.productos.models.service;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findALl();

    Producto findById(Long id);

    Producto save(Producto producto);

    public void deleteById(Long id);
}
