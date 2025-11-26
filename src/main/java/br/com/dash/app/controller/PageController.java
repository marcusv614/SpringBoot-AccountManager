package br.com.dash.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.dash.app.service.UsrService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
/*
 * O Controller controla as rotas/endpoints da aplicação. Ele é a camada
 * responsável por: Receber requisições HTTP (GET, POST, PUT, DELETE…) Chamar o
 * Service Retornar respostas (JSON ou páginas) Ele NÃO deve conter regras de
 * negócio. Ele só encaminha a requisição para o Service. Fluxo correto de uma
 * aplicação Spring : Cliente (Front) → Controller → Service → Repository →
 * Banco
 * 
 */
public class PageController {
	public final UsrService usrService;

	public PageController(UsrService usrService) {
		this.usrService = usrService;
	}

	@PostMapping("/login")
	public String loginUsr(@Valid @RequestParam("username") String username, @Valid @RequestParam("pwd") String pwd,
			HttpSession session) {

		boolean validar = usrService.validarSenha(username, pwd);
		if (!validar) {
			return "redirect:/login";
		}
		session.setAttribute("username", username);
		return "redirect:/usuarios";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}

	@GetMapping("/usuarios")
	public String listarUsr(Model model, HttpSession session) {
		Object user = session.getAttribute("username");
		if (user == null) {
			return "redirect:/login";
		}
		model.addAttribute("usuarios", usrService.checarUsr());
		return "usuarios";
	}

}
