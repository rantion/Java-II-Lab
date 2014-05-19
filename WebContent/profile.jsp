<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<head>
		<title>Profile</title>

		<link href="bootstrap-3.1.1-dist/bootstrap-3.1.1-dist/css/bootstrap-modal-bs3patch.css" rel="stylesheet">
		<link href="bootstrap-3.1.1-dist/bootstrap-3.1.1-dist/css/bootstrap-modal.css" rel="stylesheet">

		<link href="bootstrap-3.1.1-dist/bootstrap-3.1.1-dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	
	<body>
	
    <div class="container">

      <!-- Static navbar -->
      <div class="navbar navbar-default" id="header" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
            	
            	<div class="col-lg-12 dark-blue-font" >Welcome</h4></div>
            </a>
          </div>
          
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav dark-blue-font">
              <li><a href="#"><div class="col-md-12 dark-blue-font">Search Bar</div></a></li>
              <li><a href="#"><div class="col-md-12 dark-blue-font">Link to own page</div></a></li>
              <li><a href="#"><div class="col-md-12 dark-blue-font">logout </div></a></li>   
            </ul>
          </div><!--/.nav-collapse -->
        
        </div><!--/.container-fluid -->
      </div>

      <div class="container" id="profile">
      	<div class="row">
      		<div class="col-lg-6">
      			<div>
      				<h1>Screen name <h1>
      				<img class="col-lg-10" src="images/profile-img.jpg">	

      			</div>
      			<div class"col-lg-10" id="bio">bio.... </div>
      		</div>
      		
      		<div class="col-lg-4">
      			<div class="col-lg-offset-4" id="message-btn">
      				<button type="button" class="btn btn-default btn-lg">
  						<span class="glyphicon glyphicon-envelope"></span> Message
					</button>
      			</div>
      			
      			<div id="user-post">
      				<div class="posts col-lg-10 col-lg-offset-1"></div>
      				<div class="posts col-lg-10 col-lg-offset-1"></div>
      				<div class="posts col-lg-10 col-lg-offset-1"></div>
      				<div class="posts col-lg-10 col-lg-offset-1"></div>
      				<div class="posts col-lg-10 col-lg-offset-1"></div>
      				<div class="posts col-lg-10 col-lg-offset-1"></div>
      			</div>
      		</div>
      		<div class="col-lg-2">message</div>
      	</div>
      </div>

	<script src="js/jquery.min.js"></script>
	<script src="bootstrap-3.1.1-dist/bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>


		 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    	<!-- Include all compiled plugins (below), or include individual files as needed -->
    	<script src="bootstrap-3.1.1-dist/bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
	</body>

</html>