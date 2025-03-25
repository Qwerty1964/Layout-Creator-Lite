package co.benveli.layoutcreator.Epacotamento2d.Compose.um

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import co.benveli.layoutcreator.Activitys.ZomLayout
import co.benveli.layoutcreator.Objetos.DeslocamentoPosicao
import co.benveli.layoutcreator.Objetos.ResultBotoes
import co.benveli.layoutcreator.R

@ExperimentalFoundationApi
@Composable
fun ZomLayout.BotooesDeMovimentacao(
    modifier: Modifier,
    context: Context,
    rotacionadosLocal:Map<Int, Boolean>,
    deslocamentosPosicaoLocal:Map<Int, DeslocamentoPosicao>,
    visibleOrInvisible: Boolean

): ResultBotoes {

    var rotacionados by remember { mutableStateOf(rotacionadosLocal) }
    var deslocamentosPosicao by remember { mutableStateOf(deslocamentosPosicaoLocal)}

    fun onMove(deslocamentoX: Int, deslocamentoY: Int) {
        deslocamentosPosicao = deslocamentosPosicao + (idProdutoSelecionado!! to (deslocamentosPosicao[idProdutoSelecionado!!]
            ?: DeslocamentoPosicao()).copy(
            x = (deslocamentosPosicao[idProdutoSelecionado!!]?.x ?: 0) + deslocamentoX,
            y = (deslocamentosPosicao[idProdutoSelecionado!!]?.y ?: 0) + deslocamentoY
        ))
    }

    AnimatedVisibility(
        visible = visibleOrInvisible,
        enter = fadeIn(animationSpec = tween(durationMillis = 1000)),
        exit = fadeOut(animationSpec = tween(durationMillis = 1000)),
        modifier = modifier
    ) {

        ConstraintLayout{
            val (centro, topp, startt, endd, bottomm, rotacionar) = createRefs()

            Box(modifier = Modifier
                .size(50.dp)
                .constrainAs(centro) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, 100.dp)
                }
            )
            Image(
                contentDescription = "Rotacionar",
                painter = painterResource(id = R.drawable.ic_refresh_2),
                modifier = Modifier
                    .size(70.dp)
                    .border(7.dp, Color.Black)
                    .background(colorResource(id = R.color.azul_2))
                    .padding(10.dp)
                    .constrainAs(rotacionar) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom, -10.dp)
                    }
                    .combinedClickable(
                        onClick = {
                            if (idProdutoSelecionado != null) {
                                rotacionados =
                                    (rotacionados + (idProdutoSelecionado!! to !(rotacionados[idProdutoSelecionado]
                                        ?: false)))
                            }
                        },
                        onLongClick = {
                            deslocamentosPosicao = emptyMap()
                            rotacionados = emptyMap()
                        }
                    )
            )
            Image(
                contentDescription = "Top",
                painter = painterResource(id = R.drawable.ic_seta_btns),
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        if (idProdutoSelecionado != null) {
                            onMove(0, -1)
                        }
                    }
                    .constrainAs(topp) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(centro.top)
                    }
            )

            Image(
                contentDescription = "Start",
                painter = painterResource(id = R.drawable.ic_seta_btns),
                modifier = Modifier
                    .size(50.dp)
                    .rotate(270f)
                    .clickable {
                        if (idProdutoSelecionado != null) {
                            onMove(-1, 0)
                        }
                    }
                    .constrainAs(startt) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(centro.start)
                        bottom.linkTo(parent.bottom, 100.dp)
                    }
            )

            Image(
                contentDescription = "End",
                painter = painterResource(id = R.drawable.ic_seta_btns),
                modifier = Modifier
                    .size(50.dp)
                    .rotate(90f)
                    .clickable {
                        if (idProdutoSelecionado != null) {
                            onMove(1, 0)
                        }
                    }
                    .constrainAs(endd) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        start.linkTo(centro.end)
                        bottom.linkTo(parent.bottom, 100.dp)
                    }
            )

            Image(
                contentDescription = "Bottom",
                painter = painterResource(id = R.drawable.ic_seta_btns),
                modifier = Modifier
                    .size(50.dp)
                    .rotate(180f)
                    .clickable {
                        if (idProdutoSelecionado != null) {
                            onMove(0, 1)
                        }
                    }
                    .constrainAs(bottomm) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(centro.bottom)
                    }
            )
        }
    }

    return if (rotacionados != rotacionadosLocal && deslocamentosPosicao == deslocamentosPosicaoLocal){
        ResultBotoes(rotacionados, chave = idProdutoSelecionado)
    }else if (rotacionados == rotacionadosLocal && deslocamentosPosicao != deslocamentosPosicaoLocal){
        ResultBotoes(map2 = deslocamentosPosicao, chave = idProdutoSelecionado)
    }else{
        ResultBotoes()
    }

}

