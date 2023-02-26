package com.gestion.empleados.servicio;

import java.util.List;


import org.springframework.data.domain.*;

import com.gestion.empleados.entidades.Empleado;

public  interface EmpleadoService {

	public List<Empleado> findAll(Sort sort);

	public Page<Empleado> findAll(Pageable pageable);

	public void save(Empleado empleado);

	public Empleado findOne(Long id);

	public void delete(Long id);

}
