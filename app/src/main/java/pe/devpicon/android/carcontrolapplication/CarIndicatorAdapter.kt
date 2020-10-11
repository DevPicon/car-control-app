package pe.devpicon.android.carcontrolapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import pe.devpicon.android.carcontrolapplication.databinding.ItemCarIndicatorBinding

class CarIndicatorAdapter : Adapter<CardIndicatorViewHolder>() {

    private val cardIndicatorList = mutableListOf<CarIndicatorViewState>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardIndicatorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCarIndicatorBinding = ItemCarIndicatorBinding.inflate(layoutInflater, parent, false)
        return CardIndicatorViewHolder(itemCarIndicatorBinding)
    }

    override fun onBindViewHolder(holder: CardIndicatorViewHolder, position: Int) {
        holder.bind(cardIndicatorList[position])
    }

    override fun getItemCount(): Int = cardIndicatorList.size

    fun updateCarIndicatorList(newCarIndicatorList: List<CarIndicatorViewState>) {
        cardIndicatorList.clear()
        cardIndicatorList.addAll(newCarIndicatorList)
        notifyDataSetChanged()
    }
}


class CardIndicatorViewHolder(val viewBinding: ItemCarIndicatorBinding) : ViewHolder(viewBinding.root) {
    fun bind(carIndicatorViewState: CarIndicatorViewState) {
        with(viewBinding) {
            tvIndicatorLabel.text = carIndicatorViewState.indicatorLabel
            tvIndicatorValue.text = carIndicatorViewState.indicatorValue
        }
    }
}