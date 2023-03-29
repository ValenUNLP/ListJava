package tp02.ejercicio3;
import tp02.ejercicio2.*;

public class PilaGenerica<T> extends ListaEnlazadaGenerica<T> {
	
	public boolean apilar(T dato)  {//agrega elemento a la pila
		this.agregarFinal(dato);
		return true;
	}
	
	public T desapilar() { //elimina y devuelve el primer elemento de la cola
		T aux = this.elemento(this.tamanio());
		this.eliminarEn(this.tamanio());
		return aux;
	}
	
	public T tope() { //devuelve el tope de la cola
		return this.elemento(this.tamanio());
	}
	
	public boolean esVacio() {
		return this.esVacia();
	}
	
}
