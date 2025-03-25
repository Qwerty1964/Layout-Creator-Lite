package co.benveli.layoutcreator.Activitys.Funs.ZLFuns

import co.benveli.layoutcreator.Activitys.ZomLayout
import co.benveli.layoutcreator.R

fun ZomLayout.VerificarEyesZL() {
    if(cont1) {elementosZoomBinding.alturaView1.setBackgroundResource(R.drawable.ic_eye_1);cont1 =false}
    else{ elementosZoomBinding.alturaView1.setBackgroundResource(R.drawable.ic_eye_2); cont1 = true}
    if(cont2) {elementosZoomBinding.larguraView2.setBackgroundResource(R.drawable.ic_eye_1);cont2 =false}
    else{ elementosZoomBinding.larguraView2.setBackgroundResource(R.drawable.ic_eye_2); cont2 = true}
    if(cont3) {elementosZoomBinding.nomeView3.setBackgroundResource(R.drawable.ic_eye_1);cont3 =false}
    else{ elementosZoomBinding.idView4.setBackgroundResource(R.drawable.ic_eye_2); cont3 = true}

    if(cont6) {elementosZoomBinding.idView4.setBackgroundResource(R.drawable.ic_eye_1);cont6 =false}
    else{ elementosZoomBinding.idView4.setBackgroundResource(R.drawable.ic_eye_2); cont6 = true}
}