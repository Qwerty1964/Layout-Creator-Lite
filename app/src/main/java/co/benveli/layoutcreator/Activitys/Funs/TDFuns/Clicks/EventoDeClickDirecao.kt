package co.benveli.layoutcreator.Activitys.Funs.TDFuns.Clicks

import co.benveli.layoutcreator.Activitys.Funs.NumeroImparOuPar
import co.benveli.layoutcreator.Activitys.Funs.TDFuns.TradutorCompiladorTelaDeDescrição
import co.benveli.layoutcreator.Activitys.TelaDeDescricao
import co.benveli.layoutcreator.R

fun TelaDeDescricao.EventoDeClickDirecao(){
    controlador1++
    TradutorCompiladorTelaDeDescrição(cont1, cont2, cont3, false)
    if(NumeroImparOuPar(controlador1)){
        elementosActivityTelaDeDescricao.setaDirecaoTelaDescricao.setImageResource(R.drawable.ic_seta_largura_2)
    }else{elementosActivityTelaDeDescricao.setaDirecaoTelaDescricao.setImageResource(R.drawable.ic_seta_comprimento_2)} }