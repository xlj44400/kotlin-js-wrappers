package samples.alert

import antd.*
import antd.alert.*
import org.w3c.dom.*
import react.*
import react.dom.*
import styled.*

private val handleCLose: MouseEventHandler<HTMLAnchorElement> = { e ->
    console.log(e, "I was closed.")
}

fun RBuilder.closable() {
    styledDiv {
        css { +AlertStyles.closable }
        div {
            alert {
                attrs {
                    message = "Warning Text Warning Text Warning TextW arning Text Warning Text Warning TextWarning Text"
                    type = "warning"
                    closable = true
                    onClose = handleCLose
                }
            }
            alert {
                attrs {
                    message = "Error Text"
                    description = "Error Description Error Description Error Description Error Description Error Description Error Description"
                    type = "error"
                    closable = true
                    onClose = handleCLose
                }
            }
        }
    }
}
