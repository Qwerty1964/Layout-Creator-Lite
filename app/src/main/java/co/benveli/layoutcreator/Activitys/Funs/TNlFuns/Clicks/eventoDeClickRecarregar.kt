package co.benveli.layoutcreator.Activitys.Funs.TNlFuns.Clicks

import android.annotation.SuppressLint
import android.view.View
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.AtualizarRecyclerNovoProduto
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.AtualizarTextAvisoTNL
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.VerificadorSalvarLayouts
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.VerificadorTelaNovoLayout
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.alterarAlturaLarguraLayout
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.tooastTNL
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.verificadorDeSemelhancasTelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.LeituraSImplesBancoDeDadosProdutos
import co.benveli.layoutcreator.R

@SuppressLint("SetTextI18n")
fun TelaNovoLayout.eventoDeClickRecarregar(confirmador3: Boolean):Boolean{

    val nomeLayout = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString().replace("'", "")

    val (test, testNome) = VerificadorTelaNovoLayout(test1 = null, test2 = true,false)

    adapterProdutosTelaNovoLayout.limparItens()
    elementosActivityTelaNovoLayout.gifLoad.visibility = View.VISIBLE
    elementosActivityTelaNovoLayout.textAvisoNovoLayout.text =
        getString(R.string.mensagem_multável_t_n_l_27)
    AtualizarTextAvisoTNL()
    if(testNome){
        if(bancoDeDados.verificadorDeSemelhancasTelaNovoLayout(nomeLayout)) {
            if(!VerificadorSalvarLayouts(nomeLayout, test)){
                elementosActivityTelaNovoLayout.gifLoad.visibility = View.INVISIBLE
                tooastTNL(getString(R.string.mensagem_multável_t_n_l_28), "🔎")
            }
        }else{if(test && !confirmador3)alterarAlturaLarguraLayout()}

        adapterProdutosTelaNovoLayout.AtualizarItems(
            bancoDeDados.LeituraSImplesBancoDeDadosProdutos(nomeLayout, true))
        AtualizarRecyclerNovoProduto(nomeLayout, 0, true, confirmador3)

    }else{
        elementosActivityTelaNovoLayout.gifLoad.visibility = View.INVISIBLE
        tooastTNL(getString(R.string.mensagem_multável_t_n_l_29), "🤔")
    }
    return test
}