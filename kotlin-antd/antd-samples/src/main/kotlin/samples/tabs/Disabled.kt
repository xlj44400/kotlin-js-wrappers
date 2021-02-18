package samples.tabs

import antd.tabs.*
import react.*
import styled.*

fun RBuilder.disabled() {
    styledDiv {
        css { +TabsStyles.disabled }
        tabs {
            attrs.defaultActiveKey = "1"
            tabPane {
                attrs {
                    tab = "Tab 1"
                    key = "1"
                }
                +"Content of Tab Pane 1"
            }
            tabPane {
                attrs {
                    tab = "Tab 2"
                    disabled = true
                    key = "2"
                }
                +"Content of Tab Pane 2"
            }
            tabPane {
                attrs {
                    tab = "Tab 3"
                    key = "3"
                }
                +"Content of Tab Pane 3"
            }
        }
    }
}
