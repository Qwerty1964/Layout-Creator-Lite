package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import android.content.ContentValues
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabeladesenhavel
import co.benveli.layoutcreator.BancoDeDados.produtoPosicionamentoX
import co.benveli.layoutcreator.BancoDeDados.produtoPosicionamentoY
import co.benveli.layoutcreator.BancoDeDados.produtoRotacionado

fun Db.ResaveProdutosCalculoOtimizacao(x: Float, y: Float, rotacionado: Boolean, id: Int, test: Int
):Boolean{

    val reSave = ContentValues().apply{
        if(test == 1) {
            put(produtoPosicionamentoX, x)
            put(produtoPosicionamentoY, y)
        } else {
            put(produtoRotacionado, rotacionado.toString())
        }
    }

    return writableDatabase.update(dBTabeladesenhavel, reSave, "id = $id", null) != -1
}