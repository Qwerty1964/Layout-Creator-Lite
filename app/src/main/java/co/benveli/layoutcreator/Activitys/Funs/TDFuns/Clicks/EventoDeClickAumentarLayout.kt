package co.benveli.layoutcreator.Activitys.Funs.TDFuns.Clicks

import android.content.Intent
import co.benveli.layoutcreator.Activitys.TelaDeDescricao
import co.benveli.layoutcreator.Activitys.ZomLayout

fun TelaDeDescricao.EventoDeClickAumentarLayout(){
    val cont4 = if(cont1) "false" else "true"
    val cont5 = if(cont2) "false" else "true"
    val cont6 = if(cont3) "false" else "true"

    val intent = Intent(this, ZomLayout::class.java)
    intent.putExtra("cont1", cont4)
    intent.putExtra("cont2", cont5)
    intent.putExtra("cont3", cont6)
    intent.putExtra("nomeDoLayout", nomeSelecionadoSpinner)
    startActivity(intent)
    finish()}