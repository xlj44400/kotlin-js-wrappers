package samples.inputnumber

import antd.inputnumber.*
import react.*
import react.dom.*
import styled.*

private fun handleChange(value: Any?) {
    console.log("changed", value)
}

fun RBuilder.formatter() {
    styledDiv {
        css { +InputNumberStyles.formatter }
        div {
            inputNumber {
                attrs {
                    defaultValue = 1000
                    formatter = { value ->
                        "$ $value".replace(Regex("\\B(?=(\\d{3})+(?!\\d))"), ",")
                    }
                    parser = { displayValue ->
                        displayValue!!.replace(Regex("\\\$\\s?|(,*)"), "")
                    }
                    onChange = ::handleChange
                }
            }
            inputNumber {
                attrs {
                    defaultValue = 100
                    min = 0
                    max = 100
                    formatter = { value -> "$value%" }
                    parser = { displayValue ->
                        displayValue!!.replace("%", "")
                    }
                    onChange = ::handleChange
                }
            }
        }
    }
}
