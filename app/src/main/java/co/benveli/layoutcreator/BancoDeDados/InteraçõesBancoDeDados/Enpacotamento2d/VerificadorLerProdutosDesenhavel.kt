package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabeladesenhavel
import co.benveli.layoutcreator.BancoDeDados.produtoIdRaiz
import co.benveli.layoutcreator.BancoDeDados.produtoNome

fun Db.VerificadorLerProdutos(idRaiz: String): List<String> {

    var listaStrings = mutableListOf<String>()
    val sql = "SELECT $produtoNome FROM $dBTabeladesenhavel WHERE $produtoIdRaiz = '$idRaiz'"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    if (cursor.count > 0) {
        while (cursor.moveToNext()) {
            listaStrings.add(cursor.getString(0))
        };cursor.close()
    }
    return listaStrings

}