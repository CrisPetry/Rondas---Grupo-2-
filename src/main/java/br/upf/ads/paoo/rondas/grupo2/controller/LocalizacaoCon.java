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
import br.upf.ads.paoo.rondas.grupo2.model.Localizacao;
import net.iamvegan.multipartrequest.HttpServletMultipartRequest;

@WebServlet("/Privada/Localizacao/LocalizacaoCon")
public class LocalizacaoCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LocalizacaoCon() {
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
			List<Localizacao> lista = em.createQuery("from Localizacao").getResultList();
			request.setAttribute("lista", lista);
			em.close();
			request.getRequestDispatcher("LocalizacaoList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cancelar(HttpServletRequest request, HttpServletResponse response) {
		listar(request, response);
	}

	private void gravar(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Date d1 = null;
		try {
			d1 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataHora"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Localizacao p = new Localizacao(
				Long.parseLong(request.getParameter("id")),
				d1,
				Float.parseFloat(request.getParameter("lat")),
				Float.parseFloat(request.getParameter("lon")));

		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Localizacao.class, Long.parseLong(request.getParameter("excluir"))));
		em.getTransaction().commit();
		em.close();
		listar(request, response);
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Localizacao obj = em.find(Localizacao.class, Long.parseLong(request.getParameter("alterar")));
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("LocalizacaoForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void incluir(HttpServletRequest request, HttpServletResponse response) {
		try {
			Localizacao obj = new Localizacao();
			request.setAttribute("obj", obj);
			request.getRequestDispatcher("LocalizacaoForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
