package samples.spin

import antd.alert.*
import antd.spin.*
import antd.switch.*
import kotlinext.js.*
import org.w3c.dom.events.*
import react.*
import react.dom.*
import styled.*

interface NestedCardState : RState {
    var loading: Boolean
}

class NestedCard : RComponent<RProps, NestedCardState>() {
    private val toggle = fun(value: Boolean, _: MouseEvent) {
        setState {
            loading = value
        }
    }

    override fun NestedCardState.init() {
        loading = false
    }

    override fun RBuilder.render() {
        div {
            spin {
                attrs.spinning = state.loading
                alert {
                    attrs {
                        message = "Alert message title"
                        description = "Further details about the context of this alert."
                        type = "info"
                    }
                }
            }
            div {
                attrs.jsStyle = js { marginTop = 16 }
                +"Loading state："
                switch {
                    attrs {
                        checked = state.loading
                        onChange = toggle
                    }
                }
            }
        }
    }
}

fun RBuilder.nestedCard() = child(NestedCard::class) {}

fun RBuilder.nested() {
    styledDiv {
        css { +SpinStyles.nested }
        nestedCard()
    }
}
