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

app.factory('restService', function ($http) {
   return {
      query: function () {
         return $http({
                         method: 'GET',
                         url   : 'resources/todos'
                      });
      },
      post : function (url, object) {
         return $http({
                         method : 'POST',
                         url    : url,
                         headers: {'Content-Type': 'application/json'},
                         data   : object
                      });
      }
   };
});

app.controller('HomeController', [
   '$scope',
   '$filter',
   'restService',
   function ($scope, $filter, restService) {
      $scope.debug = false;
      $scope.title = "Be calm... Todo";

      restService.query().success(function (data) {
         $scope.data = data;
      });

      $scope.totaalTodos = function () {
         if ($scope.data !== undefined) {
            return $scope.data.length;
         }
         return 0;
      };

      $scope.addTodo = function () {
         $scope.data.push({
                             "done": false,
                             "todo": $scope.newTodo
                          });
         $scope.newTodo = "";
      };


      $scope.$watch('data', function () {
         restService.post('resources/todos', $scope.data)
      }, true);

   }
]);