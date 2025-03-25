package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.LeituraSImplesBancoDeDadosLayouts
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.LeituraSimplesAlturaLarguraLayouts
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.LeituraSImplesBancoDeDadosProdutos
import co.benveli.layoutcreator.R

fun TelaNovoLayout.AtualizarAlturaLargura(nomeLayout: String) {

    val produtos = bancoDeDados.LeituraSImplesBancoDeDadosProdutos(nomeLayout, true)
    adapterProdutosTelaNovoLayout.AtualizarItems(produtos)

    try {
        val nomelayout = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString()
        val altLargText = bancoDeDados.LeituraSimplesAlturaLarguraLayouts(nomelayout)

        if (altLargText.altura != 0 && altLargText.largura != 0){
            elementosActivityTelaNovoLayout.alturaNovoLayoutCompleto.setText(altLargText.altura.toString())
            elementosActivityTelaNovoLayout.larguraNovoLayoutCompleto.setText(altLargText.largura.toString())
        }
    }catch (e: Exception){}
}