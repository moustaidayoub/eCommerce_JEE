<%--  
    Document   : gestion_clients
    Created on : 10 mai 2014, 23:32:45
    Author     : Ayoub
--%>

<%@page import="Beans.Client"%>
<%@page import="Model.ClientDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
	<title>Gestion Clients</title>
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
							<h2>Gestion Clients <a href="index.jsp">[Accueil]</a></h2>
							<img class="bullet" src="css/images/bullet.png" alt="small grey bullet" />
						</div>
						<table class="data">
			<tr class="data">
				<th class="data">Login</th> 
                                <th class="data">Nom</th> 
                                <th class="data">Prenom</th> 
                                <th class="data">Email</th> 
                                <th class="data">Date Inscription</th> 
                                <th class="data">Mot de Passe</th> 
                                  <th class="data">Sexe</th> 
                                <th class="data">Date Naissance</th> 
                                <th class="data">Adresse</th> 
				<th class="data" width="75px">Opérations</th>
			</tr>
	
		        <%     
                        ClientDAO cd=null;
                        Vector<Client> vc=new Vector<Client>();
               try {
            cd = new ClientDAO();
                 } 
               catch (SQLException ex) {} 
           catch (ClassNotFoundException ex) {}
                        vc=(Vector<Client>)cd.getAllClients();
                       
 
 %>
                                  <% for(int i=0;i<vc.size();i++) 
                                                       {  %>
			<tr class="data">
				<td class="data"><center><%= vc.get(i).getLogin() %></center></td> 
                                <td class="data"><center><%= vc.get(i).getNomClient() %></center></td> 
                                <td class="data"><center><%= vc.get(i).getPrenomClient() %></center></td> 
                                <td class="data"><center><%= vc.get(i).getEmailClient() %></center></td> 
                                <td class="data"><center><%= vc.get(i).getDateInscription() %></center></td> 
                                <td class="data"><center><%= vc.get(i).getMotdepasse() %></center></td> 
                                <td class="data"><center><%= vc.get(i).getSexe() %></center></td> 
                                <td class="data"><center><%= vc.get(i).getDateNaissance() %></center></td>
                                <td class="data"><center><%= vc.get(i).getAdresse() %></center></td> 
				<td class="data" width="75px">
				<center>
				<a href="supprimer_client?<%= vc.get(i).getLogin() %>" title="Supprimer" ><img src="css/images/supprimer.png"></a>
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
            if(request.getQueryString().equals("client_supprime")) { %>
            alert('Client supprimé avec succés');
        <% }} %>
            </script>
</body>
</html>