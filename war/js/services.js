/**
 * Created by manisnow on 5/11/2014.
 */
angular.module('app.services', ['ngResource'])
    .factory('QuestionService', function($resource){
        var questionBank={};
        var  correctAnswer=0;

        //return $resource('/rest/question', {},{
          //  get:  {method:'GET'}
        //});

            return{

                setCorrectAnswer:function(data){
                    correctAnswer=data;
                },
                getCorrectAnswer:function(){
                    return correctAnswer;
                },
                setQuestionBank:function(data){
                    questionBank=data;
                },
                getQuestionBank:function(){
                    return questionBank;
                },
                getQuestions:function(){
                    return questionBank.question;
                },
                getQuestion:function(ind){
                    return questionBank.question[ind];
                },
                getTotalNoOfQuestion:function(){
                return questionBank.question.length;
            }
            };



    });

