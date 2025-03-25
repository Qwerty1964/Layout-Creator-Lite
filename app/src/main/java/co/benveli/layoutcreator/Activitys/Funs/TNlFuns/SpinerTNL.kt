package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import android.R
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.LeituraSImplesBancoDeDadosProdutos
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.verificadorPopulacaoProdutos

fun TelaNovoLayout.SpinerTNL(){

    spinner.adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, TratamentoDeDadosSpinerTNL())

    val nomelayout = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString()
    val reescrever = viewCaixaDialogoNovoProduto.findViewById<ImageView>(co.benveli.layoutcreator.R.id.reescrever_produtos_tnl)
    viewCaixaDialogoNovoProduto.findViewById<View>(co.benveli.layoutcreator.R.id.excluir_caixa_de_dialogo)
    val textOu = viewCaixaDialogoNovoProduto.findViewById<TextView>(co.benveli.layoutcreator.R.id.text_ou)
    if (!(bancoDeDados.verificadorPopulacaoProdutos(nomelayout, true))) {
        textOu.setText(getString(co.benveli.layoutcreator.R.string.mensagem_multável_t_n_l_17))

        reescrever.visibility = INVISIBLE
        val params = reescrever.layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(0, -50, 0, 0)
        reescrever.layoutParams = params

    }else textOu.setText(getString(co.benveli.layoutcreator.R.string.mensagem_multável_t_n_l_18))

    spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            nomeSelecionadoSpiner = bancoDeDados.LeituraSImplesBancoDeDadosProdutos("vsf", false)[position]

        }override fun onNothingSelected(parent: AdapterView<*>?) {}
    }}