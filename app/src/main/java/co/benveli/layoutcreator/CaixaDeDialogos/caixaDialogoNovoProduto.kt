package co.benveli.layoutcreator.CaixaDeDialogos

import android.view.View
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.SpinerTNL
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.verificadorSalvarCaixaDeDialogo
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.R

fun TelaNovoLayout.caixaDialogoNovoProduto() {

    buildCaixaDialogoNovoProduto = AlertDialog.Builder(this)
    viewCaixaDialogoNovoProduto =
        layoutInflater.inflate(R.layout.caixa_de_dialogo_add_produtos_2, null)
    buildCaixaDialogoNovoProduto.setView(viewCaixaDialogoNovoProduto)

    spinner = viewCaixaDialogoNovoProduto.findViewById<Spinner>(R.id.spinner_produtos_tnl)

    viewCaixaDialogoNovoProduto.findViewById<View>(R.id.salvar_caixa_de_dialogo)
        .setOnClickListener{ verificadorSalvarCaixaDeDialogo() }

    viewCaixaDialogoNovoProduto.findViewById<View>(R.id.excluir_caixa_de_dialogo)
        .setOnClickListener{ caixaDialogoNovoProduto.dismiss() }

    viewCaixaDialogoNovoProduto.findViewById<View>(R.id.reescrever_produtos_tnl)
        .setOnClickListener{

            val nome = viewCaixaDialogoNovoProduto.findViewById<EditText>(R.id.nome_caixa_de_dialogo)
            val quantidade = viewCaixaDialogoNovoProduto.findViewById<EditText>(R.id.quantidade_caixa_de_dialogo)
            val altura = viewCaixaDialogoNovoProduto.findViewById<EditText>(R.id.altura_caixa_de_dialogo)
            val largura = viewCaixaDialogoNovoProduto.findViewById<EditText>(R.id.largura_caixa_de_dialogo)

            nome.setText(nomeSelecionadoSpiner.objNome); quantidade.setText(nomeSelecionadoSpiner.objQuantidade)
            altura.setText(nomeSelecionadoSpiner.objAltura); largura.setText(nomeSelecionadoSpiner.objLargura)

        }

    SpinerTNL()
    caixaDialogoNovoProduto = buildCaixaDialogoNovoProduto.create()
    caixaDialogoNovoProduto = buildCaixaDialogoNovoProduto.show() }

