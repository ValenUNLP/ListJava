package tp02.ejercicio4;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio3.*;

public class TestBalanceo {
	
	public boolean Balanceo(ListaEnlazadaGenerica<Character> Lista) {
		PilaGenerica<Character> Pila = new PilaGenerica<Character>();
		
		while (!Lista.fin()) {
			Character actual = Lista.proximo();
			if(actual.toString().equals((("}")))){
				if(Pila.esVacia()) return false;
				if(Pila.tope().toString().equals("{")) {
					if (Pila.esVacia()) return false; 
					Pila.desapilar();
				}else {
					return false;
				}
			}else {
				if(actual.toString().equals("]")) {
					if (Pila.esVacia()) return false; 
					if(Pila.tope().toString().equals("[")) {
						Pila.desapilar();
					}else {
						return false;
					}
				}else {
					if(actual.toString().equals(")")) {
						if (Pila.esVacia()) return false; 
						if(Pila.tope().toString().equals("(")) {
							Pila.desapilar();
						}else {
							return false;
						}
					}else {
						Pila.apilar(actual);						
					}
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		ListaEnlazadaGenerica<Character> Lista = new ListaEnlazadaGenerica<Character>();
		
		TestBalanceo BalanceoTest = new TestBalanceo();
		
		for (int i = 0; i < args[0].length(); i++) {
			Lista.agregarFinal(args[0].charAt(i));
		}
		
		System.out.println(BalanceoTest.Balanceo(Lista));
		
}
}
