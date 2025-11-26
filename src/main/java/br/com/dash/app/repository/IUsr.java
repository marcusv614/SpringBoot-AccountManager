package br.com.dash.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dash.app.entity.Usr;

public interface IUsr extends JpaRepository<Usr, Integer> {
	List<Usr> findByEmail(String email);
	/*
	 * Conhecido também como DAO (Data Acess Object) É a camada que acessa o banco
	 * de dados
	 */

}
