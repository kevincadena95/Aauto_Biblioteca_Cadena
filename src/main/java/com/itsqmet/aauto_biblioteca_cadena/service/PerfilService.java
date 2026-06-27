package com.itsqmet.aauto_biblioteca_cadena.service;

import com.itsqmet.aauto_biblioteca_cadena.model.Perfil;
import com.itsqmet.aauto_biblioteca_cadena.repository.PerfilRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> obtenerTodo(){
        return perfilRepository.findAll();
    }

    public Optional<Perfil> buscarporId(Long id){
        return perfilRepository.findById(id);
    }

    public Perfil crearPerfil(Perfil perfil){
        return perfilRepository.save(perfil);
    }

    public boolean eliminar(Long id) {
        if (perfilRepository.existsById(id)) {
            perfilRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Perfil> actualizar(Long id, Perfil perfilActualizado) {
        return perfilRepository.findById(id).map(perfil -> {
            perfil.setFechaNacimiento(perfilActualizado.getFechaNacimiento());
            perfil.setFechaFallecimiento(perfilActualizado.getFechaFallecimiento());
            perfil.setNacionalidad(perfilActualizado.getNacionalidad());
            perfil.setOcupacion(perfilActualizado.getOcupacion());
            perfil.setReconocimientos(perfilActualizado.getReconocimientos());

            return perfilRepository.save(perfil);
        });
    }
}