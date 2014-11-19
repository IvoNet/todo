var app = angular.module('TodoApp', []);


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

app.controller('HomeController',
               function ($scope, $filter, restService) {
                  $scope.debug = false;
                  $scope.showKnowledgeBase = true;
                  $scope.title = "Be calm... Todo it";

                  //todo Rest Call


                  //todo Watch Data Post


                  //todo Total Todos


                  //todo Add Todos


                  //todo Remove Completed


               }
);