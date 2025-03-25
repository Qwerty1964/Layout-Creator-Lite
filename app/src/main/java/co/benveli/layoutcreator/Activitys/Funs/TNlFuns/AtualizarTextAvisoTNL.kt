package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.verificadorPopulacaoProdutos
import co.benveli.layoutcreator.R

fun TelaNovoLayout.AtualizarTextAvisoTNL() {
    val nomelayoutText = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString()

    val alturaText = elementosActivityTelaNovoLayout.alturaNovoLayoutCompleto.text.toString()

    val larguraText = elementosActivityTelaNovoLayout.larguraNovoLayoutCompleto.text.toString()

    val test = bancoDeDados.verificadorPopulacaoProdutos(nomelayoutText, false)

    if(nomelayoutText.isBlank() && alturaText.isBlank() && larguraText.isBlank() && !test){
        elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_3))
    }else if(nomelayoutText.isBlank() && alturaText.isBlank() && !test){
        elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_4))
    }else if(nomelayoutText.isBlank() && larguraText.isBlank() && !test) {
        elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_5))
    }else if(alturaText.isBlank() && larguraText.isBlank() && !test){
        elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_6))
    }else if(nomelayoutText.isBlank() && !test){
        elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_7))
    }else if(alturaText.isBlank() && !test){
        elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_8))
    }else if(larguraText.isBlank() && !test){
        elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_9))
    }else if(larguraText.isBlank() && alturaText.isBlank()){
        elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_10))
    }else if(nomelayoutText.isBlank()){
        elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_11))
    }else if(alturaText.isBlank()){
        elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_12))
    }else if(larguraText.isBlank()){
        elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_13))
    }else if(!test){
        //elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_14))
    }else{
        elementosActivityTelaNovoLayout.textAvisoNovoLayout.setText(getString(R.string.mensagem_multável_t_n_l_15))
    }
}