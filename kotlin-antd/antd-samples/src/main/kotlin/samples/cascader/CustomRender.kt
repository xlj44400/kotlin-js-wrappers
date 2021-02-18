package samples.cascader

import antd.cascader.*
import kotlinext.js.*
import kotlinx.html.js.*
import org.w3c.dom.events.*
import react.*
import react.dom.*
import styled.*

interface CustomRenderCascaderOptionType : CascaderOptionType {
    var code: Number?
}

private val cascaderOptions = arrayOf<CascaderOptionType>(
    jsObject {
        value = "zhejiang"
        label = "Zhejiang"
        children = arrayOf(
            jsObject {
                value = "hangzhou"
                label = "Hangzhou"
                children = arrayOf(
                    jsObject<CustomRenderCascaderOptionType> {
                        value = "xihu"
                        label = "West Lake"
                        code = 752100
                    }
                )
            }
        )
    },
    jsObject {
        value = "jiangsu"
        label = "Jiangsu"
        children = arrayOf(
            jsObject {
                value = "nanjing"
                label = "Nanjing"
                children = arrayOf(
                    jsObject<CustomRenderCascaderOptionType> {
                        value = "zhonghuamen"
                        label = "Zhong Hua Men"
                        code = 453400
                    }
                )
            }
        )
    }
)

private fun handleAreaClick(event: Event, label: String, option: CascaderOptionType) {
    event.stopPropagation()

    console.log("clicked", label, option)
}

private val handleDisplayRender = fun(labels: Array<String>, selectedOptions: Array<CascaderOptionType>?): ReactElement {
    return buildElements {
        labels.forEachIndexed { index, label ->
            val option = selectedOptions!![index]

            if (index == labels.size - 1) {
                span {
                    attrs.key = option.value!! as String
                    +"$label ("
                    a {
                        attrs.onClickFunction = { event ->
                            handleAreaClick(event, label, option)
                        }
                        +"${option.unsafeCast<CustomRenderCascaderOptionType>().code}"
                    }
                    +")"
                }
            } else {
                span {
                    attrs.key = option.value!! as String
                    +"$label / "
                }
            }
        }
    }.unsafeCast<ReactElement>()
}

fun RBuilder.customRender() {
    styledDiv {
        css { +CascaderStyles.customRender }
        cascader {
            attrs {
                options = cascaderOptions
                defaultValue = arrayOf("zhejiang", "hangzhou", "xihu")
                displayRender = handleDisplayRender
                style = js { width = "100%" }
            }
        }
    }
}
