package co.benveli.layoutcreator.Epacotamento2d.Compose.dois

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.benveli.layoutcreator.Objetos.ResultadoOrganizacao
import co.benveli.layoutcreator.Objetos.Tecido
import kotlinx.coroutines.launch


@Composable
fun VisualizarTecido(
    tecido: Tecido, resultado: ResultadoOrganizacao,
    inverterDimensoes: Boolean, multiplicador: Float,
    test1:Boolean, test2:Boolean,
    test3:Boolean, multiplicadorTexto: Float,
) {
    val largura = if (inverterDimensoes) tecido.altura * multiplicador else tecido.largura * multiplicador
    val altura = if (inverterDimensoes) tecido.largura * multiplicador else tecido.altura * multiplicador

    Column {
            Box(
                modifier = Modifier
                    .width(largura.dp)
                    .height(altura.dp)
                    .background(Color.LightGray)
            ) {
                resultado.posicionamentos.forEach { posicionamento ->
                    val produto = posicionamento.produto
                    val posicao = posicionamento.coordenada
                    val rotacionado = posicionamento.rotacionado

                    val larguraProduto =
                        if (rotacionado) produto!!.altura * multiplicador else produto!!.largura * multiplicador
                    val alturaProduto =
                        if (rotacionado) produto.largura * multiplicador else produto.altura * multiplicador

                    val offsetX = remember { Animatable((largura.dp).value) }
                    val offsetY = remember { Animatable((altura.dp).value) }

                    LaunchedEffect(posicionamento) {
                        launch {
                            offsetX.animateTo(
                                targetValue = posicao!!.x.dp.value * multiplicador,
                                animationSpec = tween(durationMillis = 2000)
                            )
                        }
                        launch {
                            offsetY.animateTo(
                                targetValue = posicao!!.y.dp.value * multiplicador,
                                animationSpec = tween(durationMillis = 2000)
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .offset((offsetX.value * multiplicador).dp, (offsetY.value * multiplicador).dp)
                            .width(larguraProduto.dp)
                            .height(alturaProduto.dp)
                            .background(Color.White)
                            .border(0.5.dp, Color.Black)
                    ) {
                        if (test2) {
                            Text(
                                text = "${larguraProduto.toInt()/multiplicador.toInt()}cm",
                                color = Color.Black,
                                fontSize = (15 * multiplicadorTexto).sp,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .align(Alignment.BottomCenter)
                            )
                        }
                        if (test1) {
                            Text(
                                text = "${alturaProduto.toInt()/multiplicador.toInt()}cm",
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
                    }
                }
            }
        }
}