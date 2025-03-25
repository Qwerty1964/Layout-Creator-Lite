package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import android.content.ContentValues
import android.content.Context
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaDadosOtimizacao
import co.benveli.layoutcreator.BancoDeDados.otimizacaoAreaFinal
import co.benveli.layoutcreator.BancoDeDados.otimizacaoIdRaiz
import co.benveli.layoutcreator.Epacotamento2d.Lógica.calcularAreaUtilizada
import co.benveli.layoutcreator.Objetos.Posicionamento

fun Db.recalcularDadosOtimizacao(idRaiz: String, posicionamentos: List<Posicionamento>, context: Context): Boolean{

    val reSave = ContentValues().apply{put(otimizacaoAreaFinal, calcularAreaUtilizada(posicionamentos).toString())}

    return writableDatabase.update(dBTabelaDadosOtimizacao, reSave, "$otimizacaoIdRaiz = '$idRaiz'", null) != -1
}