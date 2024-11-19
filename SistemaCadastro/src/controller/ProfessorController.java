package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Professor;

public class ProfessorController implements ActionListener
{
	private JTextField tfProfessorNome;
	private JTextField tfProfessorArea;
	private JTextField tfProfessorCpf;
	private JTextField tfProfessorPontuacao;
	private JTextArea taProfessor;
	
	public ProfessorController(JTextField tfProfessorNome, JTextField tfProfessorArea, JTextField tfProfessorCpf,
			JTextField tfProfessorPontuacao, JTextArea taProfessor) 
	{
		super();
		this.tfProfessorNome = tfProfessorNome;
		this.tfProfessorArea = tfProfessorArea;
		this.tfProfessorCpf = tfProfessorCpf;
		this.tfProfessorPontuacao = tfProfessorPontuacao;
		this.taProfessor = taProfessor;
	} 
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String cmd = e.getActionCommand();
		if (cmd.equals("Cadastrar"))
		{
			cadastro();
		}
		if (cmd.equals("Buscar")) 
		{
			busca();
		}
		if (cmd.equals("Atualizar"))
		{
			atualizacao();
		}
		if (cmd.equals("Excluir"))
		{
			exclusao();
		}
	}

	private void exclusao() {
		// TODO Auto-generated method stub
		
	}

	private void atualizacao() {
		// TODO Auto-generated method stub
		
	}

	private void busca() {
		// TODO Auto-generated method stub
		
	}

	private void cadastro() {
		Professor professor = new Professor();
		professor.nome = tfProfessorNome.getText();
		professor.area = tfProfessorArea.getText();
		professor.pontuacao = Integer.parseInt(tfProfessorPontuacao.getText());
		professor.cpf = tfProfessorCpf.getText();
		
		
	}
	
}
