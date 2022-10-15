package com.atvPoo08.repositories;

import java.util.ArrayList;
import java.util.List;

import com.atvPoo08.interfaces.IRepository;
import com.atvPoo08.models.Aluno;

public class RepositoryAlunoImpl implements IRepository{
	
	private List<Aluno> alunos = new ArrayList();

	@Override
	public int getIdSequencial() {
		return alunos.size() + 1;
	}

	@Override
	public int getTotalItens() {
		return alunos.size();
	}

	public Aluno getAluno(int cpf) {
		Aluno finalAluno = null; 
		for (Aluno aluno : alunos) {
			if (aluno.getCpf() == cpf) {
				finalAluno = aluno;				
			}
		}
		return finalAluno;
	}
	
	public void addAluno(Aluno aluno) {
		aluno.setCodigo(getIdSequencial());
		alunos.add(aluno);
	}
	
	public void removeAluno(int cpf) {
		int index = -1; 
		for (int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).getCpf() == cpf) {
				index = i;
			}
		}
		if(index != -1) {
			alunos.remove(index);
		}
	}
	
	public List<Aluno> listALL() {
		return this.alunos;
	}
}
