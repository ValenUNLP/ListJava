package Parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Ej8 {
	ArbolGeneral<Integer> Arbol;
	
	public Ej8(ArbolGeneral<Integer> A) {
		this.Arbol = A;
	}
	
	private void HelperResolver(ArbolGeneral<Integer> a, ListaGenerica<Integer> l) {
		if(!a.esVacio()) {
			
			for (int i = 1; i <= a.getHijos().tamanio(); i++) {
				HelperResolver(a.getHijos().elemento(i), l);
			}
			if(a.getHijos().tamanio() % 2 == 1) {
				int suma = 0;
				
				for (int i = 1; i <= a.getHijos().tamanio(); i++) {
					suma = suma + a.getHijos().elemento(i).getDato();
				}
				l.agregarFinal(suma);
			}
		}
	}
	
	public ListaGenerica<Integer> resolver(){
		ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<Integer>();
		
		HelperResolver(Arbol, Lista);
		
		return Lista;
	}
	
	public static void main(String[] args) {
		ArbolGeneral<Integer> Arbol = new ArbolGeneral<Integer>(2);
		Arbol.agregarHijo(new ArbolGeneral<Integer>(1));
		Arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(5));
		Arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(4));
		Arbol.getHijos().elemento(1).getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(9));
		Arbol.getHijos().elemento(1).getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(10));
		Arbol.getHijos().elemento(1).getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(5));
		Arbol.agregarHijo(new ArbolGeneral<Integer>(12));
		Arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(8));
		Arbol.getHijos().elemento(2).getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(3));
		Arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(4));
		Arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(7));
		Arbol.getHijos().elemento(2).getHijos().elemento(3).agregarHijo(new ArbolGeneral<Integer>(13));
		Arbol.agregarHijo(new ArbolGeneral<Integer>(14));
		
		Ej8 Ej8 = new Ej8(Arbol);
		System.out.println(Ej8.resolver());
	}
}
