package co.benveli.layoutcreator.Epacotamento2d.Compose.um

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.benveli.layoutcreator.Activitys.Funs.TooastGenerico
import co.benveli.layoutcreator.Activitys.ZomLayout
import co.benveli.layoutcreator.Objetos.DeslocamentoPosicao
import co.benveli.layoutcreator.Objetos.Posicionamento

@Composable
fun ZomLayout.layout(posicionamento: Posicionamento,
           rotacionados: Map<Int, Boolean>,
           deslocamentosPosicao: Map<Int, DeslocamentoPosicao>,
           multiplicador: Float, test1:Boolean, test2: Boolean, test3: Boolean,
           multiplicadorTexto: Float, test6: Boolean, context: Context, embutidoOuNao: Boolean
): Pair<Pair<Int, Boolean>, Pair<Float, Float>> {

    var estaSelecionado by remember {mutableStateOf(false)}

    val backgroundColor = if (estaSelecionado && !embutidoOuNao) Color.Red else {
        estaSelecionado = false
        Color.White
    }
    val produto = posicionamento.produto
    val posicao = posicionamento.coordenada

    produto!!.id

    val rotacionado =
        if(embutidoOuNao) false
        else try{ rotacionados[produto.id]!! }catch (_:Exception){produto.rotacionado}

    var largura: Int; var altura: Int

    if(rotacionado) { largura = produto.altura;altura = produto.largura
    } else { largura = produto.largura; altura = produto.altura }

    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    val deslocamento = deslocamentosPosicao[produto.id] ?: DeslocamentoPosicao()

    val posicaoXFinal = if(embutidoOuNao){
        posicao!!.x * multiplicador
    }else{ (((posicao!!.x + deslocamento.x) + (offsetX) / 6) * multiplicador) }

    val posicaoYFinal= if(embutidoOuNao) {
        posicao.y * multiplicador
    }else{ (((posicao.y + deslocamento.y) + (offsetY) / 6) * multiplicador)}

    Box(
        modifier = Modifier
            .offset(posicaoXFinal.dp, posicaoYFinal.dp)
            .width(largura.dp * multiplicador)
            .height(altura.dp * multiplicador)
            .background(backgroundColor)
            .border(0.85.dp, Color.Black)
            .clickable {
                if (idProdutoSelecionado != produto.id &&
                    idProdutoSelecionado == null && !embutidoOuNao
                ) {
                    estaSelecionado = true
                    idProdutoSelecionado = produto.id
                } else estaSelecionado = false
            }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    if (estaSelecionado) {
                        change.consumeAllChanges()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
            }
            .rotate(if (rotacionado) 90f else 0f)
    ) {
        if (test2) {
            Text(
                text = "$largura cm",
                color = Color.Black,
                fontSize = (15 * multiplicadorTexto).sp,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.BottomCenter)
            )
        }

        if (test1) {
            Text(
                text = "$altura cm",
                color = Color.Black,
                fontSize = (15 * multiplicadorTexto).sp,
                modifier = Modifier
                    .padding(4.dp)
                    .rotate(if (rotacionado) 0f else 90f)
                    .align(if (rotacionado) Alignment.CenterStart else Alignment.CenterEnd)
            )
        }
        if (test3) {
            Text(
                text = produto.nome.toString(),
                color = Color.Black,
                fontSize = (15 * multiplicadorTexto).sp,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.TopStart)
            )
        }
        if (test6){
            Text(
                text = produto.id.toString(),
                color = Color.Black,
                fontSize = (15 * multiplicadorTexto).sp,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.TopStart)
            )

        }
        /*
        val text = "${((posicao!!.x + deslocamento.x) + (offsetX) / 6).toInt() }" + ", "+
                "${((posicao.y + deslocamento.y) + (offsetY)/6).toInt()}"
        Text(
            text = text,
            color = Color.Black,
            fontSize = (15 * multiplicadorTexto).sp,
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.BottomCenter),

        )*/
    }

    return Pair(Pair(produto.id!!, estaSelecionado),
        Pair((posicaoXFinal), posicaoYFinal))
}
