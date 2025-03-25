package co.benveli.layoutcreator.Epacotamento2d.Chamadores

import android.annotation.SuppressLint
import co.benveli.layoutcreator.Activitys.TelaDeDescricao
import co.benveli.layoutcreator.Epacotamento2d.Compose.dois.VisualizarTecido
import co.benveli.layoutcreator.Epacotamento2d.Lógica.VerificadorPopulacaoEmpacotamento2D
import co.benveli.layoutcreator.Objetos.Produto
import co.benveli.layoutcreator.Objetos.Tecido

@SuppressLint("SetTextI18n")
fun TelaDeDescricao.calcularEmpacotamento2(
    tecido: Tecido, produtos: List<Produto>, inverterDimensoes: Boolean
    , test1:Boolean, test2:Boolean, test3:Boolean, confirmador: Boolean){

    val resultadoEmpacotamento = VerificadorPopulacaoEmpacotamento2D(
        nomeSelecionadoSpinner, this, produtos, tecido, confirmador, false, soun
    )

    elementosActivityTelaDeDescricao.textAreaInicialMutavel.text = resultadoEmpacotamento.areaInicial.toString() + "m²"
    elementosActivityTelaDeDescricao.textAreaFinalMutavel.text = resultadoEmpacotamento.areaFinal.toString() + "m²"
    elementosActivityTelaDeDescricao.pctUtilizadoMutavel.text = resultadoEmpacotamento.aproveitamento + "%"
    elementosActivityTelaDeDescricao.naoIseridosMutavel.text = resultadoEmpacotamento.produtosNaoUtilizados.toString()
    elementosActivityTelaDeDescricao.composeSimplesTelaDescricao.setContent {

        VisualizarTecido(
            tecido, resultadoEmpacotamento, inverterDimensoes,
            1f, test1, test2, test3,
            1f
        )
    }
}