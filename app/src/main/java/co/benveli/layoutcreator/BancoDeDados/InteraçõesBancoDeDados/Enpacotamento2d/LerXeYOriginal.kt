package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabeladesenhavel

fun Db.LerXeYOriginal(iD: Int): Pair<Int, Int> {

    var x = 0; var y = 0
    val sql = "SELECT * FROM $dBTabeladesenhavel WHERE id = $iD"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    if (cursor.count > 0) {
        while (cursor.moveToNext()) {
            x = cursor.getInt(5)
            y = cursor.getInt(6)
        };cursor.close()
    }
    return Pair(x, y)
}