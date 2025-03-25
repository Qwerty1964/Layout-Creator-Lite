package co.benveli.layoutcreator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import co.benveli.layoutcreator.Activitys.Funs.TooastGenerico
import co.benveli.layoutcreator.Activitys.TelaDeDescricao
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.TesteDePopulacaoTabelaLayouts
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.verificadorDeSemelhancasTelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.LayoutExemplo
import co.benveli.layoutcreator.databinding.ActivityTelaDeEntrada2Binding

class TelaDeEntrada : AppCompatActivity() {

    private lateinit var elementosActivityTelaDeEntrada: ActivityTelaDeEntrada2Binding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        elementosActivityTelaDeEntrada = ActivityTelaDeEntrada2Binding.inflate(layoutInflater)
        setContentView(elementosActivityTelaDeEntrada.root)

        val bancoDeDados = Db(this)

        if(bancoDeDados.verificadorDeSemelhancasTelaNovoLayout("Bolsa")){
        bancoDeDados.LayoutExemplo()}

        elementosActivityTelaDeEntrada.novoLayout.setOnClickListener {
            val intent = Intent(this, TelaNovoLayout::class.java)
            startActivity(intent) }

        elementosActivityTelaDeEntrada.savesTelaDeEntrada.setOnClickListener {
            if(bancoDeDados.TesteDePopulacaoTabelaLayouts()){
                val intent = Intent(this, TelaDeDescricao::class.java); startActivity(intent)}
            else TooastGenerico(this,getString(R.string.salve_um_layout_antes_TE), "🤓") }}}

//Sem necessidade de Fazer uma pasta click.