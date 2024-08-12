package br.com.dio.desafio.dominio;

public class Curso extends Conteudo
{
	private static final int CARGA_HORARIA_PADRAO = 48;

	private int cargaHoraria;

	public Curso(String titulo, String descricao, int... cargaHoraria)
	{
		setTitulo(titulo);
		setDescricao(descricao);

		this.cargaHoraria = cargaHoraria.length > 0 ? cargaHoraria[0] : CARGA_HORARIA_PADRAO;
	}

	public int getCargaHoraria()
	{
		return this.cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria)
	{
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public double calcularXP()
	{
		return XP_PADRAO * cargaHoraria;
	}
}