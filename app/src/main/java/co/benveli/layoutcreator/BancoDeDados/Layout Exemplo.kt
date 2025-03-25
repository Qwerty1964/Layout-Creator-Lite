package co.benveli.layoutcreator.BancoDeDados

import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.SalvarCalculoEmpacotamento
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.Enpacotamento2d.SalvarDadosOtimizacao
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.SalvarLayouts
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.SalvarProdutos
import co.benveli.layoutcreator.Objetos.Coordenada
import co.benveli.layoutcreator.Objetos.Objetos
import co.benveli.layoutcreator.Objetos.Produto

fun Db.LayoutExemplo(){

    val nomeLayout = "Bolsa"
    val altura = "150"
    val largura = "150"

    val produtos = listOf(
        Produto(nome = "1", quantidade = 2, largura = 20, altura = 20, idRaiz = "Bolsa", rotacionado = false),
        Produto(nome = "2", quantidade = 5, largura = 40, altura = 20, idRaiz = "Bolsa", rotacionado = false),
        Produto(nome = "3", quantidade = 4, largura = 65, altura = 20, idRaiz = "Bolsa", rotacionado = false),
        Produto(nome = "4", quantidade = 2, largura = 80, altura = 15, idRaiz = "Bolsa", rotacionado = false),
        Produto(nome = "5", quantidade = 1, largura = 150, altura = 15, idRaiz = "Bolsa", rotacionado = false),
        Produto(nome = "6", quantidade = 2, largura = 15, altura = 20, idRaiz = "Bolsa", rotacionado = false),
        Produto(nome = "7", quantidade = 2, largura = 15, altura = 40, idRaiz = "Bolsa", rotacionado = false),
    )

    val produtosMultiplicado = listOf(
        Produto(nome = "1", largura = 20, altura = 20, idRaiz = "Bolsa", rotacionado = false),//1.1
        Produto(nome = "1", largura = 20, altura = 20, idRaiz = "Bolsa", rotacionado = false),//1.2

        Produto(nome = "2", largura = 40, altura = 20, idRaiz = "Bolsa", rotacionado = false),//2.1
        Produto(nome = "2", largura = 40, altura = 20, idRaiz = "Bolsa", rotacionado = false),//2.2
        Produto(nome = "2", largura = 40, altura = 20, idRaiz = "Bolsa", rotacionado = false),//2.3
        Produto(nome = "2", largura = 40, altura = 20, idRaiz = "Bolsa", rotacionado = false),//2.4
        Produto(nome = "2", largura = 40, altura = 20, idRaiz = "Bolsa", rotacionado = false),//2.5

        Produto(nome = "3", largura = 65, altura = 20, idRaiz = "Bolsa", rotacionado = false),//3.1
        Produto(nome = "3", largura = 65, altura = 20, idRaiz = "Bolsa", rotacionado = false),//3.2
        Produto(nome = "3", largura = 65, altura = 20, idRaiz = "Bolsa", rotacionado = false),//3.3
        Produto(nome = "3", largura = 65, altura = 20, idRaiz = "Bolsa", rotacionado = false),//3.4

        Produto(nome = "4", largura = 80, altura = 15, idRaiz = "Bolsa", rotacionado = false),//4.1
        Produto(nome = "4", largura = 80, altura = 15, idRaiz = "Bolsa", rotacionado = false),//4.2

        Produto(nome = "5", largura = 150, altura = 15, idRaiz = "Bolsa", rotacionado = false),//5

        Produto(nome = "6", largura = 15, altura = 20, idRaiz = "Bolsa", rotacionado = false),//6.1
        Produto(nome = "6", largura = 15, altura = 20, idRaiz = "Bolsa", rotacionado = false),//6.2

        Produto(nome = "7", largura = 15, altura = 40, idRaiz = "Bolsa", rotacionado = false),//7.1
        Produto(nome = "7", largura = 15, altura = 40, idRaiz = "Bolsa", rotacionado = false),//7.2
    )

    val cordenadas = listOf(
        Coordenada(130, 15), //1.1
        Coordenada(130, 35), //1.2

        Coordenada(80, 55), //2.1
        Coordenada(80, 75), //2.2
        Coordenada(80, 95), //2.3
        Coordenada(0, 85), //2.4
        Coordenada(40, 85), //2.5

        Coordenada(0, 15), //3.1
        Coordenada(65, 15), //3.2
        Coordenada(0, 35), //3.3
        Coordenada(65, 35), //3.4

        Coordenada(0, 55), //4.1
        Coordenada(0, 70), //4.2

        Coordenada(0, 0),

        Coordenada(120, 55), //6.1
        Coordenada(135, 55), //6.2

        Coordenada(120, 75), //7.1
        Coordenada(135, 75)) //7.2

    val areaInicial = 0
    val areaNaoUtilizada = 0
    val naoInseridos = 0
    val utilizado = 0

    SalvarLayouts(Objetos(altura, largura, nomeLayout))

    for (i in produtos.indices){
        SalvarProdutos(Objetos(
            produtos[i].altura.toString(),
            produtos[i].largura.toString(),
            produtos[i].nome,
            produtos[i].quantidade.toString(),
            idRaiz = produtos[i].idRaiz))
    }

    for (i in cordenadas.indices){
        SalvarCalculoEmpacotamento(
            nomeProduto = produtosMultiplicado[i].nome.toString(),
            larguraProduto = produtosMultiplicado[i].largura,
            alturaProduto = produtosMultiplicado[i].altura,
            idRaiz = produtosMultiplicado[i].idRaiz,
            posicionamentoX = cordenadas[i].x,
            posicionamentoY = cordenadas[i].y,
            rotacionado = produtosMultiplicado[i].rotacionado
        )
    }

    SalvarDadosOtimizacao(
        areaInicial = areaInicial,
        areaFinal = areaNaoUtilizada,
        aproveitamento = "0%",
        produtosNaoUtilizados = naoInseridos,
        idRaiz = "Bolsa"
    )

}