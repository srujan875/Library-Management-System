

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


public class Log extends HttpServlet {
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			PrintWriter out =res.getWriter();
			res.setContentType("text/html");
			
		int sid=Integer.parseInt(req.getParameter("sid"));
		String bid=req.getParameter("bid");
		String idate=req.getParameter("idate");
		String rdate=req.getParameter("rdate");
			
	Configuration cfg=new Configuration();
			
			cfg.configure("hibernate3.cfg.xml");
			
			SessionFactory sf=cfg.buildSessionFactory();
			
			Session session=sf.openSession();
			
			BookLog bl= new BookLog();
			
			bl.setBookid(bid);
			bl.setIssuedate(idate);
			bl.setReturndate(rdate);
			bl.setStatus("issued");
			bl.setStudentid(sid);
		
			
			Transaction txt=session.beginTransaction(); 
			
			session.save(bl);
			txt.commit();
			
			session.close();
			sf.close();
			
			 RequestDispatcher rd=req.getRequestDispatcher("issuesu.html");
		        rd.forward(req,res);
			
			
	}

}
