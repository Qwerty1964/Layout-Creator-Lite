package co.benveli.layoutcreator.Activitys

import android.os.Bundle import android.view.View import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import co.benveli.layoutcreator.Activitys.Funs.TDFuns.ClickSelectTD
import co.benveli.layoutcreator.Activitys.Funs.TDFuns.Clicks.EventoDeClickAumentarLayout
import co.benveli.layoutcreator.Activitys.Funs.TDFuns.Clicks.EventoDeClickDirecao
import co.benveli.layoutcreator.Activitys.Funs.TDFuns.Clicks.EventoDeClickExcluir
import co.benveli.layoutcreator.Activitys.Funs.TDFuns.Clicks.EventoDeClickTransicionarTelas
import co.benveli.layoutcreator.Activitys.Funs.TDFuns.SpinerTelaDeDescricao
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.R
import co.benveli.layoutcreator.Recyclers.AdapterTelaDescricao import co.benveli.layoutcreator.Recyclers.ViewHolderTelaDescricao
import co.benveli.layoutcreator.databinding.ActivityTelaDeDescricao2Binding

class TelaDeDescricao : AppCompatActivity() {

    lateinit var elementosActivityTelaDeDescricao: ActivityTelaDeDescricao2Binding
    lateinit var bancoDeDados: Db; lateinit var adapterTelaDescricao: AdapterTelaDescricao
    lateinit var viewHolderTelaDescricao: ViewHolderTelaDescricao;lateinit var spiner: Spinner
    lateinit var nomeSelecionadoSpinner: String; var controlador1 = 0
    var cont1 = false; var cont2 = false; var cont3 = false; var soun = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        elementosActivityTelaDeDescricao = ActivityTelaDeDescricao2Binding.inflate(layoutInflater)
        setContentView(elementosActivityTelaDeDescricao.root)

        bancoDeDados = Db(this)
        spiner = elementosActivityTelaDeDescricao.spinnerNomesTelaDeDescriO

        adapterTelaDescricao = AdapterTelaDescricao()
        elementosActivityTelaDeDescricao.recyclerTelaDescricacaoProdutos.layoutManager = LinearLayoutManager(this)
        elementosActivityTelaDeDescricao.recyclerTelaDescricacaoProdutos.adapter = adapterTelaDescricao

        viewHolderTelaDescricao =  ViewHolderTelaDescricao(elementosActivityTelaDeDescricao.root)
        viewHolderTelaDescricao.MovimentacaoSimples(elementosActivityTelaDeDescricao.recyclerTelaDescricacaoProdutos)

        SpinerTelaDeDescricao()
        elementosActivityTelaDeDescricao.setaDirecaoTelaDescricao.setOnClickListener{
            EventoDeClickDirecao()}
        elementosActivityTelaDeDescricao.transicionarTelasTelaDescricao.setOnClickListener{
            EventoDeClickTransicionarTelas()}
        elementosActivityTelaDeDescricao.excluirBtnTelaLayoutCompleto.setOnClickListener{
            EventoDeClickExcluir()}

        elementosActivityTelaDeDescricao.aumentarLayoutTelaDescricao.setOnClickListener{
            EventoDeClickAumentarLayout()}

        elementosActivityTelaDeDescricao.alturaView1.setOnClickListener{ ClickSelectTD(1) }
        elementosActivityTelaDeDescricao.larguraView2.setOnClickListener{ ClickSelectTD(2) }
        elementosActivityTelaDeDescricao.nomeView3.setOnClickListener{ ClickSelectTD(3) }

    }}
