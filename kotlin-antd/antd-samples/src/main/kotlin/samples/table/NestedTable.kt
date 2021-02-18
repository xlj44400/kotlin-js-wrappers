package samples.table

import antd.badge.*
import antd.dropdown.*
import antd.icon.*
import antd.menu.*
import antd.table.*
import kotlinext.js.*
import kotlinx.html.*
import react.*
import react.dom.*
import styled.*

private interface NestedTableNestedTableDataItem {
    var key: String
    var date: String
    var name: String
    var upgradeNum: String
}

private interface NestedTableTableDataItem {
    var key: String
    var name: String
    var platform: String
    var version: String
    var upgradeNum: Number
    var creator: String
    var createdAt: String
}

private val menu = buildElement {
    menu {
        menuItem { +"Action 1" }
        menuItem { +"Action 2" }
    }
}

class NestedTableApp : RComponent<RProps, RState>() {
    private val expandRowRender: (Any, Number, Number, Boolean) -> ReactElement = { _, _, _, _ ->
        val tableColumns = arrayOf<ColumnProps<NestedTableNestedTableDataItem>>(
            jsObject {
                title = "Date"
                dataIndex = "date"
                key = "date"
            },
            jsObject {
                title = "Name"
                dataIndex = "name"
                key = "name"
            },
            jsObject {
                title = "Status"
                key = "state"
                render = { _, _, _ ->
                    buildElement {
                        span {
                            badge {
                                attrs.status = "success"
                            }
                            +"Finished"
                        }
                    }
                }
            },
            jsObject {
                title = "Upgrade Status"
                dataIndex = "upgradeNum"
                key = "upgradeNum"
            },
            jsObject {
                title = "Action"
                dataIndex = "operation"
                key = "operation"
                render = { _, _, _ ->
                    buildElement {
                        span {
                            attrs.classes = setOf("table-operation")
                            a {
                                attrs.href = "javascript:;"
                                +"Pause"
                            }
                            a {
                                attrs.href = "javascript:;"
                                +"Stop"
                            }
                            dropdown {
                                attrs.overlay = menu
                                a {
                                    attrs.href = "javascript:;"
                                    +"More "
                                    downOutlined {}
                                }
                            }
                        }
                    }
                }
            }
        )

        val data = (0..3).map { i ->
            jsObject<NestedTableNestedTableDataItem> {
                key = "$i"
                date = "2014-12-24 23:12:00"
                name = "This is production name"
                upgradeNum = "Upgraded: 56"
            }
        }.toTypedArray()

        buildElement {
            table<NestedTableNestedTableDataItem, TableComponent<NestedTableNestedTableDataItem>> {
                attrs {
                    columns = tableColumns
                    dataSource = data
                    pagination = false
                }
            }
        }
    }

    override fun RBuilder.render() {
        val tableColumns = arrayOf<ColumnProps<NestedTableTableDataItem>>(
            jsObject {
                title = "Name"
                dataIndex = "name"
                key = "name"
            },
            jsObject {
                title = "Platform"
                dataIndex = "platform"
                key = "platform"
            },
            jsObject {
                title = "Version"
                dataIndex = "version"
                key = "version"
            },
            jsObject {
                title = "Upgraded"
                dataIndex = "upgraded"
                key = "upgraded"
            },
            jsObject {
                title = "Creator"
                dataIndex = "creator"
                key = "creator"
            },
            jsObject {
                title = "Date"
                dataIndex = "createdAt"
                key = "createdAt"
            },
            jsObject {
                title = "Action"
                key = "creator"
                render = { _, _, _ ->
                    buildElement {
                        a {
                            attrs.href = "javascript:;"
                            +"Publish"
                        }
                    }
                }
            }
        )

        val data = (0..3).map { i ->
            jsObject<NestedTableTableDataItem> {
                key = "$i"
                name = "Screen"
                platform = "iOS"
                version = "10.3.4.5654"
                upgradeNum = 500
                creator = "Jack"
                createdAt = "2014-12-24 23:12:00"
            }
        }.toTypedArray()

        table<NestedTableTableDataItem, TableComponent<NestedTableTableDataItem>> {
            attrs {
                className = "components-table-demo-nested"
                columns = tableColumns
                expandedRowRender = expandRowRender
                dataSource = data
            }
        }
    }
}

fun RBuilder.nestedTableApp() = child(NestedTableApp::class) {}

fun RBuilder.nestedTable() {
    styledDiv {
        css { +TableStyles.nestedTable }
        nestedTableApp()
    }
}
