package co.benveli.layoutcreator.Epacotamento2d.Compose.um

import android.content.Context
import co.benveli.layoutcreator.Activitys.Funs.TooastGenerico
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.LeituraExibicaoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.SalvarCalculoEmpacotamento
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.recalcularDadosOtimizacao
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.SalvarProdutos
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.VerificadorDeSemelhancasProdutos
import co.benveli.layoutcreator.Objetos.Objetos
import co.benveli.layoutcreator.Objetos.Tecido
import co.benveli.layoutcreator.R

fun salvarProdutoZoomLayout(context: Context,
                            textNome: String,
                            textLargura: Int,
                            textAltura: Int,
                            idRaiz: String,
                            tecido: Tecido,
                            quantidade: Int
):Boolean{

    val test2 = try {textNome.toInt() <= 0} catch (e:Exception){false}

    val bancoDeDados = Db(context)
   return if (textLargura <= 0 || textAltura <= 0 || test2 || quantidade <= 0){
       TooastGenerico(context, context.getString(R.string.mensagem_multável_empacotamento_16), "🤨")
       false
   }else{

        if(bancoDeDados.VerificadorDeSemelhancasProdutos(textNome)){
            TooastGenerico(context, context.getString(R.string.mensagem_multável_empacotamento_18), "😔")
            false
        }else{
            val a = bancoDeDados.SalvarProdutos(
                Objetos(
                    textAltura.toString(), textLargura.toString(),
                    textNome, quantidade.toString(), idRaiz = idRaiz
                )
            ) >= 0L

            var soma = 0L
            if (quantidade > 0) {

                for (i in 0..<quantidade){
                    soma += bancoDeDados.SalvarCalculoEmpacotamento(
                        textNome, textLargura, textAltura,
                        idRaiz, (tecido.largura / 2),
                        (tecido.altura), false
                    )
                }
            }

            val b = soma > 0L

            val c = if(a&&b) {
                val posicionamento = bancoDeDados.LeituraExibicaoLayout(idRaiz).posicionamentos
                bancoDeDados.recalcularDadosOtimizacao(idRaiz, posicionamento, context)}else false
            a&&b&&c
        }
    }
}