package co.benveli.layoutcreator.Recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.benveli.layoutcreator.Objetos.Objetos
import co.benveli.layoutcreator.R

class AdapterProdutosTelaNovoLayout: RecyclerView.Adapter<ViewHolderProdutosTelaNovoLayout>() {

    private var item = listOf<Objetos>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderProdutosTelaNovoLayout {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.descricao_completa_recycler_view, parent, false)
        return ViewHolderProdutosTelaNovoLayout(view)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolderProdutosTelaNovoLayout, position: Int) {
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