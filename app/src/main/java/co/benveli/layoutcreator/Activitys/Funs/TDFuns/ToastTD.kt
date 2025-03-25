@file:Suppress("DEPRECATION")
package co.benveli.layoutcreator.Activitys.Funs.TDFuns

import android.widget.TextView
import android.widget.Toast
import co.benveli.layoutcreator.Activitys.TelaDeDescricao
import co.benveli.layoutcreator.R

fun TelaDeDescricao.tooastTD(msg: String, emoji: String) {
    val inflater = layoutInflater
    val layout = inflater.inflate(R.layout.toast_simples, null)

    layout.findViewById<TextView>(R.id.msg).text = msg
    layout.findViewById<TextView>(R.id.emoji).text = emoji

    val toast = Toast(applicationContext)
    toast.view = layout
    toast.duration = Toast.LENGTH_LONG
    toast.show()
}