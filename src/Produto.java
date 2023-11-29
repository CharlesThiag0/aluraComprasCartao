public class Produto implements Comparable<Produto> {
    private String nome;
    private double preco;
    private double limite;

    public Produto (double limite) {
        this.limite = limite;
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getLimite() {
        return limite;
    }

    public boolean comprar(double preco) {
        if (limite > preco) {
            limite -= preco;
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Produto produto) {
        return produto.compareTo(produto);
    }
}
