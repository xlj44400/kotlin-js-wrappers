package antd.upload

import react.*

external object DraggerComponent : Component<DraggerProps, RState> {
    override fun render(): ReactElement?
}

external interface DraggerProps : UploadProps {
    var height: Number?
}
