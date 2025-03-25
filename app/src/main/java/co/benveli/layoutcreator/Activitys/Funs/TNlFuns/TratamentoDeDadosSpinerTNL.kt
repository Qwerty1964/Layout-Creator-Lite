package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.verificadorDeSemelhancasTelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.LeituraSImplesBancoDeDadosProdutos
import co.benveli.layoutcreator.R

fun TelaNovoLayout.TratamentoDeDadosSpinerTNL(): MutableList<String> {

    val listNomesBruto = bancoDeDados.LeituraSImplesBancoDeDadosProdutos("vsf", false)
    val listNomesTratado: MutableList<String> = mutableListOf()
    if(listNomesBruto.isNotEmpty()){
        for(i in listNomesBruto.indices){
            val nomeProduto = listNomesBruto[i].objNome.toString()
            val idRaizProduto = listNomesBruto[i].idRaiz.toString()
            if(bancoDeDados.verificadorDeSemelhancasTelaNovoLayout(idRaizProduto)){
                listNomesTratado.add(
                    getString(R.string.mensagem_multável_t_n_l_19, nomeProduto, idRaizProduto))
            }else listNomesTratado.add("$nomeProduto, $idRaizProduto")}}
    return listNomesTratado}