package com.atvPoo08.interfaces;

import com.atvPoo08.models.Aluno;
import com.atvPoo08.models.Pessoa;
import com.atvPoo08.models.Professor;

public interface IService<T> {
	
	public void add(T pessoa);
	public void remove(int cpf);
	public int getTotalItens();

}
