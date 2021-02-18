package samples.datepicker

import antd.datepicker.*
import moment.*
import react.*
import react.dom.*
import styled.*

interface ControlledDatePickerState : RState {
    var mode: PanelMode
}

class ControlledDatePicker : RComponent<RProps, ControlledDatePickerState>() {
    private val handleOpenChange = fun(open: Boolean) {
        if (open) {
            setState {
                mode = "time"
            }
        }
    }

    private val handlePanelChange = fun(_: Moment?, newMode: PanelMode?) {
        setState {
            mode = newMode!!
        }
    }

    override fun ControlledDatePickerState.init() {
        mode = "time"
    }

    override fun RBuilder.render() {
        datePicker {
            attrs {
                mode = state.mode
                showTime = true
                onOpenChange = handleOpenChange
                onPanelChange = handlePanelChange
            }
        }
    }
}

fun RBuilder.controlledDatePicker() = child(ControlledDatePicker::class) {}

interface ControlledRangePickerState : RState {
    var mode: Any
    var value: RangeValue<Moment>
}

class ControlledRangePicker : RComponent<RProps, ControlledRangePickerState>() {
    private val handlePanelChange = fun(newValue: RangeValue<Moment>?, newMode: Any?) {
        val currentMode = newMode.unsafeCast<Array<String>>()

        setState {
            value = newValue!!
            mode = arrayOf(
                if (currentMode[0] == "date") "month" else currentMode[0],
                if (currentMode[1] == "date") "month" else currentMode[1]
            )
        }
    }

    private val handleChange = fun(newValue: RangeValue<Moment>?, _: Any?) {
        setState {
            value = newValue!!
        }
    }

    override fun ControlledRangePickerState.init() {
        mode = arrayOf("month", "month")
        value = emptyArray<RangeValue<Moment>>().unsafeCast<RangeValue<Moment>>()
    }

    override fun RBuilder.render() {
        rangePicker {
            attrs {
                placeholder = arrayOf("Start month", "End month")
                format = "YYYY-MM"
                value = state.value
                mode = state.mode
                onChange = handleChange
                onPanelChange = handlePanelChange
            }
        }
    }
}

fun RBuilder.controlledRangePicker() = child(ControlledRangePicker::class) {}

fun RBuilder.mode() {
    styledDiv {
        css { +DatePickerStyles.mode }
        div {
            controlledDatePicker()
            br {}
            controlledRangePicker()
        }
    }
}
