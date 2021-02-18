package samples.form

import antd.button.button
import antd.form.*
import antd.grid.*
import antd.grid.col
import antd.icon.*
import antd.input.input
import kotlinext.js.*
import kotlinx.html.*
import kotlinx.html.js.*
import react.*
import react.dom.a
import react.dom.div
import react.dom.jsStyle
import styled.*

private val advancedSearchForm = functionalComponent<RProps> {
    val (expand, setExpand) = useState(false)
    val formInstance = FormComponent.useForm()[0]

    fun getFields(): Array<ReactElement> {
        val count = if (expand) 10 else 6

        return (0..count).map { i ->
            buildElement {
                col {
                    attrs {
                        span = 8
                        key = i.toString()
                    }
                    formItem {
                        attrs {
                            name = "field-$i"
                            label = "Field $i"
                            rules = arrayOf(
                                jsObject<AggregationRule> {
                                    required = true
                                    message = "Input something!"
                                }
                            )
                        }
                        input {
                            attrs.placeholder = "placeholder"
                        }
                    }
                }
            }
        }.toTypedArray()
    }

    val handleFinish = { values: Any ->
        console.log("Received values of form: ", values)
    }

    form {
        attrs {
            form = formInstance
            name = "advanced+search"
            className = "ant-advanced-search-form"
            onFinish = handleFinish
        }
        row {
            attrs.gutter = 24
            childList.add(getFields())
            col {
                attrs {
                    span = 24
                    style = js { textAlign = "right" }
                }
                button {
                    attrs {
                        type = "primary"
                        htmlType = "submit"
                    }
                    +"Search"
                }
                button {
                    attrs {
                        style = js { margin = "0 8px" }
                        onClick = { formInstance.resetFields() }
                    }
                    +"Clear"
                }
                a {
                    attrs {
                        jsStyle = js { fontSize = 12 }
                        onClickFunction = {
                            setExpand(!expand)
                        }
                    }
                    if (expand) {
                        upOutlined {}
                    } else downOutlined {}
                    +" Collapse"
                }
            }
        }
    }
}

fun RBuilder.advancedSearchForm() = child(advancedSearchForm) {}

fun RBuilder.advancedSearch() {
    styledDiv {
        css { +FormStyles.advancedSearch }
        div {
            advancedSearchForm()
            div {
                attrs.classes = setOf("search-result-list")
                +"Search Result List"
            }
        }
    }
}
