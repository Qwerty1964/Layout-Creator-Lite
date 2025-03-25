package co.benveli.layoutcreator.Activitys.Funs.ZLFuns

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import co.benveli.layoutcreator.Activitys.Funs.TooastGenerico
import co.benveli.layoutcreator.Activitys.ZomLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.LeiturasimplesBancoDeDadosTecidoComposable
import co.benveli.layoutcreator.Epacotamento2d.Chamadores.calcularEmpacotamento3
import co.benveli.layoutcreator.R

@ExperimentalMaterial3Api
fun ZomLayout.ClickSelect(int: Int, boolean: Boolean) {

    if (int == 1){
        if(cont1) {elementosZoomBinding.alturaView1.setBackgroundResource(R.drawable.ic_eye_1);cont1 =false}
        else{ elementosZoomBinding.alturaView1.setBackgroundResource(R.drawable.ic_eye_2); cont1 = true}
    } else if (int == 2){
        if(cont2) {elementosZoomBinding.larguraView2.setBackgroundResource(R.drawable.ic_eye_1); cont2 =false}
        else{ elementosZoomBinding.larguraView2.setBackgroundResource(R.drawable.ic_eye_2); cont2 = true}
    } else if (int == 3) {
        if (cont3) { elementosZoomBinding.nomeView3.setBackgroundResource(R.drawable.ic_eye_1); cont3 = false }
        else { elementosZoomBinding.nomeView3.setBackgroundResource(R.drawable.ic_eye_2); cont3 = true }
    }else if (int == 6){ if(cont6) { elementosZoomBinding.idView4.setBackgroundResource(R.drawable.ic_eye_1); cont6 =false }
        else{ elementosZoomBinding.idView4.setBackgroundResource(R.drawable.ic_eye_2); cont6 = true}
    } else if (int == 5){
        contador1 = 1f
        contador2 = 1f
    }

    val displayMetrics = this.resources.displayMetrics

    val screenWidthPx = displayMetrics.widthPixels
    val screenHeightPx = displayMetrics.heightPixels

    val density = displayMetrics.density

    val screenWidthDp = screenWidthPx / density
    val screenHeight = screenHeightPx / density

    val tecido = bancoDeDados.LeiturasimplesBancoDeDadosTecidoComposable(nomeLayoutPai)

    while((tecido.largura * contador2) > (screenWidthDp - 70) || (tecido.altura * contador2) > (screenHeight - 300)){
        contador2 -= 0.10f
    }

     calcularEmpacotamento3(tecido, nomeLayoutPai, false, contador2, cont1,
        cont2, cont3, contador1, cont6, elementosZoomBinding.switch1.isChecked,
         visibleOrInvisibleSave)


}