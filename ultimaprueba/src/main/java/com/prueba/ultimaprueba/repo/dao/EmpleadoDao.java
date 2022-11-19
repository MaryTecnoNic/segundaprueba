package com.prueba.ultimaprueba.repo.dao;

import com.prueba.ultimaprueba.model.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoDao {

    Optional<Empleado> obtenerPorId(Integer idEmpleado);

    List<Empleado> listarTodo();

    Empleado guardar(Empleado empleadoDto);

}
