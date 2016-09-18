angular.module('productsApp')
  .controller('MainCtrl', function ($scope, $http) {
	  $http({
          method: 'GET',
          url: '/products'
      }).then(function(response) {
    	  $scope.products = response.data;
      }, function(response) {
    	  console.error('Error requesting races');
      });
  });