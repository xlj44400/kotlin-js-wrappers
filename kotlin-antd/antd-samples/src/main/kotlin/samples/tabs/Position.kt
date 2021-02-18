package samples.tabs

import antd.select.*
import antd.select.option
import antd.tabs.*
import kotlinext.js.*
import react.*
import react.dom.div
import react.dom.jsStyle
import styled.*

interface PositionDemoState : RState {
    var tabPosition: String
}

class PositionDemo : RComponent<RProps, PositionDemoState>() {
    private val changeTabPosition = fun(value: SelectValue, _: Any) {
        setState {
            tabPosition = value.unsafeCast<String>()
        }
    }

    override fun PositionDemoState.init() {
        tabPosition = "top"
    }

    override fun RBuilder.render() {
        div {
            div {
                attrs.jsStyle = js { marginBottom = 16 }
                +"Tab position："
                select<String, SelectComponent<String>> {
                    attrs {
                        value = state.tabPosition
                        onChange = changeTabPosition
                        dropdownMatchSelectWidth = false
                    }
                    option {
                        attrs.value = "top"
                        +"top"
                    }
                    option {
                        attrs.value = "bottom"
                        +"bottom"
                    }
                    option {
                        attrs.value = "left"
                        +"left"
                    }
                    option {
                        attrs.value = "right"
                        +"right"
                    }
                }
            }
            tabs {
                attrs.tabPosition = state.tabPosition
                tabPane {
                    attrs {
                        tab = "Tab 1"
                        key = "1"
                    }
                    +"Content of tab 1"
                }
                tabPane {
                    attrs {
                        tab = "Tab 2"
                        key = "2"
                    }
                    +"Content of tab 2"
                }
                tabPane {
                    attrs {
                        tab = "Tab 3"
                        key = "3"
                    }
                    +"Content of tab 3"
                }
            }
        }
    }
}

fun RBuilder.positionDemo() = child(PositionDemo::class) {}

fun RBuilder.position() {
    styledDiv {
        css { +TabsStyles.position }
        positionDemo()
    }
}
