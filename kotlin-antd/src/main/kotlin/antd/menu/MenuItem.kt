package antd.menu

import antd.HTMLAttributes
import org.w3c.dom.HTMLLIElement
import react.*

external object MenuItemComponent : Component<MenuItemProps, RState> {
    override fun render(): ReactElement?
}

external interface MenuItemProps : RcMenuItemProps, RProps {
    var icon: Any? /* ReactElement | String */
    var danger: Boolean?
    override var title: dynamic /* ReactElement | String */
}

external interface RcMenuItemProps : HTMLAttributes<HTMLLIElement> {
    var attribute: dynamic
    var rootPrefixCls: String?
    var eventKey: dynamic
    override var className: String?
    override var style: dynamic
    var active: Boolean?
    override var children: Any? /* String | ReactElement */
    var selectedKeys: Array<String>?
    var disabled: Boolean?
    override var title: String?
    var onItemHover: HoverEventHandler?
    override var onSelect: dynamic /* SelectEventHandler */
    override var onClick: dynamic /* MenuClickEventHandler */
    var onDeselect: SelectEventHandler?
    var parentMenu: dynamic
    var onDestroy: DestroyEventHandler?
    override var onMouseEnter: dynamic /* MenuHoverEventHandler */
    override var onMouseLeave: dynamic /* MenuHoverEventHandler */
    var multiple: Boolean?
    var isSelected: Boolean?
    var manualRef: LegacyFunctionRef?
    var itemIcon: RenderIconType?
    override var role: String?
    var mode: MenuMode?
    var inlineIndent: Number?
    var level: Number?
    var direction: String? /* "ltr" | "rtl" */
}
