

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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


public class Booksearch extends HttpServlet {
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			PrintWriter out =res.getWriter();
			res.setContentType("text/html");
			
		String bname=req.getParameter("bname");
			
	Configuration cfg=new Configuration();
			
			cfg.configure("hibernate3.cfg.xml");
			
			SessionFactory sf=cfg.buildSessionFactory();
			
			Session session=sf.openSession();
			
			BookDetails bd=new BookDetails();
			
			Query qry=session.createQuery("  from BookDetails where bookname=?");
			qry.setString(0, bname);
			
		
			
			int count=0;
			String bookid=null,name = null,author=null;
			List<BookDetails> list=qry.list();
			
			for(BookDetails emp:list)
			{
				 bookid=emp.getBookid();
				name=emp.getBookname();
				 author=emp.getBookauthor();
				
				count=emp.getAvailability();
			}
			
		if(count>0)
		{
			req.setAttribute("bname",name);
			req.setAttribute("bookid", bookid);
			req.setAttribute("author", author);
			req.setAttribute("count",count);
			 RequestDispatcher rd=req.getRequestDispatcher("searchsu.jsp");
		        rd.forward(req,res);
		}
		else
		{
			Query qry1=session.createQuery("from BookLog where bookid=?");
		
			qry1.setString(1,bookid);
			
			
			String date=null;
			List<BookLog> list2=qry1.list();
			for(BookLog emp1:list2)
			{
			}
					out.print(date+","+bookid);
		}
	
			
			
	
			
			session.close();
			sf.close();
			
			 
			
	}

}
