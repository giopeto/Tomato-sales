ngApp.lazy.controller('tomatoSalesCtrl', function($scope, $http, $log, TomatoFactory) {
	var vm = this;
	vm.get = get;
	vm.tomatoes = [];
	vm.isLoading = false;

	function get(args) {
		if(!args.size || (typeof args.size==='number' && (args.size%1)===0)) {
			vm.isLoading = true;
			vm.tomatoes = TomatoFactory.query({size: args.size}, function () {
				vm.isLoading = false;
			}, function (error) {
				vm.isLoading = false;
				$log.log("Error: ", error);
			});
		}

	};
});