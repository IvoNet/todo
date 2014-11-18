var app = angular.module('TodoApp', [
   'ngRoute'
]);

app.config([
              '$routeProvider',
              function ($routeProvider) {
                 $routeProvider.
                       when('/', {
                               templateUrl: 'views/home.html',
                               controller : 'HomeController'
                            }).
                       otherwise({redirectTo: '/'});
              }
           ]);


app.controller('HomeController', [
   '$scope',
   function ($scope) {
      $scope.debug = true;
      $scope.title = "Hello World";

   }
]);