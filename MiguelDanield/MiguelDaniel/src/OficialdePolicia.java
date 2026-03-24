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
     * Revisa si el tiempo del carro ha expirado y, si es asi, emite un tiquete.
     */
    public void revisarCarro() {
        int minutosParqueado = carro.getMinutosParqueado();
        int minutosPagados   = parquimetro.getMinutosPagados();

        if (minutosParqueado > minutosPagados) {
            int minutosIlegales = minutosParqueado - minutosPagados;
            TiqueteMulta tiquete = new TiqueteMulta(carro, minutosIlegales, nombre, numeroPlaca);
            System.out.println(tiquete);
        } else {
            System.out.println("\nEl vehiculo con placa " + carro.getPlaca()
                + " NO tiene tiempo de parqueo vencido. No se emite multa.");
        }
    }

    /**
     * Valida que los minutos ingresados sean >= 0 usando un ciclo.
     * Este metodo es reutilizado para validar tanto los minutos parqueados
     * como los minutos pagados, ahorrando codigo.
     *
     * @param scanner  objeto Scanner para leer la entrada
     * @param mensaje  texto que se le mostrara al usuario al pedir el dato
     * @return         el valor entero valido (>= 0) ingresado por el usuario
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
                System.out.println("  ERROR: Ingrese un numero entero valido.");
                scanner.next();
            }
        }
        return minutos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== SISTEMA DE MULTAS DE PARQUEO ==========");

        System.out.println("\n--- Datos del oficial de policia ---");
        System.out.print("Nombre del oficial: ");
        sc.nextLine();
        String nombreOficial = sc.nextLine();

        System.out.print("Numero de placa del oficial: ");
        while (!sc.hasNextInt()) {
            System.out.println("  ERROR: Ingrese un numero entero valido.");
            sc.next();
        }
        int placaOficial = sc.nextInt();
        sc.nextLine();

        System.out.println("\n--- Datos del vehiculo ---");
        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Color: ");
        String color = sc.nextLine();

        System.out.print("Placa del vehiculo: ");
        String placa = sc.nextLine();

        int minutosParqueado = validarMinutos(sc, "Minutos que el carro lleva parqueado: ");
        int minutosPagados   = validarMinutos(sc, "Minutos pagados en el parquimetro: ");

        CarroParqueado carro       = new CarroParqueado(marca, modelo, color, placa, minutosParqueado);
        Parquimetro    parquimetro = new Parquimetro(minutosPagados);
        OficialdePolicia oficial   = new OficialdePolicia(nombreOficial, placaOficial, carro, parquimetro);

        oficial.revisarCarro();

        sc.close();
    }
}
