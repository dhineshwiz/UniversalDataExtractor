	angular.module('formlyApp', ['formly', 'formlyBootstrap']);


	angular
	.module('formlyApp')
	.controller('MainController', MainController);

	function MainController($http, $scope) {

		var vm = this;



$scope.init_app=function()
{
	$http.get("/UniversalDataExtractor/application/").success(function(data, status) {


        $scope.vm.Applications=data;
        //alert("application_updated");


        });


}

$scope.init_category=function()
{


	  var data=JSON.stringify($scope.vm.Application.application_Id);
	  //alert("inside_init_cat");


	$http.post("/UniversalDataExtractor/categoryapp/",data).success(function(data, status) {

		  //alert("changed_application");
      $scope.vm.Categorys=data;

			//alert($scope.CollapseDemoCtrl.Category.Category);
      });




}

$scope.init_ext=function()
{


var data =JSON.stringify($scope.vm.Category.category_Id);

//alert(1);



$http.post("/UniversalDataExtractor/extractbycategid/",data).success(function(data, status) {

	  //alert("changed_application");
	  $scope.vm.Extracts=data;

		//alert($scope.CollapseDemoCtrl.Category.Category);
  });




/*$http.post=("http://localhost:8080/UniversalDataExtractor/extractbycategid/",data).success(function(data,status){


	$scope.vm.Extracts=data;

});*/



}

$scope.init_form_det=function()
{


	vm.rentalFields = {};
	vm.rental.extract_id=$scope.vm.Extract.extract_id;

		$http.get("/UniversalDataExtractor/getcustomerout/"+$scope.vm.Extract.extract_id+"/").success(function(data, status) {


			vm.rentalFields=data;




		});


}

				$scope.sub=function()
				{



					$http({method:"post",url:"/UniversalDataExtractor/insrcustdet",data:vm.rental ,headers: {'Content-type': 'application/json'},responseType: 'arraybuffer'
				}).success(function (data, status, headers, config) {
				    var blob = new Blob([data], {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});
				    var objectUrl = URL.createObjectURL(blob);
				    window.open(objectUrl);


						//alert("success");



					});




				}







			/*vm.rentalFields = [
			   				{
			   					key: 'first_name',
			   					type: 'input',
			   					templateOptions: {
			   						type: 'text',
			   						label: 'First Name',
			   						placeholder: 'Enter your first name',
			   						required: true
			   					}
			   				},
			   				{
			   					key: 'last_name',
			   					type: 'input',
			   					templateOptions: {
			   						type: 'text',
			   						label: 'Last Name',
			   						placeholder: 'Enter your last name',
			   						required: true
			   					}
			   				},
			   				{
			   					key: 'email',
			   					type: 'input',
			   					templateOptions: {
			   						type: 'email',
			   						label: 'Email address',
			   						placeholder: 'Enter email',
			   						required: true
			   					}
			   				},
			   				{
			   					key: 'under25',
			   					type: 'checkbox',
			   					templateOptions: {
			   						label: 'Are you under 25?',
			   					},
			   					// Hide this field if we don't have
			   					// any valid input in the email field
			   					hideExpression: '!model.email'
			   				}];*/







	}
