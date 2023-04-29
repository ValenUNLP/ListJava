package Parcial;

public class Palabra {
	String valor;
	Integer siguiente;
	
	public Palabra(String v, Integer s) {
		this.valor = v;
		this.siguiente = s;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Integer siguiente) {
		this.siguiente = siguiente;
	}
	
	
}
