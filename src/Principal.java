import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Produto> listaDeCompras = new ArrayList<>();

        System.out.println("Definir limite:");
        double limite = sc.nextDouble();
        Produto limiteCartao = new Produto(limite);

        int opcao;
        do {
            System.out.println("Digite o nome do produto:");
            String nome = sc.next();
            System.out.println("Digite o preco do produto:");
            double preco = sc.nextDouble();
            Produto produtos = new Produto(nome, preco);

            if (limiteCartao.comprar(preco)) {
                System.out.println("Adicionada no carrinho");
            } else {
                System.out.println("Saldo do cartão insuficiente!");
                break;
            }

            listaDeCompras.add(produtos);

            System.out.println("Deseja continuar 0 (Não), 1 (Sim):");
            opcao = sc.nextInt();
        } while (opcao == 1);

        listaDeCompras.sort(Comparator.comparing(Produto::getPreco));

        System.out.println("**********************************");
        System.out.println("COMPRAS REALIZADAS:");
        for (Produto saidaProduto : listaDeCompras) {
            System.out.printf("%s - %.1f\n",saidaProduto.getNome(), saidaProduto.getPreco());
        }
        System.out.println("**********************************");
        System.out.println("Saldo do cartão: " + limiteCartao.getLimite());

        sc.close();
    }
}
