import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestionProfesor {

	public static void main(String[] args) {
		
		
		ArrayList<Double> NotasEstudiantes;
		
		double Notas;
		
		int totalNotasIngresadas= 0;
		
		int EstudiantesAprobados= 0;
		
		int EstudiantesReprobados= 0;
		
		int EstudiantesRecuperacion=0;
		
		int EstudiantesSinRecuperacion=0;
		
		double promedioFinal = 0;
		
		double promedioFinal2=0;
		
		int cantEstudiantes=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));
		
		for (int i = 0; i < cantEstudiantes; i++) {
			String nombre=JOptionPane.showInputDialog("Ingrese el nombre del estudiante "+(i+1));
			NotasEstudiantes=new ArrayList<Double>();
			double promedio=0;
			for (int j = 0; j < 3; j++) {
				totalNotasIngresadas++;
				do {
					Notas=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota " + (j+1) + " del estudiante " +nombre));
					if (Notas<0.0 || Notas>5.0) {
						System.out.println("Ingrese una nota entre 0 y 5");
					}
				}while(Notas<0.0 || Notas>5.0);
								NotasEstudiantes.add(Notas);
				System.out.println(NotasEstudiantes);
				 
				
				promedio += NotasEstudiantes.get(j);
			
				 
				 
			}
			double promedioTotal = promedio/3;
			 
			 if(promedioTotal < 3.5) {
				 System.out.println(nombre + " ha reprobado, sus notas son " + NotasEstudiantes + " y su promedio es de "+ promedioTotal);
				 EstudiantesReprobados++;
					System.out.println("");
				 if(promedioTotal>2.0) {
					System.out.println(nombre +" puede recuperar ya que su promedio es mayor a 2.0");	
					System.out.println("");
					 EstudiantesRecuperacion++;
					 }else {
						 System.out.println(nombre +" no puede recuperar ya que su promedio es inferior o igual a 2.0");	
						 EstudiantesSinRecuperacion++;
							System.out.println("");
					 }
			 } else {
				 System.out.println(nombre + " ha aprobado, sus notas son " + NotasEstudiantes + " y su promedio es de "+ promedioTotal);
				 System.out.println("");
				 EstudiantesAprobados++;
			 }
			 
			 promedioFinal +=promedioTotal;
			 
			 
			 promedioFinal2=promedioFinal/3;
			 
			 
			
		}
		System.out.println("");
		System.out.println("Se han validado " +cantEstudiantes +" estudiantes");
		System.out.println("");
		System.out.println("Reprobaron "+EstudiantesReprobados+" estudiantes");
		System.out.println("");
		System.out.println("Aprobaron "+EstudiantesAprobados+ " estudiantes");
		System.out.println("");
		System.out.println("Pierden pero pueden recuperar "+EstudiantesRecuperacion+ " estudiantes");
		System.out.println("");
		System.out.println("Pierden sin poder recuperar "+EstudiantesSinRecuperacion+ " estudiantes");
		System.out.println("");
		System.out.println("Se registraron un total de "+totalNotasIngresadas+" notas");
		System.out.println("");
		System.out.println("El promedio total de todas las notas finales de los estudiantes es "+ promedioFinal2);
	}

}