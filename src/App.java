import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.AdministradorController;
import controller.ClienteController;
import controller.ProdutoController;
import model.Carrinho;
import model.Cupom;
import model.Estoque;
import model.Produto;
import model.Tipo;
import model.Usuario;

public class App {
    private static final int SENHA_MINIMA_CARACTERES = 8;
    private static final int QUANTIDADE_PRODUTOS_PARA_ESTOQUE = 10;
    public static void main(String[] args) {
        Usuario usuario = null;
        AdministradorController adm = new AdministradorController();
        Estoque estoque;
        List<Produto> listaParaEstoque = criarListaProdutos();

        adm.populandoEstoqueComLista(listaParaEstoque);
        

        ProdutoController produtoController = new ProdutoController();
        Carrinho carrinho = new Carrinho(produtoController);
        ClienteController clienteController;

        Scanner sc = new Scanner(System.in);

        usuario = cadastrarUsuario(sc, carrinho,usuario);

        System.out.println("Dados cadastrados:");
        System.out.println(usuario);

        System.out.println("Iniciado sistema de apresentação de produtos ");
        clienteController = new ClienteController(usuario);

        System.out.println("Apresentando produtos ");
        System.out.println(adm.getMap());

        sc.close();
    }

    private static List<Produto> criarListaProdutos() {
        List<Produto> listaParaEstoque = new ArrayList<>();
        // Adicione os produtos à listaParaEstoque aqu
        Produto p1 = new Produto(1, "AGULHA 7RL", 5, Tipo.MATERIAL_DE_TRABALHO, 100);
        Produto p2 = new Produto(2, "TINTA PRETA 30ml", 20, Tipo.MATERIAL_DE_TRABALHO, 50);
        Produto p3 = new Produto(3, "CONSULTA DE TATUAGEM", 50, Tipo.PRESTACAO_DE_SERVICO, 0);
        Produto p4 = new Produto(4, "PIERCING DE AÇO CIRÚRGICO", 10, Tipo.PIERCING, 200);
        Produto p5 = new Produto(5, "AGULHA 5M1", 6, Tipo.MATERIAL_DE_TRABALHO, 80);
        Produto p6 = new Produto(6, "SESSÃO DE TATUAGEM COLORIDA", 150, Tipo.PRESTACAO_DE_SERVICO, 0);
        Produto p7 = new Produto(7, "LOÇÃO PÓS-TATUAGEM", 15, Tipo.MATERIAL_DE_TRABALHO, 30);
        Produto p8 = new Produto(8, "TINTA COLORIDA 30ml", 25, Tipo.MATERIAL_DE_TRABALHO, 40);
        Produto p9 = new Produto(9, "SESSÃO DE RETOQUE", 30, Tipo.PRESTACAO_DE_SERVICO, 0);
        Produto p10 = new Produto(10, "PIERCING DE NARIZ", 8, Tipo.PIERCING, 150);
        listaParaEstoque.add(p1);
        listaParaEstoque.add(p2);
        listaParaEstoque.add(p3);
        listaParaEstoque.add(p4);
        listaParaEstoque.add(p5);
        listaParaEstoque.add(p6);
        listaParaEstoque.add(p7);
        listaParaEstoque.add(p8);
        listaParaEstoque.add(p9);
        listaParaEstoque.add(p10);


        return listaParaEstoque;
    }

    private static Usuario cadastrarUsuario(Scanner sc, Carrinho carrinho,Usuario usuario) {
        String nome = obterEntradaString(sc, "Insira seu nome de usuário");
        String senhaUsuario = obterSenha(sc);
        BigDecimal valorParaCompra = obterEntradaBigDecimal(sc, "Insira seu valor disponível para compra");
        List<Cupom> listaCupons = new ArrayList<>();
        usuario = new Usuario(nome, senhaUsuario, valorParaCompra, listaCupons, carrinho);
        System.out.println("Dados cadastrados:");
        System.out.println(usuario);
        return usuario;
    }

    private static String obterSenha(Scanner sc) {
        String senhaUsuario = null;
        while (senhaUsuario == null || senhaUsuario.length() < SENHA_MINIMA_CARACTERES) {
            System.out.println("Insira sua senha com pelo menos 8 digitos");
            senhaUsuario = sc.nextLine();
            if (senhaUsuario.length() < SENHA_MINIMA_CARACTERES) {
                System.out.println("A senha deve ter pelo menos 8 caracteres.");
            }
        }
        return senhaUsuario;
    }
    private static String obterEntradaString(Scanner sc, String mensagem) {
        System.out.println(mensagem);
        return sc.nextLine();
    }
    private static BigDecimal obterEntradaBigDecimal(Scanner sc, String mensagem) {
        System.out.println(mensagem);
        return sc.nextBigDecimal();
    }
}
