package br.upf.ads.paoo.rondas.grupo2.relatorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;

import br.upf.ads.paoo.rondas.grupo2.jpa.JpaUtil;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


public class RelatorioUtil {

	public static void rodarRelatorioPDF(String pathRelatorio, HashMap parameters, String nomeArquivo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection con = getEntityManagerJDBCConnection();
		JasperPrint jasperPrint = JasperFillManager.fillReport(request.getServletContext().getRealPath("/"+pathRelatorio), parameters, con);
		byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline;filename="+nomeArquivo);
		response.getOutputStream().write(b);
		response.getOutputStream().flush();
	    response.getOutputStream().close();
	}	
	
    public static Connection getEntityManagerJDBCConnection() throws SQLException { 
        EntityManager em = JpaUtil.getEntityManager();
        Session s = (Session) em;
        SessionImplementor sim = (SessionImplementor) s;
        Connection conexao = sim.connection();
        em.close();
        conexao.setAutoCommit(false);
        return conexao; 
    }
}
