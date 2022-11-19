package com.prueba.ultimaprueba.view;

import com.prueba.ultimaprueba.model.entity.Empleado;
import com.prueba.ultimaprueba.service.EmpleadoCrudService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Scope(value = "session")
@Component
@Data
public class SinSeguridad implements Serializable {

    private String hola = "Probando sin llega...";

    private Empleado empleado;

    private List<Empleado> empleadoList;

    private List<Object> listaEmpleado;

    private EmpleadoCrudService empleadoCrudService;


    @Autowired
    public SinSeguridad(EmpleadoCrudService empleadoCrudService) {
        this.empleadoCrudService = empleadoCrudService;
    }

    @PostConstruct
    public void init() {
        empleadoList = empleadoCrudService.listaTodo();
        empleado = new Empleado();
        listaEmpleado = empleadoCrudService.consumirService();


//        empleadoList = listaEmpleado.stream()
//                .filter(Empleado.class::isInstance)
//                .map(Empleado.class::cast)
//                .collect(toList());
        System.out.println("Hola...");
    }

    public void guardar() {
        System.out.println(empleado);
        empleadoCrudService.guardar(empleado);
        empleado = new Empleado();

    }

}
