





<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>registration</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Coustard">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" href="assets/css/styles.min.css">
</head>

<body style="background-image:url(&quot;assets/img/lib.jpg&quot;);background-size:cover;background-position:center;background-repeat:no-repeat;">
    <div class="highlight-clean" style="margin:150px;margin-top:120px;width:70%;height:620px;margin-bottom:219px;margin-right:219px;margin-left:18%;">
        <div class="container">
            <div class="intro">
                <%@ page import="java.sql.*" %>

<%

String bname = request.getParameter("bname");




try
{
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 System.out.println("Driver Classes Loaded");  
		 Connection con = null;
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "s9", "s9");  
		 System.out.println("Connection Established");
		 PreparedStatement preparedStatement = con.prepareStatement("select * from bookinfo where bookname like ? ");
		 preparedStatement.setString(1,"%"+bname+"%");
		 ResultSet rs = preparedStatement.executeQuery();
		 
		 %>
		 <div >
		  <h3 style="text-align:center">Book Detail</h3>
		 <table align=center border=3 width=650 height=200>
		
		 <tr align=center>
		 <th>ID</th>
		 <th>NAME</th>
		 <th>AUTHOR</th>
		 <th>CATEGORY</th>
		 <th>AVAILABILITY</th>
		 <th>STATUS</th>
		 </tr>
		 <%
		 while(rs.next())
		 {
			 %>
			 <tr align=center>
			 <td><%=rs.getString(1)%></td>
			 <td><%=rs.getString(2)%></td>
			 <td><%=rs.getString(3)%></td>
			 <td><%=rs.getString(4)%></td>
			 <td><%=rs.getInt(5)%></td>
			 <%
			 if(rs.getInt(5)>0)
			 {
				%>
				<td bgcolor="green"><b>Available</b></td>
				<% 
			 }
			 else
			 {
				
					 PreparedStatement pstmt2 = con.prepareStatement("select * from booklog where bookid= ? ");
					 pstmt2.setString(1,rs.getString(1));
					 ResultSet rs1=pstmt2.executeQuery();
					 if(rs1.next())
					 {
						 %>
					 <td><b>Sorry Your request will be from:<font color="red"><%=rs1.getString(5) %></font></b></td>
					 <%
					 }
					 else
					 {
						 %>
					<td bgcolor="red"><b>Not Available</b></td>
					<%
					}
					 
				 }
			 
			 %>
			
			 </tr>
			 <%
		 }
		 %>
		 </table></div>
		 <%
		 
}
catch(Exception e)
{
	out.println("Exception:"+e.getMessage());
}

%>
                
               
            </div>
            <div class="buttons"><a class="btn btn-outline-primary" role="button" href="booksearch.html">search Other</a></div>
        </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
    <script src="assets/js/script.min.js"></script>
</body>

</html>