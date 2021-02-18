package antd.tree

import antd.*
import org.w3c.dom.*
import react.*

external object TreeNodeComponent : Component<TreeNodeProps, TreeNodeState> {
    override fun render(): ReactElement?
}

external interface TreeNodeProps : RProps {
    var className: String?
    var checkable: Boolean?
    var disabled: Boolean?
    var disableCheckbox: Boolean?
    var title: Any? /* String | ReactElement */
    var key: String?
    var eventKey: String?
    var isLeaf: Boolean?
    var checked: Boolean?
    var expanded: Boolean?
    var loading: Boolean?
    var selected: Boolean?
    var selectable: Boolean?
    var icon: Any /* (treeNode: TreeNodeAttribute) -> ReactElement | ReactElement */
    var children: Any? /* String | ReactElement */
}

external interface TreeNodeState : RState {
    var dragNodeHighlight: Boolean
}

external interface TreeNodeAttribute {
    var eventKey: String
    var prefixCls: String
    var className: String
    var expanded: Boolean
    var selected: Boolean
    var checked: Boolean
    var halfChecked: Boolean
    var children: Any /* String | ReactElement */
    var title: Any /* String | ReactElement */
    var pos: String
    var dragOver: Boolean
    var dragOverGapTop: Boolean
    var dragOverGapBottom: Boolean
    var isLeaf: Boolean
    var selectable: Boolean
    var disabled: Boolean
    var disableCheckbox: Boolean
}

external interface TreeNodeDragEnterEvent : TreeNodeMouseEvent {
    var expandedKeys: Array<Key>
}

external interface TreeNodeMouseEvent {
    var node: TreeNodeComponent
    var event: MouseEvent<HTMLElement>
}

external interface TreeNodeDropEvent {
    var node: TreeNodeComponent
    var dragNode: TreeNodeComponent
    var dragNodesKeys: Array<Key>
    var dropPosition: Number
    var dropToGap: Boolean?
    var event: MouseEvent<HTMLElement>
}

external interface TreeNodeCheckedEvent : TreeNodeBaseEvent {
    var event: String
    var checked: Boolean?
    var checkedNodes: Array<TreeNodeComponent>?
}

external interface TreeNodeSelectedEvent : TreeNodeBaseEvent {
    var event: String
    var selected: Boolean?
    var selectedNodes: Array<DataNode>?
}

external interface TreeNodeExpandedEvent : TreeNodeBaseEvent {
    var expanded: Boolean?
}

external interface TreeNodeBaseEvent {
    var node: TreeNodeComponent
    var nativeEvent: MouseEvent<Any>
}
