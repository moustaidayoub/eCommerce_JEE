<%-- 
    Document   : gestion_categories
    Created on : 10 mai 2014, 23:33:12
    Author     : Ayoub
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="Beans.Categorie"%>
<%@page import="java.util.Vector"%>
<%@page import="Model.CategorieDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
	<title>Gestion Catégories</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<link rel="shortcut icon" href="css/images/favicon.ico" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	
	<script src="js/jquery-1.7.min.js" type="text/javascript"></script>
	<script src="js/jquery.jcarousel.js" type="text/javascript"></script>
	<script src="js/DD_belatedPNG-min.js" type="text/javascript"></script>
	<script src="js/functions.js" type="text/javascript"></script>
</head>
<body>
	<div class="shell">		
		    <% String login = (String)session.getAttribute("login");
        if(login !=null){         %>
		<div class="welcome-message">
			<p>Bonjour, <%= login %></p>
		</div>
                <% }%>
		<div class="cl"></div>
		<div id="wrapper-top"></div>
		<!-- Wrapper Middle -->
		<div id="wrapper-middle">
			<!-- Header -->
			<div id="header">
				<h1 id="logo"><a title="home" href="#">Furniture Store</a></h1>				
				<!-- Search -->
			
				<!-- END Search -->				
			</div>
			<!-- END Header -->
			<!-- Navigation -->
		
			<!-- END Navigation -->
			<!-- Main -->
			<div id="main">
				<!-- Slider -->
			
				<!-- END Slider -->
				<!-- Sidebar -->
					
				<!-- END Sidebar -->
				<!-- Content -->
				<div id="content">
					<div class="title">
							<h2>Gestion Catégories <a href="index.jsp">[Accueil]</a></h2>
							<img class="bullet" src="css/images/bullet.png" alt="small grey bullet" />
						</div>
						<center><h2><a href="ajout_categorie.jsp">Ajouter Une Catégorie </a></h2></center>
						<table class="data">
			<tr class="data">
				<th class="data">Libellé Catégorie</th>
				<th class="data" width="75px">Opérations</th>
			</tr>
	
		
                   <%     
                        CategorieDAO cd=null;
                        Vector<Categorie> vc=new Vector<Categorie>();
               try {
            cd = new CategorieDAO();
                 } 
               catch (SQLException ex) {}
           catch (ClassNotFoundException ex) {}
                        vc=(Vector<Categorie>)cd.getAllCategories();
                       
 
 %>
                                  <% for(int i=0;i<vc.size();i++)
                                                       { %>
			<tr class="data">
                           <td class="data"><center><%= vc.get(i).getLibCategorie() %></center></td>
				<td class="data" width="75px">  
				<center> 
                                    <a href="modifier_categorie.jsp?<%= vc.get(i).getIdCategorie() %>" title="Modifier"><img src="css/images/modifier.png"></a>&nbsp;&nbsp;&nbsp;  
				<a href="supprimer_categorie?<%= vc.get(i).getIdCategorie() %>" title="Supprimer"><img src="css/images/supprimer.png"></a>  
				</center>  
				</td> 
			</tr> 
			<% } %>
			
		
			
			
		</table> 
				</div> 
				<!-- END Content --> 
				<div class="cl"></div> 
			</div>
			<!-- END Main -->
		</div>
		<!-- END Wrapper Middle -->
		<div id="wrapper-bottom"></div>	
		<!-- Footer  -->
		<div id="footer">
			<span class="author">By : Moustaid Ayoub - Addoumi Mohammed - El Haloui Hicham</span>
		</div>
		<!-- END Footer --> 
	</div>
                        <script>
                        <% if(request.getQueryString()!=null){ 
            if(request.getQueryString().equals("categorie_ajoutee")) { %>
            alert('Categorie ajoutée avec succés');
        <% } if(request.getQueryString().equals("categorie_modifiee")) { %>
            alert('Categorie modifiée avec succés');
         <% } if(request.getQueryString().equals("categorie_supprimee")) { %>
            alert('Categorie supprimee avec succés');
        <% }} %>
            </script>
</body>  
</html>  