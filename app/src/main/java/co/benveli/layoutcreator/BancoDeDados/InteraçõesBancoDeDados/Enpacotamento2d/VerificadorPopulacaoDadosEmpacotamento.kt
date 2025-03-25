package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaDadosOtimizacao
import co.benveli.layoutcreator.BancoDeDados.produtoIdRaiz

fun Db.VerificadorPopulacaoDadosEmpacotamento(idRaiz: String): Boolean {

    val sql = "SELECT * FROM $dBTabelaDadosOtimizacao WHERE $produtoIdRaiz = '$idRaiz'"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    return cursor.count > 0
}