package co.benveli.layoutcreator.Activitys.Funs.TDFuns

import co.benveli.layoutcreator.Activitys.TelaDeDescricao
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.verificadorDeSemelhancasTelaNovoLayout
import co.benveli.layoutcreator.R

fun TelaDeDescricao.ClickSelectTD(int: Int) {

    if(!(nomeSelecionadoSpinner.isBlank() || bancoDeDados.verificadorDeSemelhancasTelaNovoLayout(nomeSelecionadoSpinner))){
        if (int == 1){
            if(cont1) {elementosActivityTelaDeDescricao.alturaView1.setBackgroundResource(R.drawable.ic_eye_1);cont1 =false}
            else{ elementosActivityTelaDeDescricao.alturaView1.setBackgroundResource(R.drawable.ic_eye_2); cont1 = true}
        } else if (int == 2){
            if(cont2) {elementosActivityTelaDeDescricao.larguraView2.setBackgroundResource(R.drawable.ic_eye_1); cont2 =false}
            else{ elementosActivityTelaDeDescricao.larguraView2.setBackgroundResource(R.drawable.ic_eye_2); cont2 = true}
        } else if (int == 3){
            if(cont3) {elementosActivityTelaDeDescricao.nomeView3.setBackgroundResource(R.drawable.ic_eye_1); cont3 =false}
            else{ elementosActivityTelaDeDescricao.nomeView3.setBackgroundResource(R.drawable.ic_eye_2); cont3 = true}
        }
        TradutorCompiladorTelaDeDescrição(cont1, cont2, cont3, false)
    }
}