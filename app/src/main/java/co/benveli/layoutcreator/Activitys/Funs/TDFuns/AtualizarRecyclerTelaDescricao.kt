package co.benveli.layoutcreator.Activitys.Funs.TDFuns

import co.benveli.layoutcreator.Activitys.TelaDeDescricao
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.LeituraSImplesBancoDeDadosProdutos

fun TelaDeDescricao.AtualizarRecyclerTelaDeDescricao(nomeLayout: String) {

    try {
        val produtos = bancoDeDados.LeituraSImplesBancoDeDadosProdutos(nomeLayout, true)
        adapterTelaDescricao.AtualizarItems(produtos)
    }catch (e: Exception){}}