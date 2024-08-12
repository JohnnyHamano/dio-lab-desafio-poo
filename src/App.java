import br.com.dio.desafio.dominio.*;

public class App {
	public static void main(String[] args) throws Exception {
		Conteudo curso = new Curso("Curso Java", "Curso de programação Java");
		Conteudo mentoria = new Mentoria("Mentoria Java", "Mentoria de programação Java");

		Bootcamp bootcamp = new Bootcamp("Bootcamp Java", "Bootcamp de programação Java");
        bootcamp.adicionarConteudo(curso);
        bootcamp.adicionarConteudo(mentoria);

		Dev developer = new Dev("Johnny");
		developer.inscreverBootcamp(bootcamp);

		System.out.println(curso);
		System.out.println(mentoria);
		System.out.println(bootcamp);
		System.out.println(developer);

		System.out.println("XP: "+developer.calcularTotalXP());

		System.out.println(developer.getConteudosInscritos());
		System.out.println(developer.getConteudosConcluidos());
		developer.progredir();
		System.out.println(developer.getConteudosInscritos());
		System.out.println(developer.getConteudosConcluidos());

		System.out.println("XP: "+developer.calcularTotalXP());
	}
}