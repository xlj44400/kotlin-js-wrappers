package samples.timepicker

import react.*
import react.dom.*
import styled.*

object TimePickerStyles : StyleSheet("time-picker", isStatic = true) {
    val container by css {}
    val basic by css {}
    val size by css {}
    val hideColumn by css {}
    val addon by css {}
    val value by css {}
    val disabled by css {}
    val intervalOptions by css {}
    val hours12 by css {}
    val suffix by css {}
}

class TimePickerApp : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        h2 { +"TimePicker" }
        styledDiv {
            css { +TimePickerStyles.container }
            basic()
            size()
            hideColumn()
            addon()
            value()
            disabled()
            intervalOptions()
            hours12()
            suffix()
        }
    }
}

fun RBuilder.timePickerApp() = child(TimePickerApp::class) {}
