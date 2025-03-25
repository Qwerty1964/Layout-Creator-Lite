package co.benveli.layoutcreator.Activitys.Funs.TDFuns.Clicks

import android.content.Intent
import co.benveli.layoutcreator.Activitys.TelaDeDescricao
import co.benveli.layoutcreator.Activitys.TelaNovoLayout

fun TelaDeDescricao.EventoDeClickTransicionarTelas(){

    val intent = Intent(this, TelaNovoLayout::class.java)
    intent.putExtra("cont1", "false")
    intent.putExtra("cont2", "false")
    intent.putExtra("cont3", "false")
    intent.putExtra("nomeDoLayout", nomeSelecionadoSpinner)
    startActivity(intent)
    finish() }