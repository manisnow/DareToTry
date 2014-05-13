/**
 * 
 */

angular.module("EMP", [])
    .factory("EMP", function () {

        var id
        var firstName
        var lastName
        var birthDate;
        var salaryLevel;

        return {

            getEmployee: function (id, name, price) {
                return this;
            }

        }
    })

angular.module("EMPS", [])
.factory("EMPS", function () {
 
  var emploees =[];
 
    return {
 
        getAllEmployee: function () {
            return emploees;
        },
        addEmployee:function(EMP){
            emploees.push(EMP)
        }

    }
})
