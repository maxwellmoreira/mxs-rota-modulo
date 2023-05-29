package com.mxs.rota.funcao;

import com.mxs.rota.conversor.ParadaConversor;
import com.mxs.rota.excecao.NaoEncontradoExcecao;
import com.mxs.rota.fachada.RotaFachada;
import com.mxs.rota.filtro.ParadaFiltro;
import com.mxs.rota.modelo.ParadaModelo;
import com.mxs.rota.repositorio.ParadaRepositorio;
import com.mxs.rota.requisicao.ParadaControladorObterRequisicao;
import com.mxs.rota.resposta.ParadaControladorObterResposta;
import com.mxs.rota.tipo.StatusParadaTipo;
import com.mxs.rota.tipo.StatusTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mxs.rota.padrao.MensagemPadrao.PARADA_NAO_ENCONTRADA;

/**
 * Classe responsável pelo caso de uso de busca da entidade Parada.
 */
@Service
public class ParadaObterFuncao {

    @Autowired
    private RotaFachada rotaFachada;
    @Autowired
    private ParadaConversor paradaConversor;
    @Autowired
    private ParadaRepositorio paradaRepositorio;

    /**
     * Método responsável por buscar uma lista de Paradas com base em filtros.
     *
     * @param paradaControladorObterRequisicao objeto contendo os filtros de busca
     * @return lista de Paradas encontradas
     */
    public List<ParadaControladorObterResposta> obterParadas(ParadaControladorObterRequisicao paradaControladorObterRequisicao) {

        Specification<ParadaModelo> paradaModeloSpecification = Specification.where(null);

        // CODIGO
        if (paradaControladorObterRequisicao.codigo() != null && !paradaControladorObterRequisicao.codigo().isBlank()) {
            paradaModeloSpecification = paradaModeloSpecification.and(ParadaFiltro.filtrarPorCodigo(paradaControladorObterRequisicao.codigo()));
        }

        // DESCRICAO
        if (paradaControladorObterRequisicao.descricao() != null && !paradaControladorObterRequisicao.descricao().isBlank()) {
            paradaModeloSpecification = paradaModeloSpecification.and(ParadaFiltro.filtrarPorDescricao(paradaControladorObterRequisicao.descricao()));
        }

        // ENDERECO
        if (paradaControladorObterRequisicao.endereco() != null && !paradaControladorObterRequisicao.endereco().isBlank()) {
            paradaModeloSpecification = paradaModeloSpecification.and(ParadaFiltro.filtrarPorEndereco(paradaControladorObterRequisicao.endereco()));
        }

        // LATITUDE
        if (paradaControladorObterRequisicao.latitude() != null && !paradaControladorObterRequisicao.latitude().isBlank()) {
            var latitude = Double.parseDouble(paradaControladorObterRequisicao.latitude());
            paradaModeloSpecification = paradaModeloSpecification.and(ParadaFiltro.filtrarPorLatitude(latitude));
        }

        // LONGITUDE
        if (paradaControladorObterRequisicao.longitude() != null && !paradaControladorObterRequisicao.longitude().isBlank()) {
            var longitude = Double.parseDouble(paradaControladorObterRequisicao.longitude());
            paradaModeloSpecification = paradaModeloSpecification.and(ParadaFiltro.filtrarPorLongitude(longitude));
        }

        // RAIO ENTREGA
        if (paradaControladorObterRequisicao.raioEntrega() != null && !paradaControladorObterRequisicao.raioEntrega().isBlank()) {
            var raioEntrega = Integer.parseInt(paradaControladorObterRequisicao.raioEntrega());
            paradaModeloSpecification = paradaModeloSpecification.and(ParadaFiltro.filtrarPorRaioEntrega(raioEntrega));
        }

        // STATUS PARADA
        if (paradaControladorObterRequisicao.statusParada() != null && !paradaControladorObterRequisicao.statusParada().isBlank()) {
            var statusParada = StatusParadaTipo.valueOf(paradaControladorObterRequisicao.statusParada());
            paradaModeloSpecification = paradaModeloSpecification.and(ParadaFiltro.filtrarPorStatusParada(statusParada));
        }

        // ROTA
        if (paradaControladorObterRequisicao.codigoRota() != null && !paradaControladorObterRequisicao.codigoRota().isBlank()) {
            var rota = this.rotaFachada.obterRotaPorCodigo(paradaControladorObterRequisicao.codigoRota());
            paradaModeloSpecification = paradaModeloSpecification.and(ParadaFiltro.filtrarPorRota(rota));
        }

        // STATUS ATIVO
        paradaModeloSpecification = paradaModeloSpecification.and(ParadaFiltro.filtrarPorStatus(StatusTipo.ATIVO.getCodigo()));

        var paradaModeloLista = this.paradaRepositorio.findAll(paradaModeloSpecification);

        if (paradaModeloLista.isEmpty()) {
            throw new NaoEncontradoExcecao(PARADA_NAO_ENCONTRADA);
        }

        return this.paradaConversor.modeloListaParaControladorObterRespostaLista(paradaModeloLista);
    }
}
