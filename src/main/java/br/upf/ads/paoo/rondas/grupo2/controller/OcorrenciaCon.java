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
import br.upf.ads.paoo.rondas.grupo2.model.Ocorrencia;
import br.upf.ads.paoo.rondas.grupo2.util.Upload;
import net.iamvegan.multipartrequest.HttpServletMultipartRequest;

@WebServlet("/Privada/Ocorrencia/OcorrenciaCon")
public class OcorrenciaCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OcorrenciaCon() {
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
			Ocorrencia obj = em.find(Ocorrencia.class, Long.parseLong(request.getParameter("alterarFoto")));
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("OcorrenciaFoto.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void gravarFoto(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtil.getEntityManager();

		em.getTransaction().begin();
		Ocorrencia obj = em.find(Ocorrencia.class, Long.parseLong(request.getParameter("id")));

		if (request.getParameter("foto") != null) {
			String nomeArquivo = "Foto" + request.getParameter("id") + ".jpg";

			String caminho = getServletConfig().getServletContext().getRealPath("/") + "Privada/Ocorrencia/uploads";

			Upload.copiarArquivo((HttpServletMultipartRequest) request, "foto", caminho, nomeArquivo);

			obj.setFoto(Upload.getBytesArquivo((HttpServletMultipartRequest) request, "foto"));

		}

		em.merge(obj);
		em.getTransaction().commit();
		em.close();
		listar(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			List<Ocorrencia> lista = em.createQuery("from Ocorrencia").getResultList();
			request.setAttribute("lista", lista);
			em.close();
			request.getRequestDispatcher("OcorrenciaList.jsp").forward(request, response);
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
		Ocorrencia p = new Ocorrencia(Long.parseLong(request.getParameter("id")),
				d1,
				request.getParameter("titulo"),
				request.getParameter("descricao"),
				Float.parseFloat(request.getParameter("lat")),
				Float.parseFloat(request.getParameter("lon"))
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
		em.remove(em.find(Ocorrencia.class, Long.parseLong(request.getParameter("excluir"))));
		em.getTransaction().commit();
		em.close();
		listar(request, response);
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) {
		try {
			EntityManager em = JpaUtil.getEntityManager();
			Ocorrencia obj = em.find(Ocorrencia.class, Long.parseLong(request.getParameter("alterar")));
			request.setAttribute("obj", obj);
			em.close();
			request.getRequestDispatcher("OcorrenciaForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void incluir(HttpServletRequest request, HttpServletResponse response) {
		try {
			Ocorrencia obj = new Ocorrencia();
			request.setAttribute("obj", obj);
			request.getRequestDispatcher("OcorrenciaForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
