package com.mxs.rota.funcao;

import com.mxs.rota.conversor.ParadaConversor;
import com.mxs.rota.excecao.NaoEncontradoExcecao;
import com.mxs.rota.fachada.RotaFachada;
import com.mxs.rota.repositorio.ParadaRepositorio;
import com.mxs.rota.requisicao.ParadaControladorAtualizarRequisicao;
import com.mxs.rota.resposta.ParadaControladorAtualizarResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mxs.rota.padrao.MensagemPadrao.PARADA_NAO_ENCONTRADA;

/**
 * Classe responsável pelo caso de uso de atualização da entidade Parada.
 */
@Service
public class ParadaAtualizarFuncao {

    @Autowired
    private RotaFachada rotaFachada;
    @Autowired
    private ParadaConversor paradaConversor;
    @Autowired
    private ParadaRepositorio paradaRepositorio;

    /**
     * Método responsável por atualizar uma Parada.
     *
     * @param paradaControladorAtualizarRequisicao objeto contendo os atributos que podem ser atualizados
     * @return objeto contendo o código da Parada atualizada
     * @throws NaoEncontradoExcecao lançada quando não for encontrada uma Parada
     */
    public ParadaControladorAtualizarResposta atualizarParada(ParadaControladorAtualizarRequisicao paradaControladorAtualizarRequisicao) {

        var paradaEncontradaNoBanco =
                this.paradaRepositorio.findByCodigoEquals(paradaControladorAtualizarRequisicao.codigo())
                        .orElseThrow(() -> new NaoEncontradoExcecao(PARADA_NAO_ENCONTRADA));

        var rotaEncontradaNoBanco =
                this.rotaFachada.obterRotaPorCodigo(
                        paradaControladorAtualizarRequisicao.codigoRota());

        var paradaModelo =
                this.paradaConversor.controladorAtualizarRequisicaoParaModelo(
                        paradaControladorAtualizarRequisicao, paradaEncontradaNoBanco, rotaEncontradaNoBanco);

        var codigoParada = this.paradaRepositorio.save(paradaModelo).getCodigo();

        return ParadaControladorAtualizarResposta
                .builder()
                .codigo(codigoParada)
                .build();
    }
}
