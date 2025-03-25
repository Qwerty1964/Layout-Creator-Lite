package co.benveli.layoutcreator.Activitys.Funs.TDFuns

import android.R
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import co.benveli.layoutcreator.Activitys.TelaDeDescricao

fun TelaDeDescricao.SpinerTelaDeDescricao(){

    spiner.adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, TratamentoDeDadosSpinerTelaDeDescricao())

    spiner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            nomeSelecionadoSpinner = TratamentoDeDadosSpinerTelaDeDescricao()[position]
            AtualizarRecyclerTelaDeDescricao(nomeSelecionadoSpinner)
            TradutorCompiladorTelaDeDescrição(cont1, cont2, cont3, false)

        }override fun onNothingSelected(parent: AdapterView<*>?) {}
    }}
