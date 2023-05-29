package com.mxs.rota.funcao;

import com.mxs.rota.conversor.ParadaConversor;
import com.mxs.rota.excecao.NaoEncontradoExcecao;
import com.mxs.rota.repositorio.ParadaRepositorio;
import com.mxs.rota.requisicao.ParadaControladorExcluirRequisicao;
import com.mxs.rota.resposta.ParadaControladorExcluirResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mxs.rota.padrao.MensagemPadrao.PARADA_NAO_ENCONTRADA;

/**
 * Classe responsável pelo caso de uso de exclusão da entidade Parada.
 */
@Service
public class ParadaExcluirFuncao {

    @Autowired
    private ParadaConversor paradaConversor;
    @Autowired
    private ParadaRepositorio paradaRepositorio;

    /**
     * Método responsável por excluir uma Parada.
     * Ocorrerá uma exclusão lógica (status = "I").
     *
     * @param paradaControladorExcluirRequisicao objeto contendo o código da Parada
     * @return objeto contendo o código da parada excluída
     * @throws NaoEncontradoExcecao lançada quando não for encontrada uma Parada
     */
    public ParadaControladorExcluirResposta excluirParada(ParadaControladorExcluirRequisicao paradaControladorExcluirRequisicao) {

        var paradaEncontradaNoBanco =
                this.paradaRepositorio.findByCodigoEquals(paradaControladorExcluirRequisicao.codigo())
                        .orElseThrow(() -> new NaoEncontradoExcecao(PARADA_NAO_ENCONTRADA));

        paradaEncontradaNoBanco.inativarRegistro();

        var codigoParada = this.paradaRepositorio.save(paradaEncontradaNoBanco).getCodigo();

        return ParadaControladorExcluirResposta
                .builder()
                .codigo(codigoParada)
                .build();
    }
}
