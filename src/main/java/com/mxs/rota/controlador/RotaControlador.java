package com.mxs.rota.controlador;

import com.mxs.rota.fachada.RotaFachada;
import com.mxs.rota.requisicao.RotaControladorAtualizarRequisicao;
import com.mxs.rota.requisicao.RotaControladorCriarRequisicao;
import com.mxs.rota.requisicao.RotaControladorExcluirRequisicao;
import com.mxs.rota.requisicao.RotaControladorObterRequisicao;
import com.mxs.rota.resposta.RotaControladorAtualizarResposta;
import com.mxs.rota.resposta.RotaControladorCriarResposta;
import com.mxs.rota.resposta.RotaControladorExcluirResposta;
import com.mxs.rota.resposta.RotaControladorObterResposta;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mxs.rota.padrao.UriPadrao.ROTAS_BASE;
import static com.mxs.rota.padrao.UriPadrao.ROTA_INCLUIR;
import static com.mxs.rota.padrao.UriPadrao.ROTA_BUSCAR_POR_FILTRO;
import static com.mxs.rota.padrao.UriPadrao.ROTA_ATUALIZAR;
import static com.mxs.rota.padrao.UriPadrao.ROTA_EXCLUIR;

/**
 * Classe responsável por representar o controlador de Rota.
 */
@Validated
@Controller
@RequestMapping(value = ROTAS_BASE)
public class RotaControlador {

    @Autowired
    private RotaFachada rotaFachada;

    /**
     * Método responsável por criar uma Rota.
     *
     * @param rotaControladorCriarRequisicao objeto contendo os campos de entrada para incluir uma Rota
     * @return objeto contendo o código da Rota incluída
     */
    @PostMapping(ROTA_INCLUIR)
    public ResponseEntity<RotaControladorCriarResposta> criarRota(
            @Valid @RequestBody RotaControladorCriarRequisicao rotaControladorCriarRequisicao) {
        var rotaIncluida = this.rotaFachada.criarRota(rotaControladorCriarRequisicao);
        return new ResponseEntity<>(rotaIncluida, HttpStatus.CREATED);
    }

    /**
     * Método responsável por pesquisar Rotas utilizando filtros.
     *
     * @param rotaControladorObterRequisicao objeto contendo com campos de entrada para pesquisar Rotas
     * @return lista de Rotas encontradas
     */
    @GetMapping(ROTA_BUSCAR_POR_FILTRO)
    public ResponseEntity<List<RotaControladorObterResposta>> obterRotas(
            @Valid RotaControladorObterRequisicao rotaControladorObterRequisicao) {
        var rotasEncontradas = this.rotaFachada.obterRotas(rotaControladorObterRequisicao);
        return new ResponseEntity<>(rotasEncontradas, HttpStatus.OK);
    }

    /**
     * Método responsável por atualizar uma Rota.
     *
     * @param codigo identificador da Rota
     * @param rotaControladorAtualizarRequisicao objeto com campos de entrada para atualizar uma Rota
     * @return objeto contendo o código da Rota atualizada
     */
    @PutMapping(ROTA_ATUALIZAR)
    public ResponseEntity<RotaControladorAtualizarResposta> atualizarRota(
            @NotBlank @PathVariable String codigo,
            @Valid @RequestBody RotaControladorAtualizarRequisicao rotaControladorAtualizarRequisicao) {
        var rotaAtualizada = this.rotaFachada.atualizarRota(rotaControladorAtualizarRequisicao);
        return new ResponseEntity<>(rotaAtualizada, HttpStatus.OK);
    }

    /**
     * Método responsável por excluir uma Rota.
     *
     * @param codigo identificador da Rota
     * @return objeto contendo o código da Rota excluída
     */
    @DeleteMapping(ROTA_EXCLUIR)
    public ResponseEntity<RotaControladorExcluirResposta> excluirRota(
            @NotBlank @PathVariable String codigo) {
        RotaControladorExcluirRequisicao rotaControladorExcluirRequisicao =
                RotaControladorExcluirRequisicao
                        .builder()
                        .codigo(codigo)
                        .build();
        var rotaExcluida = this.rotaFachada.excluirRota(rotaControladorExcluirRequisicao);
        return new ResponseEntity<>(rotaExcluida, HttpStatus.OK);
    }
}
