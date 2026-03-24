public class Parquimetro {

    private int minutosPagados;

    public Parquimetro(int minutosPagados) {
        this.minutosPagados = minutosPagados;
    }

    public int getMinutosPagados() { return minutosPagados; }
    public void setMinutosPagados(int minutosPagados) { this.minutosPagados = minutosPagados; }

    @Override
    public String toString() {
        return "Minutos pagados en parquimetro: " + minutosPagados;
    }
}
