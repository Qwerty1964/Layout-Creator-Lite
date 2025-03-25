package co.benveli.layoutcreator.Activitys.Funs.TNlFuns.Clicks

import android.content.Intent
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.TestDePopulacaoRecyclerTelaNovoLayout
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.tooastTNL
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.ExcluirDadosDesenhaveis
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.ExcluirLayoutSimplesBancoDeDados
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.verificadorDeSemelhancasTelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.ExcluirProdutosDbTNL
import co.benveli.layoutcreator.R
import co.benveli.layoutcreator.TelaDeEntrada

fun TelaNovoLayout.EventoDeClickExcluir(){
    if(TestDePopulacaoRecyclerTelaNovoLayout()){
        bancoDeDados.ExcluirProdutosDbTNL(elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString()) }
    if (!(bancoDeDados.verificadorDeSemelhancasTelaNovoLayout(elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString()))) {
        bancoDeDados.ExcluirLayoutSimplesBancoDeDados(elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString())
        bancoDeDados.ExcluirDadosDesenhaveis("", elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString(), false) }
    tooastTNL(getString(R.string.mensagem_mutável_t_n_l_36), "🗑")
    finish()
    val intent = Intent(this, TelaDeEntrada::class.java)
    startActivity(intent)}