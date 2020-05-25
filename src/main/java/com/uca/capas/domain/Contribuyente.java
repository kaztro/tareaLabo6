package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "CONTRIBUYENTE")
public class Contribuyente {
	@Id
	@Column(name="c_contribuyente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_contribuyente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_importancia")
	private Importancia importancia;
	
	@Transient
	private Integer c_importancia;
	
	@Size(message = "Maximo 30 caracteres", max = 30)
	@NotEmpty(message = "No se permiten campos en blanco")
	@Column(name = "s_nombre")
	private String s_nombre;
	
	@Size(message = "Maximo 30 caracteres", max = 30)
	@NotEmpty(message = "No se permiten campos en blanco")
	@Column(name = "s_apellido")
	private String s_apellido;
	
	@Size(message = "Maximon 14 caracteres", max = 14)
	@NotEmpty(message = "No se permiten campos en blanco")
	@Column(name = "s_nit")
	private String s_nit;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "f_fecha_ingreso")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date f_fecha_ingreso;
	
	public String getF_fecha_ingreso() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(f_fecha_ingreso);
	}

	public void setF_fecha_ingreso(Date f_fecha_ingreso) {
		this.f_fecha_ingreso = f_fecha_ingreso;
	}

	public Contribuyente() {
		
	}

	public Integer getC_contribuyente() {
		return c_contribuyente;
	}

	public void setC_contribuyente(Integer c_contribuyente) {
		this.c_contribuyente = c_contribuyente;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	public Integer getC_importancia() {
		return c_importancia;
	}

	public void setC_importancia(Integer c_importancia) {
		this.c_importancia = c_importancia;
	}

	public String getS_nombre() {
		return s_nombre;
	}

	public void setS_nombre(String s_nombre) {
		this.s_nombre = s_nombre;
	}

	public String getS_apellido() {
		return s_apellido;
	}

	public void setS_apellido(String s_apellido) {
		this.s_apellido = s_apellido;
	}

	public String getS_nit() {
		return s_nit;
	}

	public void setS_nit(String s_nit) {
		this.s_nit = s_nit;
	}
}
