var app =angular.module('ui.bootstrap.extracts', ['ngAnimate', 'ui.bootstrap']);



app.controller("viewextractCtr", function ($scope, $uibModal,$http) {

          //alert($scope.viewextractsCtrl.adds.group_under);
          var counter=1;
          $scope.isCollapsed = true;

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



        	  var data=JSON.stringify($scope.viewextractsCtrl.Application.application_Id);
        	  //alert("inside_init_cat");


        	$http.post("/UniversalDataExtractor/categoryapp/",data).success(function(data, status) {

        		  //alert("changed_application");
                $scope.viewextractsCtrl.Categorys=data;

        			//alert($scope.viewextractsCtrl.Category.Category);
                });
          };

          $scope.init_con = function()
          {

             var data = JSON.stringify($scope.viewextractsCtrl.Category.category_Id);

             //alert($scope.viewextractsCtrl.Category.category_Id);

             $http.post("/UniversalDataExtractor/connectionapp/",data).success(function(data, status) {

       		  //alert("changed_connection updated");
               $scope.viewextractsCtrl.ConnectionDtls=data;

       			//alert($scope.viewextractsCtrl.Category.Category);
               });



          };
        });
