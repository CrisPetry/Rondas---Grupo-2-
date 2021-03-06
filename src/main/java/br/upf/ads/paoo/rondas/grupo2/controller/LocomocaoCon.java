package br.upf.ads.paoo.rondas.grupo2.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.upf.ads.paoo.rondas.grupo2.jpa.JpaUtil;
import br.upf.ads.paoo.rondas.grupo2.model.Locomocao;

@WebServlet("/Privada/Locomocao/LocomocaoCon")
public class LocomocaoCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LocomocaoCon() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


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
			List<Locomocao> lista = em.createQuery("from Locomocao").getResultList();
			request.setAttribute("lista", lista);
			em.close();
			request.getRequestDispatcher("LocomocaoList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cancelar(HttpServletRequest request, HttpServletResponse response) {
		listar(request, response);
	}

	private void gravar(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Locomocao p = new Locomocao(
				Long.parseLong(request.getParameter("id")),
				request.getParameter("descricao"),
				request.getParameter("placa")
				);
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Locomocao.class, Long.parseLong(request.getParameter("excluir"))));
		em.getTransaction().commit();
		em.close();
		listar(request, response);
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Locomocao obj = em.find(Locomocao.class, Long.parseLong(request.getParameter("alterar")));
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("LocomocaoForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void incluir(HttpServletRequest request, HttpServletResponse response) {
		try {
			Locomocao obj = new Locomocao();
			request.setAttribute("obj", obj);
			request.getRequestDispatcher("LocomocaoForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
