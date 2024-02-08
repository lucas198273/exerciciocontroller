package model;

import java.util.ArrayList;
import java.util.List;
import model.Estoque;
import controller.ProdutoController;

public class Carrinho {

    private List<Produto> itensNoCesto;
    private Double somaValorTotalNoCarrinho = 0.0;
    private ProdutoController produtoController;

    public List<Produto> getItensNoCesto() {
        return itensNoCesto;
    }
        public Carrinho(ProdutoController produtoController) {
        this.produtoController = produtoController;
        this.itensNoCesto = new ArrayList<>();

    }
    public void adicionarItemAoCesto(Produto produto) {
        if (produto != null) {
            List <Produto> estoque = produtoController.getEstoque();
            
            if (estoque.contains(produto)) {
                itensNoCesto.add(produto);
            } else {
                throw new IllegalArgumentException("Produto não cadastrado no estoque");
            }
        } else {
            throw new IllegalArgumentException("Produto é nulo");
        }
    }

    public ProdutoController getProdutoController() {
        return produtoController;
    }

    public void somarItensNoCesto() {
        if (!itensNoCesto.isEmpty()) {
            double soma = 0;
            for (Produto produto : itensNoCesto) {
                soma += produto.getValorProduto();
            }
            setSomaValorTotalNoCarrinho(soma);
            // Removido: getSomaValorTotalNoCarrinho();
        }
    }

    public void setSomaValorTotalNoCarrinho(Double somaValorTotalNoCarrinho) {
        this.somaValorTotalNoCarrinho = somaValorTotalNoCarrinho;
    }

    public Double getSomaValorTotalNoCarrinho() {
        return somaValorTotalNoCarrinho;
    }

    // Restante do código...
}
