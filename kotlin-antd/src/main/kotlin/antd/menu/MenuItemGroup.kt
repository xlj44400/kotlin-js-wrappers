package antd.menu

import react.*

external object MenuItemGroupComponent : Component<MenuItemGroupProps, RState> {
    override fun render(): ReactElement?
}

external interface MenuItemGroupProps : RProps {
    var renderMenuItem: ((item: ReactElement, index: Number, key: String) -> ReactElement)?
    var index: Number?
    var className: String?
    var subMenuKey: String?
    var rootPrefixCls: String?
    var title: Any? /* String | ReactElement */
    var onClick: MenuClickEventHandler?
    var direction: String? /* "ltr" | "rtl" */
}
