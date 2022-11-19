package com.prueba.ultimaprueba.repo.crud;

import com.prueba.ultimaprueba.model.entity.Empleado;
import com.prueba.ultimaprueba.repo.dao.EmpleadoDao;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoCrud extends CrudRepository<Empleado, Integer> , EmpleadoDao {
}
