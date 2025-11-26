package br.com.dash.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.dash.app.entity.Usr;
import br.com.dash.app.repository.IUsr;

@Service
//Services são classes onde está presente as regras de negócio
public class UsrService {

	private IUsr repository;
	private PasswordEncoder passwordEncoder;

	// injeção de dependências:
	public UsrService(IUsr repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
		// BCryptPasswordEncoder nos permite criptografar dados.
	}

	public final Usr criarUsr(Usr usr) {
		String encoderSenha = this.passwordEncoder.encode(usr.getPwd());
		// retorna a senha criptografada do usr
		usr.setPwd(encoderSenha);
		// salva senha criptografada
		repository.save(usr);
		return usr;
	}

	public final Usr alterarUsr(Usr usr) {
		String encoderSenha = this.passwordEncoder.encode(usr.getPwd());
		// retorna a senha criptografada do usr
		usr.setPwd(encoderSenha);
		// salva senha criptografada
		repository.save(usr);
		return usr;
	}

	public List<Usr> checarUsr() {
		List<Usr> lista = repository.findAll();
		return lista;
	}

	public Boolean validarSenha(String username, String pwd) {
		String senha = repository.findByUsername(username).getPwd();
		boolean valid = passwordEncoder.matches(pwd, senha);
		return valid;
	}

	@PostMapping("/{id}")
	public Optional<Usr> deleteUsrString(@PathVariable Integer id) {
		Optional<Usr> usrOptional = repository.findById(id);
		repository.deleteById(id);
		return usrOptional;
	}

}
