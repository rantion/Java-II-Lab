<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<head>
		<title>Post</title>

		<link href="bootstrap-3.1.1-dist/bootstrap-3.1.1-dist/css/bootstrap-modal-bs3patch.css" rel="stylesheet">
		<link href="bootstrap-3.1.1-dist/bootstrap-3.1.1-dist/css/bootstrap-modal.css" rel="stylesheet">

		<link href="bootstrap-3.1.1-dist/bootstrap-3.1.1-dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	
	<body>
	


    <div class="container">
      
      <div class="row">
        <div id="post" class="col-lg-8 col-lg-offset-2">
        </div>
      </div>

      <div class="row">
        
        <div id="comments" class="col-lg-6 col-lg-offset-3">
          <div class="row">
              
              <div class="col-lg-3 col-lg-offset-1" id="user-img">
                <img class="" src="images/profile-img.jpg">
              </div>
              
              <div class="col-lg-6 col-lg-offset-1" id="user-comments">

                <div class="row">
                    <div class="comment">
                      <textarea class="text"></textarea>
                    </div>
                </div>

                <div class="row">
                  <button class="col-lg-4  col-lg-offset-8 p-black">Post</button>
           
                </div>

              
              </div>

          </div>


          <div class="row">
              <div  class="col-lg-10 col-lg-offset-1" id="comments-post">
              </div>
          </div>

        </div>

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