package br.com.dash.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dash.app.entity.Usr;
import br.com.dash.app.service.UsrService;
import jakarta.validation.Valid;

@RestController
//“Esta classe é um controller REST. Todo método aqui retorna dados (JSON),
//não páginas HTML.”
@CrossOrigin("*")
/*
 * @CrossOrigin permite requisições vindas de outros domínios, especialmente
 * frontend (React, Angular, Vue). Sem isso, o navegador bloqueia requisições
 * por causa do CORS.
 */
@RequestMapping
public class UsrController {
	private final UsrService usrService;

	public UsrController(UsrService usrService) {
		this.usrService = usrService;
	}

	@PostMapping("/cadastro")
	public ResponseEntity<Usr> criarUsr(@Valid @RequestBody Usr usr) {
		/*
		 * A anotação "@RequestBody diz ao Spring: “Pegue o JSON enviado pelo cliente e
		 * converta para um objeto Java automaticamente.” O que o Spring faz? 1.Lê o
		 * JSON enviado. 2.Converte para um objeto Usr. 3.Preenche o parâmetro usr com
		 * os valores do JSON.
		 */
		return ResponseEntity.status(201).body(usrService.criarUsr(usr));
	}

	@GetMapping("/checarUsr")
	public ResponseEntity<List<Usr>> checarUsr() {
		return ResponseEntity.status(200).body(usrService.checarUsr());
	}

	@PostMapping("/alterarusr")
	public ResponseEntity<Usr> alterarUsr(@Valid @RequestBody Usr usr) {
		return ResponseEntity.status(201).body(usrService.alterarUsr(usr));
	}

	@PostMapping("/{id}")
	public String deletarUsr(@PathVariable Integer id) {
		usrService.deleteUsr(id);
		return "redirect:/usuarios";
	}

}
