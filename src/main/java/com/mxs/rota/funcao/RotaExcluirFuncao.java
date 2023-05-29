package com.mxs.rota.funcao;

import com.mxs.rota.conversor.RotaConversor;
import com.mxs.rota.excecao.NaoEncontradoExcecao;
import com.mxs.rota.repositorio.RotaRepositorio;
import com.mxs.rota.requisicao.RotaControladorExcluirRequisicao;
import com.mxs.rota.resposta.RotaControladorExcluirResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mxs.rota.padrao.MensagemPadrao.ROTA_NAO_ENCONTRADA;

/**
 * Classe responsável pelo caso de uso de exclusão da entidade Rota.
 */
@Service
public class RotaExcluirFuncao {

    @Autowired
    private RotaConversor rotaConversor;
    @Autowired
    private RotaRepositorio rotaRepositorio;

    /**
     * Método responsável por excluir uma Rota.
     * Ocorrerá uma exclusão lógica (status = "I").
     *
     * @param rotaControladorExcluirRequisicao objeto contendo o código da Rota
     * @return objeto contendo o código da Rota excluída
     * @throws NaoEncontradoExcecao lançada quando não for encontrada uma Rota
     */
    public RotaControladorExcluirResposta excluirRota(RotaControladorExcluirRequisicao rotaControladorExcluirRequisicao) {

        var rotaEncontradaNoBanco =
                this.rotaRepositorio.findByCodigoEquals(rotaControladorExcluirRequisicao.codigo())
                        .orElseThrow(() -> new NaoEncontradoExcecao(ROTA_NAO_ENCONTRADA));

        rotaEncontradaNoBanco.inativarRegistro();

        var codigoRota = this.rotaRepositorio.save(rotaEncontradaNoBanco).getCodigo();

        return RotaControladorExcluirResposta
                .builder()
                .codigo(codigoRota)
                .build();
    }
}
