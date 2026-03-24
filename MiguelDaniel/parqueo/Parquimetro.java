/**
 * Actividad 8 - Lógica de Programación II
 * Integrantes: Miguel, Daniel
 * Clase que simula un parquímetro.
 */
public class Parquimetro {

    private int minutosPagados;

    public Parquimetro(int minutosPagados) {
        this.minutosPagados = minutosPagados;
    }

    public int getMinutosPagados() { return minutosPagados; }
    public void setMinutosPagados(int minutosPagados) { this.minutosPagados = minutosPagados; }

    @Override
    public String toString() {
        return "Minutos pagados en parquímetro: " + minutosPagados;
    }
}
