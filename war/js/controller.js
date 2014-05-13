/**
 * Created by manisnow on 5/11/2014.
 */
'use strict';
var controler = angular.module('app.controllers', []);



    controler.controller('QuestionController', ['$scope','$http' ,'QuestionService', function($scope,$http, QuestionService) {
        // Instantiate an object to store your scope data in (Best Practices)

        $scope.challange=10;



        $http.get('/rest/question').success(function (data) {
            var jsonString = angular.toJson(data);
            console.log(jsonString);
            QuestionService.setQuestionBank(angular.fromJson(jsonString));

        }).error(function (data) {

            console.log("eror"+ data);
        });


    }]);

controler.controller('TestController', ['$scope', 'QuestionService', function($scope, QuestionService) {
    $scope.list = [];
    $scope.totalSize=QuestionService.getTotalNoOfQuestion();
    $scope.ind=0;
    $scope.hidebutton=true;
    $scope.answer=false;

    $scope.question=QuestionService.getQuestion($scope.ind)
    $scope.message="Java Testing";
    $scope.nextQuestion=function() {
        $scope.list.push(this.answer);
        this.answer='';
        $scope.ind = $scope.ind + 1
        if ($scope.ind < $scope.totalSize) {

            $scope.question=QuestionService.getQuestion($scope.ind)
        }else{
            $scope.message="Testing completed";
            $scope.question={};
            $scope.hidebutton=false;
        }
    }

    }]);
