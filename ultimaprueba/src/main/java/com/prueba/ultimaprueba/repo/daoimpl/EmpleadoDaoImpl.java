package com.prueba.ultimaprueba.repo.daoimpl;

import com.prueba.ultimaprueba.model.entity.Empleado;
import com.prueba.ultimaprueba.repo.dao.EmpleadoDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class EmpleadoDaoImpl implements EmpleadoDao {

    JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert simpleJdbcInsert;

    public EmpleadoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Empleado> obtenerPorId(Integer idEmpleado) {
        return jdbcTemplate.query("Select * from dbo.empleado where idempleado = ? ", BeanPropertyRowMapper.newInstance(Empleado.class),idEmpleado).stream().findFirst();
    }

    @Override
    public List<Empleado> listarTodo() {
        return jdbcTemplate.query("Select * from dbo.empleado", BeanPropertyRowMapper.newInstance(Empleado.class));

    }
    @Override
    public Empleado guardar(Empleado empleadoDto) {
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate.getDataSource()).withTableName("empleado").usingGeneratedKeyColumns("idempleado");
        Map<String, Object> params = new HashMap<>();
        params.put("nombre", empleadoDto.getNombre());
        params.put("apellido", empleadoDto.getApellido());
        params.put("sexo", empleadoDto.getSexo());
        Number num = simpleJdbcInsert.executeAndReturnKey(params);
        empleadoDto.setIdempleado(num.intValue());
        return empleadoDto;
    }


}
