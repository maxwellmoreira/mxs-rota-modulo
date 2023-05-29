package com.mxs.rota.controlador;

import com.mxs.rota.fachada.EntregadorFachada;
import com.mxs.rota.requisicao.EntregadorControladorAtualizarRequisicao;
import com.mxs.rota.requisicao.EntregadorControladorCriarRequisicao;
import com.mxs.rota.requisicao.EntregadorControladorExcluirRequisicao;
import com.mxs.rota.requisicao.EntregadorControladorObterRequisicao;
import com.mxs.rota.resposta.EntregadorControladorAtualizarResposta;
import com.mxs.rota.resposta.EntregadorControladorCriarResposta;
import com.mxs.rota.resposta.EntregadorControladorExcluirResposta;
import com.mxs.rota.resposta.EntregadorControladorObterResposta;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mxs.rota.padrao.UriPadrao.*;

/**
 * Classe responsável por representar o controlador de Entregador.
 */
@Validated
@Controller
@RequestMapping(value = ENTREGADOR_BASE)
public class EntregadorControlador {

    @Autowired
    private EntregadorFachada entregadorFachada;

    /**
     * Método responsável por criar um Entregador.
     *
     * @param entregadorControladorCriarRequisicao objeto contendo os campos de entrada para incluir um Entregador
     * @return objeto contendo o código do Entregador incluído
     */
    @PostMapping(ENTREGADOR_INCLUIR)
    public ResponseEntity<EntregadorControladorCriarResposta> criarEntregador(@Valid @RequestBody EntregadorControladorCriarRequisicao entregadorControladorCriarRequisicao) {
        var entregadorIncluido = this.entregadorFachada.criarEntregador(entregadorControladorCriarRequisicao);
        return new ResponseEntity<>(entregadorIncluido, HttpStatus.CREATED);
    }

    /**
     * Método responsável por pesquisar Entregadores utilizando filtros.
     *
     * @param entregadorControladorObterRequisicao objeto contendo campos de entrada para pesquisar Entregadores
     * @return lista de Entregadores encontradas
     */
    @GetMapping(ENTREGADOR_BUSCAR_POR_FILTRO)
    public ResponseEntity<List<EntregadorControladorObterResposta>> obterEntregadores(@Valid EntregadorControladorObterRequisicao entregadorControladorObterRequisicao) {
        var entregadoresEncontrados = this.entregadorFachada.obterEntregador(entregadorControladorObterRequisicao);
        return new ResponseEntity<>(entregadoresEncontrados, HttpStatus.OK);
    }

    /**
     * Método responsável por atualizar um Entregador.
     *
     * @param codigo                                   identificador do Entregador
     * @param entregadorControladorAtualizarRequisicao objeto com campos de entrada para atualizar um Entregador
     * @return objeto contendo código do Entregador atualizado
     */
    @PutMapping(ENTREGADOR_ATUALIZAR)
    public ResponseEntity<EntregadorControladorAtualizarResposta> atualizarEntegador(@NotBlank @PathVariable String codigo,
                                                                                     @Valid @RequestBody EntregadorControladorAtualizarRequisicao entregadorControladorAtualizarRequisicao) {
        var entregadorAtualizado = this.entregadorFachada.atualizarEntregador(entregadorControladorAtualizarRequisicao);
        return new ResponseEntity<>(entregadorAtualizado, HttpStatus.OK);
    }

    /**
     * Método responsável por excluir um Entregador.
     *
     * @param codigo identificador do Entregador
     * @return objeto contendo o código do Entregador excluído
     */
    @DeleteMapping(ENTREGADOR_EXCLUIR)
    public ResponseEntity<EntregadorControladorExcluirResposta> excluirEntregador(@NotBlank @PathVariable String codigo) {
        EntregadorControladorExcluirRequisicao entregadorControladorExcluirRequisicao = EntregadorControladorExcluirRequisicao.builder().codigo(codigo).build();
        var entregadorExcluido = this.entregadorFachada.excluirEntregador(entregadorControladorExcluirRequisicao);
        return new ResponseEntity<>(entregadorExcluido, HttpStatus.OK);
    }
}
