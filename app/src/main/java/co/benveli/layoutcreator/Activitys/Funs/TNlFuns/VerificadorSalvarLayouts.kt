package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.SalvarLayouts
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.verificadorDeSemelhancasTelaNovoLayout
import co.benveli.layoutcreator.Objetos.Objetos

fun TelaNovoLayout.VerificadorSalvarLayouts(nomeLayout: String, test: Boolean): Boolean {

    val long:Long
    var retorno = false
    val alturaTecidoLayout = elementosActivityTelaNovoLayout.alturaNovoLayoutCompleto.text.toString()
    val largutaTecidoLayout = elementosActivityTelaNovoLayout.larguraNovoLayoutCompleto.text.toString()
    if( test
        && TestDePopulacaoRecyclerTelaNovoLayout()
        && bancoDeDados.verificadorDeSemelhancasTelaNovoLayout(nomeLayout)) {

        long = bancoDeDados.SalvarLayouts( Objetos(
            objNome = nomeLayout,
            objAltura = alturaTecidoLayout,
            objLargura = largutaTecidoLayout
        ))

        retorno = if(long != -1L) true else false
    }


return retorno}