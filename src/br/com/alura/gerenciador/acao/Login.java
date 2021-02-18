package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		Usuario usuario = banco.existeUsuario(login, senha);
		
		System.out.println("Logando " + login);

		if (usuario != null) {
			System.out.println("Usuario existe");
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";

		}

	}

}