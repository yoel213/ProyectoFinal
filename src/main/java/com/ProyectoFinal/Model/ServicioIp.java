package com.ProyectoFinal.Model;

import org.springframework.stereotype.Service;

@Service
public class ServicioIp {

	private String Ip;

	public String getIp() {
		return Ip;
	}

	public void setIp(String ip) {
		Ip = ip;
	}
	
}
