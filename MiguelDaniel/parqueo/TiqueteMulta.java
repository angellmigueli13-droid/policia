/**
 * Actividad 8 - Lógica de Programación II
 * Integrantes: Miguel, Daniel
 * Clase que simula un tiquete de multa de parqueo.
 *
 * Reglas de multa:
 *   - $25.000 por la primera hora (o parte) de parqueo ilegal
 *   - $10.000 por cada hora adicional (o parte) de parqueo ilegal
 */
public class TiqueteMulta {

    private CarroParqueado carro;
    private int minutosIlegales;
    private String nombreOficial;
    private int placaOficial;

    public TiqueteMulta(CarroParqueado carro, int minutosIlegales,
                        String nombreOficial, int placaOficial) {
        this.carro = carro;
        this.minutosIlegales = minutosIlegales;
        this.nombreOficial = nombreOficial;
        this.placaOficial = placaOficial;
    }

    /**
     * Calcula el valor de la multa.
     * Primera hora (o fracción): $25.000
     * Cada hora adicional (o fracción): $10.000
     */
    public double calcularMulta() {
        if (minutosIlegales <= 0) return 0;

        // Calcular horas ilegales (redondeando hacia arriba)
        int horasIlegales = (int) Math.ceil(minutosIlegales / 60.0);

        if (horasIlegales == 1) {
            return 25000;
        } else {
            return 25000 + (horasIlegales - 1) * 10000;
        }
    }

    public double getMulta() { return calcularMulta(); }

    @Override
    public String toString() {
        return "\n========== TIQUETE DE MULTA DE PARQUEO ==========\n" +
               "INFORMACIÓN DEL VEHÍCULO:\n" +
               carro.toString() +
               "\n\nMINUTOS PARQUEADO ILEGALMENTE: " + minutosIlegales +
               "\nVALOR DE LA MULTA: $" + String.format("%,.0f", calcularMulta()) + " pesos" +
               "\n\nOFICIAL QUE EMITE LA MULTA:\n" +
               "Nombre: " + nombreOficial +
               "\nNúmero de placa: " + placaOficial +
               "\n=================================================\n";
    }
}
