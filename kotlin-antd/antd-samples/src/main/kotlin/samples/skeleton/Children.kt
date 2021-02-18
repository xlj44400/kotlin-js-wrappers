package samples.skeleton

import antd.*
import antd.button.button
import antd.skeleton.*
import kotlinx.browser.*
import react.*
import react.dom.*
import styled.*

interface ChildrenDemoState : RState {
    var loading: Boolean
}

class ChildrenDemo : RComponent<RProps, ChildrenDemoState>() {
    private val showSkeleton: MouseEventHandler<Any> = {
        setState {
            loading = true
        }

        window.setTimeout({
            setState {
                loading = false
            }
        }, 3000)
    }

    override fun ChildrenDemoState.init() {
        loading = false
    }

    override fun RBuilder.render() {
        div("article") {
            skeleton {
                attrs.loading = state.loading
                div {
                    h4 { +"Ant Design, a design language" }
                    p { +"We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently." }
                }
            }
            button {
                attrs {
                    onClick = showSkeleton
                    disabled = state.loading
                }
                +"Show Skeleton"
            }
        }
    }
}

fun RBuilder.childrenDemo() = child(ChildrenDemo::class) {}

fun RBuilder.child() {
    styledDiv {
        css { +SkeletonStyles.children }
        childrenDemo()
    }
}
