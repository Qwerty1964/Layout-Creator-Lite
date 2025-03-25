package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import android.annotation.SuppressLint
import android.content.Intent
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.Activitys.ZomLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.VerificadorPopulacaoCalculoEmpacotamentoSimples
import co.benveli.layoutcreator.CaixaDeDialogos.caixaDialogoNovoProduto
import co.benveli.layoutcreator.R

@SuppressLint("SetTextI18n")
fun TelaNovoLayout.VerificadorTelaNovoLayout(test1:Boolean?, test2:Boolean, test:Boolean): Pair<Boolean, Boolean>{

    val a: Boolean; val b: Boolean; val c: Boolean

    val altura = elementosActivityTelaNovoLayout.alturaNovoLayoutCompleto
    val largura = elementosActivityTelaNovoLayout.larguraNovoLayoutCompleto
    val nomeLayout = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto

    if(altura.text.toString().isBlank() || altura.text.toString().equals("0")){
        a = false; altura.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso_purple)}
    else{altura.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso);a = true}

    if(largura.text.toString().isBlank() || largura.text.toString().equals("0") || largura.text.toString().toInt() >= 250){
        b = false; largura.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso_purple)}
    else{ largura.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso);b = true}

    if(nomeLayout.text.toString().isBlank()){
        nomeLayout.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso_purple)
        c = false
    }else{
        nomeLayout.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso);c = true
        if(test1 != null){
            if(!bancoDeDados.VerificadorPopulacaoCalculoEmpacotamentoSimples(nomeLayout.text.toString())){
                caixaDialogoNovoProduto()
            } else {

                tooastTNL(getString(R.string.mensagem_multável_t_n_l_23),"👌")

                val intent = Intent(this, ZomLayout::class.java)
                val cont4 = if(cont1) "false" else "true"
                val cont5 = if(cont2) "false" else "true"
                val cont6 = if(cont3) "false" else "true"

                intent.putExtra("verificador", "true")
                intent.putExtra("nomeDoLayout", nomeLayout.text.toString())
                intent.putExtra("cont1", cont4)
                intent.putExtra("cont2", cont5)
                intent.putExtra("cont3", cont6)
                startActivity(intent)
            }
        }
    }

    if(test2){
        if(!(altura.text.toString().isBlank() || altura.equals("0"))){
            altura.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso)}
        if(!(largura.text.toString().isBlank() || largura.text.toString().equals("0"))){
            largura.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso)}
        if(nomeLayout.text.toString().isNotBlank()){
            nomeLayout.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso)}
    }

    return if(test){
        Pair(a && b, c)
    }else{
        Pair(a && b && c, c)
    }
}
