

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Return extends HttpServlet {
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			PrintWriter out =res.getWriter();
			res.setContentType("text/html");
			
		int sid=Integer.parseInt(req.getParameter("sid"));
		String bid=req.getParameter("bid");
		
		String rdate=req.getParameter("rdate");
			
	Configuration cfg=new Configuration();
			
			cfg.configure("hibernate3.cfg.xml");
			
			SessionFactory sf=cfg.buildSessionFactory();
			
			Session session=sf.openSession();
			
			
			Query qry=session.createQuery("update BookLog set returndate=?,status=? where studentid=? and bookid=?");
			
			qry.setString(0,rdate);
			qry.setString(1,"returned");
			qry.setInteger(2,sid);
			qry.setString(3,bid);
			int n=qry.executeUpdate();
			
			Transaction txt=session.beginTransaction(); 
			
			
			txt.commit();
			
			session.close();
			sf.close();
			
			 RequestDispatcher rd=req.getRequestDispatcher("returnsu.html");
		        rd.forward(req,res);
			
			
	}

}
