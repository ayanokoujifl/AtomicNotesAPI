package com.atomic.schedulenotes.model.enums;

public enum Category {
	CODIGO(0, "Código"), LINK(1, "Link"), INFORMACAO(2, "Informação"), MIDIA(3, "Arquivos / Mídia"),
	ATOMIC(4, "Atomic"), ESTUDO(5, "Estudo"), OUTRO(6, "Outros");

	private Integer id;
	private String description;

	private Category() {
	}

	private Category(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public static Category parse(Integer id) {
		if (id == null) {
			return null;
		}
		for (Category category : Category.values()) {
			if (id.equals(category.id)) {
				return category;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
