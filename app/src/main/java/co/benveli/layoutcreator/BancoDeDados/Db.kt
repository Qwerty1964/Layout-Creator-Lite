package co.benveli.layoutcreator.BancoDeDados

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val dBTabelaLayout = "TabelaLayout"

val layoutAltura = "altura"
val layoutLargura = "largura"
val layoutNome = "nome"

val dBTabelaProdutos = "TabelaProdutos"

val produtosAltura = "altura"
val produtosLargura = "largura"
val produtosQuantidade = "quantidade"
val produtosNome = "nome"
val produtosIdRaiz = "idRaiz"

val dBTabeladesenhavel = "TabelaDesenhavel"

val produtoNome = "nome"
val produtoAltura = "altura"
val produtoLargura = "largura"
val produtoIdRaiz = "idRaiz"
val produtoPosicionamentoX = "posicionamentoX"
val produtoPosicionamentoY = "posicionamentoY"
val produtoRotacionado = "rotacionado"

val dBTabelaDadosOtimizacao = "TabelaDadosOtimizacao"

val otimizacaoAreaInicial = "areaInicial"
val otimizacaoAreaFinal = "areaFinal"
val otimizacaoAproveitamento = "aproveitamento"
val otimizacaoProdutosNaoUtilizados = "produtosNaoUtilizados"
val otimizacaoIdRaiz = "idRaiz"


val dBNome = "BancoDeDadosLayoutCreator"

class Db(contexT: Context)
    :SQLiteOpenHelper(contexT, dBNome, null, 3) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = """
            CREATE TABLE $dBTabelaLayout (
            $layoutAltura TEXT,
            $layoutLargura TEXT,
            $layoutNome TEXT, 
            id INTEGER PRIMARY KEY AUTOINCREMENT
            );""".trimIndent()
        db?.execSQL(sql)

        val sqL = """
            CREATE TABLE $dBTabelaProdutos (
            $produtosAltura TEXT,
            $produtosLargura TEXT,
            $produtosQuantidade TEXT,
            $produtosNome TEXT ,
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            $produtosIdRaiz TEXT
            );""".trimIndent()
        db?.execSQL(sqL)

        val sQL = """
            CREATE TABLE $dBTabeladesenhavel (
            $produtoAltura INTEGER,
            $produtoLargura INTEGER,
            $produtoNome TEXT ,
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            $produtoIdRaiz TEXT,
            $produtoPosicionamentoX INTEGER,
            $produtoPosicionamentoY INTEGER,
            $produtoRotacionado TEXT
            );""".trimIndent()
        db?.execSQL(sQL)

        val SQL = """
            CREATE TABLE $dBTabelaDadosOtimizacao (
            $otimizacaoAreaInicial INTEGER,
            $otimizacaoAreaFinal INTEGER,
            $otimizacaoAproveitamento TEXT,
            $otimizacaoProdutosNaoUtilizados INTEGER,
            $otimizacaoIdRaiz TEXT
            );""".trimIndent()
        db?.execSQL(SQL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $dBTabelaLayout")
        db?.execSQL("DROP TABLE IF EXISTS $dBTabelaProdutos")
        db?.execSQL("DROP TABLE IF EXISTS $dBTabeladesenhavel")
        db?.execSQL("DROP TABLE IF EXISTS $dBTabelaDadosOtimizacao")
        onCreate(db)
    }
}