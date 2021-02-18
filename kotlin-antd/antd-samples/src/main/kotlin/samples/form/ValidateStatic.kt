package samples.form

import antd.cascader.*
import antd.datepicker.*
import antd.form.*
import antd.input.input
import antd.inputnumber.*
import antd.select.*
import antd.select.option
import antd.timepicker.timePicker
import kotlinext.js.*
import react.*
import react.dom.jsStyle
import react.dom.span
import styled.*

private val formItemLayout = jsObject<FormItemProps<Any>> {
    labelCol = jsObject {
        xs = jsObject { span = 24 }
        sm = jsObject { span = 5 }
    }
    wrapperCol = jsObject {
        xs = jsObject { span = 24 }
        sm = jsObject { span = 12 }
    }
}

fun RBuilder.validateStatic() {
    styledDiv {
        css { +FormStyles.validateStatic }
        form {
            attrs {
                labelCol = formItemLayout.labelCol
                wrapperCol = formItemLayout.wrapperCol
            }
            formItem {
                attrs {
                    label = "Fail"
                    validateStatus = "error"
                    help = "Should be combination of numbers & alphabets"
                }
                input {
                    attrs {
                        placeholder = "unavailable choice"
                        id = "error"
                    }
                }
            }
            formItem {
                attrs {
                    label = "Warning"
                    validateStatus = "warning"
                }
                input {
                    attrs {
                        placeholder = "Warning"
                        id = "warning"
                    }
                }
            }
            formItem {
                attrs {
                    label = "Validating"
                    hasFeedback = true
                    validateStatus = "validating"
                    help = "The information is being validated..."
                }
                input {
                    attrs {
                        placeholder = "I'm the content is being validated"
                        id = "validating"
                    }
                }
            }
            formItem {
                attrs {
                    label = "Success"
                    hasFeedback = true
                    validateStatus = "success"
                }
                input {
                    attrs {
                        placeholder = "I'm the content"
                        id = "success"
                    }
                }
            }
            formItem {
                attrs {
                    label = "Warning"
                    hasFeedback = true
                    validateStatus = "warning"
                }
                input {
                    attrs {
                        placeholder = "Warning"
                        id = "warning2"
                    }
                }
            }
            formItem {
                attrs {
                    label = "Fail"
                    hasFeedback = true
                    validateStatus = "error"
                    help = "Should be combination of numbers & alphabets"
                }
                input {
                    attrs {
                        placeholder = "unavailable choice"
                        id = "error2"
                    }
                }
            }
            formItem {
                attrs {
                    label = "Success"
                    hasFeedback = true
                    validateStatus = "success"
                }
                datePicker {
                    attrs.style = js { width = "100%" }
                }
            }
            formItem {
                attrs {
                    label = "Warning"
                    hasFeedback = true
                    validateStatus = "warning"
                }
                timePicker {
                    attrs.style = js { width = "100%" }
                }
            }
            formItem {
                attrs {
                    label = "Error"
                    hasFeedback = true
                    validateStatus = "error"
                }
                select<String, SelectComponent<String>> {
                    attrs.defaultValue = "1"
                    option {
                        attrs.value = "1"
                        +"1"
                    }
                    option {
                        attrs.value = "2"
                        +"2"
                    }
                    option {
                        attrs.value = " 3"
                        +"3"
                    }
                }
            }
            formItem {
                attrs {
                    label = "Validating"
                    hasFeedback = true
                    validateStatus = "validating"
                    help = "The information is being validated..."
                }
                cascader {
                    attrs {
                        defaultValue = arrayOf("1")
                        options = emptyArray()
                    }
                }
            }
            formItem {
                attrs {
                    label = "inline"
                    style = js { marginBottom = 0 }
                }
                formItem {
                    attrs {
                        validateStatus = "error"
                        help = "Please select the correct date"
                        style = js {
                            display = "inline-block"
                            width = "calc(50% - 12px)"
                        }
                        datePicker {}
                    }
                }
                span {
                    attrs.jsStyle = js {
                        display = "inline-block"
                        width = "24px"
                        textAlign = "center"
                    }
                }
                formItem {
                    attrs.style = js {
                        display = "inline-block"
                        width = "calc(50% - 12px)"
                    }
                    datePicker {}
                }
            }
            formItem {
                attrs {
                    label = "Success"
                    hasFeedback = true
                    validateStatus = "success"
                }
                inputNumber {
                    attrs.style = js { width = "100%" }
                }
            }
        }
    }
}
