package samples.pagination

import antd.pagination.*
import react.*
import react.dom.*
import styled.*

private fun showTotal(total: Number, range: Array<Number>): ReactElement {
    return buildElement { +"Total $total items" }
}

fun RBuilder.mini() {
    styledDiv {
        css { +PaginationStyles.mini }
        div {
            pagination {
                attrs {
                    size = "small"
                    total = 50
                }
            }
            pagination {
                attrs {
                    size = "small"
                    total = 50
                    showSizeChanger = true
                    showQuickJumper = true
                }
            }
            pagination {
                attrs {
                    size = "small"
                    total = 50
                    showTotal = ::showTotal
                }
            }
        }
    }
}
