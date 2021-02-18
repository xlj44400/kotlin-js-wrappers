package antd.menu

import org.w3c.dom.events.*
import react.*

external object SubMenuComponent : Component<SubMenuProps, RState> {
    override fun render(): ReactElement?
}

external interface SubMenuProps : RProps {
    var rootPrefixCls: String?
    var className: String?
    var disabled: Boolean?
    var level: Number?
    var title: Any? /* String | ReactElement */
    var icon: Any? /* String | ReactElement */
    var style: dynamic
    var onTitleClick: ((e: TitleEventEntity) -> Unit)?
    var onTitleMouseEnter: ((e: TitleEventEntity) -> Unit)?
    var onTitleMouseLeave: ((e: TitleEventEntity) -> Unit)?
    var popupOffset: Array<Number>?
    var popupClassName: String?
}

external interface TitleEventEntity {
    var key: String
    var domEvent: Event
}
