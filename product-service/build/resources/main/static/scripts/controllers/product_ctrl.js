angular.module('productsApp')
  .controller('ProductCtrl', function ($scope, $http, $routeParams) {
	  $http({
          method: 'GET',
          url: '/products/' + $routeParams.productId
      }).then(function (response) {
    	  console.log(response)
    	  $scope.product = response.data;
      }, function(response) {
    	  console.error('Error requesting participants.')
      });
  });