package br.com.dio.desafio.dominio;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.time.LocalDate;

public class Bootcamp
{
	private String nome;
	private String descricao;
	
	private final LocalDate DATA_INICIO = LocalDate.now();
	private final LocalDate DATA_FIM = DATA_INICIO.plusDays(45);

	private Set<Conteudo> conteudos = new LinkedHashSet<>();
	private Set<Dev> devs = new HashSet<>();

	public Bootcamp(String nome, String descricao)
	{
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome()
	{
		return this.nome;
	}

	public String getDescricao()
	{
		return this.descricao;
	}

	public LocalDate getData_Inicio()
	{
		return this.DATA_INICIO;
	}

	public LocalDate getData_Fim() {
		return DATA_FIM;
	}

	public Set<Conteudo> getConteudos()
	{
		return this.conteudos;
	}

	public void setConteudos(Set<Conteudo> conteudos)
	{
		this.conteudos = conteudos;
	}

	public void adicionarConteudo(Conteudo conteudo)
	{
		this.conteudos.add(conteudo);
	}

	public Set<Dev> getDevs()
	{
		return this.devs;
	}

	public void adicionarDev(Dev dev)
	{
		this.devs.add(dev);
	}
}