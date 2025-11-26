package br.com.dash.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dash.app.entity.Usr;

public interface IUsr extends JpaRepository<Usr, Integer> {
	Usr findByUsername(String username);
	/*
	 * Conhecido também como DAO (Data Acess Object) É a camada que acessa o banco
	 * de dados
	 */

}
