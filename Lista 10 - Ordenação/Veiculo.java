package L10;

public class Veiculo implements Comparable<Veiculo> {

    private int codigo;

    public Veiculo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public int compareTo(Veiculo outro) {

        if (this.codigo > outro.codigo) {
            return 1;
        }

        if (this.codigo < outro.codigo) {
            return -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }
}
