package co.benveli.layoutcreator.Activitys.Funs.TDFuns

import co.benveli.layoutcreator.Activitys.Funs.NumeroImparOuPar
import co.benveli.layoutcreator.Activitys.TelaDeDescricao
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.LeiturasimplesBancoDeDadosTecidoComposable
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.LeituraBancoDeDadosProdutosComposable
import co.benveli.layoutcreator.Epacotamento2d.Chamadores.calcularEmpacotamento2
import co.benveli.layoutcreator.Objetos.Produto

fun TelaDeDescricao.TradutorCompiladorTelaDeDescrição(teste1:Boolean, teste2:Boolean, teste3:Boolean, confirmador:Boolean){

    val test2 = if (controlador1 == 0) false else NumeroImparOuPar(controlador1)

    val produto: MutableList<Produto> = bancoDeDados.LeituraBancoDeDadosProdutosComposable(nomeSelecionadoSpinner)
    val tecido = bancoDeDados.LeiturasimplesBancoDeDadosTecidoComposable(nomeSelecionadoSpinner)
    calcularEmpacotamento2(tecido, produto,test2, teste1, teste2, teste3, confirmador)

}