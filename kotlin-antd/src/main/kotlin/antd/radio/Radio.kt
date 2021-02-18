@file:JsModule("antd/lib/radio")
@file:JsNonModule

package antd.radio

import antd.checkbox.*
import org.w3c.dom.events.*
import react.*

@JsName("default")
external object RadioComponent : Component<RadioProps, RState> {
    val Group: RadioGroupComponent
    val Button: RadioButtonComponent

    override fun render(): ReactElement?
}

external interface RadioProps : AbstractCheckboxProps<RadioChangeEvent>, RProps

external interface RadioChangeEventTarget : RadioProps {
    override var checked: Boolean?
}

external interface RadioChangeEvent {
    var target: RadioChangeEventTarget
    var stopPropagation: () -> Unit
    var preventDefault: () -> Unit
    var nativeEvent: MouseEvent
}
