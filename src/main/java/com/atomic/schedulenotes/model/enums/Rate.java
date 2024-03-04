package com.atomic.schedulenotes.model.enums;

public enum Rate {

	BAIXA(0, "Baixa"), MEDIA(1, "Pouco importante"), NORMAL(2, "Razoável"), ALTO(3, "Importante"),
	MUITO_ALTO(4, "Muito importante");

	private Integer id;
	private String urgencia;

	private Rate() {
	}

	private Rate(Integer id, String urgencia) {
		this.id = id;
		this.urgencia = urgencia;
	}

	public static Rate parse(Integer id) {
		if (id == null) {
			return null;
		}
		for (Rate rate : Rate.values()) {
			if (id.equals(rate.id)) {
				return rate;
			}
		}
		throw new IllegalArgumentException("Perfil inválido");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}

}
