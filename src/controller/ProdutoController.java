package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Estoque;
import model.Produto;
import model.Tipo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProdutoController {
  
    Estoque estoqueObj = new Estoque();
    Map<Integer,Produto> listaProdutos = estoqueObj.getEstoqueMap();
    List<Produto> list = estoqueObj.getEstoqueList();
    
    public List<Produto> getEstoque (){
        return list;
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

   



    
}