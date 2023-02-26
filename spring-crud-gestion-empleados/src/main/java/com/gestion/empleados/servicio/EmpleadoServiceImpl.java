package com.gestion.empleados.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.empleados.entidades.Empleado;
import com.gestion.empleados.repositorios.EmpleadoRepository;

@Service
public  class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll(Sort sort) {
		return (List<Empleado>) empleadoRepository.findAll(sort);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Empleado> findAll(Pageable pageable) {
		return empleadoRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Empleado empleado) {
		((EmpleadoServiceImpl) empleadoRepository).save(empleado);
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findOne(Long id) {
		return ((EmpleadoServiceImpl) empleadoRepository).findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		((EmpleadoServiceImpl) empleadoRepository).delete(id);
		
	}
	
}
