package co.benveli.layoutcreator.Activitys.Funs.TNlFuns.Clicks

import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.TradutorCompiladorTelaNovoLayout
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.tooastTNL
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.verificadorDeSemelhancasTelaNovoLayout
import co.benveli.layoutcreator.R

fun TelaNovoLayout.ClickSelectTNL(int: Int) {

    val nomeLayout = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString()
    if(!(nomeLayout.isBlank() || bancoDeDados.verificadorDeSemelhancasTelaNovoLayout(nomeLayout))){
        if (int == 1){
            if(cont1) {elementosActivityTelaNovoLayout.alturaView1.setBackgroundResource(R.drawable.ic_eye_1);cont1 =false}
            else{ elementosActivityTelaNovoLayout.alturaView1.setBackgroundResource(R.drawable.ic_eye_2); cont1 = true}
        } else if (int == 2){
            if(cont2) {elementosActivityTelaNovoLayout.larguraView2.setBackgroundResource(R.drawable.ic_eye_1); cont2 =false}
            else{ elementosActivityTelaNovoLayout.larguraView2.setBackgroundResource(R.drawable.ic_eye_2); cont2 = true}
        } else if (int == 3){
            if(cont3) {elementosActivityTelaNovoLayout.nomeView3.setBackgroundResource(R.drawable.ic_eye_1); cont3 =false}
            else{ elementosActivityTelaNovoLayout.nomeView3.setBackgroundResource(R.drawable.ic_eye_2); cont3 = true} }
        TradutorCompiladorTelaNovoLayout(controlador1,cont1, cont2, cont3, false, confirmador2 = true, false)
    }else{if(bancoDeDados.verificadorDeSemelhancasTelaNovoLayout(nomeLayout)){
        tooastTNL(getString(R.string.mensagem_multável_t_n_l_25), "✍️")
    }else {
        tooastTNL(getString(R.string.mensagem_multável_t_n_l_26), "✍️")}}
}