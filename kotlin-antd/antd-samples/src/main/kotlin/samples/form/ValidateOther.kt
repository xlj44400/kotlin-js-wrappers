package samples.form

import antd.button.button
import antd.checkbox.*
import antd.form.*
import antd.grid.*
import antd.icon.*
import antd.inputnumber.*
import antd.radio.*
import antd.rate.*
import antd.select.*
import antd.select.option
import antd.slider.*
import antd.switch.*
import antd.upload.*
import kotlinext.js.*
import kotlinx.html.*
import react.*
import react.dom.p
import react.dom.span
import styled.*

private val formItemLayout = jsObject<FormProps<Any>> {
    labelCol = jsObject { span = 6 }
    wrapperCol = jsObject { span = 14 }
}

private val normFile = { e: EventArgs ->
    console.log("Upload event:", e)

    if (jsTypeOf(e) == "array") {
        e
    } else {
        e.asDynamic()?.fileList?.unsafeCast<Any>() ?: e
    }
}

private val demo = functionalComponent<RProps> {
    val handleFinish = { values: Any ->
        console.log("Received values of form: ", values)
    }

    val sliderMarks = {
        val sliderMarks: dynamic = js {}

        sliderMarks["0"] = "A"
        sliderMarks["20"] = "B"
        sliderMarks["40"] = "C"
        sliderMarks["60"] = "D"
        sliderMarks["80"] = "E"
        sliderMarks["100"] = "F"

        sliderMarks
    }

    form {
        attrs {
            name = "validate_other"
            labelCol = formItemLayout.labelCol
            wrapperCol = formItemLayout.wrapperCol
            onFinish = handleFinish
        }
        formItem {
            attrs.label = "Plain Text"
            span {
                attrs.classes = setOf("ant-form-text")
                +"China"
            }
        }
        formItem {
            attrs {
                name = "select"
                label = "Select"
                hasFeedback = true
                rules = arrayOf(jsObject<AggregationRule> {
                    required = true
                    message = "Please select your country!"
                })
            }
            select<String, SelectComponent<String>> {
                attrs.placeholder = "Please select a country"
                option {
                    attrs.value = "china"
                    +"China"
                }
                option {
                    attrs.value = "usa"
                    +"U.S.A"
                }
            }
        }
        formItem {
            attrs {
                name = "select-multiple"
                label = "Select[multiple]"
                rules = arrayOf(jsObject<AggregationRule> {
                    required = true
                    message = "Please select your favourite colors!"
                    type = "array"
                })
            }
            select<String, SelectComponent<String>> {
                attrs {
                    mode = "multiple"
                    placeholder = "Please select favourite colors"
                }
                option {
                    attrs.value = "red"
                    +"Red"
                }
                option {
                    attrs.value = "green"
                    +"Green"
                }
                option {
                    attrs.value = "blue"
                    +"Blue"
                }
            }
        }
        formItem {
            attrs.label = "InputNumber"
            formItem {
                attrs {
                    name = "input-number"
                    noStyle = true
                }
                inputNumber {
                    attrs {
                        min = 1
                        max = 10
                    }
                }
            }
            span {
                attrs.classes = setOf("ant-form-text")
                +"machines"
            }
        }
        formItem {
            attrs {
                name = "switch"
                label = "Switch"
                valuePropName = "checked"
            }
            switch {}
        }
        formItem {
            attrs {
                name = "slider"
                label = "Slider"
            }
            slider {
                attrs.marks = sliderMarks.unsafeCast<SliderMarks>()
            }
        }
        formItem {
            attrs {
                name = "radio-group"
                label = "Radio.Group"
            }
            radioGroup {
                radio {
                    attrs.value = "a"
                    +"item 1"
                }
                radio {
                    attrs.value = "b"
                    +"item 2"
                }
                radio {
                    attrs.value = "c"
                    +"item 3"
                }
            }
        }
        formItem {
            attrs {
                name = "radio-button"
                label = "Radio.Button"
                rules = arrayOf(jsObject<AggregationRule> {
                    required = true
                    message = "Please pick an item!"
                })
            }
            radioGroup {
                radioButton {
                    attrs.value = "a"
                    +"item 1"
                }
                radioButton {
                    attrs.value = "b"
                    +"item 2"
                }
                radioButton {
                    attrs.value = "c"
                    +"item 3"
                }
            }
        }
        formItem {
            attrs {
                name = "checkbox-group"
                label = "Checkbox.Group"
            }
            checkboxGroup {
                row {
                    col {
                        attrs.span = 8
                        checkbox {
                            attrs {
                                value = "A"
                                style = js { lineHeight = "32px" }
                            }
                            +"A"
                        }
                    }
                    col {
                        attrs.span = 8
                        checkbox {
                            attrs {
                                value = "B"
                                style = js { lineHeight = "32px" }
                            }
                            +"B"
                        }
                    }
                    col {
                        attrs.span = 8
                        checkbox {
                            attrs {
                                value = "C"
                                style = js { lineHeight = "32px" }
                            }
                            +"C"
                        }
                    }
                    col {
                        attrs.span = 8
                        checkbox {
                            attrs {
                                value = "D"
                                style = js { lineHeight = "32px" }
                            }
                            +"D"
                        }
                    }
                    col {
                        attrs.span = 8
                        checkbox {
                            attrs {
                                value = "F"
                                style = js { lineHeight = "32px" }
                            }
                            +"F"
                        }
                    }
                }
            }
        }
        formItem {
            attrs {
                name = "rate"
                label = "Rate"
            }
            rate {}
        }
        formItem {
            attrs {
                name = "upload"
                label = "Upload"
                valuePropName = "fileList"
                getValueFromEvent = normFile
                extra = "longgggggggggggggggggggggggggggggggggg"
            }
            upload {
                attrs {
                    name = "logo"
                    action = "/upload.do"
                    listType = "picture"
                }
                button {
                    uploadOutlined {}
                    +"Click to upload"
                }
            }
        }
        formItem {
            attrs.label = "Dragger"
            formItem {
                attrs {
                    name = "Dragger"
                    valuePropName = "fileList"
                    getValueFromEvent = normFile
                    noStyle = true
                }
            }
            dragger {
                attrs {
                    name = "files"
                    action = "/upload.do"
                }
                p {
                    attrs.classes = setOf("ant-upload-drag-icon")
                    inboxOutlined {}
                }
                p {
                    attrs.classes = setOf("ant-upload-text")
                    +"Click or drag file to this area to upload"
                }
                p {
                    attrs.classes = setOf("ant-upload-hint")
                    +"Support for a single or bulk upload."
                }
            }
        }
        formItem {
            attrs {
                wrapperCol = jsObject {
                    span = 12
                    offset = 6
                }
            }
            button {
                attrs {
                    type = "primary"
                    htmlType = "submit"
                }
                +"submit"
            }
        }
    }
}

fun RBuilder.validateOtherDemo() = child(demo) {}

fun RBuilder.validateOther() {
    styledDiv {
        css { +FormStyles.validateOther }
        validateOtherDemo()
    }
}
