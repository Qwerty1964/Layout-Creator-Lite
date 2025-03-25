package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.Objetos.ResultadoOrganizacao

fun Db.LeituraExibicaoLayout(idRaiz:String):ResultadoOrganizacao{

    val posicionamento = LerCalculosEmpacotamento(idRaiz)
    val dadosOtimizacao = LerDadosOtimizacao(idRaiz)
    return ResultadoOrganizacao(
        areaInicial = dadosOtimizacao.areaInicial!!.toInt(),
        areaFinal = dadosOtimizacao.areaFinal!!.toInt(),
        aproveitamento = dadosOtimizacao.aproveitamento!!.toString(),
        produtosNaoUtilizados = dadosOtimizacao.produtosNaoUtilizados!!.toInt(),
        posicionamentos = posicionamento
    )
}