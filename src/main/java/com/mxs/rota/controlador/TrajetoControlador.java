package com.mxs.rota.controlador;

import com.mxs.rota.fachada.TrajetoFachada;
import com.mxs.rota.requisicao.TrajetoControladorCriarRequisicao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.mxs.rota.padrao.UriPadrao.TRAJETO_BASE;
import static com.mxs.rota.padrao.UriPadrao.TRAJETO_INCLUIR;

/**
 * Classe responsável por representar o controlador de Trajeto.
 */
@Validated
@Controller
@RequestMapping(value = TRAJETO_BASE)
public class TrajetoControlador {

    @Autowired
    private TrajetoFachada trajetoFachada;

    /**
     * Método responsável por criar um Trajeto.
     *
     * @param trajetoControladorCriarRequisicao objeto contendo os campos de entrada para incluir um Trajeto
     * @return status http da operação
     */
    @PostMapping(TRAJETO_INCLUIR)
    public ResponseEntity<HttpStatus> criarTrajeto(@Valid @RequestBody TrajetoControladorCriarRequisicao trajetoControladorCriarRequisicao) {
        this.trajetoFachada.criarTrajeto(trajetoControladorCriarRequisicao);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
