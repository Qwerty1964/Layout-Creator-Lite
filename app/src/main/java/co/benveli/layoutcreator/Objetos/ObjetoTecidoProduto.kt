package co.benveli.layoutcreator.Objetos

data class Tecido(
    val largura: Int,
    val altura: Int)

data class Produto(
    val nome: String? = null,
    val largura: Int,
    val altura: Int,
    val id: Int? = null,
    val quantidade: Int? = null,
    val idRaiz:String,
    var rotacionado: Boolean)

data class Coordenada(
    val x: Int,
    val y: Int)

data class Posicionamento(
    val produto: Produto? = null,
    val coordenada: Coordenada? = null,
    var rotacionado: Boolean)

data class ResultadoOrganizacao(
    val areaInicial: Int,
    val areaFinal: Int,
    val aproveitamento: String,
    val produtosNaoUtilizados: Int,
    val posicionamentos: List<Posicionamento>
)

data class DadosOtimizacao(
    val areaInicial: Int? = null,
    val areaFinal: Int? = null,
    val aproveitamento: String? = null,
    val produtosNaoUtilizados: Int? = null,
)

data class DeslocamentoPosicao(
    var x: Int = 0,
    var y: Int = 0)

data class CordenadasLivres(
    var id: Int = 0,
    var x: Float = 0f,
    var y: Float = 0f)

data class ResultBotoes(val map1: Map<Int, Boolean>? = null,
                        val map2: Map<Int, DeslocamentoPosicao>? = null,
                        val chave: Int? = null)

