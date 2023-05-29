package com.mxs.rota.funcao;

import com.mxs.rota.conversor.RotaConversor;
import com.mxs.rota.excecao.NaoEncontradoExcecao;
import com.mxs.rota.filtro.RotaFiltro;
import com.mxs.rota.modelo.RotaModelo;
import com.mxs.rota.repositorio.RotaRepositorio;
import com.mxs.rota.requisicao.RotaControladorObterRequisicao;
import com.mxs.rota.resposta.RotaControladorObterResposta;
import com.mxs.rota.tipo.StatusRotaTipo;
import com.mxs.rota.tipo.StatusTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.mxs.rota.padrao.MensagemPadrao.ROTA_NAO_ENCONTRADA;

/**
 * Classe responsável pelo caso de uso de listagem da entidade Rota.
 */
@Service
public class RotaObterFuncao {

    @Autowired
    private RotaConversor rotaConversor;
    @Autowired
    private RotaRepositorio rotaRepositorio;

    /**
     * Método responsável por buscar uma lista de Rotas com base em filtros.
     *
     * @param rotaControladorObterRequisicao objeto contendo os filtros de busca
     * @return lista de Rotas encontradas
     */
    public List<RotaControladorObterResposta> obterRotas(RotaControladorObterRequisicao rotaControladorObterRequisicao) {

        Specification<RotaModelo> rotaModeloSpecification = Specification.where(null);

        // CODIGO
        if (rotaControladorObterRequisicao.codigo() != null && !rotaControladorObterRequisicao.codigo().isBlank()) {
            rotaModeloSpecification = rotaModeloSpecification.and(RotaFiltro.filtrarPorCodigo(rotaControladorObterRequisicao.codigo()));
        }

        // DATA
        if (rotaControladorObterRequisicao.data() != null && !rotaControladorObterRequisicao.data().isBlank()) {
            var data = LocalDate.parse(rotaControladorObterRequisicao.data());
            rotaModeloSpecification = rotaModeloSpecification.and(RotaFiltro.filtrarPorData(data));
        }

        // STATUS ROTA
        if (rotaControladorObterRequisicao.statusRota() != null && !rotaControladorObterRequisicao.statusRota().isBlank()) {
            var statusRota = StatusRotaTipo.valueOf(rotaControladorObterRequisicao.statusRota());
            rotaModeloSpecification = rotaModeloSpecification.and(RotaFiltro.filtrarPorStatusRota(statusRota));
        }

        // STATUS ATIVO
        rotaModeloSpecification = rotaModeloSpecification.and(RotaFiltro.filtrarPorStatus(StatusTipo.ATIVO.getCodigo()));

        var rotaModeloLista = this.rotaRepositorio.findAll(rotaModeloSpecification);

        if (rotaModeloLista.isEmpty()) {
            throw new NaoEncontradoExcecao(ROTA_NAO_ENCONTRADA);
        }

        return this.rotaConversor.modeloListaParaControladorObterRespostaLista(rotaModeloLista);
    }
}
