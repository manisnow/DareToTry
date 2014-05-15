/**
 * Created by manisnow on 5/11/2014.
 */
'use strict';
var controler = angular.module('app.controllers', []);



    controler.controller('QuestionController', ['$scope','$http' ,'$location','QuestionService', function($scope,$http, $location,QuestionService) {
        // Instantiate an object to store your scope data in (Best Practices)

        $scope.challange=10;



        $http.get('/rest/question').success(function (data) {
            var jsonString = angular.toJson(data);
            //console.log(jsonString);
            QuestionService.setQuestionBank(angular.fromJson(jsonString));

        }).error(function (data) {

            console.log("eror"+ data);
        });


        $scope.challangeQuestion=function() {
            console.log("challange"+ $scope.challange);
            QuestionService.setChallange($scope.challange);
            $location.path('/TestPage')   ;
        }


        }]);

controler.controller('TestController', ['$scope', 'QuestionService', function($scope, QuestionService) {
    $scope.list = [];
    $scope.totalSize=QuestionService.getChallange();
    $scope.ind=0;
    $scope.hidebutton=true;
    $scope.formdata={}
    $scope.correctAnswer=0;
    $scope.wrongAnswer=0;

    $scope.setAnswer=function(){

        console.log(this.selected);
    }

    $scope.question=QuestionService.getQuestion($scope.ind)
    $scope.message="Java Testing";
    $scope.nextQuestion=function() {

        if($scope.formdata.option.answer) {
            $scope.correctAnswer=$scope.correctAnswer+1;
        }else{
            $scope.wrongAnswer= $scope.wrongAnswer+1;
        }

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
