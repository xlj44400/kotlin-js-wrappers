package samples.form

import antd.*
import antd.form.*
import antd.inputnumber.*
import kotlinext.js.*
import org.w3c.dom.*
import react.*
import styled.*

private interface PrimeNumber {
    var validateStatus: FormItemValidateStatus?
    var errorMsg: String?
    var value: Number?
}

private fun validatePrimeNumber(number: Number): PrimeNumber {
    if (number == 11) {
        return jsObject {
            validateStatus = "success"
            errorMsg = null
        }
    }

    return jsObject {
        validateStatus = "error"
        errorMsg = "The prime between 8 and 12 is 11!"
    }
}

private val formItemLayout = jsObject<FormItemProps<Any>> {
    labelCol = jsObject { span = 7 }
    wrapperCol = jsObject { span = 12 }
}

private val rawForm = functionalComponent<RProps> {
    val (number, setNumber) = useState(jsObject<PrimeNumber> { value = 11 })

    val tips = "A prime is a natural number greater than 1 that has no positive divisors other than 1 and itself."

    val handleNumberChange: ChangeEventHandler<HTMLInputElement> = { inputValue ->
        val validation = validatePrimeNumber(inputValue.unsafeCast<Number>())

        setNumber(jsObject {
            validateStatus = validation.validateStatus
            errorMsg = validation.errorMsg
            value = inputValue.unsafeCast<Number>()
        })
    }

    form {
        formItem {
            attrs {
                labelCol = formItemLayout.labelCol
                wrapperCol = formItemLayout.wrapperCol
                label = "Prime between 8 & 12"
                validateStatus = number.validateStatus
                help = if (number.errorMsg !== null) number.errorMsg else tips
            }
            inputNumber {
                attrs {
                    min = 8
                    max = 12
                    value = number.value
                    onChange = handleNumberChange
                }
            }
        }
    }
}

fun RBuilder.rawForm() = child(rawForm) {}

fun RBuilder.withoutFormCreate() {
    styledDiv {
        css { +FormStyles.withoutFormCreate }
        rawForm()
    }
}
