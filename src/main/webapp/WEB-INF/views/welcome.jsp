<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>End User Portal</title>

<spring:url value="/resources/js/MainController.js" var="MainControllerjs" />

 <spring:url value="/resources/css/style.css" var="stylecss" />

 <spring:url value="/resources/css/sidebar.css" var="sidecss" />
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <!--link src="${sidecss}" rel='stylesheet' type='text/css'-->
    <style>
    body{


font-family: 'Open Sans', sans-serif;


}
/*!
 * Start Bootstrap - Simple Sidebar HTML Template (http://startbootstrap.com)
 * Code licensed under the Apache License v2.0.
 * For details, see http://www.apache.org/licenses/LICENSE-2.0.
 */

/* Toggle Styles */

#wrapper {
    padding-left: 0;
    -webkit-transition: all 0.5s ease;
    -moz-transition: all 0.5s ease;
    -o-transition: all 0.5s ease;
    transition: all 0.5s ease;
}

#wrapper.toggled {
    padding-left: 250px;
}

#sidebar-wrapper {
    z-index: 1000;
    position: fixed;
    left: 250px;
    width: 0;
    height: 100%;
    margin-left: -250px;
    overflow-y: auto;
    background: #eeeeee;
    -webkit-transition: all 0.5s ease;
    -moz-transition: all 0.5s ease;
    -o-transition: all 0.5s ease;
    transition: all 0.5s ease;
}

#wrapper.toggled #sidebar-wrapper {
    width: 250px;
}

#page-content-wrapper {
    width: 100%;
    position: absolute;
    padding: 15px;
}

#wrapper.toggled #page-content-wrapper {
    position: absolute;
    margin-right: -250px;
}

/* Sidebar Styles */

.sidebar-nav {
    position: absolute;
    top: 0;
    width: 250px;
    margin: 0;
    padding: 0;
    list-style: none;
}

.sidebar-nav li {
    text-indent: 20px;
    line-height: 40px;
}

.sidebar-nav li a {
    display: block;
    text-decoration: none;
    color: #000;
}

.sidebar-nav li a:hover {
    text-decoration: none;
    color:  #000;
    background: rgba(255,255,255,0.2);
}

.sidebar-nav li a:active,
.sidebar-nav li a:focus {
    text-decoration: none;
}

.sidebar-nav > .sidebar-brand {
    height: 65px;
    font-size: 18px;
    line-height: 60px;
}

.sidebar-nav > .sidebar-brand a {
    color: #000;
}

.sidebar-nav > .sidebar-brand a:hover {
    color:  #000;
    background: #000;
}

@media(min-width:768px) {
    #wrapper {
        padding-left: 250px;
    }

    #wrapper.toggled {
        padding-left: 0;
    }

    #sidebar-wrapper {
        width: 250px;
    }

    #wrapper.toggled #sidebar-wrapper {
        width: 0;
    }

    #page-content-wrapper {
        padding: 20px;
        position: relative;
    }

    #wrapper.toggled #page-content-wrapper {
        position: relative;
        margin-right: 0;
    }
}

    </style>
</head>
<body ng-app="formlyApp" ng-controller="MainController as vm" data-ng-init="init_app()">

<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">



        <div id="navbar" class="collapse navbar-collapse">
<!--form class="navbar-right">
           <a class="navbar-brand" href="/UniversalDataExtractor/"><button type="button"  href="/UniversalDataExtractor/" class="btn btn-danger">sign out</button></a>
</form-->

<ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Client User</a></li>
      <li><a href="/UniversalDataExtractor/" ><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>

<ul class="nav navbar-nav navbar-left">
            <li class="active"><a href="#">Universal Data Extractor</a></li>


            </ul>
            <!--div class="navbar-header">

      <a class="navbar-brand" href="#">Universal Data Extractor</a>
    </div-->
        </div><!--/.nav-collapse -->

      </div>

    </nav>
 <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">

                    </a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-save"></span>   Get Extracts</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-inbox"></span>  Inbox</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-time"></span>  Schedule</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-bullhorn"></span> Raise a Ticket</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-info-sign"></span>  Help</a>
                </li>

                <li>
                    <a href="#"><span class="glyphicon glyphicon-envelope"></span>  Contact Us</a>
                </li>
            </ul>
        </div>
    <br>
    <br>
    <br>
    <br>
    <br>
<!--pre>{{vm.rental | json}}</pre-->

    <div class="container col-md-4 col-md-offset-4">







        <form  name="input" novalidate>
        <div class="form-group" ng-class="{ 'has-error': input.category2.$touched && input.category2.$invalid }">

					      <label class="control-label" for="ctglist1">Select an Application</label>



					              <select class="form-control" name="category2" id="ctglist1" ng-options="Application as Application.application_name for Application in vm.Applications"  ng-model="vm.Application" ng-change="init_category()" required>

                          <!--  --option ng-repeat= "Application in CollapseDemoCtrl.Application" > {{Application.application_name}} </option-->

					                </select>
									<span style="color:red" class="has-error" ng-show="input.category2.$touched && input.category2.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="input.category2.$touched && input.category2.$valid">Success </span>



				             </div>
				 <div class="form-group" ng-class="{ 'has-error': input.category3.$touched && input.category3.$invalid }">

					      <label class="control-label" for="ctglist2">Select Application Category</label>


					              <select class="form-control" name="category3" id="ctglist2" ng-options="Category as Category.category_Name for Category in vm.Categorys"  ng-model="vm.Category"  ng-change="init_ext()" required>

                          <!--  option ng-repeat="Category in CollapseDemoCtrl.Category"> {{Category.Category_Name}}</option-->

					                </select>
									<span style="color:red" class="has-error" ng-show="input.category3.$touched && input.category3.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="input.category3.$touched && input.category3.$valid">Success </span>




			        </div>

			       <div class="form-group" ng-class="{ 'has-error': input.Extracts.$touched && input.Extracts.$invalid }">

			       <label clas="control-label" for="extlist3" >Select Data Extracts</label>




			          <select class="form-control" name="extlist" id="extlist3" ng-options="Extract as Extract.extract_name for Extract in vm.Extracts" ng-model="vm.Extract" ng-change="init_form_det()" required></select>


			       <span style="color:red" class="has-error" ng-show="input.extlist.$touched && input.extlist.$invalid">invalid input </span>
									<span style="color:green" class="has-error" ng-show="input.extlist.$touched && input.extlist.$valid">Success </span>






			       </div>
</form>
            <h1></h1>

            <form  name="input1" novalidate>
            <formly-form model="vm.rental" fields="vm.rentalFields" form="vm.rentalForm">
            <br>
            <br>

                <center><button type="submit" class="col-md-3 btn btn-primary" ng-disabled="vm.rentalForm.$invalid" ng-click="sub()">Submit</button></center>


            </formly-form>

        </form>


</div>
 <br>
            <br>
            <br>
            <br>
            <br>
</body>

    <!-- Application Dependencies -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/api-check/7.2.4/api-check.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular-formly/6.11.0/formly.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular-formly-templates-bootstrap/4.3.1/angular-formly-templates-bootstrap.js"></script>

    <!-- Application Scripts -->

    <script src="${MainControllerjs}"></script>

</html>