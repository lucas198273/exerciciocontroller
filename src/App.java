import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ClienteController;
import controller.ProdutoController;
import model.Carrinho;
import model.Cupom;
import model.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        Usuario usuario;
        ProdutoController produtoController = new ProdutoController();
        Carrinho carrinho = new Carrinho(produtoController);
        ClienteController clienteController;

        Scanner sc = new Scanner(System.in);
        String nome;
        BigDecimal valorParaCompra;
        List<Cupom> listaCupons = new ArrayList<>();

        System.out.println("Bem vindo ao sistema de compra e venda ");
        System.out.println("Agora iremos fazer seu cadastro");

        System.out.println("\nInsira seu nome de usuário");
        nome = sc.nextLine();

        boolean senhaOk = false;
        String senhaUsuario = null;
        while (!senhaOk) {
            System.out.println("Insira sua senha com pelo menos 8 digitos");
            String senhaString = sc.nextLine();
            if (senhaString.length() >= 8) {
                senhaUsuario = senhaString;
                senhaOk = true;
            } else {
                System.out.println("A senha deve ter pelo menos 8 caracteres.");
            }
        }

        System.out.println("Insira seu valor disponível para compra ");
        valorParaCompra = sc.nextBigDecimal();

        usuario = new Usuario(nome, senhaUsuario, valorParaCompra, listaCupons, carrinho);

        sc.close();
    }
}
