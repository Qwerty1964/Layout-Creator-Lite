package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.Objetos.Objetos
import co.benveli.layoutcreator.BancoDeDados.dBTabelaProdutos
import co.benveli.layoutcreator.BancoDeDados.produtosIdRaiz

fun Db.LeituraSImplesBancoDeDadosProdutos(nomeLayoutPai : String, boolean : Boolean):List<Objetos>{
    val listaProdutosSimples = mutableListOf<Objetos>()
    val sqlString:String
    if (boolean) {
        sqlString = "SELECT * FROM $dBTabelaProdutos WHERE $produtosIdRaiz = '$nomeLayoutPai'"
    }else{
        sqlString = "SELECT * FROM $dBTabelaProdutos"
    }
    val sql = sqlString
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    if (cursor.count > 0) {
        while (cursor.moveToNext()) {
            val objetos = Objetos(
                objAltura = cursor.getString(0),
                objLargura = cursor.getString(1),
                objQuantidade = cursor.getString(2),
                objNome = cursor.getString(3),
                id = cursor.getInt(4),
                idRaiz = cursor.getString(5)
            )
            listaProdutosSimples.add(objetos)
            };cursor.close()
        }
    return listaProdutosSimples
}