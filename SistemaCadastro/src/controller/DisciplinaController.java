package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Disciplina;

public class DisciplinaController implements ActionListener
{
	private JTextField tfDisciplinaCod;
	private JTextField tfDisciplinaNome;
	private JTextField tfDisciplinaHoras;
	private JComboBox<String> tfDiaSemana;
	private JTextField tfCodCurso;
	private JTextArea taDisciplina;
	
	public DisciplinaController(JTextField tfDisciplinaCod, JTextField tfDisciplinaNome, JTextField tfDisciplinaHoras,
			JComboBox tfDiaSemana, JTextField tfCodCurso, JTextArea taDisciplina)
	{
		super();
		this.tfDisciplinaCod = tfDisciplinaCod;
		this.tfDisciplinaNome = tfDisciplinaNome;
		this.tfDisciplinaHoras = tfDisciplinaHoras;
		this.tfDiaSemana = tfDiaSemana;
		this.tfCodCurso = tfCodCurso;
		this.taDisciplina = taDisciplina;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String cmd = e.getActionCommand();
		if (cmd.equals("Cadastrar"))
		{
			try
			{
				cadastro();
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Buscar")) 
		{
			try 
			{
				busca();
			} 
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
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

	private void busca() throws IOException 
	{
		Disciplina disciplina = new Disciplina();
		disciplina.codigoDisciplina = tfDisciplinaCod.getText();
		disciplina = buscaDisciplina(disciplina);
		if (disciplina.nomeDisciplina != null)
		{
			taDisciplina.setText("Código da disciplina: " + disciplina.codigoDisciplina + " \n- Nome: " + disciplina.nomeDisciplina
					+ " \n- Duração da aula: " + disciplina.horasMinistradas + "h \n- Dia da semana: " + disciplina.diaSemana + " \n- Código do curso: " + disciplina.codigoCurso +
					"\n-----------------------------------------------\n");
		}
		else
		{
			taDisciplina.setText("Disciplina não encontrada");
		}
		
	}

	private Disciplina buscaDisciplina(Disciplina disciplina) throws IOException 
	{
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File arq = new File(path, "disciplina.csv");
		if(arq.exists() && arq.isFile())
		{
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while(linha != null)
			{
				String[] vetLinha = linha.split(",");
				
				if (vetLinha[0].equals(disciplina.codigoDisciplina))
				{
					disciplina.nomeDisciplina = vetLinha[1];
					disciplina.diaSemana = vetLinha[2];
					disciplina.horasMinistradas = vetLinha[3];
					disciplina.codigoCurso = vetLinha[4];
					break;
				}
				
				linha = buffer.readLine();
			}
			
			buffer.close();
			isr.close();
			fis.close();
		}
		return disciplina;
	}

	private void cadastro() throws IOException
	{
		Disciplina disciplina = new Disciplina();
		disciplina.codigoDisciplina = tfDisciplinaCod.getText();
		disciplina.nomeDisciplina = tfDisciplinaNome.getText();
		disciplina.diaSemana = (String) tfDiaSemana.getSelectedItem();
		disciplina.horasMinistradas = tfDisciplinaHoras.getText();
		disciplina.codigoCurso = tfCodCurso.getText();
		cadastraDisciplina(disciplina.toString());
		tfDisciplinaCod.setText("");
		tfDisciplinaHoras.setText("");
		tfDisciplinaNome.setText("");
		tfCodCurso.setText("");
		
	}

	private void cadastraDisciplina(String csvDisciplina) throws IOException
	{
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File dir = new File(path);
		if (!dir.exists()) 
		{
			dir.mkdir();
		}
		File arq = new File(path, "disciplina.csv");
		boolean existe = false;
		if (arq.exists())
		{
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvDisciplina + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
	}
	
}
