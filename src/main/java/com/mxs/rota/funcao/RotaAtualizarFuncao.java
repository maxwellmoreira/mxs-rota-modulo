package com.mxs.rota.funcao;

import com.mxs.rota.conversor.RotaConversor;
import com.mxs.rota.excecao.NaoEncontradoExcecao;
import com.mxs.rota.modelo.RotaModelo;
import com.mxs.rota.repositorio.RotaRepositorio;
import com.mxs.rota.requisicao.RotaControladorAtualizarRequisicao;
import com.mxs.rota.resposta.RotaControladorAtualizarResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mxs.rota.padrao.MensagemPadrao.ROTA_NAO_ENCONTRADA;

/**
 * Classe responsável pelo caso de uso de atualização da entidade Rota.
 */
@Service
public class RotaAtualizarFuncao {

    @Autowired
    private RotaConversor rotaConversor;
    @Autowired
    private RotaRepositorio rotaRepositorio;

    /**
     * Método responsável por atualizar uma Rota.
     *
     * @param rotaControladorAtualizarRequisicao objeto contendo os atributos que podem ser atualizados da Rota
     * @return objeto contendo o código da Rota atualizada
     * @throws NaoEncontradoExcecao lançada quando não for encontrada uma Rota
     */
    public RotaControladorAtualizarResposta atualizarRota(RotaControladorAtualizarRequisicao rotaControladorAtualizarRequisicao) {

        var rotaEncontradaNoBanco =
                this.rotaRepositorio.findByCodigoEquals(rotaControladorAtualizarRequisicao.codigo())
                        .orElseThrow(() -> new NaoEncontradoExcecao(ROTA_NAO_ENCONTRADA));

        var rotaModelo =
                this.rotaConversor.modeloParaControladorAtualizarRequisicao(rotaControladorAtualizarRequisicao, rotaEncontradaNoBanco);

        var codigoRota = this.rotaRepositorio.save(rotaModelo).getCodigo();

        return RotaControladorAtualizarResposta.builder().codigo(codigoRota).build();
    }
}
