package samples.alert

import antd.alert.*
import react.*
import react.dom.*
import styled.*

fun RBuilder.description() {
    styledDiv {
        css { +AlertStyles.description }
        div {
            alert {
                attrs {
                    message = "Success Text"
                    description = "Success Description Success Description Success Description"
                    type = "success"
                }
            }
            alert {
                attrs {
                    message = "Info Text"
                    description = "Info Description Info Description Info Description Info Description"
                    type = "info"
                }
            }
            alert {
                attrs {
                    message = "Warning Text"
                    description = "Warning Description Warning Description Warning Description Warning Description"
                    type = "warning"
                }
            }
            alert {
                attrs {
                    message = "Error Text"
                    description = "Error Description Error Description Error Description Error Description"
                    type = "error"
                }
            }
        }
    }
}
