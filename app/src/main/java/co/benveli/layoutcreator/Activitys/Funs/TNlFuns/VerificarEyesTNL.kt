package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.R

fun TelaNovoLayout.VerificarEyesTNL() {

    val cont4 = if(cont1) true else false
    val cont5 = if(cont2) true else false
    val cont6 = if(cont3) true else false

    if(cont4) {elementosActivityTelaNovoLayout.alturaView1.setBackgroundResource(R.drawable.ic_eye_1);cont1 =false}
    else{ elementosActivityTelaNovoLayout.alturaView1.setBackgroundResource(R.drawable.ic_eye_2); cont1 = true}
    if(cont5) {elementosActivityTelaNovoLayout.larguraView2.setBackgroundResource(R.drawable.ic_eye_1);cont2 =false}
    else{ elementosActivityTelaNovoLayout.larguraView2.setBackgroundResource(R.drawable.ic_eye_2); cont2 = true}
    if(cont6) {elementosActivityTelaNovoLayout.nomeView3.setBackgroundResource(R.drawable.ic_eye_1);cont3 =false}
    else{ elementosActivityTelaNovoLayout.nomeView3.setBackgroundResource(R.drawable.ic_eye_2); cont3 = true}
}