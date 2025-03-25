package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns

import android.database.Cursor
import android.util.Log
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaLayout
import co.benveli.layoutcreator.BancoDeDados.layoutNome

fun Db.verificadorDeSemelhancasTelaNovoLayout(testSemelhanca:String):Boolean{

    val sql = "SELECT * FROM $dBTabelaLayout WHERE $layoutNome = '$testSemelhanca'"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)

    if (cursor.count > 0) {
        return false
    }else{
        return true
    }
}