package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import android.widget.EditText
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.SalvarProdutos
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.VerificadorDeSemelhancasProdutos
import co.benveli.layoutcreator.Objetos.Objetos
import co.benveli.layoutcreator.R

fun TelaNovoLayout.verificadorSalvarCaixaDeDialogo():Boolean{

    val nome = viewCaixaDialogoNovoProduto.findViewById<EditText>(R.id.nome_caixa_de_dialogo)
    val quantidade = viewCaixaDialogoNovoProduto.findViewById<EditText>(R.id.quantidade_caixa_de_dialogo)
    val altura = viewCaixaDialogoNovoProduto.findViewById<EditText>(R.id.altura_caixa_de_dialogo)
    val largura = viewCaixaDialogoNovoProduto.findViewById<EditText>(R.id.largura_caixa_de_dialogo)

    val a:Boolean; val b:Boolean; val c:Boolean; val d:Boolean; val e:Boolean

    if(nome.text.isBlank()){
        nome.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso_purple);a = false
    }else{nome.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso);a = true}
    if(quantidade.text.isBlank() || quantidade.text.toString().toInt() == 0 || quantidade.text.toString().toInt() > 75){
        quantidade.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso_purple);b = false
    }else{quantidade.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso);b = true}
    if(altura.text.isBlank() || altura.text.toString().toInt() == 0){
        altura.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso_purple);c = false
    }else{altura.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso);c = true}
    if(largura.text.isBlank() || largura.text.toString().toInt() == 0){
        largura.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso_purple); d = false
    }else{largura.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso);d = true}

    val nomeLayout = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString()

    if(nome.text.isNotBlank()){
        if(bancoDeDados.VerificadorDeSemelhancasProdutos(nome.text.toString())){
            tooastTNL(getString(R.string.mensagem_multável_t_n_l_20), "🔍")
            e = false} else e = true }else e = false

    val salvarProdutos: Long

    if(a && b && c && d && e){
        val listCaracteristicas = Objetos(
            objNome = nome.text.toString(),
            objQuantidade = quantidade.text.toString(),
            objAltura = altura.text.toString(),
            objLargura = largura.text.toString(),
            idRaiz = nomeLayout
        )
        salvarProdutos = bancoDeDados.SalvarProdutos(listCaracteristicas)
        if(salvarProdutos != -1L) {
            adapterProdutosTelaNovoLayout.limparItens()
            AtualizarRecyclerNovoProduto(nomeLayout, 0, false, false)

            tooastTNL(getString(R.string.mensagem_multável_t_n_l_21), "👌")
            caixaDialogoNovoProduto.dismiss()
        }
    }else {
        salvarProdutos = -1L }

    if(quantidade.text.toString().toInt() > 75) {
        tooastTNL(getString(R.string.mensagem_multável_t_n_l_22), "🤣")
    }
    return salvarProdutos != -1L
}
