<%-- 
    Document   : modifier_produit
    Created on : 13 mai 2014, 10:45:30
    Author     : Ayoub
--%>
<%@page import="Beans.Produit"%>
<%@page import="Model.ProduitDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Beans.Categorie"%>
<%@page import="java.util.Vector"%>
<%@page import="Model.CategorieDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
	<title>Modifier Produit</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<link rel="shortcut icon" href="css/images/favicon.ico" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/styles.css" type="text/css" media="all" />
	
	<script src="js/jquery-1.7.min.js" type="text/javascript"></script>
	<script src="js/jquery.jcarousel.js" type="text/javascript"></script>
	<script src="js/DD_belatedPNG-min.js" type="text/javascript"></script>
	<script src="js/functions.js" type="text/javascript"></script>
         <script>
         function verifLength(champ)
{
    if (champ.value.length < 6 )
    {
        surligne(champ, true);
        alert('6 caractères au moins pour chaque champ');
        return false;
    }
    else
    {
        surligne(champ, false);
             return true;
    }
}
   function surligne(champ, erreur)
{
   if(erreur)
      champ.style.backgroundColor = "#F6CECE";
   else
      champ.style.backgroundColor = "";
}
</script>
</head>
<body>
	<div class="shell">		
		    <% String login = (String)session.getAttribute("login");
        if(login !=null){         %>
		<div class="welcome-message">
			<p>Bonjour, <%= login %></p>
		</div>
                <% } %>
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
							<h2>Modification de Produit </h2>
							<img class="bullet" src="css/images/bullet.png" alt="small grey bullet" />
						</div>
			<form method="POST" action="modifier_produit?<%= request.getQueryString() %>">
		 <%     
                        CategorieDAO cd=null; 
                        ProduitDAO pd=null; 
                        Produit p=new Produit();
                        Vector<Categorie> vc=new Vector<Categorie>(); 
               try {
            cd = new CategorieDAO();
            pd=new ProduitDAO();
                 } 
               catch (SQLException ex) {}
           catch (ClassNotFoundException ex) {}
                        vc=(Vector<Categorie>)cd.getAllCategories();
                       p=pd.getProduit(request.getQueryString());
 
 %>
		<label for="select">Categorie :</label>
                <select name="categorie">
                    
                      <% for(int i=0;i<vc.size();i++)
                                                       { %>
                                 <% if(vc.get(i).getIdCategorie()==p.getCategorie().getIdCategorie()){%> 
                                 <option value="<%= vc.get(i).getIdCategorie() %>" selected><%= vc.get(i).getLibCategorie() %></option>
                    <% } else{%>
                <option value="<%= vc.get(i).getIdCategorie() %>"><%= vc.get(i).getLibCategorie() %></option>

                   <% }}%>
                </select>
		<br/>
		
		
		<label for="name">Libellé produit :</label>
		<input type="name" name="libelle" onblur="verifLength(this);" value="<%= p.getLibProduit() %>" required>
		<br/>
                    
		<label for="name">Prix :</label>
                <input type="name" name="prix" value="<%= p.getPrix() %>" required>
		<br/>
		
                <label for="name">Qte en Stock :</label>
                <input type="name" name="qte_stock" value="<%= p.getQteStock() %>" required>
		<br/>
		
		<input type="submit" value="Modifier">
		
		
		</form>			
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
</body>
</html>
