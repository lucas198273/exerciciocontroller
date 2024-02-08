package model;

public class Cupom {

    private int codigo ;
    private int porcentagemDesconto;


    public Cupom(int codigo, int porcentagemDesconto) {
        this.codigo = codigo;
        this.porcentagemDesconto = porcentagemDesconto;
    }


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public int getPorcentagemDesconto() {
        return porcentagemDesconto;
    }


    public void setPorcentagemDesconto(int porcentagemDesconto) {
        this.porcentagemDesconto = porcentagemDesconto;
    }

    
     

    
}
