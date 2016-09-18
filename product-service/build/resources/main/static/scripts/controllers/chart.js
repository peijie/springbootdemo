angular.module('productsApp')
  .controller('ChartCtrl', function ($scope, $http) {
	  $scope.drawChart = function() {
		  var data = new google.visualization.DataTable();
		  data.addColumn('string', 'Year');
		  data.addColumn('number', 'Sales');
		  data.addColumn('number', 'Expenses');
		  
		  var obj = $scope.chart;
		  data.addRows(obj.length);
		  for(var i=0;i<obj.length;i++) {
			  for(var k=0; k<obj[0].length; k++) {
				  if(k==0) {
					  data.setCell(i, k, obj[i][k].toString());
				  } else {
					  data.setCell(i, k, parseInt(obj[i][k]));
				  }
			  }
		  }
		  
		    var options = {
		    	      title: 'Company Performance',
		    	      curveType: 'function',
		    	      legend: { position: 'bottom' }
		    	    };
		    var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
		    chart.draw(data, options);

	  }
	  

	  $http({
          method: 'GET',
          url: '/chart'
      }).then(function(response) {
    	  console.log("enter chart page");
    	  $scope.chart = response.data;
    	  
    	  console.log(response.data);
    	  
    	  google.charts.load('current', {'packages':['corechart']});
          google.charts.setOnLoadCallback($scope.drawChart);

      }, function(response) {
    	  console.error('Error requesting races');
      });
  });



