package pe.devpicon.android.carcontrolapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import pe.devpicon.android.carcontrolapplication.IndicatorType.BONNET
import pe.devpicon.android.carcontrolapplication.IndicatorType.OTHERS
import pe.devpicon.android.carcontrolapplication.IndicatorType.WHEELS
import pe.devpicon.android.carcontrolapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewBinding: ActivityMainBinding
    private val customAdapter: CarIndicatorAdapter by lazy {
        CarIndicatorAdapter()
    }

    private lateinit var dummyList: ArrayList<CarIndicatorViewState>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainViewBinding.root)

        populateList()
        configRecyclerView()
        configButtons()
    }

    private fun populateList() {
        dummyList = arrayListOf(
                CarIndicatorViewState(
                        getString(R.string.label_oil_remaining),
                        0,
                        1,
                        BONNET
                ),
                CarIndicatorViewState(
                        getString(R.string.label_brake_fluid),
                        1,
                        1,
                        WHEELS
                ),
                CarIndicatorViewState(
                        getString(R.string.label_coolant),
                        1,
                        1,
                        BONNET
                ),
                CarIndicatorViewState(
                        getString(R.string.label_fuel_range),
                        0,
                        1,
                        OTHERS
                )
        )
    }

    private fun configButtons() {

        with(mainViewBinding) {
            bnvMenu.setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_item_summary -> {
                        motionMain.transitionToState(R.id.summary)
                        customAdapter.updateCarIndicatorList(dummyList)
                        customAdapter.notifyDataSetChanged()
                        true
                    }
                    R.id.menu_item_bonnet -> {
                        motionMain.transitionToState(R.id.bonnet)
                        customAdapter.updateCarIndicatorList(dummyList.filter { it.indicatorType == BONNET })
                        customAdapter.notifyDataSetChanged()
                        true
                    }
                    R.id.menu_item_wheels -> {
                        motionMain.transitionToState(R.id.wheels)
                        customAdapter.updateCarIndicatorList(dummyList.filter { it.indicatorType == WHEELS })
                        customAdapter.notifyDataSetChanged()
                        true
                    }
                    else -> false
                }
            }
        }


    }

    private fun configRecyclerView() {
        mainViewBinding.rvIndicators.adapter = customAdapter.apply {
            this.updateCarIndicatorList(
                    dummyList
            )
        }
        mainViewBinding.rvIndicators.layoutManager = LinearLayoutManager(this)
    }
}