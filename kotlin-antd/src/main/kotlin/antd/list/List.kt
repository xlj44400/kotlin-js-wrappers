@file:JsModule("antd/lib/list")
@file:JsNonModule

package antd.list

import react.*

@JsName("default")
external class ListComponent<T> : Component<ListProps<T>, ListState> {
    companion object {
        val Item: ItemComponent
    }

    override fun render(): ReactElement?
}

external val listContext: RContext<ListConsumerProps>
external val listConsumer: RConsumer<ListConsumerProps>

external interface ListProps<T> : RProps {
    var bordered: Boolean?
    var className: String?
    var style: dynamic
    var children: Any? /* String | ReactElement */
    var dataSource: Array<T>?
    var extra: Any? /* String | ReactElement */
    var grid: ListGridType?
    var id: String?
    var itemLayout: ListItemLayout?
    var loading: Any? /* Boolean | SpinProps */
    var loadMore: Any? /* String | ReactElement */
    var pagination: Any? /* PaginationConfig | Boolean */
    var prefixCls: String?
    var rowKey: Any? /* (item: T) -> String | String */
    var renderItem: ((item: T, index: Number) -> Any? /* String | ReactElement */)?
    var size: ListSize?
    var split: Boolean?
    var header: Any? /* String | ReactElement */
    var footer: Any? /* String | ReactElement */
    var locale: ListLocale?
}

external interface ListState : RState {
    var paginationCurrent: Number
    var paginationSize: Number
}

external interface ListGridType {
    var gutter: Number?
    var column: ColumnCount?
    var xs: ColumnCount?
    var sm: ColumnCount?
    var md: ColumnCount?
    var lg: ColumnCount?
    var xl: ColumnCount?
    var xxl: ColumnCount?
}

external interface ListLocale {
    var emptyText: Any /* String | ReactElement | () -> String | ReactElement */
}

external interface ListConsumerProps {
    var grid: Any
    var itemLayout: String?
}
