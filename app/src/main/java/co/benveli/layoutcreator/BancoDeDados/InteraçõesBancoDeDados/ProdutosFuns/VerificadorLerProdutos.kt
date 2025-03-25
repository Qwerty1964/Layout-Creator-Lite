package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaProdutos
import co.benveli.layoutcreator.BancoDeDados.produtosIdRaiz
import co.benveli.layoutcreator.BancoDeDados.produtosNome

fun Db.VerificadorLerProdutosDesenhavel(idRaiz: String): List<String> {

    var listaStrings = mutableListOf<String>()
    val sql = "SELECT $produtosNome FROM $dBTabelaProdutos WHERE $produtosIdRaiz = '$idRaiz'"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    if (cursor.count > 0) {
        while (cursor.moveToNext()) {
            listaStrings.add(cursor.getString(2))
        };cursor.close()
    }
    return listaStrings

}