package co.benveli.layoutcreator.Activitys

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import co.benveli.layoutcreator.Activitys.Funs.TooastGenerico
import co.benveli.layoutcreator.Activitys.Funs.ZLFuns.ClickSelect
import co.benveli.layoutcreator.Activitys.Funs.ZLFuns.VerificarEyesZL
import co.benveli.layoutcreator.Activitys.Funs.ZLFuns.VisibilityorProduct
import co.benveli.layoutcreator.Activitys.Funs.ZLFuns.VisibilityorSave
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.Objetos.CordenadasLivres
import co.benveli.layoutcreator.R
import co.benveli.layoutcreator.databinding.ActivityZomLayoutBinding
class ZomLayout : AppCompatActivity() {

    lateinit var elementosZoomBinding: ActivityZomLayoutBinding
    lateinit var bancoDeDados: Db
    var contador1 = 1f
    var contador2 = 2f

    lateinit var nomeLayoutPai: String
    var cont1 = true; var cont2 = true; var cont3 = true; var cont6 = true
    var visibleOrInvisibleSave = true; var visibleOrInvisibleProduct = true

    var mapaSimples = mutableListOf<CordenadasLivres>()
    var idProdutoSelecionado: Int? = null

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        elementosZoomBinding = ActivityZomLayoutBinding.inflate(layoutInflater)
        setContentView(elementosZoomBinding.root)

        try{ cont1 = intent.getStringExtra("cont1").toBoolean()
            cont2 = intent.getStringExtra("cont2").toBoolean()
            cont3 = intent.getStringExtra("cont3").toBoolean()
            VerificarEyesZL()
        }catch (e: Exception){}

        nomeLayoutPai = intent.getStringExtra("nomeDoLayout").toString()

        bancoDeDados = Db(this)

        elementosZoomBinding.btnAddZoom.setOnClickListener{ contador2 += 0.05f
            ClickSelect(0, true) }
        elementosZoomBinding.btnSubZoom.setOnClickListener{ contador2 -= 0.05f
            ClickSelect(0, true) }
        elementosZoomBinding.btnAddFont.setOnClickListener{ contador1 += 0.15f
            ClickSelect(0, true) }
        elementosZoomBinding.btnSubFont.setOnClickListener{ contador1 -= 0.15f
            ClickSelect(0, true) }

        elementosZoomBinding.textZoom.setOnClickListener {
            TooastGenerico(this, getString(R.string.use_os_botoes_dos_lados_z_l), "😉")}

        elementosZoomBinding.alturaView1.setOnClickListener {
            ClickSelect(1, false)}

        elementosZoomBinding.larguraView2.setOnClickListener {
            ClickSelect(2, false)}

        elementosZoomBinding.nomeView3.setOnClickListener {
            ClickSelect(3, false)}

        elementosZoomBinding.textZoom.setOnClickListener {
            ClickSelect(4, true)}

        elementosZoomBinding.textFont.setOnClickListener {
            ClickSelect(4, false)}

        elementosZoomBinding.btnResetar.setOnClickListener {
            ClickSelect(5, false)}

        elementosZoomBinding.idView4.setOnClickListener {
            ClickSelect(6, false)}

        elementosZoomBinding.switch1.setOnClickListener {
            ClickSelect(0, false)}

        elementosZoomBinding.auxiliar1.setOnClickListener{
            VisibilityorSave()
            ClickSelect(0, false)
        }

        elementosZoomBinding.auxiliar2.setOnClickListener{
            VisibilityorProduct(true)
            ClickSelect(0, false)
        }

        /*
        essa Função deveria fazer o compose ser desenhado com a caixa de adição de produtos aberta,
        mas quebrou (03/02/25)
        try{
            if(intent.getStringExtra("verificador").toBoolean()) visibleOrInvisibleProduct = false
            ClickSelect(0, false)
        }catch (e:Exception){}
        */
        if(!visibleOrInvisibleProduct)VisibilityorProduct(true)

        ClickSelect(0, false)
    }


}