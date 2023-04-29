package Parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Ej1 {
	
	private void Helper (ListaEnlazadaGenerica<String> l, ArbolGeneral<Palabra> a){
		
		if(!a.esVacio() && !a.esHoja()){
			l.agregarFinal(a.getDato().getValor());
			Helper(l, a.getHijos().elemento(a.getDato().getSiguiente()));
		}
		if(a.esHoja()) l.agregarFinal(a.getDato().getValor());

		
		
	}
	
	public ListaEnlazadaGenerica<String> UnirCaminos(ArbolGeneral<Palabra> a){
		ListaEnlazadaGenerica<String> Lista = new ListaEnlazadaGenerica<String>();
		Helper(Lista, a);
		return Lista;
	}
	
	
	public static void main(String[] args) {
		ArbolGeneral<Palabra> Arbol = new ArbolGeneral<Palabra>(new Palabra("G", 1));
		ArbolGeneral<Palabra> Arbol2 = new ArbolGeneral<Palabra>(new Palabra("E", 2));
		ArbolGeneral<Palabra> Arbol3 = new ArbolGeneral<Palabra>(new Palabra("F", 2));
		ArbolGeneral<Palabra> Arbol4 = new ArbolGeneral<Palabra>(new Palabra("J", 5));
		
		Arbol2.agregarHijo(new ArbolGeneral<Palabra>(new Palabra("A", 7)));
		Arbol2.agregarHijo(new ArbolGeneral<Palabra>(new Palabra("B", 9)));
		Arbol2.agregarHijo(new ArbolGeneral<Palabra>(new Palabra("C", 6)));
		
		Arbol3.agregarHijo(new ArbolGeneral<Palabra>(new Palabra("D", 10)));
		
		Arbol4.agregarHijo(new ArbolGeneral<Palabra>(new Palabra("H", 6)));
		Arbol4.agregarHijo(new ArbolGeneral<Palabra>(new Palabra("I", 10)));
		
		Arbol.agregarHijo(Arbol2);
		Arbol.agregarHijo(Arbol3);
		Arbol.agregarHijo(Arbol4);
		
		Ej1 Ej1 = new Ej1();
		
		System.out.println(Ej1.UnirCaminos(Arbol));
	}
}
