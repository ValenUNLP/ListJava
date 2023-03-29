package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class ColaGenerica<T> extends ListaEnlazadaGenerica<T>{
	public boolean encolar (T dato)  {//agrega elemento a la pila
		this.agregarFinal(dato);
		return true;
	}
	
	public T desencolar() { //elimina y devuelve el primer elemento de la cola
		T aux = this.elemento(1);
		this.eliminarEn(1);
		return aux;
	}
	
	public T tope() { //devuelve el tope de la cola
		return this.elemento(1);
	}
	
	public boolean esVacio() {
		return this.esVacia();
	}
}
