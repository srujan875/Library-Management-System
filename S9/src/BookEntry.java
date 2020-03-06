

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class BookEntry extends HttpServlet {
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			PrintWriter out =res.getWriter();
			res.setContentType("text/html");
			
		String bid=req.getParameter("id");
			String bname=req.getParameter("name");
			String bauthor=req.getParameter("author");
			String bcategory=req.getParameter("cat");
			int avail=Integer.parseInt(req.getParameter("avail"));
			
	Configuration cfg=new Configuration();
			
			cfg.configure("hibernate2.cfg.xml");
			
			SessionFactory sf=cfg.buildSessionFactory();
			
			Session session=sf.openSession();
			
			BookDetails bd=new BookDetails();
			
			bd.setAvailability(avail);
			bd.setBookauthor(bauthor);
			bd.setBookid(bid);
			bd.setBookcategory(bcategory);
			bd.setBookname(bname);
			
			Transaction txt=session.beginTransaction(); 
			
			session.save(bd);
			txt.commit();
			
			session.close();
			sf.close();
			
			 RequestDispatcher rd=req.getRequestDispatcher("issuesu.html");
		        rd.forward(req,res);
			
			
	}

}
