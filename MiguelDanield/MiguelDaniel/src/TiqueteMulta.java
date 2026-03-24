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
     * Primera hora (o fraccion): $25.000
     * Cada hora adicional (o fraccion): $10.000
     */
    public double calcularMulta() {
        if (minutosIlegales <= 0) return 0;
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
               "INFORMACION DEL VEHICULO:\n" +
               carro.toString() +
               "\n\nMINUTOS PARQUEADO ILEGALMENTE: " + minutosIlegales +
               "\nVALOR DE LA MULTA: $" + String.format("%,.0f", calcularMulta()) + " pesos" +
               "\n\nOFICIAL QUE EMITE LA MULTA:\n" +
               "Nombre: " + nombreOficial +
               "\nNumero de placa: " + placaOficial +
               "\n=================================================\n";
    }
}
