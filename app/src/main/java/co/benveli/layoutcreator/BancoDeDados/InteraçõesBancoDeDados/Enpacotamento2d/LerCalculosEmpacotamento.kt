package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabeladesenhavel
import co.benveli.layoutcreator.BancoDeDados.produtoIdRaiz
import co.benveli.layoutcreator.Objetos.Coordenada
import co.benveli.layoutcreator.Objetos.Posicionamento
import co.benveli.layoutcreator.Objetos.Produto

fun Db.LerCalculosEmpacotamento(idRaiz: String): List<Posicionamento> {

    var listaPosicionamentos = mutableListOf<Posicionamento>()
    val sql = "SELECT * FROM $dBTabeladesenhavel WHERE $produtoIdRaiz = '$idRaiz'"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    if (cursor.count > 0) {
        while (cursor.moveToNext()) {

            val posicionamentos = Posicionamento(
                produto = Produto(
                    altura = cursor.getInt(0),
                    largura = cursor.getInt(1),
                    nome = cursor.getString(2),
                    id = cursor.getInt(3),
                    idRaiz = cursor.getString(4),
                    rotacionado = cursor.getString(7).toBoolean(),
                ),
                coordenada = Coordenada(
                    x = cursor.getInt(5),
                    y = cursor.getInt(6)
                ),
                rotacionado = cursor.getString(7).toBoolean()
            )
            listaPosicionamentos.add(posicionamentos)
        };cursor.close()
    }
    return listaPosicionamentos

}