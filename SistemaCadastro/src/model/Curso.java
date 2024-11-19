package model;

public class Curso 
{
	public String codigo;
	public String nome;
	public String areaConhecimento;
	
	@Override
	public String toString() 
	
	{
		return codigo + "," + nome + "," + areaConhecimento;
	}
}
