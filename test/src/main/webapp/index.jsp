<html>

<head>
<title>Book Library System</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<%@page import= "com.demo.hibernate.entity.Book" %>
<%@page import= "com.demo.hibernate.repo.BookRepository" %>
<%@page import= "com.demo.beans.SaveBookBean" %>

<%@page import= "java.util.List" %>
<%@ include file="header.jsp" %> 
<jsp:useBean id="bookBean" type="com.demo.hibernate.entity.Book" class="com.demo.hibernate.entity.Book">
    <jsp:setProperty name="bookBean" property="*"/>
</jsp:useBean> 
<jsp:useBean id="saveBookBeanId" type="com.demo.beans.SaveBookBean" class="com.demo.beans.SaveBookBean"></jsp:useBean>

</head>
<body>
<% Book bookToSave= new Book();
bookToSave.setAuthor(request.getParameter("outhor"));
bookToSave.setName(request.getParameter("name"));
if(request.getParameter("price")!=null)
bookToSave.setPrice(Double.parseDouble( request.getParameter("price")));
if(request.getParameter("quantity") != null)
bookToSave.setQuantity(Double.parseDouble( request.getParameter("quantity")));
saveBookBeanId.setB(bookToSave);
%>
    <% List<Book> bookResult = new BookRepository().getBooks(); %>
<div id="divtable">
<table id="t01" style="width:100%">
<caption>Available books </caption>
  <tr>
    <th>ID</th>
    <th>Author</th> 
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
  </tr>
<% System.out.print("Book to save:"+bookBean.getAuthor()+bookBean.getName()+bookBean.getPrice()+bookBean.getQuantity()); %>
<%for(int i=0;i<bookResult.size();i++) {
Book b=bookResult.get(i);
%>
<tr>
    <td><%=b.getId() %></td>
    <td><%=b.getAuthor() %></td>
    <td><%=b.getName() %></td>
    <td><%=b.getPrice() %></td>
    <td><%=b.getQuantity() %></td>
  </tr>
<%} %>
<form method = "POST">
<tr id="trInForm">
<td><input type = "submit" value = "Add new entery" /></td>
<td><input type = "text" name = "outhor"></td>
<td><input type = "text" name = "name"></td>
<td><input type = "text" name = "price"></td>
<td><input type = "number" name = "quantity"></td>
  </tr>
  </form>
</table>
</div>
<%if(saveBookBeanId.canBeSaved()) saveBookBeanId.saveBook(); %>
    
</body>
</html>
