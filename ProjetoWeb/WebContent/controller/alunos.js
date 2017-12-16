var alunoModulo = angular.module('alunoModulo',[]);

alunoModulo.controller("alunosController", function($scope, $http) {
	
	urlAluno = 'http://localhost:8080/ProjetoWeb/rest/alunos';
	urlCurso = 'http://localhost:8080/ProjetoWeb/rest/cursos';
	
	$scope.listarAlunos = function() {
		$http.get(urlAluno).success(function (alunos) {
			$scope.alunos = alunos;	
		}).error (function (erro) {
			alert(erro);
		});	
	}
	
	$scope.listarCursos = function() {
		$http.get(urlCurso).success(function (cursos) {
			$scope.cursos = cursos;	
		}).error (function (erro) {
			alert(erro);
		});	
	}
	
	$scope.selecionaAluno = function(alunoSelecionado) {
		$scope.aluno = alunoSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.aluno = "";
	}
	
	$scope.salvar = function() {
		if ($scope.aluno.codigo == undefined) {
		   $http.post(urlAluno,$scope.aluno).success(function(aluno) {
		        //$scope.alunos.push($scope.aluno);
			    $scope.listarAlunos();
		        $scope.limparCampos();
		        alert("Aluno Salvo com Sucesso!");
		   }).error (function (erro) {
				alert(erro);
			});
		  	
		} else {
			  $http.put(urlAluno,$scope.aluno).success(function(aluno) {
				  $scope.listarAlunos();
			      $scope.limparCampos();
			      alert("Aluno Alterado com Sucesso!");
			   }).error (function (erro) {
					alert(erro);
				});	
		}
		

	}
	
	$scope.excluir = function() {
		if ($scope.aluno.codigo == undefined) {
			console.log("selecione um registro para poder excluir");
		} else {
			$http.delete(urlAluno+'/'+$scope.aluno.codigo).success(function () {
				 $scope.listarAlunos();
			     $scope.limparCampos();
			     alert("Aluno Excluído com Sucesso!");
			  }).error (function (erro) {
					alert(erro);
				});	
		}
	}
	
	//executa
	$scope.listarAlunos();
	$scope.listarCursos();
	
	
});





