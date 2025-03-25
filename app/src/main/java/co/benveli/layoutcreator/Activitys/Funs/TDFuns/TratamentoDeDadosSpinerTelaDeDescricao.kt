package co.benveli.layoutcreator.Activitys.Funs.TDFuns

import co.benveli.layoutcreator.Activitys.TelaDeDescricao
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.LeituraBancoDeDadosNomesLayouts
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.LeituraSImplesBancoDeDadosLayouts
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.LeituraSImplesBancoDeDadosProdutos

fun TelaDeDescricao.TratamentoDeDadosSpinerTelaDeDescricao(): MutableList<String> {

    val listNomesBruto = bancoDeDados.LeituraSImplesBancoDeDadosLayouts()
    val listNomesTratado: MutableList<String> = mutableListOf()

    if(listNomesBruto.isNotEmpty()){
        for(i in listNomesBruto.indices){
            val nomeLayout = listNomesBruto[i].objNome.toString()
            listNomesTratado.add(nomeLayout)}}
    return listNomesTratado
}