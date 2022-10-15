package com.atvPoo08.models;

public class Aluno extends Pessoa {

	private double nota;

	
	
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public Aluno() {
		super();
	}
	public Aluno(double nota) {
		super();
		this.nota = nota;
	}
	@Override
	public String toString() {
		return "Aluno [nota=" + nota + ", getCodigo()=" + getCodigo() + ", getCpf()=" + getCpf() + ", getNome()="
				+ getNome() + "]";
	}
}
