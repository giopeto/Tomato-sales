ngApp.lazy.factory('TomatoFactory', function ($resource) {
	var resource = $resource('tomatoes/data?size=:size', {size: '@size'}, {
		update: {
			method: 'PUT'
		}
	});

	return resource;
});