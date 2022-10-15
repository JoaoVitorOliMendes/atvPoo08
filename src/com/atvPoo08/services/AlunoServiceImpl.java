package com.atvPoo08.services;

import java.util.List;

import com.atvPoo08.interfaces.IService;
import com.atvPoo08.models.Aluno;
import com.atvPoo08.repositories.RepositoryAlunoImpl;

public class AlunoServiceImpl implements IService<Aluno> {
	
	private RepositoryAlunoImpl repositoryAluno = new RepositoryAlunoImpl();

	@Override
	public void add(Aluno aluno) {
		repositoryAluno.addAluno(aluno);
	}

	@Override
	public void remove(int cpf) {
		repositoryAluno.removeAluno(cpf);
	}

	@Override
	public int getTotalItens() {
		return repositoryAluno.getTotalItens();
	}
	
	public Aluno getAluno(int cpf) {
		return repositoryAluno.getAluno(cpf);
	}

	public List<Aluno> getALLAlunos() {
		return repositoryAluno.listALL();
	}
	
	public String getResultadoAluno(int cpf) {
		Aluno aluno = repositoryAluno.getAluno(cpf);
		if(aluno.getNota() < 40) {
			return "Reprovado";
		}else if(aluno.getNota() < 60) {
			return "Exame especial";
		}else {
			return "Aprovado";
		}
	}
	
}
