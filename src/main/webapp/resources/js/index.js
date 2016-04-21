        angular.module('ui.bootstrap.demo', ['ngAnimate', 'ui.bootstrap']);
        angular.module('ui.bootstrap.demo')
            .filter('to_trusted', ['$sce', function($sce){
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
        angular.module('ui.bootstrap.demo').controller('CollapseDemoCtrl', function ($scope, $uibModal,$http) {

          //alert($scope.CollapseDemoCtrl.adds.group_under);
          var counter=1;
          $scope.isCollapsed = true;

          $scope.CollapseDemoCtrl={};

          $scope.CollapseDemoCtrl.extracts={};

          $scope.CollapseDemoCtrl.extracts.extract_details = [];
          $scope.CollapseDemoCtrl.adds={};
          $scope.CollapseDemoCtrl.alerts=[];
          $scope.CollapseDemoCtrl.extracts.extract_output_details=[];

          $scope.CollapseDemoCtrl.extracts.extract_output_details1=[];

          //$scope.CollapseDemoCtrl.Application=[];

          //$scope.CollapseDemoCtrl.Category=[];


          $scope.addAlert = function(name) {

        	  //alert(name);
        	    $scope.CollapseDemoCtrl.alerts.push({msg: name});
        	  };

        	  $scope.closeAlert = function(index) {
        	    $scope.CollapseDemoCtrl.alerts.splice(index, 1);
        	  };


          var init_application= function()
          {

        	  $http.get("/UniversalDataExtractor/application/").success(function(data, status) {


              $scope.CollapseDemoCtrl.Applications=data;
              //alert("application_updated");

      			//alert($scope.CollapseDemoCtrl.Application.application_name);
              });





          };

          init_application();

          $scope.init_category = function()
          {



        	  var data=JSON.stringify($scope.CollapseDemoCtrl.Application.application_Id);
        	  //alert("inside_init_cat");


        	$http.post("/UniversalDataExtractor/categoryapp/",data).success(function(data, status) {

        		  //alert("changed_application");
                $scope.CollapseDemoCtrl.Categorys=data;

        			//alert($scope.CollapseDemoCtrl.Category.Category);
                });
          };

          $scope.init_con = function()
          {

             var data = JSON.stringify($scope.CollapseDemoCtrl.Category.category_Id);

             //alert($scope.CollapseDemoCtrl.Category.category_Id);

             $http.post("/UniversalDataExtractor/connectionapp/",data).success(function(data, status) {

       		  //alert("changed_connection updated");
               $scope.CollapseDemoCtrl.ConnectionDtls=data;



       			//alert($scope.CollapseDemoCtrl.Category.Category);
               });



          };





          $scope.CollapseDemoCtrl.newapp={};
          $scope.addapp=function()
          {
           //var scope=$scope.CollapseDemoCtrl;
          var modalapp = $uibModal.open({

              templateUrl: 'model_app.html',
              controller: 'Application',
        	  //scope: $scope.CollapseDemoCtrl.$get



            });
        	//alert(1);

          modalapp.result.then( function (newapp){

        	  if(newapp=='canceled')
        		  {


        		  //alert("Cancelled");
        		  }
        	  else
        		  {

          $scope.CollapseDemoCtrl.newapp = newapp;

          init_application();
          $scope.addAlert("Application added sucessfully");
        		  }

          });
          };

          $scope.addcat=function()
          {



        	  var modelcat = $uibModal.open({


        		  templateUrl: 'model_categ.html',
                  controller: 'Category',
                  resolve: {

                	  Application_Id: function()
                	  {

                		  return $scope.CollapseDemoCtrl.Application.application_Id;

                	  }
                  }


        	  });

        	  modelcat.result.then( function (newapp){

        		  if(newapp=='canceled')
        		  {


        		  //alert("Cancelled");
        		  }
        		  else
        			  {

//alert("inside cat result");

                  $scope.CollapseDemoCtrl.newcat = newapp;

                  $scope.init_category();
                  $scope.addAlert("Category added sucessfully");
        			  }


                  });

          };


          $scope.addcon=function()
          {

        	  var modelcon =$uibModal.open({


        		  templateUrl: 'model_con.html',
                  controller: 'ConnectionDtls',
                  resolve: {

                	  category_Id: function()
                	  {

                		  return $scope.CollapseDemoCtrl.Category.category_Id;

                	  }
                  }


        	  });


        	  modelcon.result.then( function (newapp){

        		  if(newapp=='canceled')
        		  {


        		  //alert("Cancelled");
        		  }
        		  else
        			  {
//alert("inside con result");



                  $scope.init_con();

                  $scope.addAlert("Connection added sucessfully");

        			  }

                  });




          }

          $scope.addextract=function()
          {

        	  $scope.CollapseDemoCtrl.extracts.catg_id=$scope.CollapseDemoCtrl.Category.category_Id;

        	  $scope.CollapseDemoCtrl.extracts.connection_id=$scope.CollapseDemoCtrl.ConnectionDtl.connection_id;


        	  var data=JSON.stringify($scope.CollapseDemoCtrl.extracts);

        	  $http.post("/UniversalDataExtractor/insrextract/",data).success(function(data, status){

           		  alert("extracts updated");
        		  location.replace("/UniversalDataExtractor/dologin/success");



                   });




          };





          $scope.change=function()
          {

          if(!$scope.CollapseDemoCtrl.adds.customeEntering)
          {
          //alert($scope.CollapseDemoCtrl.adds.customeEntering);

          $scope.CollapseDemoCtrl.adds.type='';
          $scope.CollapseDemoCtrl.adds.group_under='';
          $scope.CollapseDemoCtrl.adds.multiple_details=[];
          $scope.CollapseDemoCtrl.adds.template_datatype='';
          $scope.CollapseDemoCtrl.adds.aliasname='';
          $scope.CollapseDemoCtrl.adds.mandotary_indc='';

          $scope.CollapseDemoCtrl.form2.$setUntouched();
          //$scope.form2.typ1.$setUntouched();
          }

          }
          $scope.edit=function(index)
          {
           $scope.CollapseDemoCtrl.adds.paramname= $scope.CollapseDemoCtrl.extracts.extract_details[index].param_name;
          $scope.CollapseDemoCtrl.adds.paramvalue= $scope.CollapseDemoCtrl.extracts.extract_details[index].param_value;
          //$scope.CollapseDemoCtrl.adds.defaultvalue= $scope.CollapseDemoCtrl.extracts.extract_details[index].defaultvalue;
          $scope.CollapseDemoCtrl.adds.aliasname=$scope.CollapseDemoCtrl.extracts.extract_details[index].alias_name;
          $scope.CollapseDemoCtrl.adds.type=$scope.CollapseDemoCtrl.extracts.extract_details[index].param_datatype;
          $scope.CollapseDemoCtrl.adds.customeEntering=$scope.CollapseDemoCtrl.extracts.extract_details[index].input_required;
          $scope.CollapseDemoCtrl.adds.group_under=$scope.CollapseDemoCtrl.extracts.extract_details[index].group;
          $scope.CollapseDemoCtrl.adds.template_datatype=$scope.CollapseDemoCtrl.extracts.extract_details[index].template_datatype;
          $scope.CollapseDemoCtrl.adds.multiple_details=$scope.CollapseDemoCtrl.extracts.extract_details[index].multiple_details;
          $scope.CollapseDemoCtrl.adds.mandotary_indc=$scope.CollapseDemoCtrl.extracts.extract_details[index].mandotary_indc;

          $scope.CollapseDemoCtrl.extracts.extract_details.splice(index,1);


          }
          $scope.remove=function(index)
          {
        	  $scope.CollapseDemoCtrl.form2.$setUntouched()


         $scope.CollapseDemoCtrl.extracts.extract_details.push(
          {

          param_name: $scope.CollapseDemoCtrl.adds.paramname,
          param_value: $scope.CollapseDemoCtrl.adds.paramvalue,
          defaultvalue: $scope.CollapseDemoCtrl.adds.defaultvalue,
          alias_name: $scope.CollapseDemoCtrl.adds.aliasname,
          param_datatype: $scope.CollapseDemoCtrl.adds.type,
          input_required: $scope.CollapseDemoCtrl.adds.customeEntering,
          group: $scope.CollapseDemoCtrl.adds.group_under,
		  mandotary_indc:$scope.CollapseDemoCtrl.adds.mandotary_indc,
		  template_datatype:$scope.CollapseDemoCtrl.adds.template_datatype,
		  multiple_details:$scope.CollapseDemoCtrl.adds.multiple_details

          });



          $scope.CollapseDemoCtrl.adds.paramname= '';


          $scope.CollapseDemoCtrl.adds.paramvalue= '';
          //$scope.CollapseDemoCtrl.adds.paramvalue.$setUntouched();
          $scope.CollapseDemoCtrl.adds.defaultvalue= '';
          $scope.CollapseDemoCtrl.adds.aliasname='';
          $scope.CollapseDemoCtrl.adds.type='';
          $scope.CollapseDemoCtrl.adds.customeEntering='';
          $scope.CollapseDemoCtrl.adds.group_under='';
		  $scope.CollapseDemoCtrl.adds.mandotary_indc='';
		  $scope.CollapseDemoCtrl.adds.template_datatype='';
		  $scope.CollapseDemoCtrl.adds.multiple_details=[];
          //$scope.form2.$setPristine();

        //form2.$setValidity();


          };
          $scope.rem=function(index)
          {

        	  $scope.CollapseDemoCtrl.extracts.extract_details.splice(index,1);


          };


          //output details starting


          $scope.edit_out=function(index)
          {
           $scope.CollapseDemoCtrl.adds.output_name= $scope.CollapseDemoCtrl.extracts.extract_output_details1[index].output_name;


           $scope.CollapseDemoCtrl.adds.output_alias_name= $scope.CollapseDemoCtrl.extracts.extract_output_details1[index].output_alias_name;

          $scope.CollapseDemoCtrl.adds.mandotary_indc = $scope.CollapseDemoCtrl.extracts.extract_output_details1[index].mandotary_indc;



          $scope.CollapseDemoCtrl.extracts.extract_output_details1.splice(index,1);


          }
          $scope.remove_out=function(index)
          {



          $scope.CollapseDemoCtrl.extracts.extract_output_details1.push(
          {

          output_name: $scope.CollapseDemoCtrl.adds.output_name,

          output_alias_name: $scope.CollapseDemoCtrl.adds.output_alias_name,


          mandotary_indc: $scope.CollapseDemoCtrl.adds.mandotary_indc



          });


          $scope.CollapseDemoCtrl.adds.output_name='';

          $scope.CollapseDemoCtrl.adds.output_alias_name='';

          $scope.CollapseDemoCtrl.adds.mandotary_indc='';


          //$scope.form3.$setUntouched();


          };
          $scope.rem_out=function(index)
          {

        	  $scope.CollapseDemoCtrl.extracts.extract_output_details1.splice(index,1);

        	  $scope.CollapseDemoCtrl.form3.$setUntouched();


          };

          //For multiple Inputs-start

         // $scope.PopoverDemoCtrl={};
          $scope.CollapseDemoCtrl.adds.multiple_details=[];
          $scope.multiple_value = {
  			    //content: 'Hello, World!',
  			    templateUrl: 'multiple_val_Template.html',
  			    title: 'Adding Multiple Input',
  				 container: 'well'
  			  };
          $scope.multiple_array_value = {
    			    //content: 'Hello, World!',
    			    templateUrl: 'multi_val_array.html',
    			    title: 'Multiple Input',
    				 container: 'well'
    			  };


  	  $scope.add_pop_over=function(){
  	$scope.CollapseDemoCtrl.adds.multiple_details.push({
  	  key:$scope.CollapseDemoCtrl.adds.multiple_single.key,
  	  value:$scope.CollapseDemoCtrl.adds.multiple_single.value


  	  });

  	  $scope.CollapseDemoCtrl.adds.multiple_single.key='';
  	  $scope.CollapseDemoCtrl.adds.multiple_single.value='';


  	  };
  	  $scope.close_pop=function()
  	  {
  		  //alert(1);

  	  $scope.multiple_value.isOpen=false;

  	  };
  	//For multiple Inputs-end






        });

        angular.module('ui.bootstrap.demo').controller('Application', function($scope,$uibModalInstance,$http) {

        $scope.ok=function()
        {
        //alert($scope.CollapseDemoCtrl1.newapp.appnme);
        var data=JSON.stringify($scope.Application);


        		$http.post("/UniversalDataExtractor/insrapplication/", data).success(function(data, status) {
                    //$scope.hello = data;

        			//alert("sucess");
        			 $uibModalInstance.close($scope.Application.application_name);

                });





        }


        $scope.cancel=function()
        {


        	$uibModalInstance.close("canceled");



        }

        });


        angular.module('ui.bootstrap.demo').controller('Category', function($scope,$uibModalInstance,$http,Application_Id) {

        	$scope.Category={};

        	$scope.ok=function()
            {
            //alert($scope.CollapseDemoCtrl1.newapp.appnme);
            //alert(Application_Id);

           $scope.Category.application_Id = Application_Id;



            var data=JSON.stringify($scope.Category);


            		$http.post("/UniversalDataExtractor/insrcategory/", data).success(function(data, status) {
                        //$scope.hello = data;

            			//alert("sucess");

            			   $uibModalInstance.close($scope.Category.category_Name);
                    });






            }

        	 $scope.cancel=function()
             {


             	$uibModalInstance.close("canceled");



             }

            });



        angular.module('ui.bootstrap.demo').controller('ConnectionDtls', function($scope,$uibModalInstance,$http,category_Id) {

        	$scope.Category={};

        	$scope.ok=function()
            {
            //alert($scope.CollapseDemoCtrl1.newapp.appnme);
            //alert($scope.ConnectionDtls.Connection_Name);


$scope.ConnectionDtls.category_Id=category_Id;




            var data=JSON.stringify($scope.ConnectionDtls);
            //alert(data);


            		$http.post("/UniversalDataExtractor/insrconnection/", data).success(function(data, status) {
                        //$scope.hello = data;

            			//alert("sucess");

            			   $uibModalInstance.close($scope.ConnectionDtls);
                    });






            }

        	 $scope.cancel=function()
             {


             	$uibModalInstance.close("canceled");



             }

            });










