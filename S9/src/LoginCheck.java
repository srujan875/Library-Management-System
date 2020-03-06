

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


public class LoginCheck extends HttpServlet {
	
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out =res.getWriter();
		res.setContentType("text/html");
		
		
		int id=Integer.parseInt(req.getParameter("id"));
		
	String pwd=req.getParameter("pwd");
	
Configuration cfg=new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		
		MemberLogin ml=new MemberLogin();
		try {
Object obj=session.load(MemberLogin.class,new Integer(id));
MemberLogin ml2=(MemberLogin)obj;


if(ml2.getRole().equals("member"))
{
	RequestDispatcher rd=req.getRequestDispatcher("Home1.html");
    rd.forward(req,res);
}
else if(ml2.getRole().equals("incharge")) {
	RequestDispatcher rd=req.getRequestDispatcher("Home.html");
    rd.forward(req,res);
}


Transaction txt=session.beginTransaction(); 

session.save(ml);
txt.commit();

session.close();
sf.close();

		}
		catch(Exception e)
		{
			out.println("invalid login"+"<br>"+"<a href='index.html'>click here</a>");
		}
	}

}
