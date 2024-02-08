package model;

import java.util.Date;

public class Produto {


    private int idProduto;
    private String nomeProduto;
    private int quantidade;
    private Tipo tipoProduto;
    private Date validadeProduto = null;
    /**
     *
     */
    private double valorProduto;


      
    public Produto(int idProduto, String nomeProduto,int quantidade,  Tipo tipoProduto, double valorProduto, Date validadeProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.tipoProduto = tipoProduto;
        this.validadeProduto = validadeProduto;
        this.valorProduto = valorProduto;
    }

    public Produto(int idProduto, String nomeProduto,int quantidade, Tipo tipoProduto,double valor) {
        this(idProduto, nomeProduto, quantidade,tipoProduto,valor, null);
        
    }
  

    public Produto() {
        
    }

    public Date getValidadeProduto() {
        return validadeProduto;
    }

    public void setValidadeProduto(Date validadeProduto) {
        this.validadeProduto = validadeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public Tipo getTipoProduto() {
        return tipoProduto;
    }
    public void setTipoProduto(Tipo tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    public Date getDataValidade() {
        return validadeProduto;
    }
    public void setDataValidade(Date dataValidade) {
        this.validadeProduto = dataValidade;
    }

    @Override
    public String toString() {
        return " Id Produto = " + idProduto + " \n Nome Produto =  " + nomeProduto + "\n Tipo Produto = " + tipoProduto
                + "\n Validade Produto = " + validadeProduto ;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    



    
}
