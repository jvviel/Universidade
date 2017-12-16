var cursoModulo = angular.module('cursoModulo',[]);

cursoModulo.controller("cursosController", function($scope, $http) {
	
	urlProfessor = 'http://localhost:8080/ProjetoWeb/rest/professores';
	urlCurso = 'http://localhost:8080/ProjetoWeb/rest/cursos';
	
	$scope.listarCursos = function() {
		$http.get(urlCurso).success(function (cursos) {
			$scope.cursos = cursos;	
		}).error (function (erro) {
			alert(erro);
		});	
	}
	
	$scope.listarProfessores = function() {
		$http.get(urlProfessor).success(function (professores) {
			$scope.professores = professores;	
		}).error (function (erro) {
			alert(erro);
		});	
	}
	
	$scope.selecionaCurso = function(cursoSelecionado) {
		$scope.curso = cursoSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.curso = "";
	}
	
	$scope.salvar = function() {
		if ($scope.curso.codigo == undefined) {
		   $http.post(urlCurso,$scope.curso).success(function(curso) {
		        //$scope.cursos.push($scope.curso);
			    $scope.listarCursos();
		        $scope.limparCampos();
		        alert("Curso Salvo com Sucesso!");
		   }).error (function (erro) {
				alert(erro);
			});
		  	
		} else {
			  $http.put(urlCurso,$scope.curso).success(function(curso) {
				  $scope.listarCursos();
			      $scope.limparCampos();
			      alert("Curso Alterado com Sucesso!");
			   }).error (function (erro) {
					alert(erro);
				});	
		}
		

	}
	
	$scope.excluir = function() {
		if ($scope.curso.codigo == undefined) {
			console.log("selecione um registro para poder excluir");
		} else {
			$http.delete(urlCurso+'/'+$scope.curso.codigo).success(function () {
				 $scope.listarCursos();
			     $scope.limparCampos();
			     alert("Curso Excluído com Sucesso!");
			  }).error (function (erro) {
					alert(erro);
				});	
		}
	}
	
	//executa
	$scope.listarCursos();
	$scope.listarProfessores();
	
	
});





