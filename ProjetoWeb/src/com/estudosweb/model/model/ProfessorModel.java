package com.estudosweb.model.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="professor") //injeçao de dependencia
public class ProfessorModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id //indica chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //gera código automatico
	@Column(name="prof_codigo")
	Integer codigo;
	
	@Column(name="prof_nome", length=50, nullable=false)
	String nome;
	
	@Column(name="prof_telefone", length=50, nullable=true)
	String telefone;
	
	@Column(name="prof_email", length=50, nullable=false)
	String email;
	
	public ProfessorModel(){
		
	}
	
	public ProfessorModel(int codigo, String nome, String telefone, String email){
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		ProfessorModel other = (ProfessorModel) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	
	
}
