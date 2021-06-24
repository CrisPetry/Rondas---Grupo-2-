package br.upf.ads.paoo.rondas.grupo2.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upf.ads.paoo.rondas.grupo2.jpa.JpaUtil;
import br.upf.ads.paoo.rondas.grupo2.model.Pessoa;
import br.upf.ads.paoo.rondas.grupo2.util.Upload;
import net.iamvegan.multipartrequest.HttpServletMultipartRequest;

/**
 * Servlet implementation class PessoaCon
 */
@WebServlet("/Privada/Pessoa/PessoaCon")
public class PessoaCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PessoaCon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request = new HttpServletMultipartRequest(
				request,
				HttpServletMultipartRequest.MAX_CONTENT_LENGTH,
				HttpServletMultipartRequest.SAVE_TO_TMPDIR,
				HttpServletMultipartRequest.IGNORE_ON_MAX_LENGTH,
				HttpServletMultipartRequest.DEFAULT_ENCODING);		
		
		
		if (request.getParameter("incluir") != null) {
			incluir(request, response);
		} else if (request.getParameter("alterar") != null) {
			alterar(request, response);
		} else if (request.getParameter("excluir") != null) {
            excluir(request, response);			
		} else if (request.getParameter("gravar") != null) {
			gravar(request, response);			
		} else if (request.getParameter("cancelar") != null) {
			cancelar(request, response);			
		} else if (request.getParameter("alterarFoto") != null) {
			alterarFoto(request, response);
		} else if (request.getParameter("gravarFoto") != null) {
			gravarFoto(request, response);	
		} else {
			listar(request, response);
		}
		
	}
	
	private void alterarFoto(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Pessoa obj = em.find(Pessoa.class, Integer.parseInt(request.getParameter("alterarFoto")));
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("PessoaFoto.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void gravarFoto(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager(); 
		
		em.getTransaction().begin(); 	
		Pessoa obj = em.find(Pessoa.class, Integer.parseInt(request.getParameter("id")));

		
		if (request.getParameter("foto") != null) {
			String nomeArquivo = "Foto"+request.getParameter("id")+".jpg";
			
			String caminho = getServletConfig().getServletContext().getRealPath("/") + "Privada/Pessoa/uploads";
			
			Upload.copiarArquivo((HttpServletMultipartRequest) request, "foto", caminho, nomeArquivo);
			
			
			obj.setFoto( Upload.getBytesArquivo((HttpServletMultipartRequest) request, "foto") );
			
		}		
		
		em.merge(obj); 	
		em.getTransaction().commit(); 	
		em.close();
		listar(request, response);
	}	
	
	
	

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			List<Pessoa> lista = em.createQuery("from pessoa").getResultList(); 
			request.setAttribute("lista", lista);
			em.close();
			request.getRequestDispatcher("PessoaList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void cancelar(HttpServletRequest request, HttpServletResponse response) {
		listar(request, response);		
	}

	private void gravar(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager(); 
		Pessoa p = new Pessoa(
					Long.parseLong(request.getParameter("id")), 
					request.getParameter("nome"));
		// ----------------------------------------------------------------------------------
		em.getTransaction().begin(); 	
		em.merge(p); 					
		em.getTransaction().commit(); 	
		em.close();
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager(); 
		em.getTransaction().begin(); 	
		em.remove(em.find(Pessoa.class, Integer.parseInt(request.getParameter("excluir"))));	
		em.getTransaction().commit(); 	
		em.close();
		listar(request, response);
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Pessoa obj = em.find(Pessoa.class, Integer.parseInt(request.getParameter("alterar")));
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("PessoaForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void incluir(HttpServletRequest request, HttpServletResponse response) {
		try {
			Pessoa obj = new Pessoa();
			request.setAttribute("obj", obj);
			request.getRequestDispatcher("PessoaForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
