package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import android.annotation.SuppressLint
import androidx.constraintlayout.widget.ConstraintSet
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.R

@SuppressLint("UseSwitchCompatOrMaterialCode")
fun TelaNovoLayout.State2() {

    val bloco3 = elementosActivityTelaNovoLayout.bloco3
    val sswitch = elementosActivityTelaNovoLayout.switchi
    val elementoLinearLayout3 = elementosActivityTelaNovoLayout.linearLayout3
    val elementoTxtAviso3 = elementosActivityTelaNovoLayout.textAviso3NovoLayout
    val elementoRecyclerView = elementosActivityTelaNovoLayout.recyclerProdutosNovoLayoutCompleto

    val constraintSet = ConstraintSet()


    constraintSetOriginais = constraintSet.clone(elementosActivityTelaNovoLayout.contrainLayout0)

    constraintSet.clear(bloco3.id)
    constraintSet.clear(elementoLinearLayout3.id, ConstraintSet.START)
    constraintSet.clear(elementoTxtAviso3.id, ConstraintSet.BOTTOM)

    constraintSet.connect(
        elementoLinearLayout3.id,
        ConstraintSet.START,
        ConstraintSet.PARENT_ID,
        ConstraintSet.START
    )

    constraintSet.connect(
        elementoLinearLayout3.id,
        ConstraintSet.END,
        ConstraintSet.PARENT_ID,
        ConstraintSet.END
    )

    constraintSet.connect(
        elementoLinearLayout3.id,
        ConstraintSet.TOP,
        elementoTxtAviso3.id,
        ConstraintSet.BOTTOM,
    )

    constraintSet.connect(
        bloco3.id,
        ConstraintSet.END,
        ConstraintSet.PARENT_ID,
        ConstraintSet.START
    )

    constraintSet.connect(
        sswitch.id,
        ConstraintSet.START,
        ConstraintSet.PARENT_ID,
        ConstraintSet.END
    )

    constraintSet.connect(
        elementoTxtAviso3.id,
        ConstraintSet.TOP,
        elementoRecyclerView.id,
        ConstraintSet.BOTTOM
    )

    elementoTxtAviso3.text = getString(R.string.mensagem_multável_t_n_l_30)

    constraintSet.applyTo(elementosActivityTelaNovoLayout.contrainLayout0)
}