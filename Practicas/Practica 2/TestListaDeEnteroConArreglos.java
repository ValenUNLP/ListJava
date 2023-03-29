package Practica2;
import tp02.ejercicio2.*;
import Practica1B.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ej2 {
	ListaEnlazadaGenerica<Integer> ListaFuncion;
	
	public Ej2() {
		ListaFuncion = new ListaEnlazadaGenerica<Integer>();
	}
	
	public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
	
	public static String cadenaAleatoria(int longitud) {
        // El banco de caracteres
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }
	
	
	public void ImprimirRecursivo(ListaEnlazadaGenerica<Integer> Lista, int finPos) {
		if(finPos != 0){
			System.out.println(Lista.elemento(finPos));
			ImprimirRecursivo(Lista,finPos-1);			
		}
		
	}
	
	public ListaEnlazadaGenerica<Integer> AplicarFuncion(int n) {
			this.ListaFuncion.agregarFinal(n);
			if(n != 1) {
			if(n % 2 == 0) {
				AplicarFuncion(n / 2);
			}else {
				AplicarFuncion(3*n+1);
			}
		}
		return this.ListaFuncion;
	}
	
	public void TestListaEnlazadaGenerica() {
		ListaEnlazadaGenerica<estudiante> Estudiantes = new ListaEnlazadaGenerica<estudiante>();
		for (int i = 0; i < 4; i++) {
			String nombre = cadenaAleatoria(1);
			String apellido = cadenaAleatoria(2);
			String comision = cadenaAleatoria(3);
			String email = cadenaAleatoria(4);
			String direccion = cadenaAleatoria(5);
			Estudiantes.agregarFinal(new estudiante(nombre, apellido, comision, email, direccion));			
		}
		
		Estudiantes.comenzar();
		
		while (!Estudiantes.fin()){
			System.out.println(Estudiantes.proximo().tusDatos());
		}
	}

	public static void main(String[] args) {
		Ej2 test = new Ej2();
		Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
		//ListaEnlazadaGenerica<Integer> ListaEnteros = new ListaEnlazadaGenerica<Integer>();
		
		//for(String arg: args)ListaEnteros.agregarFinal(Integer.parseInt(arg));
		
		//System.out.println(ListaEnteros.toString());
		
		//test.ImprimirRecursivo(ListaEnteros, ListaEnteros.tamanio());
		//ListaEnteros = test.AplicarFuncion(10);
		//System.out.println(ListaEnteros.toString());
		
		//ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<>();
		//Lista.agregarFinal(23);
		//Lista.agregar(arr);
		//System.out.println(Lista.toString());
	}
	
}
