public class CarroParqueado {

    private String marca;
    private String modelo;
    private String color;
    private String placa;
    private int minutosParqueado;

    public CarroParqueado(String marca, String modelo, String color, String placa, int minutosParqueado) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.placa = placa;
        this.minutosParqueado = minutosParqueado;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getColor() { return color; }
    public String getPlaca() { return placa; }
    public int getMinutosParqueado() { return minutosParqueado; }

    @Override
    public String toString() {
        return "Marca: " + marca +
               "\nModelo: " + modelo +
               "\nColor: " + color +
               "\nPlaca: " + placa +
               "\nMinutos parqueado: " + minutosParqueado;
    }
}
