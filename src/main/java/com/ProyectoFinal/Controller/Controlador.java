package com.ProyectoFinal.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ProyectoFinal.Model.ServicioGeo;
import com.ProyectoFinal.Model.ServicioIp;
import com.ProyectoFinal.Model.ServicioOSM;


@Controller
@RequestMapping("/")
public class Controlador {
	private static Logger LOG= LoggerFactory.getLogger(Controlador.class);
	@Autowired
	ServicioIp result;
	@Autowired
	ServicioGeo geo;
	@Autowired
	ServicioOSM osm;
	
	@GetMapping
	private String ServicioIndex() {
		LOG.info("aqui inicia el servicio index");
		return "index";
	}
	
}
