package samples.list

import antd.avatar.*
import antd.icon.*
import antd.list.*
import antd.pagination.*
import kotlinext.js.*
import react.*
import react.dom.*
import styled.*

private interface VerticalListDataItem {
    var href: String
    var title: String
    var avatar: String
    var description: String
    var content: String
}

private val listData = (0..23).mapIndexed { i, _ ->
    jsObject<VerticalListDataItem> {
        href = "http://ant.design"
        title = "ant design part $i"
        avatar = "https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
        description = "Ant Design, a design language for background applications, is refined by Ant UED Team."
        content = "We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently."
    }
}.toTypedArray()

interface IconTextProps : RProps {
    var icon: ReactElement
    var text: String
}

private val iconText = functionalComponent<IconTextProps> { props ->
    span {
        childList += props.icon
        +" ${props.text}"
    }
}

fun RBuilder.iconText(handler: RHandler<IconTextProps>) = child(iconText, jsObject {}, handler)

fun RBuilder.vertical() {
    styledDiv {
        css { +ListStyles.vertical }
        list<VerticalListDataItem, ListComponent<VerticalListDataItem>> {
            attrs {
                itemLayout = "vertical"
                size = "large"
                pagination = jsObject<PaginationConfig> {
                    onChange = { page, _ ->
                        console.log(page)
                    }
                    pageSize = 3
                }
                dataSource = listData
                footer = buildElement {
                    div {
                        b { +"ant design" }
                        +" "
                        +"footer part"
                    }
                }
                renderItem = { item, _ ->
                    listItem {
                        attrs {
                            key = item.title
                            actions = arrayOf(
                                buildElement {
                                    iconText {
                                        attrs {
                                            icon = starOutlined {}
                                            text = "156"
                                        }
                                    }
                                },
                                buildElement {
                                    iconText {
                                        attrs {
                                            icon = likeOutlined {}
                                            text = "156"
                                        }
                                    }
                                },
                                buildElement {
                                    iconText {
                                        attrs {
                                            icon = messageOutlined {}
                                            text = "2"
                                        }
                                    }
                                }

                            )
                            extra = buildElement {
                                img {
                                    attrs {
                                        width = "272px"
                                        alt = "logo"
                                        src = "https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"
                                    }
                                }
                            }
                        }
                        listItemMeta {
                            attrs {
                                avatar = buildElement {
                                    avatar {
                                        attrs.src = item.avatar
                                    }
                                }
                                title = buildElement {
                                    a {
                                        attrs.href = item.href
                                        +item.title
                                    }
                                }
                                description = item.description
                            }
                        }
                        +item.content
                    }
                }
            }
        }
    }
}
