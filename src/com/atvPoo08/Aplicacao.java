package com.atvPoo08;

import javax.swing.JOptionPane;

import com.atvPoo08.controllers.ControllerAluno;
import com.atvPoo08.controllers.ControllerProfessor;
import com.atvPoo08.models.Aluno;
import com.atvPoo08.models.Professor;
import com.atvPoo08.services.AlunoServiceImpl;
import com.atvPoo08.services.ProfessorServiceImpl;

public class Aplicacao {
	
	private static boolean controleLoop = true;
	private static ProfessorServiceImpl professorService = new ProfessorServiceImpl();
	private static AlunoServiceImpl alunoService = new AlunoServiceImpl();

	public static void main(String[] args) {
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		Aluno aluno3 = new Aluno();
		Aluno aluno4 = new Aluno();
		Aluno aluno5 = new Aluno();
		aluno1.setCpf(111);
		aluno2.setCpf(222);
		aluno3.setCpf(333);
		aluno4.setCpf(444);
		aluno5.setCpf(555);
		aluno1.setNome("Joao");
		aluno2.setNome("Felipe");
		aluno3.setNome("Gabriel");
		aluno4.setNome("Andre");
		aluno5.setNome("Vinicius");
		aluno1.setNota(1.0);
		aluno2.setNota(2.5);
		aluno3.setNota(3.0);
		aluno4.setNota(4.5);
		aluno5.setNota(5.0);
		
		Professor professor1 = new Professor();
		Professor professor2 = new Professor();
		Professor professor3 = new Professor();
		Professor professor4 = new Professor();
		Professor professor5 = new Professor();
		professor1.setCpf(111);
		professor2.setCpf(222);
		professor3.setCpf(333);
		professor4.setCpf(444);
		professor5.setCpf(555);
		professor1.setNome("Leonardo");
		professor2.setNome("Lucas");
		professor3.setNome("Wallace");
		professor4.setNome("Breno");
		professor5.setNome("Pericles");
		professor1.setSalario(1000.0);
		professor2.setSalario(2000.5);
		professor3.setSalario(3000.0);
		professor4.setSalario(4000.5);
		professor5.setSalario(5000.0);
		
		alunoService.add(aluno1);
		alunoService.add(aluno2);
		alunoService.add(aluno3);
		alunoService.add(aluno4);
		alunoService.add(aluno5);
		professorService.add(professor1);
		professorService.add(professor2);
		professorService.add(professor3);
		professorService.add(professor4);
		professorService.add(professor5);
		menuPrincipal(professorService, alunoService);
	}
	
	public static void menuPrincipal(ProfessorServiceImpl professorService, AlunoServiceImpl alunoService) {
		String tituloMenu = "----------------------------------------Menu do Sistema----------------------------------------\n\n";
		tituloMenu += "Sistema realizado na disciplina de POO\n\n";
		tituloMenu += "Dados:";
		tituloMenu += "\tAlunos:\t0\n";
		tituloMenu += "\tProfessores:\t0\n\n\n\n";
		tituloMenu += "----------------------------------------Menu do Sistema----------------------------------------";
		while (controleLoop) {
			String[] menus = {"Alunos", "Professores", "Situação do Aluno", "Salário do Professor", "Sair"};
			int op = JOptionPane.showOptionDialog(null,
					tituloMenu,
					"Sistema POO", 1, 1,
					null, menus, menus[0]);
			switch(op) {
			case 0:
				ControllerAluno.menu(alunoService);
				break;
			case 1:
				ControllerProfessor.menu(professorService);
				break;
			case 2:
				ControllerAluno.situacao(alunoService);
				break;
			case 3:
				ControllerProfessor.situacao(professorService, alunoService);
				break;
			default: 
				controleLoop = false;
			}
		}
	}

}
