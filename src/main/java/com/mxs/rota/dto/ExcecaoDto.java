package com.mxs.rota.dto;

import com.mxs.rota.tipo.ExcecaoTipo;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

import static com.mxs.rota.padrao.FormatoDataPadrao.FORMATO_PARA_EXCECAO;

@Data
public class ExcecaoDto {

    private String codigo;
    private String mensagem;
    private ExcecaoTipo tipo;
    private String quando;

    public ExcecaoDto() {
        this.codigo = UUID.randomUUID().toString();
        Timestamp agora = new Timestamp(System.currentTimeMillis());
        this.quando = FORMATO_PARA_EXCECAO.format(agora);
    }
}
