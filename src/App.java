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
    public static void main(String[] args) throws Exception {
        Usuario usuario = null;
        AdministradorController adm = new AdministradorController();
        Estoque estoque ;
     


        List<Produto> listaParaEstoque = new ArrayList<>();

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

        adm.populandoEstoqueComLista(listaParaEstoque);
        estoque = new Estoque(adm.getMap());
        


        





         
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

        System.out.println("Dados cadastrados :");
        System.out.println(usuario.toString());



        // Rodando ate aqui 

        System.out.println("Iniciado sistema de apresentação de prosutos ");
        clienteController = new ClienteController(usuario);

        System.out.println("Apresentando produtos ");
        System.out.println(produtoController.getEstoque());




        sc.close();
    }
}
