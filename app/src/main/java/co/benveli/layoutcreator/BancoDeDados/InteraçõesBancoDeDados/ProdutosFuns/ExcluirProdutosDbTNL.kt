package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns

import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaProdutos
import co.benveli.layoutcreator.BancoDeDados.produtosIdRaiz

fun Db.ExcluirProdutosDbTNL(idRaiz: String) {
    writableDatabase.delete(dBTabelaProdutos, "$produtosIdRaiz=('$idRaiz')", null)
}