/**
 * Created by Павел on 09.12.2014.
 */
var VitasoftTestModule = angular.module("VitasoftTest", ["ui.bootstrap", "ui.grid"]);

VitasoftTestModule.controller("VitasoftTestController", function ($scope, $http) {

    $scope.driverForEdit = undefined;
    $scope.selectedDriver = undefined;

    $scope.driverGridOptions = {
        enableSorting: false,
        externalScope: {
            editRow: function (driver) {
                $scope.driverForEdit = JSON.parse(JSON.stringify(driver));
            },
            deleteRow: function (driver) {
                if (confirm("Запись водителя " + driver.secondName + " " + driver.firstName + " " + driver.middleName + " будет удалена.\nВы действительно хотите выполнчть удаление?")) {
                    $http({
                            url: "./service/driver",
                            dataType: "json",
                            data: driver,
                            method: "DELETE",
                            headers: {
                                "Content-Type": "application/json"
                            }
                        }
                    ).then(function (response) {
                            var dataArray = $scope.driverGridOptions.data;
                            for (var i = 0; i < dataArray.length; i++) {
                                if (dataArray[i].id == driver.id) {
                                    dataArray.splice(i, 1);
                                }
                            }
                        });
                }
            }
        },
        columnDefs: [
            {name: "Фамилия", field: "secondName"},
            {name: "Имя", field: "firstName"},
            {name: "Отчество", field: "middleName"},
            {name: "Дата рождения", field: "birthday", cellFilter: "date:'dd.MM.yyyy'"},
            {name: "Пол", field: "gender"},
            {name: "Класс", field: "driverClass.name"},
            {
                name: "Редактировать",
                cellTemplate: "<button class='btn small' ng-click='getExternalScopes().editRow(row.entity)'>Редактировать</button>"
            },
            {
                name: "Удалить",
                cellTemplate: "<button class='btn small' ng-click='getExternalScopes().deleteRow(row.entity)'>Удалить</button>"
            }
        ],
        data: []
    }
    ;

    $scope.searchDriver = function (val) {
        return $http({
            url: "./service/searchdriver",
            dataType: "json",
            data: {query: val},
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function (response) {
            return response.data;
        });
    };

    $scope.onDriverSelect = function (item, model, label) {
        var hasItem = false;
        var tableData = $scope.driverGridOptions.data;
        for (var i = 0; i < tableData.length; i++) {
            if (tableData[i].id == item.id) {
                hasItem = true;
            }
        }
        if (hasItem == false) {
            $scope.driverGridOptions.data.push(item);
        }
        $scope.selectedDriver = undefined;
    };

    $scope.calcAge = function () {
        if ($scope.driverForEdit == undefined) {
            return undefined;
        }
        var ageDiff = Date.now() - new Date($scope.driverForEdit.birthday).getTime();
        var ageDate = new Date(ageDiff);
        return Math.abs(ageDate.getUTCFullYear() - 1970);
    };

    $scope.saveDriver = function (driver) {
        $http({
                url: "./service/driver",
                dataType: "json",
                data: $scope.driverForEdit,
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                }
            }
        ).then(function (response) {
                var added = false;
                var dataArray = $scope.driverGridOptions.data;
                for (var i = 0; i < dataArray.length; i++) {
                    if (dataArray[i].id == $scope.driverForEdit.id) {
                        angular.extend(dataArray[i], $scope.driverForEdit);
                        added = true;
                    }
                }
                if (added == false) {
                    dataArray.push($scope.driverForEdit);
                }
                $scope.driverForEdit = undefined;
            });
    };

    $scope.cancelSaveDriver = function () {
        $scope.driverForEdit = undefined;
    };

    $scope.classes = [];

    $http({
        url: "./service/classes",
        dataType: "json",
        data: "",
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (response) {
        $scope.classes = response.data;
    })

});