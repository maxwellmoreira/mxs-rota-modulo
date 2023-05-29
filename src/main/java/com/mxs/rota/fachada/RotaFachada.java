package com.mxs.rota.fachada;

import com.mxs.rota.excecao.NaoEncontradoExcecao;
import com.mxs.rota.funcao.RotaAtualizarFuncao;
import com.mxs.rota.funcao.RotaExcluirFuncao;
import com.mxs.rota.funcao.RotaIncluirFuncao;
import com.mxs.rota.funcao.RotaObterFuncao;
import com.mxs.rota.modelo.RotaModelo;
import com.mxs.rota.repositorio.RotaRepositorio;
import com.mxs.rota.requisicao.RotaControladorAtualizarRequisicao;
import com.mxs.rota.requisicao.RotaControladorCriarRequisicao;
import com.mxs.rota.requisicao.RotaControladorExcluirRequisicao;
import com.mxs.rota.requisicao.RotaControladorObterRequisicao;
import com.mxs.rota.resposta.RotaControladorAtualizarResposta;
import com.mxs.rota.resposta.RotaControladorCriarResposta;
import com.mxs.rota.resposta.RotaControladorExcluirResposta;
import com.mxs.rota.resposta.RotaControladorObterResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mxs.rota.padrao.MensagemPadrao.ROTA_NAO_ENCONTRADA;

/**
 * Classe responsável por agrupar todos os casos de uso do domínio Rota.
 */
@Service
public class RotaFachada {

    @Autowired
    private RotaIncluirFuncao rotaIncluirFuncao;
    @Autowired
    private RotaObterFuncao rotaObterFuncao;
    @Autowired
    private RotaAtualizarFuncao rotaAtualizarFuncao;
    @Autowired
    private RotaExcluirFuncao rotaExcluirFuncao;
    @Autowired
    private RotaRepositorio rotaRepositorio;

    /**
     * Método responsável por chamar o caso de uso referente à criação de Rota.
     *
     * @param rotaControladorCriarRequisicaoLista lista de Rotas
     * @return lista de códigos das Rotas incluídas
     */
    public List<RotaControladorCriarResposta> criarRotas(List<RotaControladorCriarRequisicao> rotaControladorCriarRequisicaoLista) {
        return rotaControladorCriarRequisicaoLista.stream().map(this::criarRota).collect(Collectors.toList());
    }

    /**
     * Método responsável por chamar o caso de uso referente à criação de Rota.
     *
     * @param rotaControladorCriarRequisicao objeto contendo os atributos da Rota
     * @return objeto contendo o código de identificação da Rota incluída
     */
    public RotaControladorCriarResposta criarRota(RotaControladorCriarRequisicao rotaControladorCriarRequisicao) {
        return this.rotaIncluirFuncao.criarRota(rotaControladorCriarRequisicao);
    }

    /**
     * Método responsável por chamar o caso de uso referente à pesquisa de Rotas.
     *
     * @param rotaControladorObterRequisicao objeto contendo os filtros de busca
     * @return lista de Rotas encontradas
     */
    public List<RotaControladorObterResposta> obterRotas(RotaControladorObterRequisicao rotaControladorObterRequisicao) {
        return this.rotaObterFuncao.obterRotas(rotaControladorObterRequisicao);
    }

    /**
     * Método responsável por pesquisar por uma Rota.
     *
     * @param codigoRota código da Rota
     * @return objeto Rota encontrado
     * @throws NaoEncontradoExcecao lançada quando não for encontrada uma Rota
     */
    public RotaModelo obterRotaPorCodigo(String codigoRota) {
        return this.rotaRepositorio.findByCodigoEquals(codigoRota).orElseThrow(() -> new NaoEncontradoExcecao(ROTA_NAO_ENCONTRADA));
    }

    /**
     * Método responsável por chamar o caso de uso referente à atualização de Rota.
     *
     * @param rotaControladorAtualizarRequisicao objeto contendo os atributos que podem ser atualizados da Rota
     * @return objeto contendo o código da Rota atualizada
     */
    public RotaControladorAtualizarResposta atualizarRota(RotaControladorAtualizarRequisicao rotaControladorAtualizarRequisicao) {
        return this.rotaAtualizarFuncao.atualizarRota(rotaControladorAtualizarRequisicao);
    }

    /**
     * Método responsável por chamar o caso de uso referente à exclusão de Rota.
     *
     * @param rotaControladorExcluirRequisicao objeto contendo o código da Rota
     * @return objeto contendo o código da Rota excluída
     */
    public RotaControladorExcluirResposta excluirRota(RotaControladorExcluirRequisicao rotaControladorExcluirRequisicao) {
        return this.rotaExcluirFuncao.excluirRota(rotaControladorExcluirRequisicao);
    }
}
