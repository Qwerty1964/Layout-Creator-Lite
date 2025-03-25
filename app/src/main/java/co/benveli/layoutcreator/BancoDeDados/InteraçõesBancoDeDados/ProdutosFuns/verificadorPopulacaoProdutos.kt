package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns

import android.annotation.SuppressLint
import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaProdutos
import co.benveli.layoutcreator.BancoDeDados.produtosIdRaiz

@SuppressLint("Recycle")
fun Db.verificadorPopulacaoProdutos(nomeLayoutPai: String, boolean: Boolean):Boolean{

    return try {
        if (boolean){
            val sql = "SELECT * FROM $dBTabelaProdutos"
            val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
            cursor.count > 0
        }else{
            val sql = "SELECT * FROM $dBTabelaProdutos WHERE $produtosIdRaiz = '$nomeLayoutPai'"
            val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
            cursor.count > 0
        }
    }catch (_:Exception){
        false
    }
}