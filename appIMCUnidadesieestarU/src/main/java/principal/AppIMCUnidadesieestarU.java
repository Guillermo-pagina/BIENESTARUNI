package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppIMCUnidadesieestarU {
    private static ArrayList<personal> listaPersonas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("\n...MENU DE BIENESTAR...");
            System.out.println("1. Agregar Registro");
            System.out.println("2. Ver Lista de Registros");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            
            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                op = 0;
            }

            if (op == 1) {
                try {
                    System.out.print("Nombre completo: ");
                    String nom = sc.nextLine();
                    System.out.print("Fecha Nacimiento (AÑO-MES-DIA, ej. 2000-05-151"
                            + ": ");
                    LocalDate fec = LocalDate.parse(sc.nextLine());
                    System.out.print("Peso (kg): ");
                    double p = Double.parseDouble(sc.nextLine());
                    System.out.print("Altura (m): ");
                    double a = Double.parseDouble(sc.nextLine());
                    System.out.print("Direccion: ");
                    String dir = sc.nextLine();
                    System.out.print("Telefono: ");
                    String tel = sc.nextLine();
                    System.out.print("Correo: ");
                    String cor = sc.nextLine();

                    personal nueva = new personal(nom, fec, p, a, dir, tel, cor);
                    listaPersonas.add(nueva);
                    System.out.println("Guardado correctamente.");
                } catch (Exception e) {
                    System.out.println("Error al ingresar los datos. Verifique el formato de la fecha (AAAA-MM-DD) y los numeros.");
                }
            } else if (op == 2) {
                if (listaPersonas.isEmpty()) {
                    System.out.println("No hay datos cargados.");
                } else {
                    for (personal p : listaPersonas) {
                        System.out.println(p);
                    }
                }
            }
        } while (op != 3);

        sc.close();
    }
}