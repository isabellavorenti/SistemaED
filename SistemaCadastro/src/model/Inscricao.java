package model;

public class Inscricao
{
	public String cpfDocente;
    public String codDisciplina;
    public String codProcesso;
    
	@Override
	public String toString() 
	{
		return cpfDocente + "," + codDisciplina + ","
				+ codProcesso;
	}
}
