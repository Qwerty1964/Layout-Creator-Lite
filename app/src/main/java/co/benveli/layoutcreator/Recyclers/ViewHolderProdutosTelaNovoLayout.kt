package co.benveli.layoutcreator.Recyclers

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.benveli.layoutcreator.Activitys.Funs.TooastGenerico
import co.benveli.layoutcreator.BancoDeDados.Db
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.LayoutsFuns.verificadorDeSemelhancasTelaNovoLayout
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.ExcluirProdutosDbTD
import co.benveli.layoutcreator.BancoDeDados.InteraçõesBancoDeDados.ProdutosFuns.verificadorPopulacaoProdutos
import co.benveli.layoutcreator.Objetos.Objetos
import co.benveli.layoutcreator.R

class ViewHolderProdutosTelaNovoLayout (view: View):RecyclerView.ViewHolder(view){

    var id = view.findViewById<TextView>(R.id.id_descricao_completa)
    var nome = view.findViewById<TextView>(R.id.nome_descricao_completa)
    var nomeLayoutPai = view.findViewById<TextView>(R.id.nome_layout_pai_descricao_completa)
    var quantidade = view.findViewById<TextView>(R.id.quantidade_descricao_completa)
    var altura = view.findViewById<TextView>(R.id.altura_descricao_completa)
    var largura = view.findViewById<TextView>(R.id.largura_descricao_completa)

    val helper =
        androidx.recyclerview.widget.ItemTouchHelper(
            ItemTouchHelper(androidx.recyclerview.widget.ItemTouchHelper.UP
                    or androidx.recyclerview.widget.ItemTouchHelper.DOWN,
                androidx.recyclerview.widget.ItemTouchHelper.RIGHT))

    inner class ItemTouchHelper(dragDirs: Int, swipeDirs: Int): androidx.recyclerview.
    widget.ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val adapterProdutosTelaNovoLayout = AdapterProdutosTelaNovoLayout()
            val from = viewHolder.adapterPosition
            val to = target.adapterPosition
            adapterProdutosTelaNovoLayout.notifyItemMoved(from, to)
        return true}

        override fun getSwipeDirs(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
            val context = viewHolder.itemView.context
            val nomeLayoutPai = viewHolder.itemView.findViewById<TextView>(R.id.nome_layout_pai_descricao_completa).text.toString()
            val bancoDeDados = Db(context)

            if (bancoDeDados.verificadorDeSemelhancasTelaNovoLayout(nomeLayoutPai)) {
                return super.getSwipeDirs(recyclerView, viewHolder)
            }else {
                return if (bancoDeDados.verificadorPopulacaoProdutos(nomeLayoutPai, false)) {
                    super.getSwipeDirs(recyclerView, viewHolder)
                }else{ 0 }}}

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            val context = viewHolder.itemView.context
            val textIdViewHolderAlterado = viewHolder.itemView.findViewById<TextView>(R.id.id_descricao_completa).text.toString().toInt()
            val bancoDeDados = Db(context)
            bancoDeDados.ExcluirProdutosDbTD(textIdViewHolderAlterado)

            TooastGenerico(context, context.getString(R.string.mensagem_multável_view_holder_1), "🗑")}}

    fun MovimentacaoSimplesProduto(recyclerView : RecyclerView) {
        helper.attachToRecyclerView(recyclerView) }

    fun PrintarItens(item: Objetos) {

        nome.text = item.objNome
        quantidade.text = item.objQuantidade.toString()
        altura.text = item.objAltura
        largura.text = item.objLargura
        id.text = item.id.toString()
        nomeLayoutPai.text = item.idRaiz
    }}
