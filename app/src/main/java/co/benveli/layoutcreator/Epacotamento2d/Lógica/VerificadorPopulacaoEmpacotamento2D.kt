package co.benveli.layoutcreator.Epacotamento2d.Lógica

import android.content.Context
import co.benveli.layoutcreator.Activitys.Funs.TooastGenerico
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.ExcluirDadosDesenhaveis
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.LeituraExibicaoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.VerificadorLerProdutos
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.VerificadorDeSemelhancasProdutos
import co.benveli.layoutcreator.Objetos.Produto
import co.benveli.layoutcreator.Objetos.ResultadoOrganizacao
import co.benveli.layoutcreator.Objetos.Tecido

fun VerificadorPopulacaoEmpacotamento2D(
    idRaiz: String,
    context: Context,
    produtos: List<Produto>,
    tecido: Tecido,
    confirmador: Boolean, // false
    test1: Boolean,       // test8
    soun: Boolean         // true
): ResultadoOrganizacao {

    val bancoDeDados = Db(context)

    //TooastGenerico(context, "$test1", "")

    return if (test1) {
        if (!soun) {
            gerarCoordenadasAdaptado_2(produtos, tecido, context, confirmador)
        }else{
            gerarCoordenadasAdaptado_1(produtos, tecido, context, confirmador)
        }
    }else{
        try {
            val listNomesTBDesenhavel = bancoDeDados.VerificadorLerProdutos(idRaiz)
            for (i in listNomesTBDesenhavel) {
                if (!(bancoDeDados.VerificadorDeSemelhancasProdutos(i))) {
                    bancoDeDados.ExcluirDadosDesenhaveis(i, "", true)
                }
            }/* Esta é uma verificação de segurança, mas não vejo o motivo de estar aqui.
             Talvez a uns messes ela fosse util. */

            bancoDeDados.LeituraExibicaoLayout(idRaiz)

        } catch (e: Exception) {
            if (!soun) {
                gerarCoordenadasAdaptado_2(produtos, tecido, context, confirmador)
            }else{
                gerarCoordenadasAdaptado_1(produtos, tecido, context, confirmador)
            }
        }
    }
}

