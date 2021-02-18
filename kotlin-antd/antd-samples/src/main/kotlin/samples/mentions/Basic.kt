package samples.mentions

import antd.mentions.*
import kotlinext.js.*
import react.*
import styled.*

private fun handleChange(value: Any) {
    console.log("Change: ", value)
}

private fun handleSelect(option: OptionProps, prefix: String) {
    console.log("select", option)
}

fun RBuilder.basic() {
    styledDiv {
        css { MentionsStyles.basic }
        mentions {
            attrs {
                style = js { width = "100%" }
                onChange = ::handleChange
                onSelect = ::handleSelect
            }
            option {
                attrs.value = "afc163"
                +"afc163"
            }
            option {
                attrs.value = "zombieJ"
                +"zombieJ"
            }
            option {
                attrs.value = "yesmeck"
                +"yesmeck"
            }
        }
    }
}
