package co.benveli.layoutcreator.CaixaDeDialogos

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.AtualizarRecyclerNovoProduto
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.TradutorCompiladorTelaNovoLayout
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.tooastTNL
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.ExcluirDadosDesenhaveis
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.ExcluirDadosEmpacotamento
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.ResaveLayoutsDb
import co.benveli.layoutcreator.Objetos.Tecido
import co.benveli.layoutcreator.R
import kotlinx.coroutines.*

fun TelaNovoLayout.CaixaDeDialogoMutavelTNL(text: String, boolean: Boolean?, textLargura: String, textAltura: String){

    val builder = AlertDialog.Builder(this)
    val nomeLayout = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString()

    if (boolean == null) {
        val inflater = LayoutInflater.from(this)
        val dialogView = inflater.inflate(R.layout.toast_simples, null)

        builder.setView(dialogView)
        dialogView.findViewById<TextView>(R.id.msg).text = text
        dialogView.findViewById<TextView>(R.id.emoji).text = "😠"

        val dialog = builder.show()
        CoroutineScope(Dispatchers.Main).launch {
            delay(6000)
            dialog.dismiss()
        }
        builder.setCancelable(true)
    } else{
    builder.setMessage("""
        $text
        $textAltura x $textLargura
    """.trimIndent())
        .setPositiveButton(getString(R.string.mensagem_multável_c_d_l_a_1)) { _, _ ->
                if(boolean){
                    try { if (textLargura.equals("") || textLargura.equals("0") || textAltura.equals("") || textAltura.equals("0")){
                        tooastTNL(getString(R.string.mensagem_multável_c_d_l_a_2), "🧐")
                    }else{
                        val tecido = Tecido(
                            largura = textLargura.toInt(),
                            altura = textAltura.toInt())
                        if(bancoDeDados.ResaveLayoutsDb(tecido, nomeLayout)) tooastTNL(getString(R.string.mensagem_multável_c_d_l_a_3), "👍")
                    }
                        AtualizarRecyclerNovoProduto(nomeLayout, 0, false, false)
                    }catch (e: Exception){}
                }else{
                    bancoDeDados.ExcluirDadosDesenhaveis("", nomeLayout, false)
                    bancoDeDados.ExcluirDadosEmpacotamento(nomeLayout)
                    TradutorCompiladorTelaNovoLayout(0, cont1, cont2, cont3,
                        confirmador = true, confirmador2 = false, false)
                    elementosActivityTelaNovoLayout.composeModeloAntigoNovoLayout.visibility = View.INVISIBLE
                }
                builder.setCancelable(true)
        }.setNegativeButton(getString(R.string.mensagem_multável_c_d_l_a_4)) { _, _ -> builder.setCancelable(true) }
        builder.show()
    }
}