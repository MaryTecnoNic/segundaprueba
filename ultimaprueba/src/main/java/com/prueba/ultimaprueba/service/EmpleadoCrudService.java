package com.prueba.ultimaprueba.service;

import com.prueba.ultimaprueba.model.entity.Empleado;
import com.prueba.ultimaprueba.repo.crud.EmpleadoCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoCrudService {

    private final EmpleadoCrud oEmpleadoCrud;

    @Autowired
    public EmpleadoCrudService(EmpleadoCrud oEmpleadoCrud) {
        this.oEmpleadoCrud = oEmpleadoCrud;
    }

    public Optional<Empleado> obtenerPorId(Integer id) {
        return oEmpleadoCrud.findById(id);
    }

    public List<Empleado> listaTodo() {
        return (List<Empleado>) oEmpleadoCrud.findAll();
    }

    public Empleado guardar(Empleado oEmpleado) {
        return oEmpleadoCrud.save(oEmpleado);
    }

    public List<Object> consumirService() {
        String uri = "http://localhost:8081/empleado/listar";
        RestTemplate restTemplate = new RestTemplate();
        Object[] result = restTemplate.getForObject(uri, Object[].class);
        return Arrays.asList(result);

    }

}
