package com.ProyectoFinal.Model;

import org.springframework.stereotype.Service;

@Service
public class ServicioOSM {
private String url;

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

}
