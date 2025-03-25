package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns

import android.content.ContentValues
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaLayout
import co.benveli.layoutcreator.BancoDeDados.layoutAltura
import co.benveli.layoutcreator.BancoDeDados.layoutLargura
import co.benveli.layoutcreator.BancoDeDados.layoutNome
import co.benveli.layoutcreator.Objetos.Tecido

fun Db.ResaveLayoutsDb(objetos: Tecido, layoutNomeTb: String):Boolean{

    val reSave = ContentValues().apply{

        put(layoutAltura, objetos.altura.toString())
        put(layoutLargura, objetos.largura).toString()}

    return writableDatabase.update(dBTabelaLayout, reSave, "$layoutNome = '$layoutNomeTb'", null) != -1


}