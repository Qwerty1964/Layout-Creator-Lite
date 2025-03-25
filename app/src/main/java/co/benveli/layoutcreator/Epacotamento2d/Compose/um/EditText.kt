@file:Suppress("DEPRECATION")
package co.benveli.layoutcreator.Epacotamento2d.Compose.um

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.benveli.layoutcreator.R

@ExperimentalMaterial3Api
@Composable
fun editText(hint: String,
             modifier: Modifier,
             boolean: Boolean,
             test: Boolean
): String {
    var text by remember { mutableStateOf("") }
    val test2 = try {text.toInt() <= 0} catch (e:Exception){false}
    var isFocused by remember { mutableStateOf(false) }
    TextField(
        value = text,
        onValueChange = { newValue ->
            if (boolean && newValue.length <= 3 && newValue.all { it.isDigit() }) {
                text = newValue
            } else if (!boolean && newValue.length <= 15) text = newValue
        },
        modifier = modifier
            .onFocusChanged { isFocused = it.isFocused }
            .background(Color.White)
            .border(7.dp, if (test || test2) colorResource(id = R.color.cinza) else Color.Black)
            .size(150.dp, 80.dp),
        label = {
            AnimatedVisibility(visible = !isFocused && text.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                ) {
                    Text(
                        text = hint,
                        fontFamily = FontFamily(Font(R.font.sugo_display)),
                        fontSize = 20.sp
                    )
                }
            }
        },
        textStyle = TextStyle(
            fontSize = 25.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
        ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
        ),
        singleLine = true,

        )
    return text
}