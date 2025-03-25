package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns

import androidx.core.content.contentValuesOf
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.Objetos.Objetos
import co.benveli.layoutcreator.BancoDeDados.dBTabelaProdutos
import co.benveli.layoutcreator.BancoDeDados.produtosAltura
import co.benveli.layoutcreator.BancoDeDados.produtosIdRaiz
import co.benveli.layoutcreator.BancoDeDados.produtosLargura
import co.benveli.layoutcreator.BancoDeDados.produtosNome
import co.benveli.layoutcreator.BancoDeDados.produtosQuantidade

fun Db.SalvarProdutos(listItem: Objetos):Long{

    return writableDatabase.insert(dBTabelaProdutos, null, contentValuesOf().apply {

        put(produtosAltura, listItem.objAltura)
        put(produtosLargura, listItem.objLargura)
        put(produtosQuantidade, listItem.objQuantidade)
        put(produtosNome, listItem.objNome)
        put(produtosIdRaiz, listItem.idRaiz)

    })

}