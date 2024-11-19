package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Curso;

public class CursoController implements ActionListener 
{

	private JTextField tfCursoId;
	private JTextField tfCursoNome;
	private JTextField tfCursoArea;
	private JTextArea taCurso;
	
	public CursoController(JTextField tfCursoId, JTextField tfCursoNome, JTextField tfCursoArea, JTextArea taCurso) 
	{
		super();
		this.tfCursoId = tfCursoId;
		this.tfCursoNome = tfCursoNome;
		this.tfCursoArea = tfCursoArea;
		this.taCurso = taCurso;
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
//		if (cmd.equals("Atualizar"))
//		{
//			atualizacao();
//		}
		if (cmd.equals("Excluir")) 
		{
			try 
			{
				exclusao();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		
	}

	private void exclusao() throws IOException
	{
	}

	
	private void atualizacao() 
	{
		
	}

	private void busca() throws IOException
	{
		Curso curso = new Curso();
		curso.codigo = tfCursoId.getText();
		curso = buscaCurso(curso);
		if (curso.nome != null)
		{
			taCurso.setText("Código do curso: " + curso.codigo + " \n- Nome: " + curso.nome + 
					" \n- Área do conhecimento: " + curso.areaConhecimento + "\n-----------------------------------------------------------");
		}
		else
		{
			taCurso.setText("Curso não encontrado");
		}
	}

	private Curso buscaCurso(Curso curso) throws IOException 
	{
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File arq = new File(path, "curso.csv");
		if(arq.exists() && arq.isFile())
		{
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while(linha != null)
			{
				String[] vetLinha = linha.split(",");
				
				if (vetLinha[0].equals(curso.codigo))
				{
					curso.nome = vetLinha[1];
					curso.areaConhecimento = vetLinha[2];
					break;
				}
				
				linha = buffer.readLine();
			}
			
			buffer.close();
			isr.close();
			fis.close();
		}
		return curso;
	}

	private void cadastro() throws IOException 
	{
		Curso curso = new Curso();
		curso.codigo = tfCursoId.getText();
		curso.nome = tfCursoNome.getText();
		curso.areaConhecimento = tfCursoArea.getText();
		cadastraCurso(curso.toString());
		tfCursoArea.setText("");
		tfCursoId.setText("");
		tfCursoNome.setText("");
	}

	private void cadastraCurso(String csvCurso) throws IOException 
	{
		String path = System.getProperty("user.home") + File.separator + "SistemaCadastro";
		File dir = new File(path);
		if (!dir.exists()) 
		{
			dir.mkdir();
		}
		File arq = new File(path, "curso.csv");
		boolean existe = false;
		if (arq.exists())
		{
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvCurso + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}
	
}
















