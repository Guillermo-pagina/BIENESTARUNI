package principal;

import java.time.LocalDate;

public class personal {
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private double peso;
    private double altura;
    private String direccion;
    private String telefono;
    private String correo;

    public personal(String nombreCompleto, LocalDate fechaNacimiento, double peso, double altura, String direccion, String telefono, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.altura = altura;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public personal() {
    }

    public int calcularEdad() {
        if (fechaNacimiento == null) return 0;
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.getYear() - fechaNacimiento.getYear();
    }

    public boolean esMayorEdad() {
        return calcularEdad() >= 18;
    }

    public double calcularIMC() {
        if (altura <= 0) return 0;
        return peso / (altura * altura);
    }

    public String clasificarIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) return "Bajo peso";
        if (imc < 25.0) return "Normal";
        if (imc < 30.0) return "Sobrepeso";
        return "Obesidad";
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + " | Edad: " + calcularEdad() + " | Nacimiento: " + fechaNacimiento + 
               "  Peso: " + peso + "kg | Altura: " + altura + "m  Tel: " + telefono + 
               "  Correo: " + correo + "  Dir: " + direccion + 
               "  IMC: " + String.format("%.2f", calcularIMC()) + " (" + clasificarIMC() + ")";
    }
}