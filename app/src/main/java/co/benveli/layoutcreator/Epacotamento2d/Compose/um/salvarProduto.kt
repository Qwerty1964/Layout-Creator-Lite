package co.benveli.layoutcreator.Epacotamento2d.Compose.um

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import co.benveli.layoutcreator.Activitys.Funs.TooastGenerico
import co.benveli.layoutcreator.Activitys.Funs.ZLFuns.ClickSelect
import co.benveli.layoutcreator.Activitys.Funs.ZLFuns.VisibilityorProduct
import co.benveli.layoutcreator.Activitys.ZomLayout
import co.benveli.layoutcreator.Objetos.Tecido
import co.benveli.layoutcreator.R

@ExperimentalMaterial3Api
@Composable
fun ZomLayout.salvarProduto(context: Context, modifier: Modifier, idRaiz: String, tecido: Tecido) {

    var textNome by remember { mutableStateOf("") }
    var textQuantidade by remember { mutableStateOf("") }
    var textAltura by remember { mutableStateOf("") }
    var textLargura by remember { mutableStateOf("") }
    var resetar by remember { mutableStateOf(false) }

    ConstraintLayout(
        modifier = modifier
            .background(colorResource(id = R.color.azul_2))
            .border(2.dp, Color.Black),
    ) {

        val (nome, quantidade, altura, largura, salvar, calcelar) = createRefs()

        textNome =
            editText(
                stringResource(R.string.mensagem_multável_empacotamento_8),
                modifier = Modifier
                    .constrainAs(nome) {
                        top.linkTo(parent.top, 20.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                false, textNome.isEmpty()
            )

        textQuantidade =
            editText(
                stringResource(R.string.mensagem_multável_empacotamento_9),
                modifier = Modifier
                    .constrainAs(quantidade) {
                        top.linkTo(nome.bottom, 20.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                true, textQuantidade.isEmpty()
            )

        textLargura =
            editText(
                stringResource(R.string.mensagem_multável_empacotamento_10),
                modifier = Modifier
                    .constrainAs(largura) {
                        top.linkTo(quantidade.bottom, 20.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                true, textLargura.isEmpty()
            )

        textAltura =
            editText(
                stringResource(R.string.mensagem_multável_empacotamento_11),
                modifier = Modifier
                    .constrainAs(altura) {
                        top.linkTo(largura.bottom, 20.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                true, textAltura.isEmpty()
            )

        Image(
            painter = painterResource(id = R.drawable.ic_nuvemr_transparent),
            contentDescription = stringResource(R.string.mensagem_multável_empacotamento_12),
            modifier = Modifier
                .background(colorResource(id = R.color.azul_1))
                .border(7.dp, Color.Black)
                .size(80.dp, 80.dp)
                .padding(15.dp)
                .clickable {
                    if (textNome.isNotEmpty() || textQuantidade.isNotEmpty() || textLargura.isNotEmpty()
                        || textAltura.isNotEmpty()
                    ) {
                        if (salvarProdutoZoomLayout(
                                context, textNome, textLargura.toInt(),
                                textAltura.toInt(), idRaiz, tecido, textQuantidade.toInt()
                            )
                        ) {
                            TooastGenerico(context, context.getString(R.string.mensagem_multável_empacotamento_13), "😁")

                            textNome = ""; textAltura = ""; textLargura = ""
                            resetar = !resetar
                            VisibilityorProduct(true)
                            ClickSelect(0, false)
                        } else TooastGenerico(context, context.getString(R.string.mensagem_multável_empacotamento_14), "🧐")

                    } else TooastGenerico(context, context.getString(R.string.mensagem_multável_empacotamento_15), "🤨")

                }
                .constrainAs(salvar) {
                    top.linkTo(altura.bottom, 20.dp)
                    bottom.linkTo(parent.bottom, 20.dp)
                    end.linkTo(parent.end, 20.dp)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_lixeira),
            contentDescription = "Cancelado",
            modifier = Modifier
                .background(colorResource(id = R.color.azul_1))
                .border(7.dp, Color.Black)
                .size(80.dp, 80.dp)
                .padding(15.dp)
                .clickable {
                    VisibilityorProduct(true)
                    ClickSelect(0, false)
                }
                .constrainAs(calcelar) {
                    top.linkTo(altura.bottom, 20.dp)
                    bottom.linkTo(parent.bottom, 20.dp)
                    start.linkTo(parent.start, 20.dp)
                    end.linkTo(salvar.start, 80.dp)
                }
        )
    }

}