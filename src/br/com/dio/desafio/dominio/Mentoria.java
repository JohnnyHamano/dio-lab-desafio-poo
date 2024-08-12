package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mentoria extends Conteudo
{
	private final LocalDate DATA = LocalDate.now();

	public Mentoria(String titulo, String descricao)
	{
		setTitulo(titulo);
		setDescricao(descricao);
	}

	public LocalDate getData()
	{
		return this.DATA;
	}

	public String getDataToString()
	{
		return this.DATA.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	@Override
	public double calcularXP()
	{
		return XP_PADRAO + 10d;
	}
}