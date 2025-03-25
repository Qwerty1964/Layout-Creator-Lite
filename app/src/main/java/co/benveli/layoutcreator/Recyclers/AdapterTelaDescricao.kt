package co.benveli.layoutcreator.Recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.benveli.layoutcreator.Objetos.Objetos
import co.benveli.layoutcreator.R

class AdapterTelaDescricao: RecyclerView.Adapter<ViewHolderTelaDescricao>() {

    private var item = listOf<Objetos>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderTelaDescricao {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.descricao_completa_recycler_view, parent, false)
        return ViewHolderTelaDescricao(view)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolderTelaDescricao, position: Int) {
        holder.PrintarItens(item[position])
    }

    fun AtualizarItems(novoItem: List<Objetos>){
        item = novoItem
        notifyDataSetChanged()
    }

    fun limparItens() {
        item = emptyList()
        notifyDataSetChanged()

    }


}