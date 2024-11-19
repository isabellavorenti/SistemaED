package model;

public class Professor 
{
	public String nome;
	public String area;
	public String cpf;
	public int pontuacao;
	  
	@Override
	public String toString() 
	{
		return nome + "," + area + "," + cpf + "," + pontuacao;
	}	  
}     
