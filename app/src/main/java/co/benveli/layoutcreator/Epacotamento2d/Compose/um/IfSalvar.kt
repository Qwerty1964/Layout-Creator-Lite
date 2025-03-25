package co.benveli.layoutcreator.Epacotamento2d.Compose.um

import android.content.Context
import android.content.Intent
import android.util.Log
import android.webkit.WebSettings.ZoomDensity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import co.benveli.layoutcreator.Activitys.Funs.TooastGenerico
import co.benveli.layoutcreator.Activitys.ZomLayout
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.ResaveProdutosCalculoOtimizacao
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.verificadorDeSemelhancasTelaNovoLayout
import co.benveli.layoutcreator.Objetos.CordenadasLivres
import co.benveli.layoutcreator.Objetos.DeslocamentoPosicao
import co.benveli.layoutcreator.Objetos.ResultadoOrganizacao
import co.benveli.layoutcreator.R
import co.benveli.layoutcreator.TelaDeEntrada

@Composable
fun ZomLayout.IfSalvar(modifier: Modifier, rotacionados: Map<Int, Boolean>,
             deslocamentosPosicao: Map<Int, DeslocamentoPosicao>,
             context: Context, multiplicador: Float,
             resultadoEmbutido: ResultadoOrganizacao,
             embutidoOuNao: Boolean
){
    val bancoDeDados = Db(context)

    Text(
        text = stringResource(R.string.mensagem_multável_empacotamento_7),
        fontSize = 27.sp,
        fontFamily = FontFamily(Font(R.font.sugo_display)),
        color = Color.White,
        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
        modifier = modifier
            .size(70.dp)
            .border(7.dp, Color.Black)
            .background(colorResource(id = R.color.azul_2))
            .padding(10.dp)
            .padding(top = 15.dp)
            .clickable {
                val verificadores = mutableListOf<Boolean>()
                for (chave in rotacionados.keys) {
                    verificadores.add(
                        bancoDeDados.ResaveProdutosCalculoOtimizacao(
                            0F, 0F, rotacionados[chave]!!,
                            chave, 0
                        )
                    )
                }

                for (i in mapaSimples) {

                    val a = try{deslocamentosPosicao[i.id]!!.x}catch (_: Exception){0}
                    val b = try{deslocamentosPosicao[i.id]!!.y}catch (_: Exception){0}

                    var x: Float
                    var y: Float
                    if (i.x == 0f && i.y == 0f){
                        x = a.toFloat()
                        y = b.toFloat()
                    }else{
                        x = i.x
                        y = i.y
                    }

                    resultadoEmbutido.posicionamentos
                     if(embutidoOuNao){
                        resultadoEmbutido.posicionamentos.forEach{ posicionamento ->
                            if(posicionamento.produto!!.id == i.id){
                                bancoDeDados.ResaveProdutosCalculoOtimizacao(
                                            posicionamento.coordenada!!.x.toFloat(),
                                            posicionamento.coordenada.y.toFloat(),
                                    false, i.id, 1
                                )
                            }
                        }
                     }else{
                         bancoDeDados.ResaveProdutosCalculoOtimizacao(
                            x/multiplicador, y/multiplicador, false, i.id, 1
                        )
                    }
                }

                val intent = Intent(context, TelaDeEntrada::class.java)
                startActivity(context, intent, null)
            }
    )
}