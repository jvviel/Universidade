var professoresModulo = angular.module('professoresModulo',[]);

professoresModulo.controller("professoresController", function ($scope, $http){
    
    urlProfessor = 'http://localhost:8080/ProjetoWeb/rest/professores';
    
    $scope.listarProfessor = function() {
        $http.get(urlProfessor).success(function (professores){
            $scope.professores = professores;
        }).error (function(erro){
            alert(erro);
        });
    }
    
    
    $scope.selecionaProfessor = function(professorSelecionado){
        $scope.professor = professorSelecionado;
    }

    $scope.limparCampos = function(){
        $scope.professor = "";
    }
    
    $scope.salvar = function(){
        
        if($scope.professor.codigo == undefined) {
            $http.post(urlProfessor, $scope.professor).success(function(professor) {
                //$scope.professores.push($scope.professor);
            	$scope.listarProfessor();
                $scope.limparCampos();
                alert("Professor Salvo Com Sucesso!");
            }).error (function(erro){
                alert(erro);
            });
            
        }else{
            $http.put(urlProfessor, $scope.professor).success(function(professor){
                $scope.listarProfessor();
                $scope.limparCampos();
                alert("Professor Alterado com Sucesso!");
            }).error (function(erro){
                alert(erro);
            });
        }
  
    }
    
    
    $scope.excluir = function(){
        if($scope.professor.codigo == undefined){
            alert("selecione um registro");
    } else{
        $http.delete(urlProfessor + '/' + $scope.professor.codigo).success(function (){
            $scope.listarProfessor();
            $scope.limparCampos();
            alert("Professor Excluído com Sucesso!");
        }).error (function (erro){
            alert(erro);
        });
        
    }
        
    }
    
    //executa
    $scope.listarProfessor();
    
});