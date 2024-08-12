package br.com.dio.desafio.dominio;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Iterator;
import java.util.Optional;

public class Dev
{
	private String nome;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

	public Dev(String nome)
	{
		this.nome = nome;
	}

	public String getNome()
	{
		return this.nome;
	}

	public Set<Conteudo> getConteudosInscritos()
	{
		return this.conteudosInscritos;
	}

	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos)
	{
		this.conteudosInscritos = conteudosInscritos;
	}

	public void adicionarConteudosInscritos(Conteudo conteudosInscritos)
	{
		this.conteudosInscritos.add(conteudosInscritos);
	}

	public Set<Conteudo> getConteudosConcluidos()
	{
		return this.conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos)
	{
		this.conteudosConcluidos = conteudosConcluidos;
	}

	public void adicionarConteudosConcluidos(Conteudo conteudosConcluidos)
	{
		this.conteudosConcluidos.add(conteudosConcluidos);
	}

	public void inscreverBootcamp(Bootcamp bootcamp)
	{
		this.conteudosInscritos.addAll(bootcamp.getConteudos());
		bootcamp.adicionarDev(this);
	}

	public void progredir()
	{
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		
		if (conteudo.isPresent())
		{
			Conteudo c = conteudo.get();

			this.conteudosInscritos.remove(c);
			this.conteudosConcluidos.add(c);
		}
		else
		{
			System.err.println("Nenhum conteúdo encontrado.");
		}
	}

	public double calcularTotalXP()
	{
		Iterator<Conteudo> iterator = getConteudosConcluidos().iterator();
		double xp = 0;

		while(iterator.hasNext())
		{
			xp += iterator.next().calcularXP();
		}

		return xp;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;

		Dev other = (Dev) obj;

		if (nome == null) {
			if (other.nome != null) return false;
		} else if (!nome.equals(other.nome)) return false;

		if (conteudosInscritos == null) {
			if (other.conteudosInscritos != null) return false;
		} else if (!conteudosInscritos.equals(other.conteudosInscritos)) return false;

		if (conteudosConcluidos == null) {
			if (other.conteudosConcluidos != null) return false;
		} else if (!conteudosConcluidos.equals(other.conteudosConcluidos)) return false;

		return true;
	}
}