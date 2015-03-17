function Hello($scope, $http) {
    $http.get('http://localhost:9000/greeting').
        success(function(data) {
            $scope.greeting = data;
        });
}
