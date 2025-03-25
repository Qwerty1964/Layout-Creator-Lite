package co.benveli.layoutcreator.Activitys.Funs

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import co.benveli.layoutcreator.R

fun TooastGenerico(context: Context, msg: String, emoji: String) {
    val inflater = LayoutInflater.from(context)
    val layout = inflater.inflate(R.layout.toast_simples, null)

    layout.findViewById<TextView>(R.id.msg).text = msg
    layout.findViewById<TextView>(R.id.emoji).text = emoji

    val toast = Toast(context)
    toast.view = layout
    toast.duration = Toast.LENGTH_LONG
    toast.show()
}