package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d

import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaDadosOtimizacao
import co.benveli.layoutcreator.BancoDeDados.otimizacaoIdRaiz

fun Db.ExcluirDadosEmpacotamento(nomeLayoutPai: String){
    writableDatabase.delete(dBTabelaDadosOtimizacao, "$otimizacaoIdRaiz=('$nomeLayoutPai')", null)

}