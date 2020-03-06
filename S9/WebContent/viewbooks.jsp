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
		 <h3 aligin="center">Book Details</h3>
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
		 </table>
		 <%
		 
}
catch(Exception e)
{
	out.println("Exception:"+e.getMessage());
}

%>
