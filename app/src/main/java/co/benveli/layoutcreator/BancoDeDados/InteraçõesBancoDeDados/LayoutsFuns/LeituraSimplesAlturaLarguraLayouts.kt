package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns

import android.database.Cursor
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.dBTabelaLayout
import co.benveli.layoutcreator.BancoDeDados.layoutNome
import co.benveli.layoutcreator.Objetos.Tecido

fun Db.LeituraSimplesAlturaLarguraLayouts(string: String):Tecido{

    var tecido = Tecido(0, 0)
    val sql = "SELECT * FROM $dBTabelaLayout WHERE $layoutNome = '$string'"
    val cursor: Cursor = this.readableDatabase.rawQuery(sql, null)
    if (cursor.count > 0) {
        while (cursor.moveToNext()) {
            tecido = Tecido(
                altura = cursor.getInt(0),
                largura = cursor.getInt(1),
            )
        };cursor.close()
        return tecido
    }else{
        tecido = Tecido(0, 0)
        return tecido}
}