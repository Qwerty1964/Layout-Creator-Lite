package co.benveli.layoutcreator.Activitys.Funs.TDFuns.Clicks

import co.benveli.layoutcreator.Activitys.Funs.TDFuns.tooastTD
import co.benveli.layoutcreator.Activitys.TelaDeDescricao
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.ExcluirDadosDesenhaveis
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.ExcluirDadosEmpacotamento
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.ExcluirLayoutSimplesBancoDeDados
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.ExcluirProdutosDbTNL
import co.benveli.layoutcreator.R

fun TelaDeDescricao.EventoDeClickExcluir(){
    bancoDeDados.ExcluirProdutosDbTNL(nomeSelecionadoSpinner)
    bancoDeDados.ExcluirLayoutSimplesBancoDeDados(nomeSelecionadoSpinner)
    bancoDeDados.ExcluirDadosDesenhaveis("", nomeSelecionadoSpinner, false)
    bancoDeDados.ExcluirDadosEmpacotamento(nomeSelecionadoSpinner)
    tooastTD(getString(R.string.mensagem_multável_t_d_3), "🗑")
    finish()
}