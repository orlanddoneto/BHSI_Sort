package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Program {

	public static void main(String[] args) {
		int tamVetor = 10000; //tamanho do vetor
		int tipo = 3; //[1]Integer [2]String [3]Double
		int porcentagem = 20; //Porcentagem em que as extremidades do vetor vão ordenar usando selectSort
		
		List<Generic> list = geraVetor(tamVetor,tipo);
		
		BHSI__Algorithm.sort(list, 0, tamVetor-1, porcentagem);
		
		for(Generic item : list) {
			System.out.println(item.getValue());
		}

	}
	
	
	private static List<Generic> geraVetor(int tam, int tipo){
		Random random = new Random();
		List<Generic> list = new ArrayList<>();
		
		switch(tipo) {
		case 1:
			for(int i = 0 ; i<tam;i++) {
				list.add(new Generic<Integer>(random.nextInt(tam))); // aqui você informa o valor máximo de um elemento do array
			}
			break;
			
		case 2:
			for(int i = 0 ; i<tam;i++) {
				list.add(new Generic<String>(generateRandomString())); // aqui você informa o valor máximo de um elemento do array
			}
			break;
			
		case 3:
			for(int i = 0 ; i<tam;i++) {
				list.add(new Generic<Double>(random.nextDouble(tam))); // aqui você informa o valor máximo de um elemento do array
			}
			break;
		
		default:
			System.out.println("Seleção inválida! Apenas 1,2 ou 3.");
		}
		
		return list;
	
	}
	
	private static String generateRandomString() {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(7);

		Random random = new Random();
		for (int i = 0; i < 7; i++) {
			int index = random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}

		return sb.toString();
	}
}
