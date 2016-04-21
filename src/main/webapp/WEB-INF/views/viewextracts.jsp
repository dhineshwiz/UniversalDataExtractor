<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Technical User Page</title>

<spring:url value="/resources/js/index.js" var="indexjs" />

<spring:url value="/resources/js/viewextract.js" var="viewjs" />

<spring:url value="/resources/html/model_app.html" var="model_apphtml"/>

<spring:url value="/resources/html/model_categ.html" var="model_categhtml"></spring:url>

<spring:url value="/resources/html/model_con.html" var="model_conhtml"></spring:url>

<spring:url value="/resources/html/viewextract.html" var="view_exthtml"></spring:url>

 <spring:url value="/resources/css/style.css" var="stylecss" />









  <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>

  <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

  <link src="${stylecss }"rel="stylesheet"/ >

  <script src='http://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js'></script>

  <script src='http://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-animate.js'></script>

   <script src='https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/1.2.4/ui-bootstrap-tpls.min.js'></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-touch.min.js"></script>

<style>
body{


font-family: 'Open Sans', sans-serif;


}
.modal{


font-family: 'Open Sans', sans-serif;


}
</style>




   <script>
var app = angular.module("ui.bootstrap.extracts", ['ngAnimate', 'ui.bootstrap']).filter('to_trusted', ['$sce', function($sce){
    return function(text) {

		$sce.str = {
		name: ''
		};


		for(var i=0;i<((text+'').length);i++)
		{

		if(text[i]=='$')
		{

		$sce.str.name = $sce.str.name + '<code>';


		}
		else if(text[i]=='?')
		{
		$sce.str.name = $sce.str.name + '</code>';

		}
		else
		{

		$sce.str.name = $sce.str.name + text[i];


		}

		}



		return $sce.trustAsHtml($sce.str.name);
    };
}]);
app.controller("viewextractCtrl", function($scope, $uibModal,$http) {
	  var counter=1;
      $scope.isCollapsed = true;
$scope.isopen=true;
      $scope.viewextractsCtrl={};

      $scope.viewextractsCtrl.extracts={};

      $scope.viewextractsCtrl.extracts.extract_details = [];
      $scope.viewextractsCtrl.adds={};
      $scope.viewextractsCtrl.alerts=[];
      $scope.viewextractsCtrl.extracts.extract_output_details=[];

      $scope.viewextractsCtrl.extracts.extract_output_details1=[];

      //$scope.viewextractsCtrl.Application=[];

      //$scope.viewextractsCtrl.Category=[];


      $scope.addAlert = function(name) {

    	  //alert(name);
    	    $scope.viewextractsCtrl.alerts.push({msg: name});
    	  };

    	  $scope.closeAlert = function(index) {
    	    $scope.viewextractsCtrl.alerts.splice(index, 1);
    	  };


      var init_application= function()
      {

    	  $http.get("/UniversalDataExtractor/application/").success(function(data, status) {


          $scope.viewextractsCtrl.Applications=data;
          //alert("application_updated");

  			//alert($scope.viewextractsCtrl.Application.application_name);
          });





      };

      init_application();

      $scope.init_category = function()
      {



    	  var data=JSON.stringify($scope.viewextractCtrl.Application.application_Id);
    	  //alert("inside_init_cat");


    	$http.post("/UniversalDataExtractor/categoryapp/",data).success(function(data, status) {

    		  //alert("changed_application");
            $scope.viewextractsCtrl.Categorys=data;

    			//alert($scope.viewextractsCtrl.Category.Category);
            });
      };

      $scope.init_con = function()
      {

         var data = JSON.stringify($scope.viewextractCtrl.Category.category_Id);

         //alert($scope.viewextractsCtrl.Category.category_Id);

         $http.post("/UniversalDataExtractor/extractbycategid/",data).success(function(data, status) {

   		  //alert("changed_connection updated");
           $scope.viewextractCtrl.Extracts=data;

   			//alert($scope.viewextractsCtrl.Category.Category);
           });



      };

      $scope.get_con = function()
      {

    	  var data = JSON.stringify($scope.viewextractCtrl.Extract.connection_id);



    	  $http.post("/UniversalDataExtractor/connbyid/",data).success(function(data, status) {

       		  //alert("changed_connection updated");
               $scope.viewextractCtrl.full.connection=data;
               $scope.isopen=true;

       			//alert($scope.viewextractsCtrl.Category.Category);
               });




      };

      $scope.get_ext = function()
      {

         var data = JSON.stringify($scope.viewextractCtrl.Extract.extract_id);

         //alert($scope.viewextractsCtrl.Category.category_Id);

         $http.post("/UniversalDataExtractor/extractbyid/",data).success(function(data, status) {

   		  //alert("changed_connection updated");
   		  $scope.viewextractCtrl.full={};
           $scope.viewextractCtrl.full.Extracts=data;
           $scope.get_con();

   			//alert($scope.viewextractsCtrl.Category.Category);
           });



      };

      $scope.multiple_array_value = {
			    //content: 'Hello, World!',
			    templateUrl: 'multi_val_array.html',
			    title: 'Multiple Input',
				 container: 'well'
			  };

});
</script>

<!-- div ng-app="myShoppingList" ng-controller="myCtrl">
    <ul>
        <li ng-repeat="x in products">{{x}}</li>
    </ul>
</div-->


<body ng-app="ui.bootstrap.extracts" ng-controller="viewextractCtrl">
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">



        <div id="navbar" class="collapse navbar-collapse">
<!--form class="navbar-right">
           <a class="navbar-brand" href="/UniversalDataExtractor/"><button type="button"  href="/UniversalDataExtractor/" class="btn btn-danger">sign out</button></a>
</form-->

<ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Technical User</a></li>
      <li><a href="/UniversalDataExtractor/" ><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>

<ul class="nav navbar-nav">
            <li ><a href="/UniversalDataExtractor/dologin/index/">Add Extracts</a></li>

            <li class="active"> <a href="viewextracts">View Extracts</a></li>

            </ul>
            <!--div class="navbar-header">

      <a class="navbar-brand" href="#">Universal Data Extractor</a>
    </div-->
        </div><!--/.nav-collapse -->

      </div>
    </nav>
	<div class="container">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
      <div class="starter-template">
    <div  data-ng-init="init_application()">

<script type="text/ng-template" id="multi_val_array.html">
<div class="well">


		  <table class="table table-striped">
		  <tr>
		  <th>Value</th>
		  <th></th>
		  <th>Description</th>
		  </tr>
		  <tr ng-repeat="a in add1.multiple_details">

		  <td>{{a.key}}</td>
		  <th></td>
		  <td>{{a.value}}</td>

		  </tr>
		  </table>
</div>


</script>



    <div class="row">


<div class="col-md-12">

<!--pre>{{viewextractCtrl.full.Extracts | json}}</pre-->

       	<form  class="form-horizontal" name="input" novalidate >



				    <div class="form-group" ng-class="{ 'has-error': input.category2.$touched && input.category2.$invalid }">

					      <label class="col-md-4 control-label" for="ctglist">Application</label>


						<div class="col-md-4">
					              <select class="form-control" name="category2" id="ctglist" ng-options="Application as Application.application_name for Application in viewextractsCtrl.Applications"  ng-model="viewextractCtrl.Application" ng-change="init_category()" required>

                          <!--  --option ng-repeat= "Application in CollapseDemoCtrl.Application" > {{Application.application_name}} </option-->

					                </select>
									<span style="color:red" class="has-error" ng-show="input.category2.$touched && input.category2.$invalid">invalid input </span>


				             </div>
				             </div>





<div class="form-group" ng-class="{ 'has-error': input.category3.$touched && input.category3.$invalid }">

					      <label class="col-md-4 control-label" for="ctglist">Application Category</label>

          				<div class="col-md-4">
					              <select class="form-control" name="category3" id="ctglist" ng-options="Category as Category.category_Name for Category in viewextractsCtrl.Categorys"  ng-model="viewextractCtrl.Category"  ng-change="init_con()" required>

                          <!--  option ng-repeat="Category in CollapseDemoCtrl.Category"> {{Category.Category_Name}}</option-->

					                </select>
									<span style="color:red" class="has-error" ng-show="input.category3.$touched && input.category3.$invalid">invalid input </span>

				             </div>


			       </div>


<div class="form-group" ng-class="{ 'has-error': input.connection.$touched && input.connection.$invalid }">

					      <label class="col-md-4 control-label" for="connection">Extracts</label>

          				<div class="col-md-4">

					              <select class="form-control" name="connection" id="connection" ng-options="Extract as Extract.extract_name for Extract in viewextractCtrl.Extracts"    ng-model="viewextractCtrl.Extract" ng-change="get_ext()"  required>

                          <!--  option ng-repeat="Category in CollapseDemoCtrl.Category"> {{Category.Category_Name}}</option-->

					                </select>
									<span style="color:red" class="has-error" ng-show="input.connection.$touched && input.connection.$invalid">invalid input </span>

				             </div>

			       </div>

			       </form>
</div>
</div>
<div class="row" ng-show="input.connection.$valid">
<div class="col-md-12">
<!--center><h2>{{viewextractCtrl.full.Extracts.extract_name}}</h2></center-->
<!--h2>Extract Details</h2-->
<uib-accordion>

     <uib-accordion-group heading="Extract Details" is-open="isopen">
       <table class="table table-hover">


        <tr>
          <th>Name</th>
          <td>{{viewextractCtrl.full.Extracts.extract_name}}</td>
        </tr>

        <tr>
          <th>Description</th>
          <td>{{viewextractCtrl.full.Extracts.extract_description}}</td>

        </tr>

        <tr>
          <th>Query</th>
          <td ng-bind-html="viewextractCtrl.full.Extracts.query_skeleton | to_trusted"></td>

        </tr>

        <tr>
           <th>Preview</th>
           <td ng-show="input.connection.$valid">{{viewextractCtrl.full.Extracts.query_skeleton ?'True':'False'}}</td>

        </tr>
     </table>
<br>
<br>
<br>
</uib-accordion-group>
<uib-accordion-group heading="Extract Param Details" is-open="0">
<!--h2>Extract Param Details</h2-->
<table class="table table-hover table-bordered">

<tr>
<th>Name</th>
<th>Value</th>
<th>Alias Name</th>
<th>Type</th>
<th>Data Type</th>
<th>Customer Input</th>

<th>Mandatory Field</th>
<th>Multiple Fields</th>

</tr>
<tr ng-repeat="add1 in viewextractCtrl.full.Extracts.extract_details">
<td>{{add1.param_name}}</td>
<td ng-bind-html="add1.param_value | to_trusted"></td>

<td>{{add1.alias_name}}</td>
<td>{{add1.param_datatype}}</td>
<td>{{add1.template_datatype}}</td>

<td>{{add1.input_required?'YES':'NO'}}</td>

<td>{{add1.mandotary_indc?'YES':'NO'}}</td>
<td><button uib-popover-template="multiple_array_value.templateUrl" uib-popover="On the top-right"  popover-title="Multiple Values" type="button" class="btn btn-default" ng-if="add1.param_datatype=='multiCheckbox'" >Multiple Value</button>
 </td>

</tr>



</table>
<br>
<br>
<br>
</uib-accordion-group>

<uib-accordion-group heading="Extract Output Param Details" is-open="0">
<!--h2>Extract Output Param Details</h2-->
<table class="table table-hover table-bordered">
<tr>
<th>Output Field Name</th>
<th>Output Allias Name</th>
<th>Mandatory Field</th>

</tr>
<tr ng-repeat="out in viewextractCtrl.full.Extracts.extract_output_details1">
<td>{{out.output_name}}</td>
<td>{{out.output_alias_name}}</td>
<td>{{out.mandotary_indc?'YES':'NO'}}</td>



</tr>

</table>




</uib-accordion-group>

<uib-accordion-group heading="Extract Connection  Details" is-open="0">
<!--h2>Extract Connection  Details</h2-->
<table class="table table-hover">

<tr>
<th>Connection Name</th>
<td>{{viewextractCtrl.full.connection.connection_name}}</td>
</tr>
<tr>
<th>Connection Type</th>
<td>{{viewextractCtrl.full.connection.connection_type}}</td>


</tr>

<tr>
<th>DB Name</th>
<td>{{viewextractCtrl.full.connection.db_name}}</td>

</tr>
<tr>
<th>Connection Type</th>
<td>{{viewextractCtrl.full.connection.connection_type}}</td>


</tr>

<tr>
<th>Driver Name</th>
<td>{{viewextractCtrl.full.connection.driver_name}}</td>

</tr>
<tr>
<th>Server Ip / URL</th>
<td>{{viewextractCtrl.full.connection.server_ip}}</td>


</tr>

<tr>
<th>Port Number</th>
<td>{{viewextractCtrl.full.connection.port_number}}</td>

</tr>



</table>


</uib-accordion-group>

</uib-accordion>


</div>
</div>


