<%-- 
    Document   : consulter_panier
    Created on : 13 mai 2014, 23:44:37
    Author     : Ayoub
--%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Beans.Categorie"%>
<%@page import="java.util.Vector"%>
<%@page import="Model.CategorieDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="Beans.Produit"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
    <head>
        <title>Panier</title>
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
            HttpSession ses = request.getSession();
            Map<Produit, Integer> panier = null;
            if (ses.getAttribute("panier") == null) {
                panier = new HashMap<Produit, Integer>();
                ses.setAttribute("panier", panier);
            } else {
                panier = (HashMap<Produit, Integer>) ses.getAttribute("panier");
            }

            CategorieDAO cd = null;
            Vector<Categorie> vc = new Vector<Categorie>();
            try {
                cd = new CategorieDAO();
            } catch (SQLException ex) {
            } catch (ClassNotFoundException ex) {
            }
            vc = (Vector<Categorie>) cd.getAllCategories();
            int total = 0;

            for (Entry<Produit, Integer> entry : panier.entrySet()) {
                Produit p = entry.getKey();
                int qte = entry.getValue();
                if (qte > 0) {
                    total = total + (p.getPrix() * qte);
                } else {
                    total = total + p.getPrix();
                }
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

                    <!-- Sidebar -->
                    <div id="sidebar">
                        <div class="box">
                            <div class="title">
                                <h2>Categories</h2>
                                <img class="bullet" src="css/images/bullet.png" alt="small grey bullet" />
                            </div>
                            <ul>
                                <% for (int i = 0; i < vc.size(); i++) {%>

                                <li><a title="categorie" href="categorie_produits.jsp?<%= vc.get(i).getIdCategorie()%>"><%= vc.get(i).getLibCategorie()%></a></li>
                                <% }%>							
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
                    <!-- Content -->
                    <div id="content">

                        <div class="title">
                            <h2>Panier</h2>
                            <img class="bullet" src="css/images/bullet.png" alt="small grey bullet" />
                        </div>
                        <!-- login form -->

                        <table class="data">
                            <tr class="data">
                                <th class="data">Image</th> 
                                <th class="data">Libelle</th> 
                                <th class="data">Model</th> 
                                <th class="data">Categorie</th> 
                                <th class="data">Prix</th>
                                <th class="data">Quantité</th>
                                <th class="data" width="75px">Opérations</th>
                            </tr> 
                            <%   for (Entry<Produit, Integer> entry : panier.entrySet()) {
                                    Produit p = entry.getKey();
                                    int qte = entry.getValue();
                            %>
                            <tr class="data">
                                <td class="data"><center><img src="<%= p.getImage() %>" alt="image" /></center></td>  
                                <td class="data"><center><%= p.getLibProduit()%></center></td> 
                                <td class="data"><center><%= p.getModel()%></center></td> 
                                <td class="data"><center><%= cd.getLibCategorie(p.getCategorie().getIdCategorie())%></center></td> 
                                <td class="data"><center><%= p.getPrix()%> DH</center></td>
                                <td class="data">
                                    <center>    
                                        <% for (int j=1;j<=p.getQteStock();j++){ 
                                            if(j==qte){%>
                                            <a href="modifier_panier?model=<%= p.getModel() %>&qte=<%= j %>" style="color:red;font-weight:bold; " > <%= j %></a> | 
                                           <% } else {%>
                                           <a href="modifier_panier?model=<%= p.getModel() %>&qte=<%= j %>" > <%= j %></a> | 
                                           <% } %>
                                           <% } %>
                                           
                                    </center>
                                </td>  

                                <td class="data" width="75px">
                                    <center>
                                        <a href="supprimer_produit_panier?<%= p.getModel()%>" title="Supprimer" ><img src="css/images/supprimer.png"></a>
                                    </center>
                                </td>
                            </tr>
                            <% }%>
                        </table>
                        <h3>Montant Total : <%= total %> DH</h3>
                        <% 
                    if (login != null) {%> 
                        <br/><h3><a href="enregistrer_panier?<%= total %>" style="color:red; font-variant: small-caps;font-weight: bolder;">Enregistrer Panier</a></h3>
                        <br/><h3><a href="passer_cmd?<%= total %>"  style="color:red; font-variant: small-caps;font-weight: bolder;">Passer Commande</a></h3>
                        <% } else {%> 
                          <br/><h3 style="color:red; font-variant: small-caps;font-weight: bolder;">Enregistrer Panier (Client seulement)</h3>
                          <br/><h3 style="color:red; font-variant: small-caps;font-weight: bolder;">Passer Commande (Client seulement)</h3>
                      
                        <% } %>


                        <!-- end login form -->
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
            if(request.getQueryString().equals("ajouter_panier")) { %>
            alert('Produit ajoutée au panier avec succés');
        <% } else if(request.getQueryString().equals("produit_existe")){ %>
            alert('Produit existe déja dans le panier vous pouvez modifier la quantité');
                <% } else if(request.getQueryString().equals("enregistrer_panier")){ %>
            alert('panier enregistré avec succés');
                  <% } else if(request.getQueryString().equals("enregistrer_panier")){ %>
            alert('panier modifié avec succés');
                      <% } else if(request.getQueryString().equals("supprimer_produit_panier")){ %>
            alert('produit supprime du panier avec succés');
                    <% } else if(request.getQueryString().equals("commande_passee")){ %>
            alert('commande passée avec succés');
                   <% } else if(request.getQueryString().equals("panier_vide")){ %>
            alert('vous devez sélectionner au moins un produit');
            <% }} %>
                
        </script>
    </body>
</html>
