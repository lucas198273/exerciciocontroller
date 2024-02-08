package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AdministradorSistema  {

    private Long codigoAcesso ;
    private String nomeCompleto;
    private LocalDateTime horarioDeAcesso ;
    
    public AdministradorSistema(Long codigoAcesso , String nomeCompleto){
            this.codigoAcesso = codigoAcesso;
            this.nomeCompleto = nomeCompleto;
            this.horarioDeAcesso = LocalDateTime.now();
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    
    
}
