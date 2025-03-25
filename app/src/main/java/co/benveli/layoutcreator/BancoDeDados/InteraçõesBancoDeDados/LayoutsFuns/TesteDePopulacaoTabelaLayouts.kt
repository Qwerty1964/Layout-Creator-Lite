package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaLayout

fun Db.TesteDePopulacaoTabelaLayouts():Boolean{

    val sql = "SELECT * FROM $dBTabelaLayout"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    return cursor.count > 0
}