

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


public class Registration extends HttpServlet {
	
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out =res.getWriter();
		res.setContentType("text/html");
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		String role="member";
		long phone=Long.parseLong(req.getParameter("phone"));
		
		
Configuration cfg=new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		
		MemberLogin ml=new MemberLogin();
		
		ml.setUserid(id);
		ml.setEmail(email);
		ml.setName(name);
		ml.setPassword(pwd);
		ml.setRole(role);
		ml.setPhonenumber(phone);
		
		
		Transaction txt=session.beginTransaction(); 
		
		session.save(ml);
		txt.commit();
		
		session.close();
		sf.close();
		
		 RequestDispatcher rd=req.getRequestDispatcher("regsu.html");
	        rd.forward(req,res);
	}

}
