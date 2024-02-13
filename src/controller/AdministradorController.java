package controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.AdministradorSistema;
import model.Carrinho;
import model.Cupom;
import model.Estoque;
import model.Produto;
import model.Tipo;

import java.util.List;

public class AdministradorController {

    AdministradorSistema adm;
    Estoque estoque = new Estoque();
    ProdutoController controller = new ProdutoController();

    public void populandoEstoqueComLista(List<Produto> listaDeProdutos) {
        List<Produto> lista = listaDeProdutos;
        
        try {
            if (!lista.isEmpty()) {
                for (int i = 0; i < lista.size(); i++) {
                    Produto produto = lista.get(i);
                    controller.estoqueObj.adicionarProduto(produto);;
                }

                System.out.println("Produtos adicionados ao estoque com sucesso");

                for (Produto produto : lista) {
                    System.out.println(produto.toString());
                }
                System.out.println("\n Estoque populado");
            } else {
                System.out.println("A lista de produtos está vazia.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao acessar a lista: índice fora dos limites.");
           
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
     
        }
    }
    public Map<Integer, Produto> getMap(){
        return estoque.getEstoqueMap();
    }


    public AdministradorController(AdministradorSistema adm) {
        this.adm = adm;
    }
    public AdministradorController() {
        //TODO Auto-generated constructor stub
    }


    public void adicionarProdutoEstoque(Produto produto) {
        if (produto == null) {
            System.out.println("Produto é nulo");
            return;
        }
        if (estoque.produtoExistente(produto)) {
            System.out.println("Produto existe no estoque");
        } else {
            estoque.adicionarProduto(produto);
            System.out.println("Dados do produto adicionado : " + produto.toString());
        }
    }
    public List<Produto> listaPorTipoDeProduto(Tipo tipo) {
        List<Produto> produtos = new ArrayList<>();
        for (Produto produto : estoque.getEstoqueList()) {
            if (produto.getTipoProduto() == tipo) {
                produtos.add(produto);
            }
        }
        return produtos;
    }

    public List<Produto> filtragemValorMaximo_Minimo(int valorMinimo, int valorMaximo) {
        List<Produto> listaProduto = new ArrayList<>(estoque.getEstoqueList());
        for (Produto produto : listaProduto) {
            if (produto.getValorProduto() <= valorMaximo && produto.getValorProduto() >= valorMinimo) {
                listaProduto.add(produto);
            }
        }
        return listaProduto;
    }

    public List<Produto> validadeProdutoEntre(Date dataInicial, Date dataFinal) {
        List<Produto> listaTemp = new ArrayList<>();
        for (Produto obj : estoque.getEstoqueList()) {
            Date dataValidade = obj.getValidadeProduto();
            if (dataValidade.after(dataInicial) && dataValidade.before(dataFinal)) {
                listaTemp.add(obj);
            }
        }
        return listaTemp;
    }

    public Produto consultarPorId(int idProdutoDesejado) {
        return estoque.consultarPorId(idProdutoDesejado);
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
        System.out.println("1 para PIERCING\n2 para TATUAGEM\n3 para MATERIAL_DE_TRABALHO, \n4 PRESTACAO DE SERVICO \n5  PRODUTO ESPECIFICO");
        int scanTipo = sc.nextInt();
        Tipo tipoProduto = null;

        switch (scanTipo) {
            case 1:
                tipoProduto = Tipo.PIERCING;
                break;
            case 2:
                tipoProduto = Tipo.TATUAGEM;
                break;
            case 3:
                tipoProduto = Tipo.PRESTACAO_DE_SERVICO;
                break;
            case 4: 
                tipoProduto = Tipo.PRESTACAO_DE_SERVICO;
                break;
            case 5 :
            tipoProduto = Tipo.PRODUTO_ESPECIFICO; 
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

        adicionarProdutoEstoque(novoProduto);
    }
    // Dentro da classe ProdutoController

    public List<Produto> getEstoqueList() {
        return new ArrayList<>(estoque.getEstoqueList());
    }


    

    
    

}
