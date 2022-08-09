import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

//		Comparator<String> comparadorPorTamanho = new ComparadorPorTamanho();
//		Collections.sort(palavras, comparadorPorTamanho); *Modo antigo
//		palavras.sort(comparadorPorTamanho);

//		palavras.sort((s1, s2) -> {
//			if (s1.length() < s2.length())
//				return -1;
//			if (s1.length() > s2.length())
//				return 1;
//			return 0;
//		});

		palavras.sort(Comparator.comparing(String::length)); // Metodo reference
//		OU
		palavras.sort(Comparator.comparing(s -> s.length()));
//		OU
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
//		OU
		Function<String, Integer> funcao = String::length;
		Function<String, Integer> funcao2 = s -> s.length();
//		OU
		Function<String, Integer> funcaoOld = new Function<String, Integer>() { // s -> s.length();
			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
		Comparator<String> comparador = Comparator.comparing(funcaoOld);
		palavras.sort(comparador);

		System.out.println(palavras);

//		for (String p : palavras) {
//			System.out.println(p); *Formato antigo
//		}

//		Consumer<String> consumior = new ImprimeNaLinha();
//		Consumer<String> consumior = new Consumer<String>() {
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//		};

//		palavras.forEach(consumior);

		Consumer<String> impressor = System.out::println;
//		Ou
		Consumer<String> impressorOld = s -> System.out.println(s);

		palavras.forEach(impressorOld);
//		palavras.forEach(s -> System.out.println(s));
//		Ou
		palavras.forEach(System.out::println);
	}
}

//class ImprimeNaLinha implements Consumer<String> {
//	@Override
//	public void accept(String s) {
//		System.out.println(s);
//	}
//}

//class ComparadorPorTamanho implements Comparator<String> {
//	@Override
//	public int compare(String s1, String s2) {
//		if (s1.length() < s2.length())
//			return -1;
//		if (s1.length() > s2.length())
//			return 1;
//		return 0;
//	}
//}
