package co.benveli.layoutcreator.Epacotamento2d.Lógica

import android.content.Context
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.SalvarCalculoEmpacotamento
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.SalvarDadosOtimizacao
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.VerificadorPopulacaoDadosEmpacotamento
import co.benveli.layoutcreator.Objetos.ResultadoOrganizacao

fun saveDadosEmpacotamento(melhorResultado: ResultadoOrganizacao,
                           confirmador: Boolean, context: Context) {

    val bancoDeDados = Db(context)
    val verificador1 = mutableListOf<Long>()

    var idraiz = ""
    val tIdRaiz = try{
        idraiz = melhorResultado.posicionamentos.first().produto!!.idRaiz
        true }catch (e: Exception){ false }

    if (tIdRaiz) {
        val confirmador2 =
            try {
                bancoDeDados.VerificadorPopulacaoDadosEmpacotamento(idraiz)
            } catch (e: Exception) {
                true
            }
        if(confirmador && !confirmador2 ){
            for (posicionamento in melhorResultado.posicionamentos) {

                val auxiliar = bancoDeDados.SalvarCalculoEmpacotamento(
                    posicionamento.produto!!.nome.toString(),
                    posicionamento.produto.largura,
                    posicionamento.produto.altura,
                    posicionamento.produto.idRaiz,
                    posicionamento.coordenada!!.x,
                    posicionamento.coordenada.y,
                    posicionamento.rotacionado)

                verificador1.add(auxiliar)
            }

            val verificador2 = bancoDeDados.SalvarDadosOtimizacao(
                melhorResultado.areaInicial,
                melhorResultado.areaFinal,
                melhorResultado.aproveitamento,
                melhorResultado.produtosNaoUtilizados,
                idraiz)
            //Toast.makeText(context, "$verificador1, $verificador2", Toast.LENGTH_LONG).show()
        }
    }
}