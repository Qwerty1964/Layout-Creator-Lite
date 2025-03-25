package co.benveli.layoutcreator.Activitys

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.AtualizarTextAvisoTNL
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.Clicks.ClickSelectTNL
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.Clicks.EventoDeClickExcluir
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.Clicks.EventoDeClickNovoProduto
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.Clicks.eventoDeClickRecarregar
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.Clicks.EventoDeClickSalvar
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.State1
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.State2
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.TransicionarTelasTNL
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.VerificadorTelaNovoLayout
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.VerificarEyesTNL
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.atualizarCmoposeSelecionado
import co.benveli.layoutcreator.Activitys.Funs.TNlFuns.tooastTNL
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.verificadorDeSemelhancasTelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.verificadorPopulacaoProdutos
import co.benveli.layoutcreator.CaixaDeDialogos.CaixaDeDialogoMutavelTNL
import co.benveli.layoutcreator.Objetos.Objetos
import co.benveli.layoutcreator.R
import co.benveli.layoutcreator.Recyclers.AdapterProdutosTelaNovoLayout
import co.benveli.layoutcreator.Recyclers.ViewHolderProdutosTelaNovoLayout
import co.benveli.layoutcreator.databinding.ActivityTelaNovoLayout2Binding

class TelaNovoLayout : AppCompatActivity() {

    lateinit var elementosActivityTelaNovoLayout: ActivityTelaNovoLayout2Binding
    lateinit var caixaDialogoNovoProduto: AlertDialog
    val bancoDeDados = Db(this);lateinit var buildCaixaDialogoNovoProduto: AlertDialog.Builder
    lateinit var viewCaixaDialogoNovoProduto: View; lateinit var adapterProdutosTelaNovoLayout: AdapterProdutosTelaNovoLayout
    lateinit var viewHolderProdutosTelaNovoLayout: ViewHolderProdutosTelaNovoLayout; lateinit var spinner: Spinner
    lateinit var nomeSelecionadoSpiner: Objetos; var soun = false
    var constraintSetOriginais: Unit? = null

    var controlador1 = 0; var cont1 = true; var cont2 = true; var cont3 = true
    var composeSelecionado = true; var multiplicador = 1.0F

    private val handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        elementosActivityTelaNovoLayout = ActivityTelaNovoLayout2Binding.inflate(layoutInflater)
        setContentView(elementosActivityTelaNovoLayout.root)

        val intent1 = intent.getStringExtra("cont1")
        val intent2 = intent.getStringExtra("cont2")
        val intent3 = intent.getStringExtra("cont3")
        VerificarEyesTNL()
        val elementoView1 = elementosActivityTelaNovoLayout.view1
        val bloco3 = elementosActivityTelaNovoLayout.bloco3
        val elementoLinearLayout3 = elementosActivityTelaNovoLayout.linearLayout3

        val constraintSet = ConstraintSet()
        val constraintSetOriginal = ConstraintSet()
        constraintSet.clone(elementosActivityTelaNovoLayout.contrainLayout0)
        constraintSetOriginal.clone(elementosActivityTelaNovoLayout.contrainLayout0)

        constraintSet.clear(bloco3.id)
        constraintSet.clear(elementoView1.id, ConstraintSet.TOP)
        constraintSet.clear(elementoLinearLayout3.id, ConstraintSet.START)
        constraintSet.connect(bloco3.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        constraintSet.connect(bloco3.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        constraintSet.connect(elementoView1.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)

        if(intent1 == null && intent2 == null && intent3 == null) State1()
        cont1 = intent1.toBoolean(); cont2 = intent2.toBoolean(); cont3 = intent3.toBoolean()

        var atualState: Boolean? = null //null = state 1 //false = state 2 //true = state 3

        var contadordeChatice = 0
        elementosActivityTelaNovoLayout.mudarStateNovoLayout.setOnClickListener {

            val transition = AutoTransition()

            transition.setDuration(1750)
            TransitionManager.beginDelayedTransition(elementosActivityTelaNovoLayout.contrainLayout0, transition)

            val textNomeLayout =
                elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto.text.toString()

            val (test, testNome) = VerificadorTelaNovoLayout(test1 = null, test2 = true, true)
            val test2 = bancoDeDados.verificadorPopulacaoProdutos(textNomeLayout, false)

            if (testNome) {
                if (!bancoDeDados.verificadorDeSemelhancasTelaNovoLayout(textNomeLayout) || test2) {
                    // State3()
                    atualState = true
                    constraintSetOriginal.applyTo(elementosActivityTelaNovoLayout.contrainLayout0)
                    eventoDeClickRecarregar(false)
                } else if (test) {
                    atualState = false
                    constraintSet.applyTo(elementosActivityTelaNovoLayout.contrainLayout0)
                    State2()
                }
            }
            val largura = elementosActivityTelaNovoLayout.larguraNovoLayoutCompleto
            if(atualState == null){
                if(!testNome && !test){ tooastTNL(getString(R.string.mensagem_multável_t_n_l_31), "️😑")
                } else if(!test){
                    val text = if(largura.text.toString().isEmpty() || largura.text.toString().toInt() < 250) getString(R.string.mensagem_multável_t_n_l_32) else {
                        largura.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso_purple)
                        contadordeChatice += 1
                        getString(R.string.mensagem_multável_t_n_l_24)
                    }
                    if(contadordeChatice < 3) tooastTNL(text, "🤨") else CaixaDeDialogoMutavelTNL(text, null, "", "")

                } else if(!testNome){ tooastTNL(getString(R.string.mensagem_multável_t_n_l_33), "☹️") }
            }else if(!atualState!!){
                if(!testNome && !test && !test2){ tooastTNL(getString(R.string.mensagem_multável_t_n_l_34), "️😤")
                } else if(!testNome && !test){ tooastTNL(getString(R.string.mensagem_multável_t_n_l_31), "️😑")
                } else if(!test){
                    val text = if(largura.text.toString().isEmpty() || largura.text.toString().toInt() < 250) getString(R.string.mensagem_multável_t_n_l_32) else {
                        largura.setBackgroundResource(R.drawable.container_fundo_branco_contorno_grosso_purple)
                        contadordeChatice += 1
                        getString(R.string.mensagem_multável_t_n_l_24)
                    };if(contadordeChatice <= 1) tooastTNL(text, "🤨") else CaixaDeDialogoMutavelTNL(text, null, "", "")
                } else if(!testNome){ tooastTNL(getString(R.string.mensagem_multável_t_n_l_33), "☹️")
                } else if(!test2){ tooastTNL(getString(R.string.mensagem_multável_t_n_l_35), "😔") }
            }
        }

        elementosActivityTelaNovoLayout.adicionarProdutoNovoLayoutCompleto.setOnClickListener {
            EventoDeClickNovoProduto()}

        elementosActivityTelaNovoLayout.recarregarIconeLayoutNovoLayoutCompleto.setOnClickListener {
            eventoDeClickRecarregar(false)}

        elementosActivityTelaNovoLayout.salvarNovoLayoutCompleto.setOnClickListener{
            EventoDeClickSalvar()}

        elementosActivityTelaNovoLayout.excluirNovoLayoutCompleto.setOnClickListener {
            EventoDeClickExcluir()}

        elementosActivityTelaNovoLayout.alturaView1.setOnClickListener {
            ClickSelectTNL(1)}
        elementosActivityTelaNovoLayout.larguraView2.setOnClickListener {
            ClickSelectTNL(2)}
        elementosActivityTelaNovoLayout.nomeView3.setOnClickListener {
            ClickSelectTNL(3)}

        elementosActivityTelaNovoLayout.composeSimplesNovoLayout.setOnClickListener {
            composeSelecionado = true; atualizarCmoposeSelecionado(composeSelecionado) }

        elementosActivityTelaNovoLayout.composeModeloAntigoNovoLayout.setOnClickListener {
            composeSelecionado = false; atualizarCmoposeSelecionado(composeSelecionado)}

        elementosActivityTelaNovoLayout.addNovoLayoutCompleto.setOnClickListener {
            if(multiplicador < 2){ multiplicador += 0.05f; eventoDeClickRecarregar(false)} }

        elementosActivityTelaNovoLayout.subNovoLayoutCompleto.setOnClickListener {
            if(multiplicador > 1){ multiplicador -= 0.05f; eventoDeClickRecarregar(false)} }

        adapterProdutosTelaNovoLayout = AdapterProdutosTelaNovoLayout()
        elementosActivityTelaNovoLayout.recyclerProdutosNovoLayoutCompleto.layoutManager = LinearLayoutManager(this)
        elementosActivityTelaNovoLayout.recyclerProdutosNovoLayoutCompleto.adapter = adapterProdutosTelaNovoLayout

        viewHolderProdutosTelaNovoLayout = ViewHolderProdutosTelaNovoLayout(elementosActivityTelaNovoLayout.root)
        viewHolderProdutosTelaNovoLayout.MovimentacaoSimplesProduto(elementosActivityTelaNovoLayout.recyclerProdutosNovoLayoutCompleto)
        if(!(bancoDeDados.verificadorDeSemelhancasTelaNovoLayout(intent.getStringExtra("nomeDoLayout").toString()))) TransicionarTelasTNL()
        AtualizarTextAvisoTNL()

        atualizarCmoposeSelecionado(composeSelecionado)

        elementosActivityTelaNovoLayout.switchi.setOnCheckedChangeListener { _, isChecked ->
            soun = isChecked
            eventoDeClickRecarregar(false)
        }
        VerificadorTelaNovoLayout(null, false, true)
        runnable = Runnable {
            VerificadorTelaNovoLayout(null, false, true)
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)

    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }
}
