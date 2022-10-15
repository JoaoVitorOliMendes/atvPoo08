package com.atvPoo08.services;

import java.util.List;

import com.atvPoo08.interfaces.IService;
import com.atvPoo08.models.Aluno;
import com.atvPoo08.models.Professor;
import com.atvPoo08.repositories.RepositoryProfessorImpl;

public class ProfessorServiceImpl implements IService<Professor> {
	
	private RepositoryProfessorImpl repositoryProfessor = new RepositoryProfessorImpl();

	@Override
	public void add(Professor professor) {
		repositoryProfessor.addProfessor(professor);
	}

	@Override
	public void remove(int cpf) {
		repositoryProfessor.removeProfessor(cpf);
	}

	@Override
	public int getTotalItens() {
		return repositoryProfessor.getTotalItens();
	}

	public Professor getProfessor(int cpf) {
		return repositoryProfessor.getProfessor(cpf);
	}

	public List<Professor> getALLProfessores() {
		return repositoryProfessor.listALL();
	}
	
	public String getSalarioProfessor(int cpf, AlunoServiceImpl alunoService) {
		Professor professor = repositoryProfessor.getProfessor(cpf);
		if(professor != null) {
			int qtdAlunos = alunoService.getTotalItens();
			Double salarioBase = (professor.getSalario() + 2380);
			return String.valueOf(salarioBase + ((salarioBase * 0.03) * qtdAlunos));
		}
		return null;
	}
}
