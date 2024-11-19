package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Inscricao;

public class InscricaoController implements ActionListener
{
	private JTextField tfInscricaoCpf; 
	private JTextField tfInscricaoCodDisciplina;
	private JTextField tfInscricaoCodProcesso; 
	private JTextArea taInscricao;
	
	public InscricaoController(JTextField tfInscricaoCpf, JTextField tfInscricaoCodDisciplina,
			JTextField tfInscricaoCodProcesso, JTextArea taInscricao) 
	{
		super();
		this.tfInscricaoCpf = tfInscricaoCpf;
		this.tfInscricaoCodDisciplina = tfInscricaoCodDisciplina;
		this.tfInscricaoCodProcesso = tfInscricaoCodProcesso;
		this.taInscricao = taInscricao;
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

	private void cadastro() 
	{
		Inscricao inscricao = new Inscricao();
		inscricao.cpfDocente = tfInscricaoCpf.getText();
		inscricao.codDisciplina = tfInscricaoCodDisciplina.getText();
		inscricao.codProcesso = tfInscricaoCodProcesso.getText();
		
		System.out.println(inscricao);
	}

	private void exclusao()
	{
		
		
	}

	private void atualizacao() 
	{
		
		
	}

	private void busca() 
	{
		
		
	}
	
	
}
