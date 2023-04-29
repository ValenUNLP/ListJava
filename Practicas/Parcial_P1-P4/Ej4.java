package Parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class Ej4 {
	
	private Character buscarLetra(ArbolBinario<Character> a, String Codigo){
		System.out.println(Codigo);
		if(Codigo.length() != 0) {
			char c = Codigo.charAt(0);
			if(c == '0') {
				return buscarLetra(a.getHijoIzquierdo(), Codigo.substring(1));
			}else  return buscarLetra(a.getHijoDerecho(), Codigo.substring(1));
		}
		return a.getDato();
	}

	public ListaGenerica<Character> descifrarCodigo(ArbolBinario<Character> a, ListaGenerica<String> Codigo){
		
		ListaGenerica<Character> Lista = new ListaEnlazadaGenerica<Character>();
		
		Codigo.comenzar();
		
		while(!Codigo.fin()) {
			
			Lista.agregarFinal(buscarLetra(a, Codigo.proximo()));
			
		}
		
		return Lista;
		
	}
	
	
	public static void main(String[] args) {
		ArbolBinario<Character> Arbol = new ArbolBinario<Character>('e');
		Arbol.agregarHijoIzquierdo(new ArbolBinario<>('e'));
		Arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Character>('e'));
		Arbol.getHijoIzquierdo().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Character>('c'));
		Arbol.getHijoIzquierdo().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Character>('s'));
		
		
		Arbol.agregarHijoDerecho(new ArbolBinario<Character>('e'));
		Arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Character>('e'));
		Arbol.getHijoDerecho().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Character>('e'));
		Arbol.getHijoDerecho().getHijoIzquierdo().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Character>('e'));
		Arbol.getHijoDerecho().getHijoIzquierdo().getHijoIzquierdo().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Character>('a'));
		Arbol.getHijoDerecho().getHijoIzquierdo().getHijoIzquierdo().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Character>('g'));
		Arbol.getHijoDerecho().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Character>('e'));
		Arbol.getHijoDerecho().getHijoIzquierdo().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Character>('r'));;
		
		Arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Character>('e'));
		Arbol.getHijoDerecho().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Character>('d'));
		Arbol.getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Character>('e'));
		Arbol.getHijoDerecho().getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Character>('o'));
		
		Ej4 Ej4 = new Ej4();
		ListaEnlazadaGenerica<String> Codigo = new ListaEnlazadaGenerica<>();
		
		Codigo.agregarFinal("101");
		Codigo.agregarFinal("001");
		Codigo.agregarFinal("10001");
		Codigo.agregarFinal("1111");
		Codigo.agregarFinal("1001");
		Codigo.agregarFinal("110");
		Codigo.agregarFinal("1111");
		
		System.out.println(Ej4.descifrarCodigo(Arbol, Codigo));
		//Arbol.entreNiveles(1, 6);
	}
}
