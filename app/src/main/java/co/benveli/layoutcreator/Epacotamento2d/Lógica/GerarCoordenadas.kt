package co.benveli.layoutcreator.Epacotamento2d.Lógica

import android.annotation.SuppressLint
import android.content.Context
import co.benveli.layoutcreator.Activitys.Funs.TooastGenerico
import co.benveli.layoutcreator.Objetos.Coordenada
import co.benveli.layoutcreator.Objetos.Posicionamento
import co.benveli.layoutcreator.Objetos.Produto
import co.benveli.layoutcreator.Objetos.ResultadoOrganizacao
import co.benveli.layoutcreator.Objetos.Tecido
import java.util.BitSet
import kotlin.math.max

fun calcularAreaUtilizada(posicionamentos: List<Posicionamento>): Int {
    var areaUtilizada = 0
    for (posicionamento in posicionamentos) {
        val produto = posicionamento.produto
        areaUtilizada += produto!!.largura * produto.altura
    }
    return areaUtilizada
}

@SuppressLint("DefaultLocale")
fun gerarCoordenadasAdaptado_1(
    produtos: List<Produto>, tecido:Tecido, context: Context,
    confirmador: Boolean): ResultadoOrganizacao {

    //println("Lógica 1")

    val posicionamentos = mutableListOf<Posicionamento>()
    val containerWidth = tecido.largura
    val containerHeight = tecido.altura
    val container = Array(containerHeight) { BooleanArray(containerWidth) { false } }
    val produtosOrdenados = produtos.sortedWith(compareByDescending<Produto> { it.altura }.thenByDescending { it.largura })

    for (produto in produtosOrdenados) {var bestPosition: Posicionamento? = null
        for (rotation in 0..1) {
            val largura = if (rotation == 0) produto.largura else produto.altura
            val altura = if (rotation == 0) produto.altura else produto.largura
            for (y in 0 until containerHeight) {
                for (x in 0 until containerWidth) {
                    if (canPlace(container, x, y, largura, altura)) {
                        bestPosition = Posicionamento(produto, Coordenada(x, y), rotation == 1)
                        break
                    }
                }
                if (bestPosition != null) break
            }
            if (bestPosition != null) break
        }
        bestPosition?.let {
            posicionamentos.add(it)
            val largura = if (it.rotacionado) it.produto!!.altura else it.produto!!.largura
            val altura = if (it.rotacionado) it.produto!!.largura else it.produto!!.altura
            place(container, it.coordenada!!.x, it.coordenada.y,largura, altura)
        }
    }

    var bestMaxHeight = calculateMaxHeight(posicionamentos)
    var bestPosicionamentos = posicionamentos.toList()

    for (i in 0 until posicionamentos.size) {
        val originalPosicionamento = posicionamentos[i]
        val produto = originalPosicionamento.produto ?: continue
        val originalRotation = originalPosicionamento.rotacionado
        val originalX = originalPosicionamento.coordenada?.x ?: 0
        val originalY = originalPosicionamento.coordenada?.y ?: 0
        val originalWidth = if (originalRotation) produto.altura else produto.largura
        val originalHeight = if (originalRotation) produto.largura else produto.altura

        remove(container, originalX, originalY, originalWidth, originalHeight)

        for (rotation in 0..1) {
            val largura = if (rotation == 0) produto.largura else produto.altura
            val altura = if (rotation == 0) produto.altura else produto.largura
            for (y in 0 until containerHeight) {
                for (x in 0 until containerWidth) {
                    if (canPlace(container, x, y, largura, altura)) {
                        val newPosicionamento = Posicionamento(produto, Coordenada(x, y), rotation == 1)
                        val tempPosicionamentos = posicionamentos.toMutableList()
                        tempPosicionamentos[i] = newPosicionamento
                        val currentMaxHeight = calculateMaxHeight(tempPosicionamentos)

                        if (currentMaxHeight < bestMaxHeight) {
                            bestMaxHeight = currentMaxHeight
                            bestPosicionamentos = tempPosicionamentos.toList()
                        }
                        break
                    }
                }
                if (bestMaxHeight < calculateMaxHeight(posicionamentos)) break
            }
        }
        val bestRotation = bestPosicionamentos[i].rotacionado
        val bestX = bestPosicionamentos[i].coordenada?.x ?: 0
        val bestY = bestPosicionamentos[i].coordenada?.y ?: 0
        val bestWidth = if (bestRotation) produto.altura else produto.largura
        val bestHeight = if (bestRotation) produto.largura else produto.altura
        place(container, bestX, bestY, bestWidth, bestHeight)
    }

    val areaInicial = containerWidth * containerHeight
    val areaUtilizada = bestPosicionamentos.sumOf { pos ->
        if (pos.produto != null) {
            if (pos.rotacionado) pos.produto.altura * pos.produto.largura else pos.produto.largura * pos.produto.altura
        } else 0
    }
    val naoInseridos = produtos.size - bestPosicionamentos.size
    val aproveitamento = if (areaInicial > 0) (areaUtilizada.toDouble() / areaInicial) * 100 else 0.0
    val areaNaoUtilizada = if (aproveitamento > 0) aproveitamento - 100 else 0
    val aproveitamentoFormatado = String.format("%.2f", aproveitamento)

    saveDadosEmpacotamento(
        ResultadoOrganizacao(areaInicial / 100, areaNaoUtilizada.toInt() , aproveitamentoFormatado,
            naoInseridos, bestPosicionamentos), confirmador, context)

    return ResultadoOrganizacao(
        areaInicial / 100,
        areaNaoUtilizada.toInt(),
        aproveitamentoFormatado,
        naoInseridos,
        bestPosicionamentos
    )
}

fun gerarCoordenadasAdaptado_2(
    produtos: List<Produto>, tecido: Tecido, context:Context,
    confirmador: Boolean): ResultadoOrganizacao {

    //println("Lógica 2")
    val posicionamentos = mutableListOf<Posicionamento>()
    val containerWidth = tecido.largura
    val containerHeight = tecido.altura
    val container = Array(containerHeight) { BooleanArray(containerWidth) { false } }
    val produtosOrdenados = produtos.sortedWith(compareByDescending<Produto> { it.altura }.thenByDescending { it.largura })

    for (produto in produtosOrdenados) {
        var placed = false
        for (rotation in 0..1) {
            val largura = if (rotation == 0) produto.largura else produto.altura
            val altura = if (rotation == 0) produto.altura else produto.largura

            for (y in 0 until containerHeight) {
                for (x in 0 until containerWidth) {
                    if (canPlace(container, x, y, largura, altura)) {
                        posicionamentos.add(Posicionamento(produto, Coordenada(x, y), rotation == 1))
                        place(container, x, y, largura, altura)
                        placed = true
                        break
                    }
                }
                if (placed) break
            }
            if (placed) break
        }
    }

    val areaInicial = containerWidth * containerHeight
    val areaUtilizada = calcularAreaUtilizada(posicionamentos)
    val areaNaoUtilizada = areaInicial - areaUtilizada
    val naoInseridos = produtos.size -posicionamentos.size
    val aproveitamento = if (areaInicial > 0) (areaUtilizada.toDouble() / areaInicial) * 100 else 0.0
    val aproveitamentoFormatado = String.format("%.2f", aproveitamento)

    saveDadosEmpacotamento(
        ResultadoOrganizacao(areaInicial / 100, areaNaoUtilizada / 100, aproveitamentoFormatado,
            naoInseridos, posicionamentos), confirmador, context)

    return ResultadoOrganizacao(
        areaInicial / 100,
        areaNaoUtilizada / 100,
        aproveitamentoFormatado,
        naoInseridos,
        posicionamentos
    )
}

fun remove(container: Array<BooleanArray>, x: Int, y: Int, width: Int, height: Int) {
    for (i in y until y + height) {
        for (j in x until x + width) {
            container[i][j] = false
        }
    }
}

fun calculateMaxHeight(posicionamentos: List<Posicionamento>): Int {
    var maxHeight = 0
    for (pos in posicionamentos) {
        val produto = pos.produto
        val y = pos.coordenada?.y ?: 0
        val altura = if (pos.rotacionado) produto?.largura ?: 0 else produto?.altura ?: 0
        maxHeight = max(maxHeight, y + altura)
    }
    return maxHeight
}

fun canPlace(container: Array<BooleanArray>, x: Int, y: Int, width: Int, height: Int): Boolean {
    if (x + width > container[0].size || y + height > container.size) return false
    for (i in y until y + height) {
        for (j in x until x + width) {
            if (container[i][j]) return false
        }
    }
    return true
}

fun place(container: Array<BooleanArray>, x: Int, y: Int, width: Int, height: Int) {
    for (i in y until y + height) {
        for (j in x until x + width) {
            container[i][j] = true
        }
    }
}