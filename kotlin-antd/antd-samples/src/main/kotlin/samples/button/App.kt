package samples.button

import kotlinx.css.*
import kotlinx.css.properties.*
import react.*
import react.dom.*
import styled.*

object ButtonStyles : StyleSheet("button", isStatic = true) {
    val container by css {}
    val basic by css {}
    val size by css {}
    val loading by css {}
    val buttonGroup by css {
        descendants("h4") {
            margin(16.px, 0.px)
            fontSize = 14.px
            lineHeight = LineHeight("1px")
            fontWeight = FontWeight.normal
        }
        descendants("h4") {
            firstChild {
                marginTop = 0.px
            }
        }
        descendants(".ant-btn-group") {
            marginBottom = 8.px
        }
    }
    val block by css {}
    val icon by css {}
    val disabled by css {}
    val multiple by css {}
    val ghost by css {}
}

class ButtonApp : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        h2 { +"Button" }
        styledDiv {
            css { +ButtonStyles.container }
            basic()
            size()
            loading()
            buttonGroup()
            block()
            icon()
            disabled()
            multiple()
            ghost()
        }
    }
}

fun RBuilder.buttonApp() = child(ButtonApp::class) {}
