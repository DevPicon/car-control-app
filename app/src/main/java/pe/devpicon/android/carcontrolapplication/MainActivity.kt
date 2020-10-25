package pe.devpicon.android.carcontrolapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import pe.devpicon.android.carcontrolapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainViewBinding.root)

        configRecyclerView()
        configButtons()
    }

    private fun configButtons() {

        with(mainViewBinding) {
            bnvMenu.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_item_summary -> {
                        motionMain.transitionToState(R.id.summary)
                        true
                    }
                    R.id.menu_item_bonnet -> {
                        motionMain.transitionToState(R.id.bonnet)
                        true
                    }
                    R.id.menu_item_wheels -> {
                        motionMain.transitionToState(R.id.wheels)
                        true
                    }
                    else -> false
                }
            }
        }


    }

    private fun configRecyclerView() {
        mainViewBinding.rvIndicators.adapter = CarIndicatorAdapter().apply {
            this.updateCarIndicatorList(
                    listOf(
                            CarIndicatorViewState(
                                    getString(R.string.label_oil_remaining),
                                    getString(R.string.label_low),
                                    1
                            ),
                            CarIndicatorViewState(
                                    getString(R.string.label_oil_remaining),
                                    getString(R.string.label_normal),
                                    1
                            ),
                            CarIndicatorViewState(
                                    getString(R.string.label_oil_remaining),
                                    getString(R.string.label_low),
                                    1
                            ),
                            CarIndicatorViewState(
                                    getString(R.string.label_oil_remaining),
                                    getString(R.string.label_low),
                                    1
                            )
                    )
            )
        }
        mainViewBinding.rvIndicators.layoutManager = LinearLayoutManager(this)
    }
}