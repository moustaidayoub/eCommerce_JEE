<%-- 
    Document   : categorie_produits
    Created on : 13 mai 2014, 16:24:27
    Author     : Ayoub
--%>

<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map"%>
<%@page import="Beans.Categorie"%>
<%@page import="Model.CategorieDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Beans.Produit"%>
<%@page import="java.util.Vector"%>
<%@page import="Model.ProduitDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
	<title>Produits</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<link rel="shortcut icon" href="css/images/favicon.ico" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

	<script src="js/jquery-1.7.min.js" type="text/javascript"></script>
	<script src="js/jquery.jcarousel.js" type="text/javascript"></script>
	<script src="js/DD_belatedPNG-min.js" type="text/javascript"></script>
	<script src="js/functions.js" type="text/javascript"></script>
</head>
<body>
	                                                                 <% 
                                       HttpSession ses=request.getSession(); 
                                       Map<Produit,Integer> panier=null;
                                       if(ses.getAttribute("panier")==null) 
                                                 {
                                           panier=new HashMap<Produit,Integer>();
                                           ses.setAttribute("panier", panier);
                                       }  
                                                      else 
                                                  panier=(HashMap<Produit,Integer>)ses.getAttribute("panier");
                                                                
                        CategorieDAO cd=null;
                        Vector<Categorie> vc=new Vector<Categorie>();
               try {
            cd = new CategorieDAO();
                 } 
               catch (SQLException ex) {}
           catch (ClassNotFoundException ex) {}
                        vc=(Vector<Categorie>)cd.getAllCategories();
                        int total=0;
                        
                        for(Entry<Produit, Integer> entry : panier.entrySet()) {
    Produit p = entry.getKey(); 
    int qte = entry.getValue();
    if(qte>0)
        total=total+(p.getPrix()*qte);
       else 
           total=total+p.getPrix();
                        }

                       
 
 %>
	<div class="shell">		
				<div id="top-navigation">
                    
	<% String login = (String)session.getAttribute("login");
        if(login !=null){         %> 
        
		 	<a title="Se deconnecter" href="deconnexion">DECONNEXION</a><a title="Mon Espace Client" href="espace_client.jsp">MON ESPACE CLIENT</a><a class="cart" title="Panier" href="consulter_panier.jsp">Panier</a><a></a><span><%= panier.size()  %> Article(s)</span><span class="sep">|</span><span><%= total %> DH</span>
		</div>
                <div class="welcome-message">
<p> Bonjour, <%= login %> </p></div> 
<% }else { %> 
<a title="Se connecter" href="connexion.jsp">CONNEXION</a><a title="s'inscrire" href="inscription.jsp">INSCRIPTION</a><a class="cart" title="Panier" href="consulter_panier.jsp">Panier</a><a></a><span><%= panier.size()  %> Article(s)</span><span class="sep">|</span><span><%= total %> DH</span>
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
		
			<div id="navigation">
				<ul>
				<li class="first"><a title="Home" href="index.jsp">Accueil<span class="home">&nbsp;</span></a></li>
					<li><a title="A Propos" href="#">A Propos</a></li>
					<li><a title="Contactez-Nous" href="#">Contactez-Nous</a></li>
				</ul>
				<div class="cl"></div>
			</div>
			
			<!-- END Navigation -->
			<!-- Main -->
			<div id="main">
				<!-- Slider -->
			
				<!-- END Slider -->
				<!-- Sidebar -->
					
				<!-- END Sidebar -->
				<!-- Content -->
				<div id="content">
					<!-- Products -->
					<div class="products">
					
						<div class="row">
                                                                                                                 <%     
                        ProduitDAO pd=null;
                        CategorieDAO cdao=null;
                        Vector<Produit> vp=new Vector<Produit>();
               try {
            pd = new ProduitDAO();
            cdao= new CategorieDAO();
                 }   
               catch (SQLException ex) {}
           catch (ClassNotFoundException ex) {}
                         vp=(Vector<Produit>)pd.getProduitsByCategorie(Integer.parseInt(request.getQueryString()));
                       
 
 %>
                  <% for(int i=0;i<vp.size();i++)
                                                       { %>
                                                        <div class="product-holder">	
								<div class="product">
                                                                    <img src="<%= vp.get(i).getImage() %>" alt="image produit" />
									<div class="desc">
                                                                            <p>Libellé : <%= vp.get(i).getLibProduit() %></p> 
                                                                            <p>Model : <%= vp.get(i).getModel() %></p> 
                                                                            <p>Catégorie : <%= cdao.getLibCategorie(vp.get(i).getCategorie().getIdCategorie()) %></p> 
										<p class="price">Prix : <%= vp.get(i).getPrix() %></p>
                                                                               <p>Qte en Stock: <%= vp.get(i).getQteStock() %></p>
                                                                                <a href="ajouter_panier?<%= vp.get(i).getModel() %>" >Ajouter Au Panier</a>
									</div>
									<div class="bottom"></div>
								</div>	
								<div class="product-bottom"></div>
							</div>						
							<% } %>
                                                    	
                                                       	
						</div>
						
						<div class="cl"></div>
					</div>
					<!-- END Products -->
					
				</div>
                                                <div id="sidebar">
					<div class="box">
						<div class="title">
							<h2>Categories</h2>
							<img class="bullet" src="css/images/bullet.png" alt="small grey bullet" />
						</div>
                                            <ul>
                               
                                  <% for(int i=0;i<vc.size();i++)
                                                       { %>
						
                                                        <li><a title="Cabinets" href="categorie_produits.jsp?<%= vc.get(i).getIdCategorie() %>"><%= vc.get(i).getLibCategorie() %></a></li>
                                                       <% } %>
						</ul> 
					</div>
					<div class="box">
						<div class="title">
							<h2>Partenaires</h2>
							<img class="bullet" src="css/images/bullet.png" alt="small grey bullet" />
						</div>
						<ul>
							<li><a title="Hmall" href="www.hmall.ma">Hmall.ma - 1er Mall en ligne au Maroc</a></li>
							<li><a title="Jumia" href="www.jumia.ma">Jumia.ma‎ - Vente En Ligne Sur Jumia - </a></li>		
							<li><a title="Bikhir" href="www.bikhir.ma">Bikhir.ma - Achetez tout sur Bikhir</a></li>							
						</ul>
					</div>
					<div class="box">
						<div class="title">
							<h2>Suivez-Nous</h2>
							<img class="bullet" src="css/images/bullet.png" alt="small grey bullet" />
						</div>	
						<ul class="socials">
							<li><a title="Facebook" href="#"><img src="css/images/fb.png" alt="facebook icon" />facebook</a></li>
							<li><a title="Tweeter" href="#"><img src="css/images/tweet.png" alt="tweeter icon" />twitter</a></li>
							<li><a title="Blogger" href="#"><img src="css/images/blogger.png" alt="blogger icon" />blogger</a></li>
						</ul>
					</div>
				</div>
				<!-- END Sidebar -->
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
