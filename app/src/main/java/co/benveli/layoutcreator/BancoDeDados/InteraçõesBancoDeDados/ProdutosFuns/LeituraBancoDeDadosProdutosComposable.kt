package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaProdutos
import co.benveli.layoutcreator.BancoDeDados.produtosIdRaiz
import co.benveli.layoutcreator.Objetos.Produto

fun Db.LeituraBancoDeDadosProdutosComposable(nomeLayoutPai:String): MutableList<Produto> {

    val listaProdutosComplexos = mutableListOf<Produto>()
    val sql = "SELECT * FROM $dBTabelaProdutos WHERE $produtosIdRaiz = '$nomeLayoutPai'"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    if (cursor.count > 0) {
        while (cursor.moveToNext()) {
            val produto = Produto(
                altura = cursor.getInt(0),
                largura = cursor.getInt(1),
                quantidade = cursor.getInt(2),
                nome = cursor.getString(3),
                id = cursor.getInt(4),
                idRaiz = cursor.getString(5),
                rotacionado = false
            )
            listaProdutosComplexos.add(produto)
        };cursor.close()
    }

    val returnProdutosComplexosTratados = mutableListOf<Produto>()

    for(i in listaProdutosComplexos) {
        if (i.quantidade!! >= 2) {
            for (k in 0 until i.quantidade) {
                returnProdutosComplexosTratados.add(i)
            }
        }else{
            returnProdutosComplexosTratados.add(i)
        }
    }
    return returnProdutosComplexosTratados

}