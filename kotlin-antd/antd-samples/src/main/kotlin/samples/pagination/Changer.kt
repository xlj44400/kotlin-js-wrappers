package samples.pagination

import antd.pagination.*
import react.*
import react.dom.*
import styled.*

private fun handleShowSizeChange(current: Number, size: Number) {
    console.log(current, size)
}

fun RBuilder.changer() {
    styledDiv {
        css { +PaginationStyles.changer }
        pagination {
            attrs {
                showSizeChanger = true
                onShowSizeChange = ::handleShowSizeChange
                defaultCurrent = 3
                total = 500
            }
        }
        br {}
        pagination {
            attrs {
                showSizeChanger = true
                onShowSizeChange = ::handleShowSizeChange
                defaultCurrent = 3
                total = 500
                disabled = true
            }
        }
    }
}
