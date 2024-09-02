import java.util.HashMap;
import javax.swing.JOptionPane;

public class GestionProfesorHashMap {

    public static void main(String[] args) {

        HashMap<String, Double[]> estudiantesNotas = new HashMap<>(); 
        int totalNotasIngresadas = 0;
        int estudiantesAprobados = 0;
        int estudiantesReprobados = 0;
        int estudiantesRecuperacion = 0;
        int estudiantesSinRecuperacion = 0;
        double promedioFinal = 0;
        double promedioFinal2 = 0;

        int cantEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));

        for (int i = 0; i < cantEstudiantes; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (i + 1));
            Double[] notas = new Double[3]; // Array to store three grades for each student
            double promedio = 0;

            for (int j = 0; j < 3; j++) {
                totalNotasIngresadas++;
                double nota;
                do {
                    nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota " + (j + 1) + " del estudiante " + nombre));
                    if (nota < 0.0 || nota > 5.0) {
                        System.out.println("Ingrese una nota entre 0 y 5");
                    }
                } while (nota < 0.0 || nota > 5.0);

                notas[j] = nota;
                promedio += nota;
            }

            estudiantesNotas.put(nombre, notas);

            double promedioTotal = promedio / 3;

            if (promedioTotal < 3.5) {
                System.out.println(nombre + " ha reprobado, sus notas son " + notas[0] + ", " + notas[1] + ", " + notas[2] + " y su promedio es de " + promedioTotal);
                estudiantesReprobados++;
                if (promedioTotal > 2.0) {
                    System.out.println(nombre + " puede recuperar ya que su promedio es mayor a 2.0");
                    estudiantesRecuperacion++;
                } else {
                    System.out.println(nombre + " no puede recuperar ya que su promedio es inferior o igual a 2.0");
                    estudiantesSinRecuperacion++;
                }
            } else {
                System.out.println(nombre + " ha aprobado, sus notas son " + notas[0] + ", " + notas[1] + ", " + notas[2] + " y su promedio es de " + promedioTotal);
                estudiantesAprobados++;
            }

            promedioFinal += promedioTotal;
        }

        promedioFinal2 = promedioFinal / cantEstudiantes;

        
        System.out.println("");
        System.out.println("Se han validado " + cantEstudiantes + " estudiantes");
        System.out.println("Reprobaron " + estudiantesReprobados + " estudiantes");
        System.out.println("Aprobaron " + estudiantesAprobados + " estudiantes");
        System.out.println("Pierden pero pueden recuperar " + estudiantesRecuperacion + " estudiantes");
        System.out.println("Pierden sin poder recuperar " + estudiantesSinRecuperacion + " estudiantes");
        System.out.println("Se registraron un total de " + totalNotasIngresadas + " notas");
        System.out.println("El promedio total de todas las notas finales de los estudiantes es " + promedioFinal2);
    }
}
