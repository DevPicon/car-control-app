package pe.devpicon.android.carcontrolapplication

data class CarIndicatorViewState(
        val indicatorLabel: String,
        val indicatorValue: Int,
        val indicatorIcon: Int,
        val indicatorType: IndicatorType
)


enum class IndicatorType {
    BONNET, WHEELS, OTHERS
}