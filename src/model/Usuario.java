package model;

import java.math.BigDecimal;
import java.util.List;

public  class Usuario  {

    private String nomeUsuario;
    private  String senhaLogin;
    private BigDecimal valorParaCompra;
    private List<Cupom> cuponsDesconto ;
    private Carrinho carrinho;

 

    public Usuario(String nomeUsuario, String senhaLogin, BigDecimal valorParaCompra, List<Cupom> cuponsDesconto,
            Carrinho carrinho) {
        this.nomeUsuario = nomeUsuario;
        this.senhaLogin = senhaLogin;
        this.valorParaCompra = valorParaCompra;
        this.cuponsDesconto = cuponsDesconto;
        this.carrinho = carrinho;
    }
    public Usuario() {
        //TODO Auto-generated constructor stub
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public String getSenhaLogin() {
        return senhaLogin;
    }
    public void setSenhaLogin(String senhaLogin) {
        this.senhaLogin = senhaLogin;
    }
    public BigDecimal getValorParaCompra() {
        return valorParaCompra;
    }
    public void setValorParaCompra(BigDecimal valorParaCompra) {
        this.valorParaCompra = valorParaCompra;
    }
    public List<Cupom> getCuponsDesconto() {
        return cuponsDesconto;
    }
    public void setCuponsDesconto(List<Cupom> cuponsDesconto) {
        this.cuponsDesconto = cuponsDesconto;
    }
    public Carrinho getCarrinho() {
        return carrinho;
    }
    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
    @Override
    public String toString() {
        return "Usuario " + nomeUsuario + "\n Senha Login " + senhaLogin + "\n Valor Para Compra "
                + valorParaCompra + "        CuponsDesconto=" + cuponsDesconto + " \n Carrinho=" + carrinho.getItensNoCesto() ;
    }


    










    
}
