package co.benveli.layoutcreator.Epacotamento2d.Compose.um

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import co.benveli.layoutcreator.Activitys.Funs.TooastGenerico
import co.benveli.layoutcreator.Activitys.Funs.ZLFuns.ClickSelect
import co.benveli.layoutcreator.Activitys.ZomLayout
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.LeituraExibicaoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.LerCalculosEmpacotamento
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.LeituraBancoDeDadosProdutosComposable
import co.benveli.layoutcreator.Epacotamento2d.Lógica.VerificadorPopulacaoEmpacotamento2D
import co.benveli.layoutcreator.Objetos.CordenadasLivres
import co.benveli.layoutcreator.Objetos.DeslocamentoPosicao
import co.benveli.layoutcreator.Objetos.Produto
import co.benveli.layoutcreator.Objetos.Tecido
import co.benveli.layoutcreator.R

@ExperimentalMaterial3Api
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ZomLayout.TesteVizualizarTecido(
    tecido: Tecido, inverterDimensoes: Boolean,
    multiplicador: Float, test1:Boolean, test2: Boolean,
    test3: Boolean, multiplicadorTexto: Float,
    context : Context, test6: Boolean,
    idRaiz: String, test8: Boolean,
    visibleOrInvisibleSave: Boolean
): Boolean {
    val bancoDeDados = Db(context)
    var rotacionados by remember { mutableStateOf<Map<Int, Boolean>>(emptyMap()) }
    val largura = if (inverterDimensoes) tecido.altura else tecido.largura
    val altura = if (inverterDimensoes) tecido.largura else tecido.altura
    var salvar = !visibleOrInvisibleSave

    var deslocamentosPosicao by remember { mutableStateOf<Map<Int, DeslocamentoPosicao>>(emptyMap()) }

    val listProdutos = mutableListOf<Produto>()
    bancoDeDados.LerCalculosEmpacotamento(idRaiz).forEach{posicionamento ->
        listProdutos.add(posicionamento.produto!!)
    }
    val resultado = VerificadorPopulacaoEmpacotamento2D(
        idRaiz, context, listProdutos, tecido, false, test8, true
    )

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        val (botoesDeMovimentacao, save, adicionar, sim, nao, toast, auxiliar, salvarCaixa, layout) = createRefs()

        Box(
            modifier = Modifier
                .constrainAs(layout){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ){

            Box(
                modifier = Modifier
                    .width(largura.dp * multiplicador)
                    .height(altura.dp * multiplicador)
                    .align(Alignment.TopCenter)
                    .background(Color.LightGray)
                    .border(2.dp, Color.Black)
            ) {
                resultado.posicionamentos.forEach{ posicionamento ->
                    val resultadoLayout = layout(posicionamento,
                        rotacionados, deslocamentosPosicao, multiplicador,
                        test1, test2, test3, multiplicadorTexto, test6, context, test8)

                    val (idSelecionado, controlador) = resultadoLayout.first
                    val (x, y) = resultadoLayout.second
                    val idProduto = posicionamento.produto!!.id

                    if(x != 0f || y != 0f){
                        val existingItem = mapaSimples.find { it.id == idProduto }

                        if (existingItem != null) {
                            mapaSimples.remove(existingItem)
                        }
                        mapaSimples.add(CordenadasLivres(idProduto!!, x, y))
                    }
                    if (controlador && idProdutoSelecionado != idSelecionado) {
                        idProdutoSelecionado = idSelecionado
                    }

                    if (!controlador && idProdutoSelecionado == idSelecionado) {
                        idProdutoSelecionado = null
                    }
                }
            }
        }

        val movimentacao = BotooesDeMovimentacao(
            modifier = Modifier
                .constrainAs(botoesDeMovimentacao) {
                    bottom.linkTo(parent.bottom, 75.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            context, rotacionados, deslocamentosPosicao, !salvar
        )

        if(movimentacao.map1 != null && rotacionados != movimentacao.map1) {
            rotacionados = movimentacao.map1
        }
        if(movimentacao.map2 != null && deslocamentosPosicao != movimentacao.map2) {
            deslocamentosPosicao = movimentacao.map2
        }

        Box(modifier = Modifier.constrainAs(auxiliar){
            bottom.linkTo(botoesDeMovimentacao.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })


        val startPadding by animateDpAsState(
            targetValue = if (!salvar) 10.dp else 0.dp,
            animationSpec = tween(durationMillis = 1000), label = ""
        )
        val bottomPadding by animateDpAsState(
            targetValue = if (!salvar) 35.dp else 65.dp,
            animationSpec = tween(durationMillis = 1000), label = ""
        )
        val endPadding by animateDpAsState(
            targetValue = if (salvar) 10.dp else 260.dp,
            animationSpec = tween(durationMillis = 1000), label = ""
        )

        Image(
            contentDescription = "Salvar",
            painter = painterResource(id = R.drawable.ic_save_zoom_2),
            modifier = Modifier
                .size(70.dp)
                .border(7.dp, Color.Black)
                .background(colorResource(id = R.color.azul_2))
                .padding(10.dp)
                .constrainAs(save) {
                    start.linkTo(parent.start, margin = startPadding)
                    end.linkTo(parent.end, margin = endPadding)
                    bottom.linkTo(parent.bottom, margin = bottomPadding)
                    width = Dimension.wrapContent
                }
                .clickable {
                    salvar = !salvar
                }
        )

        //TooastGenerico(context, "$adicionarProduto2 ", "")

        if (!salvar) {
            Image(
                contentDescription = "Adicionar",
                painter = painterResource(id = R.drawable.ic_add),
                modifier = Modifier
                    .size(70.dp)
                    .border(7.dp, Color.Black)
                    .background(colorResource(id = R.color.azul_2))
                    .constrainAs(adicionar) {
                        end.linkTo(parent.end, 10.dp)
                        bottom.linkTo(parent.bottom, 35.dp)
                    }
            )
        }

        if (salvar) {
            IfSalvar(
                Modifier.constrainAs(sim) {
                    start.linkTo(parent.start, 10.dp)
                    bottom.linkTo(parent.bottom, 35.dp)
                },
                rotacionados, deslocamentosPosicao,
                context, multiplicador, resultado, test8
            )

            Text(
                text = stringResource(R.string.mensagem_multável_empacotamento_17),
                fontSize = 27.sp,
                fontFamily = FontFamily(Font(R.font.sugo_display)),
                color = Color.White,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                modifier = Modifier
                    .constrainAs(nao) {
                        end.linkTo(parent.end, 10.dp)
                        bottom.linkTo(parent.bottom, 35.dp)
                    }
                    .size(70.dp)
                    .border(7.dp, Color.Black)
                    .background(colorResource(id = R.color.azul_2))
                    .padding(10.dp)
                    .padding(top = 15.dp)
            )
        }
        val constraints = Modifier.constrainAs(toast) {
            bottom.linkTo(sim.top, 50.dp)
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        if (salvar){
            AvisoSalvar(constraints, rotacionados, context, multiplicador, resultado)}

        val modiifier = Modifier.constrainAs(salvarCaixa) {
            bottom.linkTo(parent.bottom, 20.dp)
            top.linkTo(parent.top, 20.dp)
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
        }

        AnimatedVisibility(
            visible = !visibleOrInvisibleProduct,
            enter = fadeIn(animationSpec = tween(durationMillis = 1000)),
            exit = fadeOut(animationSpec = tween(durationMillis = 1000)),
            modifier = modiifier
        ) {
            salvarProduto(context, modiifier, idRaiz, tecido)
        }

    }
    return salvar
}
