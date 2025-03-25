package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.LeituraSImplesBancoDeDadosProdutos

fun TelaNovoLayout.TestDePopulacaoRecyclerTelaNovoLayout():Boolean {

    val test = bancoDeDados.LeituraSImplesBancoDeDadosProdutos(
     elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString(), true)

    if (test.isEmpty()) {
        return false
    }else{
        return true}}