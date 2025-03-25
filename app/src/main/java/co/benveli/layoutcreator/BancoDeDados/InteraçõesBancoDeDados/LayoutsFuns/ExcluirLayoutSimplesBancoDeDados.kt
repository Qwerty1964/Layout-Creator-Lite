package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns

import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaLayout
import co.benveli.layoutcreator.BancoDeDados.layoutNome

fun Db.ExcluirLayoutSimplesBancoDeDados(nomeLayoutPai: String){

    writableDatabase.delete(dBTabelaLayout, "$layoutNome=('$nomeLayoutPai')", null)

}