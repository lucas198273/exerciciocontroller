package model;

import java.sql.Date;

public class CompraRealizada {
    
    private Date dataDaCompra;
    private Date proazoMaximoDevolucao = null;
    private Produto produto;
    private Double valorDaCompra;


    public CompraRealizada(Date dataDaCompra, Date proazoMaximoDevolucao, Produto produto, Double valorDaCompra) {
        this.dataDaCompra = dataDaCompra;
        this.proazoMaximoDevolucao = proazoMaximoDevolucao;
        this.produto = produto;
        this.valorDaCompra = valorDaCompra;
    }
    
        public CompraRealizada(Date dataDaCompra,Produto produto, Double valorDaCompra) {
        this.dataDaCompra = dataDaCompra;
        this.proazoMaximoDevolucao = null;
        this.produto = produto;
        this.valorDaCompra = valorDaCompra;
    }



        public Date getDataDaCompra() {
            return dataDaCompra;
        }
        public void setDataDaCompra(Date dataDaCompra) {
            this.dataDaCompra = dataDaCompra;
        }
        public Date getProazoMaximoDevolucao() {
            return proazoMaximoDevolucao;
        }
        public void setProazoMaximoDevolucao(Date proazoMaximoDevolucao) {
            this.proazoMaximoDevolucao = proazoMaximoDevolucao;
        }
        public Produto getProduto() {
            return produto;
        }
        public void setProduto(Produto produto) {
            this.produto = produto;
        }
        public Double getValorDaCompra() {
            return valorDaCompra;
        }
        public void setValorDaCompra(Double valorDaCompra) {
            this.valorDaCompra = valorDaCompra;
        }
    

    
}
