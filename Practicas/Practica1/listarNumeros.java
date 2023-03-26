package Practica1B;


public class listarNumeros {
int a;
int b;
	
public listarNumeros(int a, int b) {
	this.a = a;
	this.b = b;
}

public int getA() {
	return a;
}

public void setA(int a) {
	this.a = a;
}

public int getB() {
	return b;
}

public void setB(int b) {
	this.b = b;
}
	
public void listarConFor() {
	for (int i = a; i <= b; i++) {
		System.out.println(i);		
	}
}

public void listarConWhile() {
	int i = a;
	while(i <= b) {
		System.out.println(i);
		i++;
	}
}

public void recorrerRecursivo(int num, int fin) {
	if (num <= fin){
		System.out.println(num);
		recorrerRecursivo(num+1 ,b);
	}
}

public void listarSinEstructuras() {	
	recorrerRecursivo(a, b);
}

}
