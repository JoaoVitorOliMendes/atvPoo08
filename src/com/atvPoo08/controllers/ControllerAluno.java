package com.atvPoo08.controllers;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.atvPoo08.models.Aluno;
import com.atvPoo08.services.AlunoServiceImpl;

public class ControllerAluno {
	
	public static boolean controleLoop;
	
	public static void menu(AlunoServiceImpl alunoService) {
		controleLoop = true;
		while (controleLoop) {
			String[] menus = {"Cadastrar", "Remover", "Listar", "Pesquisar", "Voltar"};
			String menuDesc = ":: Menu Alunos ::\n\n";
			menuDesc += "Alunos Cadastrados:\t0\n\n\n\n";
			menuDesc += "Defina sua opção";
			
			int op = JOptionPane.showOptionDialog(null,
					menuDesc,
					"Sistema POO", 1, 1,
					null, menus, menus[0]);
			
			switch(op) {
			case 0: 
				addAluno(alunoService);
				break;
			case 1: 
				removeAluno(alunoService);
				break;
			case 2: 
				listAlunos(alunoService);
				break;
			case 3: 
				findAluno(alunoService);
				break;
			default:
				controleLoop = false;
			}
		}
	}
	
	public static void addAluno(AlunoServiceImpl alunoService) {
		JTextField cpf = new JTextField();
		JTextField nome = new JTextField();
		JTextField nota = new JTextField();
		Object[] field2 = {
				"Digite o cpf do Aluno:", cpf,
				"Digite o nome do Aluno:", nome,
				"Digite a nota do Aluno:", nota
		};
		int yOn = JOptionPane.showConfirmDialog(null, field2, "Cadastrar Aluno", JOptionPane.YES_NO_OPTION);
		if(yOn == 0) {
			Aluno aluno = new Aluno();
			int cpfInt = Integer.valueOf(cpf.getText());
			if(alunoService.getAluno(cpfInt) == null) {
				if(Double.valueOf(nota.getText()) > 0) {
					aluno.setCpf(cpfInt);
					aluno.setNome(nome.getText());
					aluno.setNota(Double.valueOf(nota.getText()));
					alunoService.add(aluno);
				}else {
					JOptionPane.showConfirmDialog(null, "A nota deve ser maior que 0", "Alerta", JOptionPane.YES_NO_OPTION);
				}
			}else {
				JOptionPane.showConfirmDialog(null, "O aluno com cpf: " + cpfInt + " ja esta cadastrado no sistema", "Alerta", JOptionPane.YES_NO_OPTION);
			}
		}
	}
	
	public static void removeAluno(AlunoServiceImpl alunoService) {
		JTextField cpf = new JTextField();
		Object[] field2 = {
				"Digite o cpf do Aluno a ser removido:", cpf
		};
		int yOn = JOptionPane.showConfirmDialog(null, field2, "Remover aluno", JOptionPane.YES_NO_OPTION);
		if(yOn == 0) {
			int cpfInt = Integer.valueOf(cpf.getText());
			alunoService.remove(cpfInt);
		}
	}
	
	public static void listAlunos(AlunoServiceImpl alunoService) {
		String alunoLista = "";
		for (Aluno aluno : alunoService.getALLAlunos()) {
			alunoLista += aluno.toString() + "\n";
		}
		int yOn = JOptionPane.showConfirmDialog(null, ":: Alunos Cadastrados ::\n\n" + alunoLista + "\n\n", "Listar alunos", JOptionPane.YES_NO_OPTION);
	}
	
	public static void findAluno(AlunoServiceImpl alunoService) {
		JTextField cpf = new JTextField();
		Object[] field2 = {
				"Digite o cpf do Aluno:", cpf
		};
		int yOn = JOptionPane.showConfirmDialog(null, field2, "Pesquisar aluno", JOptionPane.YES_NO_OPTION);
		if(yOn == 0) {
			int cpfInt = Integer.valueOf(cpf.getText());
			int resultYON = JOptionPane.showConfirmDialog(null, ":: Pesquisa de Aluno ::\n\n" + alunoService.getAluno(cpfInt) + "\n\n", "Listar alunos", JOptionPane.YES_NO_OPTION);
		}
	}
	
	public static void situacao(AlunoServiceImpl alunoService) {
		JTextField cpf = new JTextField();
		Object[] field2 = {
				"Digite o cpf do Aluno:", cpf
		};
		int yOn = JOptionPane.showConfirmDialog(null, field2, "Pesquisar aluno", JOptionPane.YES_NO_OPTION);
		if(yOn == 0) {
			int cpfInt = Integer.valueOf(cpf.getText());
			int resultYON = JOptionPane.showConfirmDialog(null, ":: Situacao do Aluno ::\n\n" + alunoService.getResultadoAluno(cpfInt) + "\n\n", "Situacao do Aluno", JOptionPane.YES_NO_OPTION);
		}
	}
}
