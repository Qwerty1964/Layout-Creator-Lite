package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import co.benveli.layoutcreator.Activitys.TelaNovoLayout

fun TelaNovoLayout.TransicionarTelasTNL(){

    try {
        val nomeLayoutPai = intent.getStringExtra("nomeDoLayout").toString()
        elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.setText(nomeLayoutPai)
        AtualizarRecyclerNovoProduto(intent.getStringExtra("nomeDoLayout").toString(), 0, false, false)
        intent.getStringExtra("cont1").toBoolean()
        intent.getStringExtra("cont2").toBoolean()
        intent.getStringExtra("cont3").toBoolean()

    }catch (e: Exception){}

}