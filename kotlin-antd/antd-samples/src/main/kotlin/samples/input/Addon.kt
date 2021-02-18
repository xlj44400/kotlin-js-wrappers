package samples.input

import antd.icon.*
import antd.input.input
import antd.select.*
import antd.select.option
import kotlinext.js.*
import react.*
import react.dom.*
import styled.*

private val selectBefore = buildElement {
    select<String, SelectComponent<String>> {
        attrs {
            defaultValue = "Http://"
            style = js { width = 90 }
        }
        option {
            attrs.value = "Http://"
            +"Http://"
        }
        option {
            attrs.value = "Https://"
            +"Https://"
        }
    }
}

private val selectAfter = buildElement {
    select<String, SelectComponent<String>> {
        attrs {
            defaultValue = ".com"
            style = js { width = 80 }
        }
        option {
            attrs.value = ".com"
            +".com"
        }
        option {
            attrs.value = ".jp"
            +".jp"
        }
        option {
            attrs.value = ".cn"
            +".cn"
        }
        option {
            attrs.value = ".org"
            +".org"
        }
    }
}

fun RBuilder.addon() {
    styledDiv {
        css { +InputStyles.addon }
        div {
            div {
                attrs.jsStyle = js { marginBottom = 16 }
                input {
                    attrs {
                        addonBefore = "Http://"
                        addonAfter = ".com"
                        defaultValue = "mysite"
                    }
                }
            }
            div {
                attrs.jsStyle = js { marginBottom = 16 }
                input {
                    attrs {
                        addonBefore = selectBefore
                        addonAfter = selectAfter
                        defaultValue = "mysite"
                    }
                }
            }
            div {
                attrs.jsStyle = js { marginBottom = 16 }
                input {
                    attrs {
                        addonAfter = buildElement {
                            settingOutlined {}
                        }
                        defaultValue = "mysite"
                    }
                }
            }
        }
    }
}
