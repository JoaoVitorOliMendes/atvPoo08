package com.atvPoo08.controllers;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.atvPoo08.models.Aluno;
import com.atvPoo08.models.Professor;
import com.atvPoo08.services.AlunoServiceImpl;
import com.atvPoo08.services.ProfessorServiceImpl;

public class ControllerProfessor {
	
	public static boolean controleLoop;
	
	public static void menu(ProfessorServiceImpl professorService) {
		controleLoop = true;
		while (controleLoop) {
			String[] menus = {"Cadastrar", "Remover", "Listar", "Pesquisar", "Voltar"};
			String menuDesc = ":: Menu Professores ::\n\n";
			menuDesc += "Professores Cadastrados:\t0\n\n\n\n";
			menuDesc += "Defina sua opção";
			
			int op = JOptionPane.showOptionDialog(null,
					menuDesc,
					"Sistema POO", 1, 1,
					null, menus, menus[0]);
			
			switch(op) {
			case 0: 
				addProfessor(professorService);
				break;
			case 1: 
				removeProfessor(professorService);
				break;
			case 2: 
				listProfessor(professorService);
				break;
			case 3: 
				findProfessor(professorService);
				break;
			default:
				controleLoop = false;
			}
		}
	}
	
	public static void addProfessor(ProfessorServiceImpl professorService) {
		JTextField cpf = new JTextField();
		JTextField nome = new JTextField();
		JTextField salario = new JTextField();
		Object[] field2 = {
				"Digite o cpf do Professor:", cpf,
				"Digite o nome do Professor:", nome,
				"Digite o salario do Professor:", salario
		};
		int yOn = JOptionPane.showConfirmDialog(null, field2, "Cadastrar Professor", JOptionPane.YES_NO_OPTION);
		if(yOn == 0) {
			Professor professor = new Professor();
			int cpfInt = Integer.valueOf(cpf.getText());
			if(professorService.getProfessor(cpfInt) == null) {
				if(Double.valueOf(salario.getText()) > 0) {
					professor.setCpf(cpfInt);
					professor.setNome(nome.getText());
					professor.setSalario(Double.valueOf(salario.getText()));
					professorService.add(professor);
				}else {
					JOptionPane.showConfirmDialog(null, "O salario deve ser maior que 0", "Alerta", JOptionPane.YES_NO_OPTION);
				}
			}else {
				JOptionPane.showConfirmDialog(null, "O professor com cpf: " + cpfInt + " ja esta cadastrado no sistema", "Alerta", JOptionPane.YES_NO_OPTION);
			}
		}
	}
	
	public static void removeProfessor(ProfessorServiceImpl professorService) {
		JTextField cpf = new JTextField();
		Object[] field2 = {
				"Digite o cpf do Professor a ser removido:", cpf
		};
		int yOn = JOptionPane.showConfirmDialog(null, field2, "Remover professor", JOptionPane.YES_NO_OPTION);
		if(yOn == 0) {
			int cpfInt = Integer.valueOf(cpf.getText());
			professorService.remove(cpfInt);
		}
	}
	
	public static void listProfessor(ProfessorServiceImpl professorService) {
		String professorLista = "";
		for (Professor professor : professorService.getALLProfessores()) {
			professorLista += professor.toString() + "\n";
		}
		int yOn = JOptionPane.showConfirmDialog(null, ":: Professores Cadastrados ::\n\n" + professorLista + "\n\n", "Listar Professores", JOptionPane.YES_NO_OPTION);
	}
	
	public static void findProfessor(ProfessorServiceImpl professorService) {
		JTextField cpf = new JTextField();
		Object[] field2 = {
				"Digite o cpf do Professor:", cpf
		};
		int yOn = JOptionPane.showConfirmDialog(null, field2, "Pesquisar professor", JOptionPane.YES_NO_OPTION);
		if(yOn == 0) {
			int cpfInt = Integer.valueOf(cpf.getText());
			int resultYON = JOptionPane.showConfirmDialog(null, ":: Pesquisa de Professor ::\n\n" + professorService.getProfessor(cpfInt) + "\n\n", "Listar professor", JOptionPane.YES_NO_OPTION);
		}
	}
	
	public static void situacao(ProfessorServiceImpl professorService, AlunoServiceImpl alunoService) {
		JTextField cpf = new JTextField();
		Object[] field2 = {
				"Digite o cpf do Professor:", cpf
		};
		int yOn = JOptionPane.showConfirmDialog(null, field2, "Pesquisar professor", JOptionPane.YES_NO_OPTION);
		if(yOn == 0) {
			int cpfInt = Integer.valueOf(cpf.getText());
			int resultYON = JOptionPane.showConfirmDialog(null, ":: Salario do Professor ::\n\n" + professorService.getSalarioProfessor(cpfInt, alunoService) + "\n\n", "Salario do Professor", JOptionPane.YES_NO_OPTION);
		}
	}
}
