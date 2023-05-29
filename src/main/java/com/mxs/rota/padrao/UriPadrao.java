package com.mxs.rota.padrao;

/**
 * Classe responsável pelas definições de URI na camada controladora.
 */
public class UriPadrao {

    public static final String URI_BASE_V1 = "api/v1/";

    // ------------------------ DEFINIÇÕES DE ROTA ------------------------ //
    public static final String ROTAS_BASE = URI_BASE_V1 + "rotas";
    public static final String ROTA_INCLUIR = "rota";
    public static final String ROTA_BUSCAR_POR_FILTRO = "buscar-por-filtro";
    public static final String ROTA_ATUALIZAR = "rota/{codigo}";
    public static final String ROTA_EXCLUIR = "rota/{codigo}";

    // ------------------------ DEFINIÇÕES DE PARADA ------------------------ //
    public static final String PARADAS_BASE = URI_BASE_V1 + "paradas";
    public static final String PARADA_INCLUIR = "parada";
    public static final String PARADA_BUSCAR_POR_FILTRO = "buscar-por-filtro";
    public static final String PARADA_ATUALIZAR = "parada/{codigo}";
    public static final String PARADA_EXCLUIR = "parada/{codigo}";

    // ------------------------ DEFINIÇÕES DE ENTREGADOR ------------------------ //

    public static final String ENTREGADOR_BASE = URI_BASE_V1 + "entregadores";
    public static final String ENTREGADOR_INCLUIR = "entregador";
    public static final String ENTREGADOR_BUSCAR_POR_FILTRO = "buscar-por-filtro";
    public static final String ENTREGADOR_ATUALIZAR = "entregador/{codigo}";
    public static final String ENTREGADOR_EXCLUIR = "entregador/{codigo}";

    // ------------------------ DEFINIÇÕES DE TRAJETO ------------------------ //

    public static final String TRAJETO_BASE = URI_BASE_V1 + "trajetos";
    public static final String TRAJETO_INCLUIR = "trajeto";
}
