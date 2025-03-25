package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.LeituraSimplesAlturaLarguraLayouts
import co.benveli.layoutcreator.CaixaDeDialogos.CaixaDeDialogoMutavelTNL
import co.benveli.layoutcreator.R

fun TelaNovoLayout.alterarAlturaLarguraLayout(){

    val textLargura = elementosActivityTelaNovoLayout.larguraNovoLayoutCompleto.text.toString()
    val textAltura = elementosActivityTelaNovoLayout.alturaNovoLayoutCompleto.text.toString()
    val nomeLayout = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString()

    val alturaLargura = bancoDeDados.LeituraSimplesAlturaLarguraLayouts(nomeLayout)
    val altura = alturaLargura.altura; val largura = alturaLargura.largura
    if(largura != textLargura.toInt() || altura != textAltura.toInt()){
        CaixaDeDialogoMutavelTNL(
            getString(R.string.mensagem_multável_t_n_l_1), true, textLargura, textAltura )
    }
}