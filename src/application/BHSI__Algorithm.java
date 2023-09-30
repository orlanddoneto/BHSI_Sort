package application;

import java.util.List;
import java.util.function.BiFunction;

public class BHSI__Algorithm {
	
	private static void heapify(List<Generic> list, int n, int i) {
        int largest = i; // Inicializar o maior como raiz
        int l = 2 * i + 1; // esquerda = 2 * i + 1
        int r = 2 * i + 2; // direita = 2 * i + 2

        // Se o filho esquerdo é maior que a raiz
        
        if (l < n && (list.get(l).compareTo(list.get(largest)))> 0)
            largest = l;

        // Se o filho direito é maior que o maior até agora
       
        if (r < n && (list.get(r).compareTo(list.get(largest)))> 0)
            largest = r;

        // Se o maior não é raiz
      
        if (largest != i) {
            Generic swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);
            // Recursivamente heapify a subarvore afetada
            heapify(list, n, largest);
        }
    }
	
	
	
	public static void sort(List<Generic> list, int ini, int fim, double porcentagem) {
		
		heapify(list,ini,fim);
		
		int posicaoPorcentagem = (int) (fim * (porcentagem/100));
		
		// select pro inicio
		for (int i = ini; i<=posicaoPorcentagem-1;i++) {
            int menor = i; // ou Maior
            Generic temp = list.get(i);
            for (int j = i+1; j<list.size();j++) {
                if (list.get(j).compareTo(list.get(menor))< 0) {
                    menor = j;
                }
            }
            list.set(i, list.get(menor));
            list.set(menor, temp);
        }
		//select Pro final
		int ordemInversa = -1;
		for (int i =fim ;i>=(fim-posicaoPorcentagem-1);i--) {
            int menor = i; // ou Maior
            Generic temp = list.get(i);
            for (int j = i-1; j>=ini;j--) {
                if (list.get(j).compareTo(list.get(menor)) *ordemInversa < 0) {
                    menor = j;
                }
            }
            list.set(i, list.get(menor));
            list.set(menor, temp);
        }
		
		///Insert pra os valores intermediários
		for (int i=posicaoPorcentagem+1; i<=(fim-posicaoPorcentagem); i++) {
            Generic temp = list.get(i);
            int j = i-1;
            while (j >= 0 && (list.get(j).compareTo(temp)> 0)) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, temp);
        }
		
	}
	
	
}
