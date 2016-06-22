<%-- 
    Document   : index
    Created on : 9 mai 2014, 14:53:59
    Author     : Ayoub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
	<title>Home-Administration</title>
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
					<!-- Products -->
					<div class="products">
					
						<div class="row">
<div class="product-holder">	
								<div class="product">
									<a title="gestion produits" href="gestion_produits.jsp"><img src="css/images/produits.jpg" alt="gestion produits" /></a>
									<div class="desc">
										<p>Gestion</p>
										<p class="price">Produits</p>
									</div>
									<div class="bottom"></div>
								</div>	
								<div class="product-bottom"></div>
							</div>						
							<div class="product-holder">	
								<div class="product">
									<a title="gestion catégories" href="gestion_categories.jsp"><img src="css/images/categories.jpg" alt="gestion categories" /></a>
									<div class="desc">
										<p>Gestion</p>
										<p class="price">Catégories</p>
									</div>
									<div class="bottom"></div>
								</div>	
								<div class="product-bottom"></div>
							</div>
							<div class="product-holder">	
								<div class="product">
									<a title="gestion clients" href="gestion_clients.jsp"><img src="css/images/clients.png" alt="gestion clients" /></a>
									<div class="desc">
										<p>Gestion</p>
										<p class="price">Clients</p>
									</div>
									<div class="bottom"></div>
								</div>	
								<div class="product-bottom"></div>
							</div>
						<div class="product-holder">	
								<div class="product">
									<a title="gestion commandes" href="gestion_commandes.jsp"><img src="css/images/cmd.png" alt="gestion commandes" /></a>
									<div class="desc">
										<p>Gestion</p>
										<p class="price">Commandes</p>
									</div>
									<div class="bottom"></div>
								</div>	
								<div class="product-bottom"></div>
							</div>
						</div>
						
						<div class="cl"></div>
					</div>
					<!-- END Products -->
					
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