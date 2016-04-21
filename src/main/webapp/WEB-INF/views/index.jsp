<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Technical User Page</title>

<spring:url value="/resources/js/index.js" var="indexjs" />

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






    <script src= " ${indexjs} "></script>
<style>
body{


font-family: 'Open Sans', sans-serif;


}
.modal{


font-family: 'Open Sans', sans-serif;


}
.well{
    max-width: 400px;
    margin: 0 auto;

    top: 0px;
}
.popover{
    max-width: 100%; // Max Width of the popover (depending on the container!)
}
//for multiple values-end
/* Specify styling for tooltip contents */
        .customClass{

          background-color: #ffff66;
          box-shadow: 0 6px 12px rgba(0,0,0,.175);
        }


</style>

  </head>

  <body>


<html ng-app="ui.bootstrap.demo">
<body>
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
            <li class="active"><a href="#">Add Extracts</a></li>

            <li> <a href="viewextracts">View Extracts</a></li>
            </ul>
            <!--div class="navbar-header">

      <a class="navbar-brand" href="#">Universal Data Extractor</a>
    </div-->
        </div><!--/.nav-collapse -->

      </div>
    </nav>
	<div class="container">

      <div class="starter-template">
    <div ng-controller="CollapseDemoCtrl" data-ng-init="init_application()">

<!--script type="text/ng-template" ng-include="'${model_apphtml}'" id="model_app.html"></script-->

    <script type="text/ng-template" id="model_app.html">
        <div class="modal-header">
            <h3 class="modal-title">Add Application</h3>
        </div>
        <div class="modal-body">
            	<form  class="form-horizontal" name="newapp" novalidate >
				     <div class="form-group" ng-class="{ 'has-error': newapp.appnme.$touched && newapp.appnme.$invalid }">
        <label class = "col-md-2 control-label" for="appnme">Name</label>
        <div class="col-md-10">
        <input type="text" name="appnme" id="appnme" class="form-control" ng-model="Application.application_name"  ng-minlength="1" required>
		<span style="color:red" class="has-error" ng-show="newapp.appnme.$touched && newapp.appnme.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="newapp.appnme.$touched && newapp.appnme.$valid">Success </span>
        </div>


      </div>
	   <div class="form-group" ng-class="{ 'has-error': newapp.constring.$touched && newapp.constring.$invalid }">
        <label class = "col-md-2 control-label" for="constring">Email</label>
        <div class="col-md-10">
        <input type="email" name="constring" id="constring" class="form-control" ng-model="Application.email"  ng-minlength="1" required>
		<span style="color:red" class="has-error" ng-show="newapp.constring.$touched && newapp.constring.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="newapp.constring.$touched && newapp.constring.$valid">Success </span>
        </div>


      </div>



	  </form>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-disabled="newapp.$invalid " ng-click="ok()" >OK</button>
            <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>

        </div>
    </script>
      <br>
	  <br>
	  <br>
	  <br>
	  <br>


 <script type="text/ng-template" id="model_categ.html">
        <div class="modal-header">
            <h3 class="modal-title">Add Category</h3>
        </div>
        <div class="modal-body">
            	<form  class="form-horizontal" name="newcat" novalidate >
				     <div class="form-group" ng-class="{ 'has-error': newcat.catnme.$touched && newcat.catnme.$invalid }">
        <label class = "col-md-2 control-label" for="catnme">Name</label>
        <div class="col-md-10">
        <input type="text" name="catnme" id="catnme" class="form-control" ng-model="Category.category_Name"  ng-minlength="1" required>
		<span style="color:red" class="has-error" ng-show="newcat.catnme.$touched && newcat.catnme.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="newcat.catnme.$touched && newcat.catnme.$valid">Success </span>
        </div>


      </div>
	   <div class="form-group" ng-class="{ 'has-error': newcat.catdesc.$touched && newcat.catdesc.$invalid }">
        <label class = "col-md-2 control-label" for="catdesc">Description</label>
        <div class="col-md-10">
        <input type="text" name="catdesc" id="catdesc" class="form-control" ng-model="Category.category_Description"  ng-minlength="1" required>
		<span style="color:red" class="has-error" ng-show="newcat.catdesc.$touched && newcat.catdesc.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="newcat.catdesc.$touched && newcat.catdesc.$valid">Success </span>
        </div>


      </div>



	  </form>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-disabled="newcat.$invalid " ng-click="ok()" >OK</button>
            <button class="btn btn-warning" type="button"  ng-click="cancel()">Cancel</button>

        </div>
    </script>

<script type="text/ng-template" id="model_con.html">
        <div class="modal-header">
            <h3 class="modal-title">Add Connection</h3>
        </div>
        <div class="modal-body">
            	<form  class="form-horizontal" name="newcon" novalidate >
				     <div class="form-group" ng-class="{ 'has-error': newcon.connme.$touched && newcon.connme.$invalid }">
        <label class = "col-md-3 control-label" for="connme">Name</label>
        <div class="col-md-9">
        <input type="text" name="connme" id="connme" class="form-control" ng-model="ConnectionDtls.connection_name"  ng-minlength="1" required>
		<span style="color:red" class="has-error" ng-show="newcon.connme.$touched && newcon.connme.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="newcon.connme.$touched && newcon.connme.$valid">Success </span>
        </div>


      </div>

	  <div class="form-group" ng-class="{ 'has-error': newcon.Connection_type.$touched && newcon.Connection_type.$invalid }">
        <label class = "col-md-3 control-label" for="Connection_type">Type</label>
        <div class="col-md-9">
        <select class="form-control"id="Connection_type" class="form-control" ng-model="ConnectionDtls.connection_type" required>
		<option>Sql Server</option>

		<option>My Sql</option>
		<option>Oracle</option>



		</select>
		<span style="color:red" class="has-error" ng-show="newcon.Connection_type.$touched && newcon.Connection_type.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="newcon.Connection_type.$touched && newcon.Connection_type.$valid">Success </span>
        </div>


      </div>

 <div class="form-group" ng-class="{ 'has-error': newcon.ipaddress.$touched && newcon.ipaddress.$invalid }">
        <label class = "col-md-3 control-label" for="ipaddress">IP Address / URL</label>
        <div class="col-md-9">
        <input type="text" name="ipaddress" id="ipaddress" class="form-control" ng-model="ConnectionDtls.server_ip"  ng-minlength="1" required>
		<span style="color:red" class="has-error" ng-show="newcon.ipaddress.$touched && newcon.ipaddress.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="newcon.ipaddress.$touched && newcon.ipaddress.$valid">Success </span>
        </div>


      </div>

	  <div class="form-group" ng-class="{ 'has-error': newcon.Port_Number.$touched && newcon.Port_Number.$invalid }">
        <label class = "col-md-3 control-label" for="Port_Number">Port Number</label>
        <div class="col-md-9">
        <input type="number" name="Port_Number" id="Port_Number" class="form-control" ng-model="ConnectionDtls.port_number"  ng-minlength="1" required>
		<span style="color:red" class="has-error" ng-show="newcon.Port_Number.$touched && newcon.Port_Number.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="newcon.Port_Number.$touched && newcon.Port_Number.$valid">Success </span>
        </div>


      </div>


	  <div class="form-group" ng-class="{ 'has-error': newcon.DB_Name.$touched && newcon.DB_Name.$invalid }">
        <label class = "col-md-3 control-label" for="DB_Name">DB Name</label>
        <div class="col-md-9">
        <input type="text" name="DB_Name" id="DB_Name" class="form-control" ng-model="ConnectionDtls.db_name"  ng-minlength="1" required>
		<span style="color:red" class="has-error" ng-show="newcon.DB_Name.$touched && newcon.DB_Name.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="newcon.DB_Name.$touched && newcon.DB_Name.$valid">Success </span>
        </div>


      </div>






	   <div class="form-group" ng-class="{ 'has-error': newcon.Driver_name.$touched && newcon.Driver_name.$invalid }">
        <label class = "col-md-3 control-label" for="Driver_name">Driver Name</label>
        <div class="col-md-9">
        <input type="text" name="Driver_name" id="Driver_name" class="form-control" ng-model="ConnectionDtls.driver_name"  ng-minlength="1" required>
		<span style="color:red" class="has-error" ng-show="newcon.Driver_name.$touched && newcon.Driver_name.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="newcon.Driver_name.$touched && newcon.Driver_name.$valid">Success </span>
        </div>


      </div>

	  <div class="form-group" ng-class="{ 'has-error': newcon.User_Name.$touched && newcon.User_Name.$invalid }">
        <label class = "col-md-3 control-label" for="User_Name">User Name</label>
        <div class="col-md-9">
        <input type="text" name="User_Name" id="User_Name" class="form-control" ng-model="ConnectionDtls.user_name"  ng-minlength="1" required>
		<span style="color:red" class="has-error" ng-show="newcon.User_Name.$touched && newcon.User_Name.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="newcon.User_Name.$touched && newcon.User_Name.$valid">Success </span>
        </div>


      </div>


	  <div class="form-group" ng-class="{ 'has-error': newcon.Password.$touched && newcon.Password.$invalid }">
        <label class = "col-md-3 control-label" for="Password">Password</label>
        <div class="col-md-9">
        <input type="password" name="Password" id="Password" class="form-control" ng-model="ConnectionDtls.password"  ng-minlength="1" required>
		<span style="color:red" class="has-error" ng-show="newcon.Password.$touched && newcon.Password.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="newcon.Password.$touched && newcon.Password.$valid">Success </span>
        </div>


      </div>






	  </form>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-disabled="newcon.$invalid " ng-click="ok()" >OK</button>
            <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>

        </div>
    </script>

 <script type="text/ng-template" id="multiple_val_Template.html">

		<div class="well">



		  <table class="table table-striped">
		  <tr>
		  <th>Value</th>
		  <th></th>
		  <th>Description</th>
		  </tr>
		  <tr ng-repeat="a in CollapseDemoCtrl.adds.multiple_details">

		  <td>{{a.key}}</td>
		  <th></td>
		  <td>{{a.value}}</td>

		  </tr>
		  </table>


 <form name="form2" novalidate>
 <div class="row">


<div class="col-md-5">
  <label>Value</label>

              <input type="number" class="form-control" name="paramname" ng-model="CollapseDemoCtrl.adds.multiple_single.key" / required>



		  </div>
		  <div class="col-md-5">
  <label>Description</label>
              <input type="text" class="form-control" name="paramname" ng-model="CollapseDemoCtrl.adds.multiple_single.value" / required>



		  </div>
		  <div class="col-md-2">
		  <br>
		   <button class="btn btn-sm btn-primary" ng-click = "add_pop_over()">Add</button>

		  </div>


		  </div>
<br>
<br>

<div class="row">

<div class="col-md-2 col-md-offset-5">
		  <button class="btn btn-sm btn-primary" ng-click = "close_pop()">save</button>
</div>



</div>


		  </form>
       </div>
</script>

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

<script type="text/ng-template" id="alert.html">

    <div class="alert" style="background-color:#fa39c3;color:white" role="alert">
      <div ng-transclude></div>
    </div>
  </script>


<script type="text/ng-template" id="connection_dtls.html">

<table class="table table-hover">
<tr>


</tr>
<tr>
<th>Connection Name</th>
<td>{{CollapseDemoCtrl.ConnectionDtl.connection_name}}</td>
</tr>
<tr>
<th>Connection Type</th>
<td>{{CollapseDemoCtrl.ConnectionDtl.connection_type}}</td>


</tr>

<tr>
<th>DB Name</th>
<td>{{CollapseDemoCtrl.ConnectionDtl.db_name}}</td>

</tr>


<tr>
<th>Driver Name</th>
<td>{{CollapseDemoCtrl.ConnectionDtl.driver_name}}</td>

</tr>
<tr ng-if="CollapseDemoCtrl.ConnectionDtl.connection_type=='Sql Server'">
<th>Server Ip / URL</th>
<td>{{CollapseDemoCtrl.ConnectionDtl.server_ip}}</td>


</tr>

<tr>
<th>Port Number</th>
<td>{{CollapseDemoCtrl.ConnectionDtl.port_number}}</td>

</tr>



</table>









</script>

<div class="row">


<div class="col-md-10">

       	<form  class="form-horizontal" name="input" novalidate >



				    <div class="form-group" ng-class="{ 'has-error': input.category2.$touched && input.category2.$invalid }">

					      <label class="col-md-3 control-label" for="ctglist">Application</label>


						<div class="col-md-3">
					              <select class="form-control" name="category2" id="ctglist" ng-options="Application as Application.application_name for Application in CollapseDemoCtrl.Applications"  ng-model="CollapseDemoCtrl.Application" ng-change="init_category()" required>

                          <!--  --option ng-repeat= "Application in CollapseDemoCtrl.Application" > {{Application.application_name}} </option-->

					                </select>
									<span style="color:red" class="has-error" ng-show="input.category2.$touched && input.category2.$invalid">invalid input </span>


				             </div>

							<div class="col-md-3">
							<button class="btn btn-sm btn-primary"  ng-click="addapp();">ADD Application</button>
							</div>


			       </div>




<div class="form-group" ng-class="{ 'has-error': input.category3.$touched && input.category3.$invalid }">

					      <label class="col-md-3 control-label" for="ctglist">Application Category</label>

          				<div class="col-md-3">
					              <select class="form-control" name="category3" id="ctglist" ng-options="Category as Category.category_Name for Category in CollapseDemoCtrl.Categorys"  ng-model="CollapseDemoCtrl.Category"  ng-change="init_con()" required>

                          <!--  option ng-repeat="Category in CollapseDemoCtrl.Category"> {{Category.Category_Name}}</option-->

					                </select>
									<span style="color:red" class="has-error" ng-show="input.category3.$touched && input.category3.$invalid">invalid input </span>

				             </div>
				             <div class="col-md-3">
							<button class="btn btn-sm btn-primary" ng-disabled="input.category2.$invalid" ng-click="addcat();">ADD Category</button>
							</div>

			       </div>


<div class="form-group" ng-class="{ 'has-error': input.connection.$touched && input.connection.$invalid }">

					      <label class="col-md-3 control-label" for="connection">Application Connection</label>

          				<div class="col-md-3">
          				<style>
        /* Specify styling for tooltip contents */
        .tooltip.customClass .tooltip-inner {


          background-color:#e6e6e6 ;
          opacity: 1;

           color: #000000;

        }

        .tooltip-in{
        background-color:#e6e6e6 ;
          opacity: 1;

           color: #000000;

        }

      </style>
					              <select class="form-control" name="connection" id="connection" ng-options="ConnectionDtl as ConnectionDtl.connection_name for ConnectionDtl in CollapseDemoCtrl.ConnectionDtls" tooltip-class="customClass"  uib-tooltip-template="'connection_dtls.html'"   ng-model="CollapseDemoCtrl.ConnectionDtl" tooltip-enable="input.connection.$valid" tooltip-placement="bottom" required>

                          <!--  option ng-repeat="Category in CollapseDemoCtrl.Category"> {{Category.Category_Name}}</option-->

					                </select>
									<span style="color:red" class="has-error" ng-show="input.connection.$touched && input.connection.$invalid">invalid input </span>

				             </div>
				             <div class="col-md-3">
							<button class="btn btn-sm btn-primary" ng-disabled="input.category3.$invalid" ng-click="addcon();">ADD Connection</button>




							</div>

			       </div>


			       <div class="form-group" ng-class="{ 'has-error': input.extract_name.$touched && input.extract_name.$invalid }">

					      <label class="col-md-3 control-label" for="extract_name">Extract Name</label>

          				<div class="col-md-3">
					             <input type="text" class="form-control" name="extract_name" id="extract_name"   ng-model="CollapseDemoCtrl.extracts.extract_name" required/>




									<span style="color:red" class="has-error" ng-show="input.extract_name.$touched && input.extract_name.$invalid">invalid input </span>

				             </div>


			       </div>

			        <div class="form-group" ng-class="{ 'has-error': input.extract_description.$touched && input.extract_description.$invalid }">

					      <label class="col-md-3 control-label" for="extract_description">Extract Description</label>

          				<div class="col-md-3">
					             <input type="text" class="form-control" name="extract_description" id="extract_description"   ng-model="CollapseDemoCtrl.extracts.extract_description" required/>




									<span style="color:red" class="has-error" ng-show="input.extract_description.$touched && input.extract_description.$invalid">invalid input </span>

				             </div>


			       </div>

			        <div class="form-group">

					      <label class="col-md-3 control-label" for="preview_option">Preview Option</label>

          				<div class="col-md-4">
					             <input type="checkbox"  name="preview_option" id="extract_description"   ng-model="CollapseDemoCtrl.extracts.preview_option" required/>





				             </div>


			       </div>

<div class="form-group">

<label class="col-md-3 control-label" for="query_skeleton"> Query Skeleton</label>

<div class="col-md-4">
<textarea name="query_skeleton" id="query_skeleton"   class="form-control" ng-model="CollapseDemoCtrl.extracts.query_skeleton" rows="3"></textarea>

</div>
</div>


		</form>


</div>
<div class="col-md-2">
<uib-alert ng-repeat="alert in CollapseDemoCtrl.alerts" type="success" close="closeAlert($index)">{{alert.msg}}</uib-alert>

</div>

<div class="col-md-12">


      <hr>

 <uib-tabset active="activeTab">



<uib-tab index="0" heading="Param Details">

<br>
      <table class="table table-striped">
<tr>
<th>Parameter Name</th>
<th>Parameter Value</th>
<th>Alias Name</th>
<th>Type</th>
<th>Data Type</th>
<th>Customer Input</th>

<th>Mandatory Field</th>
<th>Multiple Fields</th>
<th></th>

<th>Edit</th>
<th>Remove</th>
</tr>
<tr ng-repeat="add1 in CollapseDemoCtrl.extracts.extract_details">
<td>{{add1.param_name}}</td>
<td ng-bind-html="add1.param_value | to_trusted"></td>

<td>{{add1.alias_name}}</td>
<td>{{add1.param_datatype}}</td>
<td>{{add1.template_datatype}}</td>

<td>{{add1.input_required?'YES':'NO'}}</td>

<td>{{add1.mandotary_indc?'YES':'NO'}}</td>
<td><button uib-popover-template="multiple_array_value.templateUrl" uib-popover="On the top-right"  popover-title="Multiple Values" type="button" class="btn btn-default" ng-if="add1.param_datatype=='multiCheckbox'" >Multiple Value</button>
 </td>
<td></td>
<td><button type="button" class="btn btn-default" aria-label="Left Align" ng-click="edit($index)">
  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
</button>
<td> <button class="btn btn-sm btn-danger" ng-click = "rem($index)">Remove</button> </td>

</tr>

</table>







<hr>





 <form name="CollapseDemoCtrl.form2" novalidate>
 <div class="row">


<div class="col-md-2" ng-class="{'has-error': CollapseDemoCtrl.form2.paramname.$touched && CollapseDemoCtrl.form2.paramname.$invalid}">
  <label>Parameter Name</label>
              <input id={{add.id}} type="text" class="form-control" name="paramname" ng-model="CollapseDemoCtrl.adds.paramname" / required>



			  <span style="color:red" class="has-error" ng-show="CollapseDemoCtrl.form2.paramname.$touched && CollapseDemoCtrl.form2.paramname.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="CollapseDemoCtrl.form2.paramname.$touched && CollapseDemoCtrl.form2.paramname.$valid">Success </span>
									</div>



			  <div class="col-md-2" ng-class="{'has-error': CollapseDemoCtrl.form2.paramvalue.$touched && CollapseDemoCtrl.form2.paramvalue.$invalid}">
               <label>Parameter Value</label>
              <input id={{add.id}} type="text" class="form-control" name="paramvalue"  ng-model="CollapseDemoCtrl.adds.paramvalue" / required>
             <span style="color:red" class="has-error" ng-show="CollapseDemoCtrl.form2.paramvalue.$touched && CollapseDemoCtrl.form2.paramvalue.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="CollapseDemoCtrl.form2.paramvalue.$touched && CollapseDemoCtrl.form2.paramvalue.$valid">Success </span>



			 </div>



		     <!--div class="col-md-2" ng-class="{'has-error': form2.defaultvalue.$touched && form2.defaultvalue.$invalid}">
              <label>default value</label>
              <input id={{add.id}} type="text" class="form-control" name="defaultvalue" ng-model="CollapseDemoCtrl.adds.defaultvalue" / required>
			  <span style="color:red" class="has-error" ng-show="form2.defaultvalue.$touched && form2.defaultvalue.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="form2.defaultvalue.$touched && form2.defaultvalue.$valid">Success </span>


           </div-->





		<div class="col-md-2"  ng-show="CollapseDemoCtrl.adds.customeEntering" ng-class="{'has-error': CollapseDemoCtrl.form2.aliasname.$touched && CollapseDemoCtrl.form2.aliasname.$invalid}">
              <label>Alias Name</label>
              <input id={{add.id}} type="text" class="form-control" name="aliasname" ng-model="CollapseDemoCtrl.adds.aliasname" / required>
			  <span style="color:red" class="has-error" ng-show="CollapseDemoCtrl.form2.aliasname.$touched && CollapseDemoCtrl.form2.aliasname.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="CollapseDemoCtrl.form2.aliasname.$touched && CollapseDemoCtrl.form2.aliasname.$valid">Success </span>


           </div>



		    <div class="col-md-2">
              <label ng-show="CollapseDemoCtrl.adds.customeEntering">Type</label>
               <select class="form-control" name="type1" id={{add.id}}  ng-model="CollapseDemoCtrl.adds.type" ng-show="CollapseDemoCtrl.adds.customeEntering">
                  						<option>input</option>
						                        <option>multiCheckbox</option>


					                </select>

									<div class="checkbox">

  </div>


		   </div>

<div class="col-md-4">
<label></label>
<button uib-popover-template="multiple_value.templateUrl" uib-popover="On the top-right" ng-if="CollapseDemoCtrl.adds.type=='multiCheckbox'"  popover-title="Multiple Value Add box" type="button" class="btn btn-default form-control" popover-is-open="multiple_value.isOpen" ng-show="CollapseDemoCtrl.adds.customeEntering">Adding Multiple Value</button>
</div>
		   <div class="col-md-2" ng-if="CollapseDemoCtrl.adds.type=='input'">
		    <!--label ng-show="CollapseDemoCtrl.adds.customeEntering">Template Type</label-->
               <select class="form-control" name="type1" id={{add.id}}  ng-model="CollapseDemoCtrl.adds.template_datatype" ng-show="CollapseDemoCtrl.adds.customeEntering">
                  						 <option value="" default selected>Select Data Type</option>
                  						<option>text</option>
						                <option>date</option>
                                        <option>number</option>

					                </select>

		   </div>

<div class="col-md-2" >


      <label for="mandEntering" ng-if="CollapseDemoCtrl.adds.type=='input'">Mandatory Indicator</label>
	  <input type="checkbox" id="checkboxSuccess" value="Yes" name="mandEntering" ng-if="CollapseDemoCtrl.adds.type=='input'" ng-model="CollapseDemoCtrl.adds.mandotary_indc">



</div>

<div>



</div>





		    <!-- button uib-popover-template="multiple_value.templateUrl" uib-popover="top-right"  popover-title="Multiple Value Add box" type="button" class="btn btn-default">Add Multiple Value</button-->







<br>











</div>

<div class ="row">


<div class="col-md-2 col-md-offset-8">

<label for="checkboxcustent">
Customer Input

<input type="checkbox" id="checkboxcustent" value="Yes" name="customeEntering" ng-model="CollapseDemoCtrl.adds.customeEntering" ng-change= "change();">
</label>
<!-- button type="button" class="btn btn-primary btn-sm form-control"  ng-click="remove($index)">Add </button-->
</div>

<div class="col-md-2">





		   <button type="button" class="btn btn-primary btn-sm form-control"  ng-click="remove($index)">Add </button>
		    </div>



</div>


<br>
<br>


</form>
</uib-tab>






<uib-tab index="1" heading="Output Param Details">

<table class="table table-striped">
<tr>
<th>Output Field Name</th>
<th>Output Allias Name</th>
<th>Mandatory Field</th>

</tr>
<tr ng-repeat="out in CollapseDemoCtrl.extracts.extract_output_details1">
<td>{{out.output_name}}</td>
<td>{{out.output_alias_name}}</td>
<td>{{out.mandotary_indc?'YES':'NO'}}</td>

<td></td>
<td><button type="button" class="btn btn-default" aria-label="Left Align" ng-click="edit_out($index)">
  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
</button>
<td> <button class="btn btn-sm btn-danger" ng-click = "rem_out($index)">Remove</button> </td>

</tr>

</table>

<form name="CollapseDemoCtrl.form3" novalidate>
 <div class="row">


<div class="col-md-2" ng-class="{'has-error': form3.output_name.$touched && form3.output_name.$invalid}">
  <label>Output Field Name</label>
              <input id={{add.id}} type="text" class="form-control" name="output_name" ng-model="CollapseDemoCtrl.adds.output_name" / required>



			  <span style="color:red" class="has-error" ng-show="form3.output_name.$touched && form3.output_name.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="form3.output_name.$touched && form3.output_name.$valid">Success </span>
									</div>



			  <div class="col-md-2" ng-class="{'has-error': form2.output_alias_name.$touched && form2.output_alias_name.$invalid}">
               <label>Output Allias Name</label>
              <input id={{add.id}} type="text" class="form-control" name="output_alias_name"  ng-model="CollapseDemoCtrl.adds.output_alias_name" / required>
             <span style="color:red" class="has-error" ng-show="form3.output_alias_name.$touched && form3.output_alias_name.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="form3.output_alias_name.$touched && form3.output_alias_name.$valid">Success </span>



			 </div>



		     <div class="col-md-2" ng-class="{'has-error': form2.mandotary_indc.$touched && form2.mandotary_indc.$invalid}">
              <br>
              <label>Mandatory Indicator</label>
              <input id={{add.id}} type="checkbox"  name="mandotary_indc" ng-model="CollapseDemoCtrl.adds.mandotary_indc" / required>
			  <span style="color:red" class="has-error" ng-show="form3.mandotary_indc.$touched && form3.defaultvalue.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="form3.mandotary_indc.$touched && form3.defaultvalue.$valid">Success </span>





           </div>

<div class="col-md-2">
<br>
<button type="button" class="btn btn-primary btn-sm form-control"  ng-click="remove_out($index)">Add </button>

</div>


</div>


</form>
</uib-tab>

<!--uib-tab index="2" heading="Application & connection details">

 <uib-accordion class="col-md-8 col-md-offset-2" close-others="1">
<uib-accordion-group  heading="Application Details" is-open="0" is-disabled="0" >
<div class="row">
<table class="table table-hover">
<tr>

<th>Name</th>
<th>value</th>
</tr>
<tr>
<td>Application Name</td>
<td>{{CollapseDemoCtrl.Application.application_name}}</td>
</tr>
<tr>
<td>Email Distribution List</td>
<td>{{CollapseDemoCtrl.Application.email}}</td>


</tr>

<tr>
<td>Category</td>
<td>{{CollapseDemoCtrl.Category.category_Name}}</td>

</tr>


</table>



</div>
</uib-accordion-group>
<uib-accordion-group heading="Connection Details" is-open="0" is-disabled="0">
<div class="row">
<table class="table table-hover">
<tr>

<th>Name</th>
<th>value</th>
</tr>
<tr>
<td>Connection Name</td>
<td>{{CollapseDemoCtrl.ConnectionDtl.connection_name}}</td>
</tr>
<tr>
<td>Connection Type</td>
<td>{{CollapseDemoCtrl.ConnectionDtl.connection_type}}</td>


</tr>

<tr>
<td>DB Name</td>
<td>{{CollapseDemoCtrl.ConnectionDtl.db_name}}</td>

</tr>
<tr>
<td>Connection Type</td>
<td>{{CollapseDemoCtrl.ConnectionDtl.connection_type}}</td>


</tr>

<tr>
<td>Driver Name</td>
<td>{{CollapseDemoCtrl.ConnectionDtl.driver_name}}</td>

</tr>
<tr>
<td>Server Ip</td>
<td>{{CollapseDemoCtrl.ConnectionDtl.server_ip}}</td>


</tr>

<tr>
<td>Port Number</td>
<td>{{CollapseDemoCtrl.ConnectionDtl.port_number}}</td>

</tr>



</table>



</div>
</uib-accordion-group>



 </uib-accordion>




 </uib-tab-->




</uib-tabset>

<br>
<br>

</div>

<br>
<br>
<br>
<br>
<br>
<br>



<div class="col-md-2" style="margin-left: 400px;">
<input type="submit" class="btn col-md-2 btn-warning form-control" ng-click="addextract()" ></input>
</div>

</div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>


<!--script src="<c:url value="/resources/js/newmodel.js" />" > </script-->



</body>





</html>
