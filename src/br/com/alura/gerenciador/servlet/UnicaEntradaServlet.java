package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acoes.AlteraEmpresa;
import br.com.alura.gerenciador.acoes.ListaEmpresas;
import br.com.alura.gerenciador.acoes.MostraEmpresa;
import br.com.alura.gerenciador.acoes.NovaEmpresa;
import br.com.alura.gerenciador.acoes.NovaEmpresaForm;
import br.com.alura.gerenciador.acoes.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = null;

		String paramAcao = request.getParameter("acao");

		if (paramAcao.equals("ListaEmpresas")) {

			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response);

		} else if (paramAcao.equals("RemoveEmpresa")) {

			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.executa(request, response);

		} else if (paramAcao.equals("MostraEmpresa")) {

			MostraEmpresa acao = new MostraEmpresa();
			nome =  acao.executa(request, response);

		} else if (paramAcao.equals("AlteraEmpresa")) {

			AlteraEmpresa acao = new AlteraEmpresa();
			nome = acao.executa(request, response);

		} else if (paramAcao.equals("NovaEmpresa")) {

			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(request, response);

		} else if (paramAcao.equals("NovaEmpresaForm")) {

			NovaEmpresaForm acao = new NovaEmpresaForm();
			nome = acao.executa(request, response);

		}

		String[] tipoEEndereco = nome.split(":");
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);

		}
	}

}
