package br.com.dash.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "usr")
public class Usr {
	// Representa a tabela do meu banco de dados

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotBlank(message = "O nome é obrigatório!")
	@Column(name = "username", length = 50, nullable = false)
	private String username;

	@NotBlank(message = "A senha é obrigatória!")
	@Column(name = "pwd", columnDefinition = "TEXT", nullable = false)
	private String pwd;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getId() {
		return id;
	}

}
