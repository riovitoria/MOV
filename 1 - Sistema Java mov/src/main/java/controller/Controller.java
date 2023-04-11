package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

// Listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarpessoa();
		// Encaminhar a lista ao documento movimenta.jsp
		request.setAttribute("pessoa", lista);
		RequestDispatcher rd = request.getRequestDispatcher("movimenta.jsp");
		rd.forward(request, response);

	}

	// Novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setar variáveis
		contato.setNome(request.getParameter("nome"));
		contato.setPrio1(request.getParameter("prio1"));
		contato.setPrio2(request.getParameter("prio2"));
		contato.setPrio3(request.getParameter("prio3"));
		contato.setPrio4(request.getParameter("prio4"));
		contato.setPrio5(request.getParameter("prio5"));
		// invocar o método inserir contato passando o objeto contato
		dao.inserirContato(contato);

		// redirecionar para o documento movimenta.jsp
		response.sendRedirect("main");
	}

	// Editar contato
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id do contato q será editado
		String idcon = request.getParameter("idcon");
		// Setar a variavel JavaBeans
		contato.setIdcon(idcon);
		// executar o método selecionarcontato (DAO)
		dao.selecionarContato(contato);
		// setar os atributos do formulário com o conteúdo do javabenas
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("prio1", contato.getPrio1());
		request.setAttribute("prio2", contato.getPrio2());
		request.setAttribute("prio3", contato.getPrio3());
		request.setAttribute("prio4", contato.getPrio4());
		request.setAttribute("prio5", contato.getPrio5());
		
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis JAvaBeans
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setPrio1(request.getParameter("prio1"));
		contato.setPrio2(request.getParameter("prio2"));
		contato.setPrio3(request.getParameter("prio3"));
		contato.setPrio4(request.getParameter("prio4"));
		contato.setPrio5(request.getParameter("prio5"));
		
		// executar o método alterar contato
		dao.alterarContato(contato);
		// redirecionar para o documento movimenta.jsp (atualizando as alterações)
		response.sendRedirect("main");
	}

	// remover contato
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento da id do contato a ser excluído
		String idcon = request.getParameter("idcon");
		// setar a variável idcon JavaBeans
		contato.setIdcon(idcon);
		// executar o método deletar contato (DAO)
		dao.deletarContato(contato);
		// redirecionar para o documento movimenta.jsp (atualizando as alterações)
		response.sendRedirect("main");
	}
}