import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}

}

public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

//		cursos.sort(Comparator.comparing(c -> c.getAlunos()));
		cursos.sort(Comparator.comparing(Curso::getAlunos));

//		cursos.forEach(System.out::println); //reference chama objeto e nao atributo especifico
//		cursos.forEach(c -> System.out.println(c.getNome()));
//		permite concatenar chamadas para trabalhar com muitos objetos
		/* IntStream stream = */
		OptionalDouble sum = cursos.stream().filter(c -> c.getAlunos() >= 100) //
				.mapToInt(Curso::getAlunos) //
//				.sum()//
				.average();

		cursos.stream() // permite concatenar chamadas para trabalhar com muitos objetos
				.filter(c -> c.getAlunos() >= 100) // Quando tem condicao ou comparacao etc. nao da pra usar o reference
//				.forEach(c -> System.out.println(c.getNome()))
//				.map(c -> c.getAlunos()) // Agora devolve um stream de integer 
				.map(Curso::getAlunos) // Agora devolve um stream de integer
//				.forEach(total -> System.out.println(total))// imprime o total de alunos em cada curso
//				.forEach(System.out::println) //
		;
//		System.out.println("Total de alunos: " + sum);

		// Optional permite trabalhar c referencias que podem ser nulas
		/* Optional<Curso> optionalCurso = */
//		cursos.stream() //
//				.filter(c -> c.getAlunos() >= 100) // condicao
//				.findAny() // Retorna qualquer um que entre na condicao
//				.ifPresent(c -> System.out.println(c.getNome())) // se existir executa, evitando possivel exception
//		;

		/* List<Curso> resultado = */
		cursos = cursos.stream() // Reaproveitamento de stream
				.filter(c -> c.getAlunos() >= 100) //
				.collect(Collectors.toList())//
		;
		cursos.stream().forEach(c -> System.out.println(c.getNome()));

//		MAPMap retorno <String, Integer> map = 
		cursos.stream() // Necessita de chave e valor
				.filter(c -> c.getAlunos() >= 100) //
				.collect(Collectors.toMap( //
						c -> c.getNome(), //
						c -> c.getAlunos() //
				))//
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		;

	}
}
