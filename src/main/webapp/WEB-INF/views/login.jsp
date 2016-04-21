<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">


    <spring:url value="/resources/css/signin.css" var="signcss" />


   <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>

<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

    <link href="${signcss}" rel="stylesheet">

    <script src='http://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js'></script>

  <script src='http://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-animate.js'></script>

   <script src='https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/1.2.4/ui-bootstrap-tpls.min.js'></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-touch.min.js"></script>


<style type="text/css">
body{


font-family: 'Open Sans', sans-serif;


}
.modal{


font-family: 'Open Sans', sans-serif;


}




</style>









  <script type="text/javascript">

  angular.module('ui.bootstrap.demo', ['ui.bootstrap']);

  angular.module('ui.bootstrap.demo').controller('login', function ($scope, $uibModal,$http) {

$scope.sub=function()
{

	var data=$scope.login.email;
	  $http.post("/UniversalDataExtractor/dologin/",data).success(function(data, status) {


	  $scope.recive={};

	  var dt=data.redirect;

	  if(dt=="index")
			  {



		  location.replace("/UniversalDataExtractor/dologin/index/")
			  }

	  else
		  {


		 location.replace("/UniversalDataExtractor/dologin/welcome/")

		  }

	  });

}
  });







  </script>

  </head>


  <body ng-app="ui.bootstrap.demo">

    <div class="container" ng-controller="login">
    <center>
<h1>Universal Data Extractor</h1></center>

      <form class="form-signin">
        <br>
        <br>

        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="Email Address" name="name" ng-model="login.email" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" ng-model="login.password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" ng-click="sub()">Sign in</button>
        <br>
        <br>
        <button class="btn btn-lg btn-success btn-block" type="button">Sign up</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
