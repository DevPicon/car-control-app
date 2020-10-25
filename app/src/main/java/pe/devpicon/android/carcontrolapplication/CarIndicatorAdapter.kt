package pe.devpicon.android.carcontrolapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.widget.TextViewCompat
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
            when (carIndicatorViewState.indicatorValue) {
                0 -> {
                    tvIndicatorValue.text = viewBinding.root.context.getString(R.string.label_normal)
                    TextViewCompat.setTextAppearance(tvIndicatorValue, R.style.indicator_level_normal)
                }

                1 -> {
                    tvIndicatorValue.text = viewBinding.root.context.getString(R.string.label_low)
                    TextViewCompat.setTextAppearance(tvIndicatorValue, R.style.indicator_level_low)
                }
                else -> tvIndicatorValue.text = "N/A"
            }

            motionItem.setTransitionDuration(5000)
            motionItem.transitionToState(R.id.item_end)
        }

    }
}