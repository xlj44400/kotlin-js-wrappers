package samples.progress

import antd.progress.progress
import react.*
import react.dom.div
import styled.*

fun RBuilder.line() {
    styledDiv {
        css { +ProgressStyles.line }
        div {
            progress {
                attrs.percent = 30
            }
            progress {
                attrs {
                    percent = 50
                    status = "active"
                }
            }
            progress {
                attrs {
                    percent = 70
                    status = "exception"
                }
            }
            progress {
                attrs.percent = 100
            }
            progress {
                attrs {
                    percent = 50
                    showInfo = false
                }
            }
        }
    }
}
