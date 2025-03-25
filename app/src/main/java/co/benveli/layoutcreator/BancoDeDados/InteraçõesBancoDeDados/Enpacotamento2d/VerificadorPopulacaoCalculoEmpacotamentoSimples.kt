package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabeladesenhavel
import co.benveli.layoutcreator.BancoDeDados.produtoIdRaiz

fun Db.VerificadorPopulacaoCalculoEmpacotamentoSimples(idRaiz: String):Boolean {

    val sql = "SELECT * FROM $dBTabeladesenhavel WHERE $produtoIdRaiz = '$idRaiz'"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    return cursor.count > 0

}