package com.atvPoo08.repositories;

import java.util.ArrayList;
import java.util.List;

import com.atvPoo08.interfaces.IRepository;
import com.atvPoo08.models.Professor;

public class RepositoryProfessorImpl implements IRepository {
	
	private List<Professor> professores = new ArrayList();

	@Override
	public int getIdSequencial() {
		return professores.size() + 1;
	}

	@Override
	public int getTotalItens() {
		return professores.size();
	}

	public Professor getProfessor(int cpf) {
		Professor finalProfessor = null; 
		for (Professor professor : professores) {
			if(professor.getCpf() == cpf) {
				finalProfessor = professor;				
			}
		}
		return finalProfessor;
	}
	
	public void addProfessor(Professor professor) {
		professor.setCodigo(getIdSequencial());
		professores.add(professor);
	}
	
	public void removeProfessor(int cpf) {
		int index = -1; 
		for (int i = 0; i < professores.size(); i++) {
			if(professores.get(i).getCpf() == cpf) {
				index = i;
			}
		}
		if(index != -1) {
			professores.remove(index);
		}
	}
	
	public List<Professor> listALL() {
		return this.professores;
	}
}
