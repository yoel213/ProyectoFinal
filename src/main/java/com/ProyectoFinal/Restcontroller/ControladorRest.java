package com.ProyectoFinal.Restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ProyectoFinal.Model.ServicioGeo;
import com.ProyectoFinal.Model.ServicioIp;
import com.ProyectoFinal.Model.ServicioOSM;


@RestController
@RequestMapping("/MyServicio")
public class ControladorRest {
	private static Logger LOG= LoggerFactory.getLogger(ControladorRest.class);
	@Autowired
	ServicioIp result;
	@Autowired
	ServicioGeo geo;
	@Autowired
	ServicioOSM osm;
		
	@GetMapping
	private ServicioOSM MyService(Model model) {
		//obtenemos la ip
		String uri = "https://api.ipify.org?format=json";
		RestTemplate restTemplate = new RestTemplate ();
		result = restTemplate.getForObject(uri, ServicioIp.class );
		//obtenemos la localizacion
		String uri1 = "https://ipinfo.io/"+result.getIp()+"/geo";
		RestTemplate restTemplate1 = new RestTemplate ();
		geo = restTemplate1.getForObject(uri1, ServicioGeo.class);
		String[] loc1 = geo.getLoc().split(",");
		//creamos el string del map
		String map = "https://www.openstreetmap.org/?mlat="+loc1[0]+"&mlon="+loc1[1]+"#map=15/"+loc1[0]+"/"+loc1[1]+"&layers=N";
		osm.setUrl(map);
		model.addAttribute("servicio", osm);
		LOG.info(osm.getUrl());
		return osm;
	}
	
	@GetMapping(value="/Ip")
	private ServicioIp Ip() {
		String uri = "https://api.ipify.org?format=json";
		RestTemplate restTemplate = new RestTemplate ();
		result = restTemplate.getForObject(uri, ServicioIp.class );
		return result;
	}
		
	@GetMapping (value="/Geo")
	private ServicioGeo Geo() {
		String uri = "https://api.ipify.org?format=json";
		RestTemplate restTemplate = new RestTemplate ();
		result = restTemplate.getForObject(uri, ServicioIp.class );
		
		String uri1 = "https://ipinfo.io/"+result.getIp()+"/geo";
		RestTemplate restTemplate1 = new RestTemplate ();
		geo = restTemplate1.getForObject(uri1, ServicioGeo.class );
		return geo;	
	}
	
}
