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
import br.upf.ads.paoo.rondas.grupo2.model.Usuario;
import net.iamvegan.multipartrequest.HttpServletMultipartRequest;

@WebServlet("/Privada/Usuario/UsuarioCon")
public class UsuarioCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioCon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request = new HttpServletMultipartRequest(request, HttpServletMultipartRequest.MAX_CONTENT_LENGTH,
				HttpServletMultipartRequest.SAVE_TO_TMPDIR, HttpServletMultipartRequest.IGNORE_ON_MAX_LENGTH,
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
		} else {
			listar(request, response);
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			List<Usuario> lista = em.createQuery("from Usuario").getResultList();
			request.setAttribute("lista", lista);
			em.close();
			request.getRequestDispatcher("UsuarioList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cancelar(HttpServletRequest request, HttpServletResponse response) {
		listar(request, response);
	}

	private void gravar(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager();
		Usuario p = new Usuario(Long.parseLong(request.getParameter("id")), request.getParameter("email"),
				request.getParameter("nome"), request.getParameter("senha"));

		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Usuario.class, Long.parseLong(request.getParameter("excluir"))));
		em.getTransaction().commit();
		em.close();
		listar(request, response);
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Usuario obj = em.find(Usuario.class, Long.parseLong(request.getParameter("alterar")));
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("UsuarioForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void incluir(HttpServletRequest request, HttpServletResponse response) {
		try {
			Usuario obj = new Usuario();
			request.setAttribute("obj", obj);
			request.getRequestDispatcher("UsuarioForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
