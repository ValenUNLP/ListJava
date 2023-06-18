package P5;

import java.util.Iterator;

import src.ColaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.GrafoImplListAdy;
import tp06.ejercicio3.Vertice;
import tp06.ejercicio3.VerticeImplListAdy;

public class Recorridos<T> {
	
	
	 public void dfs(Grafo<T> grafo){
		 boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		 for (int i=1; i<=grafo.listaDeVertices().tamanio();i++){
		 if (!marca[i])
		 this.dfs(i, grafo, marca);
		 }
		 }
		private void dfs(int i, Grafo<T> grafo, boolean[] marca){
		 marca[i] = true;
		 Vertice<T> v = grafo.listaDeVertices().elemento(i);
		 System.out.println(v.dato());
		 ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		 ady.comenzar();
		 while(!ady.fin()){
		 int j = ady.proximo().verticeDestino().getPosicion();
		 if(!marca[j]){
		 this.dfs(j, grafo, marca);
		 }
		 }
		 } 
		
	public void bfs(Grafo<T> grafo) {
		boolean[] Marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		for(int i=1 ; i <= grafo.listaDeVertices().tamanio(); i++) {
			if(!Marca[i]) {
				this.bfs(i, grafo, Marca);
			}
		}
	}
	
	private void bfs(int i, Grafo<T> grafo, boolean[] marca) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> Cola = new ColaGenerica<Vertice<T>>();
		Cola.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		while(!Cola.esVacia()){
			Vertice<T> v = Cola.desencolar();
			System.out.println(v.dato());
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()){
				Arista<T> Arista = ady.proximo();
				int j = Arista.verticeDestino().getPosicion();
				if(!marca[j]) {
					Vertice<T> w = Arista.verticeDestino();
					marca[j] = true;
					Cola.encolar(w);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Recorridos<Integer> R = new Recorridos<Integer>();
		Grafo<Integer> G = new GrafoImplListAdy<>();
		Vertice<Integer> v1 = new VerticeImplListAdy<Integer>(10);
		Vertice<Integer> v2 = new VerticeImplListAdy<Integer>(2);
		Vertice<Integer> v3 = new VerticeImplListAdy<Integer>(-1);
		
		G.agregarVertice(v1);
		G.agregarVertice(v2);
		G.agregarVertice(v3);
		G.conectar(v1, v2);
		G.conectar(v1,  v3);
		R.bfs(G);
		
	}
	
	
}
