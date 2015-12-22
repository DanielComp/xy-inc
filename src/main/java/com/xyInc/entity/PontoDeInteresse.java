package com.xyInc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ponto_de_interesse")
public class PontoDeInteresse {
	
	@Id	
	@GeneratedValue
	private Long id;
	
	private String nome;
	private Integer x;
	private Integer y;

	public PontoDeInteresse() {
	}
	
	public PontoDeInteresse(Long id, String nome, Integer x, Integer y) {
		super();
		this.id = id;
		this.nome = nome;
		this.x = x;
		this.y = y;
	}
	
	public PontoDeInteresse(String nome, Integer x, Integer y) {
		super();
		this.nome = nome;
		this.x = x;
		this.y = y;
	}
	
	public PontoDeInteresse(Integer x, Integer y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "PontoDeInteresse [id=" + id + ", nome=" + nome + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PontoDeInteresse other = (PontoDeInteresse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
