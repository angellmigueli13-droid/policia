/**
 * Actividad 8 - Lógica de Programación II
 * Integrantes: Miguel, Daniel
 *
 * Clase que simula un oficial de policía que inspecciona carros parqueados.
 * Contiene el método main del programa.
 */

import java.util.Scanner;

public class OficialdePolicia {

    private String nombre;
    private int numeroPlaca;
    private CarroParqueado carro;
    private Parquimetro parquimetro;

    public OficialdePolicia(String nombre, int numeroPlaca,
                             CarroParqueado carro, Parquimetro parquimetro) {
        this.nombre = nombre;
        this.numeroPlaca = numeroPlaca;
        this.carro = carro;
        this.parquimetro = parquimetro;
    }

    public String getNombre() { return nombre; }
    public int getNumeroPlaca() { return numeroPlaca; }

    /**
     * Revisa si el tiempo del carro ha expirado y, si es así, emite un tiquete.
     */
    public void revisarCarro() {
        int minutosParqueado = carro.getMinutosParqueado();
        int minutosPagados   = parquimetro.getMinutosPagados();

        if (minutosParqueado > minutosPagados) {
            int minutosIlegales = minutosParqueado - minutosPagados;
            TiqueteMulta tiquete = new TiqueteMulta(carro, minutosIlegales, nombre, numeroPlaca);
            System.out.println(tiquete);
        } else {
            System.out.println("\nEl vehículo con placa " + carro.getPlaca()
                + " NO tiene tiempo de parqueo vencido. No se emite multa.");
        }
    }

    /**
     * Valida que los minutos ingresados sean >= 0 usando un ciclo.
     * Este método es reutilizado para validar tanto los minutos parqueados
     * como los minutos pagados, ahorrando código.
     *
     * @param scanner  objeto Scanner para leer la entrada
     * @param mensaje  texto que se le mostrará al usuario al pedir el dato
     * @return         el valor entero válido (>= 0) ingresado por el usuario
     */
    public static int validarMinutos(Scanner scanner, String mensaje) {
        int minutos = -1;
        while (minutos < 0) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                minutos = scanner.nextInt();
                if (minutos < 0) {
                    System.out.println("  ERROR: Los minutos deben ser mayores o iguales a 0. Intente de nuevo.");
                }
            } else {
                System.out.println("  ERROR: Ingrese un número entero válido.");
                scanner.next(); // descartar entrada inválida
            }
        }
        return minutos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== SISTEMA DE MULTAS DE PARQUEO ==========");

        // Datos del oficial
        System.out.println("\n--- Datos del oficial de policía ---");
        System.out.print("Nombre del oficial: ");
        sc.nextLine();
        String nombreOficial = sc.nextLine();

        System.out.print("Número de placa del oficial: ");
        while (!sc.hasNextInt()) {
            System.out.println("  ERROR: Ingrese un número entero válido.");
            sc.next();
        }
        int placaOficial = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        // Datos del carro
        System.out.println("\n--- Datos del vehículo ---");
        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Color: ");
        String color = sc.nextLine();

        System.out.print("Placa del vehículo: ");
        String placa = sc.nextLine();

        // Validación de minutos con el método reutilizable
        int minutosParqueado = validarMinutos(sc, "Minutos que el carro lleva parqueado: ");
        int minutosPagados   = validarMinutos(sc, "Minutos pagados en el parquímetro: ");

        // Crear objetos
        CarroParqueado carro       = new CarroParqueado(marca, modelo, color, placa, minutosParqueado);
        Parquimetro    parquimetro = new Parquimetro(minutosPagados);
        OficialdePolicia oficial   = new OficialdePolicia(nombreOficial, placaOficial, carro, parquimetro);

        // Revisar y emitir multa si corresponde
        oficial.revisarCarro();

        sc.close();
    }
}
