package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Estoque {
    
    private  Map<Integer, Produto> estoqueMap = new HashMap<>();

    public Estoque(Map<Integer,Produto> estoque ){
        setEstoqueMap(estoque);
    }
    public Estoque(){}
    
    public Map<Integer, Produto> getEstoqueMap() {
        return estoqueMap;
    }
    public void adicionarProduto(Produto produto){
        estoqueMap.put(produto.getIdProduto(), produto);
    }
    public List<Produto> getEstoqueList() {
        return new ArrayList<>(estoqueMap.values());
    }
    public boolean produtoExistente(Produto produto) {
        boolean produtoExistente = estoqueMap.containsKey(produto.getIdProduto());
    
        if (!produtoExistente) {
            System.out.println("Produto não cadastrado no estoque");
        }
        return produtoExistente;
    }
    public Produto consultarPorId(Integer id){
        Produto produto = estoqueMap.get(id);
        return produto;
    }

    public  void setEstoqueMap(Map<Integer, Produto> estoqueMap) {
        this.estoqueMap = estoqueMap;
    }
    



}
