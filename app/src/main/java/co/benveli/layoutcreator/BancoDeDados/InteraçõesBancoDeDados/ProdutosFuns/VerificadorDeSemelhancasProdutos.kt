package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaProdutos
import co.benveli.layoutcreator.BancoDeDados.produtosNome

fun Db.VerificadorDeSemelhancasProdutos(nomeProduto:String):Boolean{

    val sql = "SELECT $produtosNome FROM $dBTabelaProdutos WHERE $produtosNome = '$nomeProduto'"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    return (cursor.count > 0)
}