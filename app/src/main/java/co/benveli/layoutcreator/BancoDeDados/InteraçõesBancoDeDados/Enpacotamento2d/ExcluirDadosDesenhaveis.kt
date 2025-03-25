package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabeladesenhavel
import co.benveli.layoutcreator.BancoDeDados.produtoIdRaiz
import co.benveli.layoutcreator.BancoDeDados.produtoNome

fun Db.ExcluirDadosDesenhaveis(nomeProduto: String, nomelayout: String, boolean: Boolean) {

    if (boolean)
        writableDatabase.delete(dBTabeladesenhavel, "$produtoNome=('$nomeProduto')", null)
    else writableDatabase.delete(dBTabeladesenhavel, "$produtoIdRaiz=('$nomelayout')", null)

}