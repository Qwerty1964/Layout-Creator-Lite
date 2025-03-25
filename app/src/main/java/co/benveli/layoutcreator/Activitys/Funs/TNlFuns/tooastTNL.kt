@file:Suppress("DEPRECATION")
package co.benveli.layoutcreator.Activitys.Funs.TNlFuns

import android.widget.TextView
import android.widget.Toast
import co.benveli.layoutcreator.Activitys.TelaNovoLayout
import co.benveli.layoutcreator.R

fun TelaNovoLayout.tooastTNL(msg: String, emoji: String) {
    val inflater = layoutInflater
    val layout = inflater.inflate(R.layout.toast_simples, null)

    layout.findViewById<TextView>(R.id.msg).text = msg
    layout.findViewById<TextView>(R.id.emoji).text = emoji

    val toast = Toast(applicationContext)
    toast.view = layout
    toast.duration = Toast.LENGTH_LONG
    toast.show()
}