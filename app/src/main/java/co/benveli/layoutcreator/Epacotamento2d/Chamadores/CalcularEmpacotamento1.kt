package co.benveli.layoutcreator.Epacotamento2d.Chamadores

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.tooastTNL
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.VerificadorPopulacaoCalculoEmpacotamentoSimples
import co.benveli.layoutcreator.Epacotamento2d.Compose.dois.VisualizarTecido
import co.benveli.layoutcreator.Epacotamento2d.Lógica.VerificadorPopulacaoEmpacotamento2D
import co.benveli.layoutcreator.Objetos.Produto
import co.benveli.layoutcreator.Objetos.Tecido
import co.benveli.layoutcreator.R
import co.benveli.layoutcreator.TelaDeEntrada


@SuppressLint("SetTextI18n")
fun TelaNovoLayout.calcularEmpacotamento1(
    tecido: Tecido, produtos: List<Produto>, inverterDimensoes: Boolean,
    test1:Boolean, test2:Boolean, test3:Boolean,
    confirmador: Boolean, confirmador2: Boolean, multiplicador: Float,
    soun: Boolean, confirmador3: Boolean) {

    val context = this

    val idRaiz = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString()

    Thread{
        val resultadoEmpacotamento =
            VerificadorPopulacaoEmpacotamento2D(idRaiz, this, produtos, tecido, confirmador, false, soun)

        elementosActivityTelaNovoLayout.textAreaInicialMutavel.text =
            resultadoEmpacotamento.areaInicial.toString() + "m²"
        elementosActivityTelaNovoLayout.textAreaFinalMutavel.text =
            resultadoEmpacotamento.areaFinal.toString() + "m²"
        elementosActivityTelaNovoLayout.pctUtilizadoMutavel.text =
            resultadoEmpacotamento.aproveitamento + "%"
        elementosActivityTelaNovoLayout.naoIseridosMutavel.text =
            resultadoEmpacotamento.produtosNaoUtilizados.toString()

        if (!confirmador3) {
            runOnUiThread {
                elementosActivityTelaNovoLayout.composeSimplesNovoLayout.setContent {
                    VisualizarTecido(
                        tecido, resultadoEmpacotamento,
                        inverterDimensoes, multiplicador,
                        test1, test2, test3, 1f,
                    )
                }
            }
            val resultadoEmpacotamento2 =
                VerificadorPopulacaoEmpacotamento2D(
                    idRaiz,
                    context,
                    produtos,
                    tecido,
                    confirmador,
                    true,
                    soun
                )

            if (bancoDeDados.VerificadorPopulacaoCalculoEmpacotamentoSimples(idRaiz)) {
                val listOrigninais = mutableListOf<Pair<Int?, Int?>>()
                val listMutados = mutableListOf<Pair<Int?, Int?>>()
                val listDiferentes = mutableListOf<Boolean>()

                for (resultado in resultadoEmpacotamento.posicionamentos) {
                    val posicao = resultado.coordenada
                    listOrigninais.add(Pair(posicao!!.x, posicao.y))
                }

                for (resultado2 in resultadoEmpacotamento2.posicionamentos) {
                    val posicao = resultado2.coordenada
                    listMutados.add(Pair(posicao!!.x, posicao.y))
                }

                val tamanhoMinimo = minOf(listOrigninais.size, listMutados.size)
                for (i in 0 until tamanhoMinimo) {
                    if (listOrigninais[i].first != listMutados[i].first || listOrigninais[i].second != listMutados[i].second) {
                        listDiferentes.add(true)
                    }
                }
                if (listDiferentes.size != 0) {
                    runOnUiThread {
                        elementosActivityTelaNovoLayout.textAvisoNovoLayout.text = getString(R.string.mensagem_multável_t_n_l_16)
                        elementosActivityTelaNovoLayout.composeModeloAntigoNovoLayout.setContent {
                            VisualizarTecido(
                                tecido,
                                resultadoEmpacotamento2,
                                inverterDimensoes,
                                multiplicador,
                                test1,
                                test2,
                                test3,
                                1f
                            )
                        }
                    }
                }
            }

            runOnUiThread {
                elementosActivityTelaNovoLayout.gifLoad.visibility = View.INVISIBLE
                tooastTNL(getString(R.string.mensagem_multável_empacotamento_1), "👍")
            }

        }else {

            runOnUiThread {
                tooastTNL(getString(R.string.mensagem_multável_empacotamento_2), "😁 ")

                finish()
                val intent = Intent(this, TelaDeEntrada::class.java)
                startActivity(intent)
            }
        }

    }.start()
}
