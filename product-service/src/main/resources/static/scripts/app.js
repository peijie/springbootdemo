angular
  .module('productsApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/products', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/products/:productId', {
    	  templateUrl: 'views/product.html',
    	  controller: 'ProductCtrl'
      })
      .when('/chart', {
    	  templateUrl: 'views/chart.html',
    	  controller: 'ChartCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });