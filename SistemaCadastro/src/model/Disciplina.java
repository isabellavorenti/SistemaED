package model;

public class Disciplina
{

	public String codigoDisciplina;
	public String nomeDisciplina;
	public String diaSemana;
	public String horasMinistradas;
	public String codigoCurso;
	
	@Override
	public String toString() 
	{
		return codigoDisciplina + "," + nomeDisciplina
				+ "," + diaSemana + "," + horasMinistradas + "," + codigoCurso;
	}
}
