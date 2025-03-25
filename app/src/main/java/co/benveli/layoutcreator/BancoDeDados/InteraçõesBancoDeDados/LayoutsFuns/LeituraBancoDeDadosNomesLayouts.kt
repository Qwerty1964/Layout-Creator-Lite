package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.Objetos.Objeto
import co.benveli.layoutcreator.BancoDeDados.dBTabelaLayout
import co.benveli.layoutcreator.BancoDeDados.layoutNome

fun Db.LeituraBancoDeDadosNomesLayouts():List<Objeto>{

    val listaLayoutsNomes = mutableListOf<Objeto>()
    val sql = "SELECT $layoutNome FROM $dBTabelaLayout"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    if (cursor.count > 0) {
        val collumIndex = cursor.getColumnIndex(layoutNome)
        while (cursor.moveToNext()) {
            val objeto = Objeto(
                nomesLayouts = cursor.getString(collumIndex)
            )
            listaLayoutsNomes.add(objeto)
        };cursor.close()
    }
    return listaLayoutsNomes
}