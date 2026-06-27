package com.itsqmet.aauto_biblioteca_cadena.service;

import com.itsqmet.aauto_biblioteca_cadena.model.Categoria;
import com.itsqmet.aauto_biblioteca_cadena.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerTodo(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarporId(Long id){
        return categoriaRepository.findById(id);
    }

    public Categoria crearCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public boolean eliminar(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Categoria> actualizar(Long id, Categoria categoriaActualizada) {
        return categoriaRepository.findById(id).map(categoria -> {
            categoria.setNombreCategoria(categoriaActualizada.getNombreCategoria());
            categoria.setDescripcion(categoriaActualizada.getDescripcion());

            return categoriaRepository.save(categoria);
        });
    }
}
