package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import androidx.core.content.contentValuesOf
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabeladesenhavel
import co.benveli.layoutcreator.BancoDeDados.produtoAltura
import co.benveli.layoutcreator.BancoDeDados.produtoIdRaiz
import co.benveli.layoutcreator.BancoDeDados.produtoLargura
import co.benveli.layoutcreator.BancoDeDados.produtoNome
import co.benveli.layoutcreator.BancoDeDados.produtoPosicionamentoX
import co.benveli.layoutcreator.BancoDeDados.produtoPosicionamentoY
import co.benveli.layoutcreator.BancoDeDados.produtoRotacionado

fun Db.SalvarCalculoEmpacotamento(
    nomeProduto: String,
    larguraProduto: Int,
    alturaProduto: Int,
    idRaiz: String,
    posicionamentoX: Int,
    posicionamentoY: Int,
    rotacionado: Boolean,
):Long {
    return writableDatabase.insert(dBTabeladesenhavel, null, contentValuesOf().apply {

        put(produtoNome, nomeProduto)
        put(produtoLargura, larguraProduto)
        put(produtoAltura, alturaProduto)
        put(produtoIdRaiz, idRaiz)
        put(produtoPosicionamentoY, posicionamentoY)
        put(produtoPosicionamentoX, posicionamentoX)
        put(produtoRotacionado, rotacionado.toString())
    })
}