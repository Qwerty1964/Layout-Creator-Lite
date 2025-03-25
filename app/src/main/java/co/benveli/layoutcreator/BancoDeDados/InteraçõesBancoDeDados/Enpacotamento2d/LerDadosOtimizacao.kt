package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaDadosOtimizacao
import co.benveli.layoutcreator.BancoDeDados.produtoIdRaiz
import co.benveli.layoutcreator.Objetos.DadosOtimizacao

fun Db.LerDadosOtimizacao(idRaiz: String): DadosOtimizacao {

    var dadosOrganizacao = DadosOtimizacao()
    val sql = "SELECT * FROM $dBTabelaDadosOtimizacao WHERE $produtoIdRaiz = '$idRaiz'"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    if (cursor.count > 0) {
        while (cursor.moveToNext()) {

            dadosOrganizacao = DadosOtimizacao(
                areaInicial = cursor.getInt(0),
                areaFinal = cursor.getInt(1),
                aproveitamento = cursor.getString(2),
                produtosNaoUtilizados = cursor.getInt(3)
            )
        };cursor.close()
    }
    return dadosOrganizacao


}