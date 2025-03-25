package co.benveli.layoutcreator.Epacotamento2d.Compose.um

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.benveli.layoutcreator.Activitys.ZomLayout
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.LerXeYOriginal
import co.benveli.layoutcreator.Objetos.CordenadasLivres
import co.benveli.layoutcreator.Objetos.ResultadoOrganizacao
import co.benveli.layoutcreator.R

@Composable
fun ZomLayout.AvisoSalvar(modifier: Modifier,
                mapRotacionados: Map<Int,Boolean>,
                context: Context, multiplicador: Float,
                resultado: ResultadoOrganizacao
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(colorResource(id = R.color.azul_2))
            .border(5.dp, Color.Black)
    ) {
        Column(
            modifier = Modifier.padding(bottom = 30.dp)
        ) {

            Text(
                text = stringResource(R.string.mensagem_multável_empacotamento_3),
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.sugo_display)),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .padding(top = 15.dp)

            )
            Text(
                text = stringResource(R.string.mensagem_multável_empacotamento_4),
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.sugo_display)),
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 15.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier
                        .offset(x = 20.dp, y = 20.dp)
                        .border(6.dp, Color.Black)
                        .background(Color.White)
                ) {
                    for (chave in mapRotacionados.keys) {
                        if(mapRotacionados.size <= 10)
                            Text(
                                text = chave.toString(),
                                fontFamily = FontFamily(Font(R.font.sugo_display)),
                                fontSize = 20.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(10.dp)
                            )
                    }
                }

                Column(
                    modifier = Modifier
                        .offset(x = 20.dp, y = 20.dp)
                        .border(6.dp, Color.Black)
                        .background(Color.White)
                ) {
                    for (values in mapRotacionados.values) {
                        if(mapRotacionados.size <= 10)
                            Text(
                                text = if (values) stringResource(R.string.mensagem_multável_empacotamento_5) else stringResource(
                                    R.string.mensagem_multável_empacotamento_6
                                ),
                                fontFamily = FontFamily(Font(R.font.sugo_display)),
                                fontSize = 20.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(10.dp)
                            )
                    }
                }
                var listValores = mutableListOf<String>()
                var listIds = mutableListOf<String>()
                for (i in mapaSimples) {

                    val bancoDeDados = Db(context)
                    val (posicaoOriginalX, posicaoOriginalY) = bancoDeDados.LerXeYOriginal(i.id)

                    val x = ((i.x - (posicaoOriginalX * multiplicador)) / multiplicador)
                    val y = ((i.y - posicaoOriginalY * multiplicador) / multiplicador)
                    val text = "${x.toInt()}" + "x" + ", ${y.toInt()}" + "y"

                    if (x != 0f || y != 0f){
                        if(listValores.size < 10)listValores.add(text)
                        if(listIds.size < 10)listIds.add(i.id.toString())
                    }

                }

                Column(
                    modifier = Modifier
                        .offset(x = 20.dp, y = 20.dp)
                        .border(6.dp, Color.Black)
                        .background(Color.White)
                ) {
                    for (i in listIds) {
                        Text(
                            text = i,
                            fontFamily = FontFamily(Font(R.font.sugo_display)),
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .offset(x = 20.dp, y = 20.dp)
                        .border(6.dp, Color.Black)
                        .background(Color.White)
                ) {
                    for (text in listValores) {
                        Text(
                            text = text,
                            fontFamily = FontFamily(Font(R.font.sugo_display)),
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        }
    }
}