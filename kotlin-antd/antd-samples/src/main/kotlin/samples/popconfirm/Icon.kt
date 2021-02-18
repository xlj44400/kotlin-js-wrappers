package samples.popconfirm

import antd.icon.*
import antd.popconfirm.*
import kotlinext.js.*
import react.*
import react.dom.*
import styled.*

fun RBuilder.icon() {
    styledDiv {
        css { +PopconfirmStyles.icon }
        popconfirm {
            attrs {
                title = "Are you sure？"
                icon = buildElement {
                    questionCircleOutlined {
                        attrs.style = js { color = "red" }
                    }
                }
            }
            a {
                attrs.href = "#"
                +"Delete"
            }
        }
    }
}
