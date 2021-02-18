package samples.form

import antd.button.button
import antd.form.*
import antd.input.input
import antd.radio.*
import kotlinext.js.*
import react.*
import react.dom.div
import styled.*

private interface FormLayoutDemoState : RState {
    var formLayout: String
}

private class FormLayoutDemo : RComponent<FormProps<Any>, FormLayoutDemoState>() {
    private val handleFormLayoutChange = fun(event: RadioChangeEvent) {
        setState {
            formLayout = event.target.value.unsafeCast<String>()
        }
    }

    override fun FormLayoutDemoState.init() {
        formLayout = "horizontal"
    }

    override fun RBuilder.render() {
        val formItemLayout = if (state.formLayout == "horizontal") {
            jsObject<FormItemProps<Any>> {
                labelCol = jsObject { span = 4 }
                wrapperCol = jsObject { span = 14 }
            }
        } else null

        val buttonItemLayout = if (state.formLayout == "horizontal") {
            jsObject<FormItemProps<Any>> {
                wrapperCol = jsObject {
                    span = 14
                    offset = 4
                }
            }
        } else null

        div {
            form {
                attrs.layout = state.formLayout
                formItem {
                    attrs {
                        label = "Form Layout"
                        labelCol = formItemLayout?.labelCol
                        wrapperCol = formItemLayout?.wrapperCol
                    }
                    radioGroup {
                        attrs {
                            defaultValue = "horizontal"
                            onChange = handleFormLayoutChange
                        }
                        radioButton {
                            attrs.value = "horizontal"
                            +"Horizontal"
                        }
                        radioButton {
                            attrs.value = "vertical"
                            +"Vertical"
                        }
                        radioButton {
                            attrs.value = "inline"
                            +"Inline"
                        }
                    }
                }
                formItem {
                    attrs {
                        label = "Field A"
                        labelCol = formItemLayout?.labelCol
                        wrapperCol = formItemLayout?.wrapperCol
                    }
                    input {
                        attrs.placeholder = "input placeholder"
                    }
                }
                formItem {
                    attrs {
                        label = "Field B"
                        labelCol = formItemLayout?.labelCol
                        wrapperCol = formItemLayout?.wrapperCol
                    }
                    input {
                        attrs.placeholder = "input placeholder"
                    }
                }
                formItem {
                    attrs.wrapperCol = buttonItemLayout?.wrapperCol
                    button {
                        attrs.type = "primary"
                        +"Submit"
                    }
                }
            }
        }
    }
}

fun RBuilder.formLayoutDemo() = child(FormLayoutDemo::class) {}

fun RBuilder.layout() {
    styledDiv {
        css { +FormStyles.layout }
        formLayoutDemo()
    }
}
