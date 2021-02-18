package antd.message

typealias Key = String

typealias NoticeType = String /* "info" | "success" | "error" | "warning" | "loading" */

typealias ConfigContent = Any /* ReactElement | String */
typealias ConfigDuration = Any /* Number | () -> Unit */
typealias JointContent = Any /* ConfigContent | ArgsProps */
typealias ConfigOnClose = () -> Unit
