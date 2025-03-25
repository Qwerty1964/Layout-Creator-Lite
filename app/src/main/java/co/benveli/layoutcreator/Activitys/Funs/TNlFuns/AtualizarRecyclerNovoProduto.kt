package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import co.benveli.layoutcreator.Activitys.TelaNovoLayout

fun TelaNovoLayout.AtualizarRecyclerNovoProduto (
    nomeLayout: String,
    test2: Int,
    confirmador: Boolean,
    confirmador3: Boolean){

    TradutorCompiladorTelaNovoLayout(test2, cont1, cont2, cont3, confirmador, true, confirmador3)
    AtualizarAlturaLargura(nomeLayout)
}
