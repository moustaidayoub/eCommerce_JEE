<%-- 
    Document   : gestion_produits
    Created on : 10 mai 2014, 23:32:25
    Author     : Ayoub
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="Beans.Produit"%>
<%@page import="java.util.Vector"%>
<%@page import="Model.ProduitDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
	<title>Gestion Produits</title>
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
							<h2>Gestion Produits <a href="index.jsp">[Accueil]</a></h2>
							<img class="bullet" src="css/images/bullet.png" alt="small grey bullet" />
						</div>
			<center><a href="ajouter_produit.jsp"><h2> Ajouter Un Produit </h2></a></center>
                        <%     
                        ProduitDAO pd=null;
                        Vector<Produit> vp=new Vector<Produit>();
               try {
            pd = new ProduitDAO();
                 } 
               catch (SQLException ex) {} 
           catch (ClassNotFoundException ex) {}
                        vp=(Vector<Produit>)pd.getAllProduits();
                       
 
 %>
<table class="data">
			 <tr class="data">
				<th class="data">Image</th> 
                                <th class="data">Libelle</th> 
                                <th class="data">Model</th> 
                                <th class="data">Categorie</th> 
                                <th class="data">Prix Unite</th>
                                <th class="data">Qte en Stock</th>
				<th class="data" width="75px">Opérations</th>
			</tr>  
    <% for(int i=0;i<vp.size();i++)
                                                       {%> 
                         <tr class="data">
                             <td class="data"><center><img src="<%= vp.get(i).getImage() %>" alt="image" /></center></td> 
                                <td class="data"><center><%= vp.get(i).getLibProduit() %></center></td> 
                                <td class="data"><center><%= vp.get(i).getModel() %></center></td> 
                                <td class="data"><center><%= vp.get(i).getCategorie().getLibCategorie() %></center></td> 
                                <td class="data"><center><%= vp.get(i).getPrix() %></center></td> 
                                <td class="data"><center><%= vp.get(i).getQteStock() %></center></td>  
				<td class="data" width="75px">
				<center>
                                    <a href="modifier_produit.jsp?<%= vp.get(i).getModel() %>" title="Modifier" ><img src="css/images/modifier.png"></a>&nbsp;&nbsp;&nbsp;
				<a href="supprimer_produit?<%= vp.get(i).getModel() %>" title="Supprimer" ><img src="css/images/supprimer.png"></a>
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
            if(request.getQueryString().equals("produit_ajoute")) { %>
            alert('Produit ajouté avec succés');
        <% } else if(request.getQueryString().equals("produit_modifie")){ %>
            alert('Produit modifié avec succés');
                <% } else if(request.getQueryString().equals("produit_supprime")){ %>
            alert('produit supprimé avec succés');
            <% }} %>
                </script>
</body> 
</html> 