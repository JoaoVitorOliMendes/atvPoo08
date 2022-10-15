package com.atvPoo08.models;

public class Professor extends Pessoa {

	private double salario;

	
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Professor() {
		super();
	}
	public Professor(double salario) {
		super();
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Professor [salario=" + salario + ", getCodigo()=" + getCodigo() + ", getCpf()=" + getCpf()
				+ ", getNome()=" + getNome() + ", toString()=" + super.toString() + "]";
	}
	
}
