package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.VerificadorPopulacaoCalculoEmpacotamentoSimples
import co.benveli.layoutcreator.CaixaDeDialogos.CaixaDeDialogoMutavelTNL
import co.benveli.layoutcreator.R

fun TelaNovoLayout.atualizarCmoposeSelecionado(boolean: Boolean){

    val nomeLayout = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString().replace("'", "")

    if(bancoDeDados.VerificadorPopulacaoCalculoEmpacotamentoSimples(nomeLayout) && !boolean){
        CaixaDeDialogoMutavelTNL(
            getString(R.string.mensagem_multável_t_n_l_2),
            false, "", "")
    }
}