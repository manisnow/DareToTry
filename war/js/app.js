'use strict';


// Declare app level module which depends on filters, and services
angular.module('app', ['app.services','app.controllers','ngRoute']).
    config(['$routeProvider', function($routeProvider) {
        $routeProvider.when("/JavaQuestHome", {
            templateUrl: "/html/JavaQuestHome.html",
            controller:'QuestionController'

        }).when("/TestPage",{
            
            templateUrl: "/html/TestPage.html",
            controller:'TestController'
        }).when("/EditEmp",{
            templateUrl: "/html/EditEmployee.html"
        });
    }]);





/*app.controller("MainController",function($scope,QuestionService){
    //  $scope.url="http://rest-service.guides.spring.io/greeting";
    $scope.challange=10;
    $scope.questionBank=QuestionService.getQuestionBank;
    
    $scope.challangeQuestion=function(){
    	QuestionService.callQuestionBankRest()
    	console.log("called " );
    }


    
    
});


app.service("QuestionService", function ($http) {
 var questionBank="";


  this.callQuestionBankRest= function(){
        $http.get("/rest/question").success(function (data) {
            var jsonString = angular.toJson(data);

            this.getQuestionBank=jsonString
            console.log("sstar" + this.getQuestionBank);

        }).error(function(data) {
            console.log(data);

        })}
  
  this.getQuestionBank=questionBank;

  
  
});

*/
