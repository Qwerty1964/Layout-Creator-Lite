package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.Objetos.Objetos
import co.benveli.layoutcreator.BancoDeDados.dBTabelaLayout

fun Db.LeituraSImplesBancoDeDadosLayouts():List<Objetos>{

    val listaLayoutsSimples = mutableListOf<Objetos>()
    val sql = "SELECT * FROM $dBTabelaLayout "
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    if (cursor.count > 0) {
        while (cursor.moveToNext()) {
            val objetos = Objetos(
                objAltura = cursor.getString(0),
                objLargura = cursor.getString(1),
                objNome = cursor.getString(2),
                id = cursor.getInt(3)
            )
            listaLayoutsSimples.add(objetos)
        };cursor.close()
    }
    return listaLayoutsSimples
}