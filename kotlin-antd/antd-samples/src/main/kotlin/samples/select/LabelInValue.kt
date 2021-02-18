package samples.select

import antd.select.LabeledValue
import antd.select.SelectComponent
import antd.select.select
import kotlinext.js.*
import react.*
import react.dom.*
import styled.*

private fun handleChange(value: LabeledValue, option: Any) {
    console.log(value)  // { key: "lucy", label: "Lucy (101)" }
}

fun RBuilder.labelInValue() {
    styledDiv {
        css { +SelectStyles.labelInValue }
        select<LabeledValue, SelectComponent<LabeledValue>> {
            attrs {
                labelInValue = true
                defaultValue = jsObject { key = "lucy" }
                style = js { width = 120 }
                onChange = ::handleChange
            }
            option {
                attrs.value = "jack"
                +"Jack (100)"
            }
            option {
                attrs.value = "lucy"
                +"Lucy (101)"
            }
        }
    }
}
