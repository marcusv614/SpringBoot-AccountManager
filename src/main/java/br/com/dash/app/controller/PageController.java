package br.com.dash.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.dash.app.service.UsrService;
import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {
	private static final Logger log = LoggerFactory.getLogger(PageController.class);

	public final UsrService usrService;

	public PageController(UsrService usrService) {
		this.usrService = usrService;
	}

	@GetMapping("/")
	public String home() {
		return "redirect:/login";
	}

	@PostMapping("/login")
	public String loginUsr(@RequestParam("username") String username, @RequestParam("pwd") String pwd,
			HttpSession session, RedirectAttributes redirectAttrs) {
		log.info("Tentativa de login para username='{}'", username);

		boolean validar = usrService.validarSenha(username, pwd);
		log.info("Resultado validarSenha for '{}': {}", username, validar);

		if (!validar) {
			redirectAttrs.addFlashAttribute("error", "Credenciais inválidas");
			return "redirect:/login";
		}

		session.setAttribute("username", username);
		return "redirect:/usuarios";
	}

	@GetMapping("/login")
	public String login(Model model) {
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
