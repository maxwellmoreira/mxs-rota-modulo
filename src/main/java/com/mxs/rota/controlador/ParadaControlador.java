package com.mxs.rota.controlador;

import com.mxs.rota.fachada.ParadaFachada;
import com.mxs.rota.requisicao.*;
import com.mxs.rota.resposta.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mxs.rota.padrao.UriPadrao.PARADAS_BASE;
import static com.mxs.rota.padrao.UriPadrao.PARADA_INCLUIR;
import static com.mxs.rota.padrao.UriPadrao.PARADA_BUSCAR_POR_FILTRO;
import static com.mxs.rota.padrao.UriPadrao.PARADA_ATUALIZAR;
import static com.mxs.rota.padrao.UriPadrao.PARADA_EXCLUIR;

/**
 * Classe responsável por representar o controlador de Parada.
 */
@Validated
@Controller
@RequestMapping(value = PARADAS_BASE)
public class ParadaControlador {

    @Autowired
    private ParadaFachada paradaFachada;

    /**
     * Método responsável por criar uma Parada.
     *
     * @param paradaControladorCriarRequisicao objeto contendo os campos de entrada para incluir uma Parada
     * @return objeto contendo o código da Parada incluída
     */
    @PostMapping(PARADA_INCLUIR)
    public ResponseEntity<ParadaControladorCriarResposta> criarParada(
            @Valid @RequestBody ParadaControladorCriarRequisicao paradaControladorCriarRequisicao) {
        var paradaCriada = this.paradaFachada.criarParada(paradaControladorCriarRequisicao);
        return new ResponseEntity<>(paradaCriada, HttpStatus.CREATED);
    }

    /**
     * Método responsável por pesquisar Paradas utilizando filtros.
     *
     * @param paradaControladorObterRequisicao objeto contendo com campos de entrada para pesquisar Paradas
     * @return lista de Paradas encontradas
     */
    @GetMapping(PARADA_BUSCAR_POR_FILTRO)
    public ResponseEntity<List<ParadaControladorObterResposta>> obterParadas(
            @Valid ParadaControladorObterRequisicao paradaControladorObterRequisicao) {
        var paradasEncontradas = this.paradaFachada.obterParadas(paradaControladorObterRequisicao);
        return new ResponseEntity<>(paradasEncontradas, HttpStatus.OK);
    }

    /**
     * Método responsável por atualizar uma Parada.
     *
     * @param codigo identificador da Parada
     * @param paradaControladorAtualizarRequisicao objeto contendo os campos de entrada para atualizar uma Parada
     * @return objeto contendo o código da Parada atualizada
     */
    @PutMapping(PARADA_ATUALIZAR)
    public ResponseEntity<ParadaControladorAtualizarResposta> atualizarParada(
            @NotBlank @PathVariable String codigo,
            @Valid @RequestBody ParadaControladorAtualizarRequisicao paradaControladorAtualizarRequisicao) {
        var paradaAtualizada = this.paradaFachada.atualizarParada(paradaControladorAtualizarRequisicao);
        return new ResponseEntity<>(paradaAtualizada, HttpStatus.OK);
    }

    /**
     * Método responsável por excluir uma Parada.
     *
     * @param codigo identificador da Parada
     * @return objeto contendo o código da Parada excluída
     */
    @DeleteMapping(PARADA_EXCLUIR)
    public ResponseEntity<ParadaControladorExcluirResposta> excluirParada(
            @NotBlank @PathVariable String codigo) {
        ParadaControladorExcluirRequisicao paradaControladorExcluirRequisicao =
                ParadaControladorExcluirRequisicao
                        .builder()
                        .codigo(codigo)
                        .build();
        var paradaExcluida = this.paradaFachada.excluirParada(paradaControladorExcluirRequisicao);
        return new ResponseEntity<>(paradaExcluida, HttpStatus.OK);
    }
}
