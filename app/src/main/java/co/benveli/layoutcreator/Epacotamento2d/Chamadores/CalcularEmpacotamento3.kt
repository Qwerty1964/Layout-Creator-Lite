package co.benveli.layoutcreator.Epacotamento2d.Chamadores

import androidx.compose.material3.ExperimentalMaterial3Api
import co.benveli.layoutcreator.Activitys.ZomLayout
import co.benveli.layoutcreator.Epacotamento2d.Compose.um.TesteVizualizarTecido
import co.benveli.layoutcreator.Epacotamento2d.Lógica.VerificadorPopulacaoEmpacotamento2D
import co.benveli.layoutcreator.Objetos.Tecido

@ExperimentalMaterial3Api
fun ZomLayout.calcularEmpacotamento3(
    tecido: Tecido, idRaiz: String, inverterDimensoes: Boolean, multiplicador: Float
    , test1:Boolean, test2:Boolean, test3:Boolean,
    multiplicador2: Float, test6: Boolean,
    test8: Boolean, visibleOrInvisibleSave: Boolean): Boolean{

    var retorto = false

    elementosZoomBinding.composableZoom.setContent {
        retorto = TesteVizualizarTecido(
            tecido,
            inverterDimensoes,
            multiplicador,
            test1,
            test2,
            test3,
            multiplicador2,
            this,
            test6,
            idRaiz,
            test8,
            visibleOrInvisibleSave
        )
    }

    return retorto
}