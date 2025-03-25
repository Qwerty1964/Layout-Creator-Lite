package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import co.benveli.layoutcreator.Activitys.Funs.NumeroImparOuPar
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.LeiturasimplesBancoDeDadosTecidoComposable
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.verificadorDeSemelhancasTelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.LeituraBancoDeDadosProdutosComposable
import co.benveli.layoutcreator.Epacotamento2d.Chamadores.calcularEmpacotamento1
import co.benveli.layoutcreator.Objetos.Produto

fun TelaNovoLayout.TradutorCompiladorTelaNovoLayout(
    test: Int,
    teste3:Boolean,
    teste4:Boolean,
    teste5:Boolean,
    confirmador: Boolean,
    confirmador2: Boolean,
    confirmador3: Boolean
) {

    val nomeLayoutPai = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString().replace("'", "")
    if (!(bancoDeDados.verificadorDeSemelhancasTelaNovoLayout(nomeLayoutPai))) {

        val produto: MutableList<Produto> =
            bancoDeDados.LeituraBancoDeDadosProdutosComposable(nomeLayoutPai)

        val tecido = bancoDeDados.LeiturasimplesBancoDeDadosTecidoComposable(nomeLayoutPai)

        calcularEmpacotamento1(tecido, produto, false, teste3, teste4, teste5, confirmador,
            confirmador2, multiplicador, soun, confirmador3)
    }
}
