package samples.tree

import antd.tree.*
import react.*
import styled.*

class LineDemo : RComponent<RProps, RState>() {
    private val handleSelect = fun(selectedKeys: Array<Key>, info: OnSelectInfo) {
        console.log("selected", selectedKeys, info)
    }

    override fun RBuilder.render() {
        tree {
            attrs {
                showLine = true
                defaultExpandedKeys = arrayOf("0-0-0")
                onSelect = handleSelect
            }
            treeNode {
                attrs {
                    title = "parent 1"
                    key = "0-0"
                }
                treeNode {
                    attrs {
                        title = "parent 1-0"
                        key = "0-0-0"
                    }
                    treeNode {
                        attrs {
                            title = "leaf"
                            key = "0-0-0-0"
                            disableCheckbox = true
                        }
                    }
                    treeNode {
                        attrs {
                            title = "leaf"
                            key = "0-0-0-1"
                        }
                    }
                    treeNode {
                        attrs {
                            title = "leaf"
                            key = "0-0-0-2"
                        }
                    }
                }
                treeNode {
                    attrs {
                        title = "parent 1-1"
                        key = "0-0-1"
                    }
                    treeNode {
                        attrs {
                            title = "leaf"
                            key = "0-0-1-0"
                        }
                    }
                }
                treeNode {
                    attrs {
                        title = "parent 1-2"
                        key = "0-0-2"
                    }
                    treeNode {
                        attrs {
                            title = "leaf"
                            key = "0-0-2-0"
                        }
                    }
                    treeNode {
                        attrs {
                            title = "leaf"
                            key = "0-0-2-1"
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.lineDemo() = child(LineDemo::class) {}

fun RBuilder.line() {
    styledDiv {
        css { +TreeStyles.line }
        lineDemo()
    }
}
