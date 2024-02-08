package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Produto;
import model.Tipo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProdutoController {
    public static Map<Integer, Produto> listaProdutos = new HashMap<>();

    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            System.out.println("Produto é nulo");
            return;
        }
        if (listaProdutos.containsValue(produto)) {
            System.out.println("Produto existe no estoque");
        } else {
            listaProdutos.put(produto.getIdProduto(), produto);
            System.out.println("Dados do produto adicionado : " + produto.toString());
        }
    }

    public List<Produto> listaPorTipoDeProduto(Tipo tipo) {
        List<Produto> produtos = new ArrayList<>();
        for (Produto produto : listaProdutos.values()) {
            if (produto.getTipoProduto() == tipo) {
                produtos.add(produto);
            }
        }
        return produtos;
    }

    public List<Produto> filtragemValorMaximo_Minimo(int valorMinimo, int valorMaximo) {
        List<Produto> listaProduto = new ArrayList<>();
        for (Produto produto : listaProdutos.values()) {
            if (produto.getValorProduto() <= valorMaximo && produto.getValorProduto() >= valorMinimo) {
                listaProduto.add(produto);
            }
        }
        return listaProduto;
    }

    public List<Produto> validadeProdutoEntre(Date dataInicial, Date dataFinal) {
        List<Produto> listaTemp = new ArrayList<>();
        for (Produto obj : listaProdutos.values()) {
            Date dataValidade = obj.getValidadeProduto();
            if (dataValidade.after(dataInicial) && dataValidade.before(dataFinal)) {
                listaTemp.add(obj);
            }
        }
        return listaTemp;
    }

    public Produto consultarPorId(int idProdutoDesejado) {
        return listaProdutos.getOrDefault(idProdutoDesejado, null);
    }

   
    public void cadastrarProdutoNoEstoque() {
        Produto novoProduto ;
        novoProduto = new Produto(){};
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o id");
        int idProduto = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha pendente

        System.out.println("Informe o Nome do Produto");
        String nomeProduto = sc.nextLine();

        System.out.println("Informe o tipo do produto ");
        System.out.println("1 para Piercing\n2 para Tatuagem\n3 para Orcamento");
        int scanTipo = sc.nextInt();
        Tipo tipoProduto = null;

        switch (scanTipo) {
            case 1:
                tipoProduto = Tipo.Piercing;
                break;
            case 2:
                tipoProduto = Tipo.Tatuagem;
                break;
            case 3:
                tipoProduto = Tipo.PRESTACAO_DE_SERVICO;
                break;
            default:
                System.out.println("Valor inválido");
                return;
        }

        System.out.println("Informe o valor do produto");
        double valorProduto = sc.nextDouble();

        System.out.println("Informe a data de validade neste formato (dd/MM/yyyy)");
        System.out.println("Caso não exista uma data de validade, pressione Enter");
        sc.nextLine(); // Consumir a quebra de linha pendente
        String scanValidade = sc.nextLine();

        if (scanValidade.isEmpty()) {
            novoProduto.setIdProduto(idProduto);
            novoProduto.setNomeProduto(nomeProduto);
            novoProduto.setTipoProduto(tipoProduto);
            novoProduto.setValorProduto(valorProduto);
        } else {
            try {
                Date dataValidade = sdf.parse(scanValidade);
                novoProduto.setIdProduto(idProduto);
                novoProduto.setNomeProduto(nomeProduto);
                novoProduto.setTipoProduto(tipoProduto);
                novoProduto.setValorProduto(valorProduto);
                novoProduto.setDataValidade(dataValidade);
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Produto não cadastrado.");
                return;
            }
        }

        adicionarProduto(novoProduto);
    }

    
}