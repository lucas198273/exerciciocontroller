package controller;

import java.util.ArrayList;
import java.util.List;

import model.Carrinho;
import model.CompraRealizada;
import model.Produto;
import model.Usuario;

public class ClienteController {

    private Carrinho carrinho;
    private Usuario usuario;
    private List<Produto> itensNoCesto;

    public ClienteController(Usuario usuario) {
        this.usuario = usuario;
        this.carrinho = new Carrinho(new ProdutoController());
        this.itensNoCesto = new ArrayList<>(carrinho.getItensNoCesto());
    }


    
    // Restante do código...


    public void adicionarItemAoCesto(Produto produto) {
        if (produto != null) {
            // Certifique-se de que produtoController está disponível
            List<Produto> estoque = new ArrayList<>(carrinho.getItensNoCesto());
            if (estoque.contains(produto)) {
                itensNoCesto.add(produto);
            } else {
                throw new IllegalArgumentException("Produto não cadastrado no estoque");
            }
        } else {
            throw new IllegalArgumentException("Produto é nulo");
        }
    }


}


