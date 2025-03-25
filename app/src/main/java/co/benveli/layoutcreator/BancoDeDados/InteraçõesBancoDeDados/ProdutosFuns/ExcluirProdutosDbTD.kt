package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns

import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaProdutos

fun Db.ExcluirProdutosDbTD(id: Int) {

    writableDatabase.delete(dBTabelaProdutos, "id=($id)", null)

}