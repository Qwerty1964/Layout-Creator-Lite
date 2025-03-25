package co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns

import androidx.core.content.contentValuesOf
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.Objetos.Objetos
import co.benveli.layoutcreator.BancoDeDados.dBTabelaLayout
import co.benveli.layoutcreator.BancoDeDados.layoutAltura
import co.benveli.layoutcreator.BancoDeDados.layoutLargura
import co.benveli.layoutcreator.BancoDeDados.layoutNome

fun Db.SalvarLayouts(listItem: Objetos):Long{

    return writableDatabase.insert(dBTabelaLayout, null, contentValuesOf().apply {

        put(layoutAltura, listItem.objAltura)
        put(layoutLargura, listItem.objLargura)
        put(layoutNome, listItem.objNome)
    })

}