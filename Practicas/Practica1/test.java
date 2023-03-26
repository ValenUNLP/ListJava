package Practica1B;

import java.util.Scanner;

public class test {
	Scanner s = new Scanner(System.in);
	estudiante[] estudiantes = new estudiante[2];
	profesor[] profesores = new profesor[3];
	
	public test() {
		
	}
	
	public void llenarEstudiantes(){

		for (int i = 0; i < estudiantes.length; i++) {
			estudiantes[i] = new estudiante();
			estudiantes[i].setApellido(s.nextLine());
			estudiantes[i].setNombre(s.nextLine());
			estudiantes[i].setComision(s.nextLine());
			estudiantes[i].setDireccion(s.nextLine());
			estudiantes[i].setEmail(s.nextLine());
			
		}
	}
	
	public void leerEstudiantes() {
		for (int i = 0; i < estudiantes.length; i++) {
			System.out.println(estudiantes[i].tusDatos());
		}
	}
	
	public void llenarProfesores(){

		for (int i = 0; i < profesores.length; i++) {
			profesores [i] = new profesor();
			profesores[i].setApellido(s.nextLine());
			profesores[i].setNombre(s.nextLine());
			profesores[i].setFacultad(s.nextLine());
			profesores[i].setCatedra(s.nextLine());
			profesores[i].setEmail(s.nextLine());
			
		}
	}
	
	public void leerProfesores() {
		for (int i = 0; i < profesores.length; i++) {
			System.out.println(profesores[i].tusDatos());
		}
	}
}
