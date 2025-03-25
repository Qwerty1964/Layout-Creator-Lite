package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import androidx.core.content.contentValuesOf
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaDadosOtimizacao
import co.benveli.layoutcreator.BancoDeDados.otimizacaoAproveitamento
import co.benveli.layoutcreator.BancoDeDados.otimizacaoAreaFinal
import co.benveli.layoutcreator.BancoDeDados.otimizacaoAreaInicial
import co.benveli.layoutcreator.BancoDeDados.otimizacaoIdRaiz
import co.benveli.layoutcreator.BancoDeDados.otimizacaoProdutosNaoUtilizados

fun Db.SalvarDadosOtimizacao(
    areaInicial: Int,
    areaFinal: Int,
    aproveitamento: String,
    produtosNaoUtilizados: Int,
    idRaiz: String
): Long {
    return writableDatabase.insert(dBTabelaDadosOtimizacao, null, contentValuesOf().apply {
        put(otimizacaoAreaInicial, areaInicial)
        put(otimizacaoAreaFinal, areaFinal)
        put(otimizacaoAproveitamento, aproveitamento)
        put(otimizacaoProdutosNaoUtilizados, produtosNaoUtilizados)
        put(otimizacaoIdRaiz, idRaiz)
    })

}