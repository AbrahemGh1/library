<%@page import="com.demo.hibernate.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/searchForBook.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<%@ include file="header.jsp" %> 
</head>
<body>
<%@page import= "com.demo.beans.SearchBookByNameBean" %>
<%@page import= "com.demo.hibernate.entity.Book" %>
<%@page import= "java.util.List" %>
<jsp:useBean id="SearchBookByNameBeanId" type="com.demo.beans.SearchBookByNameBean" class="com.demo.beans.SearchBookByNameBean">
    <jsp:setProperty name="SearchBookByNameBeanId" property="*"/>
</jsp:useBean>  
<%System.out.print(SearchBookByNameBeanId.getBookName()+"from "); %>
<% List<Book> bookResult = SearchBookByNameBeanId.searchResult(); %>
<div id="divtable">
<table id="t01" style="width:100%">
<caption>Search Result</caption>
  <tr>
    <th>ID</th>
    <th>Author</th> 
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
  </tr>
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
</table>
</div>






</body>
</html>