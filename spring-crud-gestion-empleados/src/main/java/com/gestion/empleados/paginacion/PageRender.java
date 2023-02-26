package com.gestion.empleados.paginacion;

import java.util.List;

import org.springframework.data.domain.Page;

// <T> representa un tipo una clase
public class PageRender<T> {
	
	private String url;
	private Page<T> page;
	private int totalPaginas;
	private int numElementosPorPagina;
	private int paginaActual;
	private List<PageItem> paginas;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
	}
	
	

}
