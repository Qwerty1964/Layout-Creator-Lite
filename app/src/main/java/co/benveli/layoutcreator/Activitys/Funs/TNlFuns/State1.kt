package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import android.annotation.SuppressLint
import androidx.constraintlayout.widget.ConstraintSet
import co.benveli.layoutcreator.Activitys.TelaNovoLayout

@SuppressLint("UseSwitchCompatOrMaterialCode")
fun TelaNovoLayout.State1() {
    val constraintSet = ConstraintSet()

    val elementoNomeLayout = elementosActivityTelaNovoLayout.nomeLayoutNovoLayoutCompleto
    val elementoTexProduto = elementosActivityTelaNovoLayout.textProdutosTnl
    val elementoView3 = elementosActivityTelaNovoLayout.view3
    val elementoView1 = elementosActivityTelaNovoLayout.view1
    val elementoView1Clone = elementosActivityTelaNovoLayout.view1Clone
    val bloco3 = elementosActivityTelaNovoLayout.bloco3
    val sswitch = elementosActivityTelaNovoLayout.switchi
    val elementoLinearLayout3 = elementosActivityTelaNovoLayout.linearLayout3

    constraintSet.clone(elementosActivityTelaNovoLayout.contrainLayout0)

    constraintSet.clear(bloco3.id)
    constraintSet.clear(elementoLinearLayout3.id, ConstraintSet.START)

    constraintSet.connect(
        elementoNomeLayout.id,
        ConstraintSet.BOTTOM,
        ConstraintSet.PARENT_ID,
        ConstraintSet.BOTTOM,
    )

    constraintSet.connect(
        elementoTexProduto.id,
        ConstraintSet.END,
        ConstraintSet.PARENT_ID,
        ConstraintSet.START
    )

    constraintSet.connect(
        elementoView3.id,
        ConstraintSet.END,
        ConstraintSet.PARENT_ID,
        ConstraintSet.START,
    )

    constraintSet.connect(
        bloco3.id,
        ConstraintSet.END,
        ConstraintSet.PARENT_ID,
        ConstraintSet.START
    )

    constraintSet.connect(
        bloco3.id,
        ConstraintSet.TOP,
        ConstraintSet.PARENT_ID,
        ConstraintSet.TOP
    )

    constraintSet.connect(
        sswitch.id,
        ConstraintSet.START,
        ConstraintSet.PARENT_ID,
        ConstraintSet.END
    )

    constraintSet.connect(
        elementoView1.id,
        ConstraintSet.TOP,
        elementoView1Clone.id,
        ConstraintSet.BOTTOM
    )

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

    constraintSet.applyTo(elementosActivityTelaNovoLayout.contrainLayout0)

}