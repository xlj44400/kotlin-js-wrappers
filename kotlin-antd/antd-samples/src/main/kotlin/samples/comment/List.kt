package samples.comment

import antd.comment.*
import antd.list.*
import antd.tooltip.*
import kotlinext.js.*
import moment.*
import react.*
import react.dom.*
import styled.*

private val data = arrayOf<CommentProps>(
    jsObject {
        actions = arrayOf(buildElement {
            span { +"Reply to" }
        })
        author = "Han Solo"
        avatar = "https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
        content = buildElement {
            p {
                +"""
                        We supply a series of design principles, practical patterns and high quality design
                        resources (Sketch and Axure), to help people create their product prototypes beautifully and
                        efficiently.
                    """.trimIndent()
            }
        }
        datetime = buildElement {
            tooltip {
                attrs.title = moment()
                    .subtract(1, "days")
                    .format("YYYY-MM-DD HH:mm:ss")
                span {
                    +moment().subtract(1, "days").fromNow()
                }
            }
        }
    },
    jsObject {
        actions = arrayOf(buildElement {
            span { +"Reply to" }
        })
        author = "Han Solo"
        avatar = "https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
        content = buildElement {
            p {
                +"""
                        We supply a series of design principles, practical patterns and high quality design
                        resources (Sketch and Axure), to help people create their product prototypes beautifully and
                        efficiently.
                    """.trimIndent()
            }
        }
        datetime = buildElement {
            tooltip {
                attrs.title = moment()
                    .subtract(2, "days")
                    .format("YYYY-MM-DD HH:mm:ss")
                span {
                    +moment().subtract(2, "days").fromNow()
                }
            }
        }
    }
)

fun RBuilder.list() {
    styledDiv {
        css { +CommentStyles.list }
        list<CommentProps, ListComponent<CommentProps>> {
            attrs {
                className = "comment-list"
                header = "${data.size} replies"
                itemLayout = "horizontal"
                dataSource = data
                renderItem = { item, _ ->
                    li {
                        comment {
                            attrs {
                                actions = item.actions
                                author = item.author
                                avatar = item.avatar
                                content = item.content
                                datetime = item.datetime
                            }
                        }
                    }
                }
            }
        }
    }
}
