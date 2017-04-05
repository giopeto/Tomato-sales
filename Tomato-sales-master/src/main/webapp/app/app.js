var ngApp = angular.module('ngApp', ['ngRoute', 'ngResource']);

ngApp.config(function ($controllerProvider, $compileProvider, $filterProvider, $provide, $routeProvider, $httpProvider) {
	
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

	ngApp.lazy = {
        controller: $controllerProvider.register,
       	directive: $compileProvider.directive,
        filter: $filterProvider.register,
        factory: $provide.factory,
        service: $provide.service
    };

	$routeProvider.when('/tomato-sales', {
		templateUrl: 'app/tomato-sales/tomato-sales.html',
		resolve: {
			load: ['$q', '$rootScope', function ($q, $rootScope) {
				var deferred = $q.defer();
				require([
					'dist/js/tomato-sales/tomato-sales.controller.min.js',
					'dist/js/tomato-sales/tomato-sales.service.min.js'
				], function () {
					$rootScope.$apply(function () {
						deferred.resolve();
					}, function (err) {
						console.log('RouteProvider resolve error: ', err);
					});
				});
				return deferred.promise;
			}]
		}
	});

	$routeProvider.otherwise({
		redirectTo: '/tomato-sales'
	});
});