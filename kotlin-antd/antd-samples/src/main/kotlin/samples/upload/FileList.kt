package samples.upload

import antd.button.*
import antd.icon.*
import antd.upload.*
import kotlinext.js.*
import react.*
import styled.*

interface MyUploadState : RState {
    var fileList: Array<UploadFile>
}

class MyUpload : RComponent<RProps, MyUploadState>() {
    private val handleChange = fun(info: UploadChangeParam<UploadFile>) {
        var newFileList = info.fileList

        // 1. Limit the number of uploaded files
        // Only to show two recent uploaded files, and old ones will be replaced by the new
        newFileList = newFileList.slice(-2..0).toTypedArray()

        // 2. Read from response and show file link
        newFileList = newFileList.map { file ->
            if (file.response != null) {
                // Component will show file.url as link
                file.url = file.response.asDynamic().url.unsafeCast<String>()
            }

            return@map file
        }.toTypedArray()

        // 3. Filter successfully uploaded files according to response from server
        newFileList = newFileList.filter { file ->
            if (file.response != null) {
                return@filter file.response.asDynamic().status.unsafeCast<String>() == "success"
            }

            return@filter true
        }.toTypedArray()

        setState {
            fileList = newFileList
        }
    }

    override fun MyUploadState.init() {
        fileList = arrayOf(jsObject {
            uid = "-1"
            name = "xxx.png"
            status = "done"
            url = "http://www.baidu.com/xxx.png"
        })
    }

    override fun RBuilder.render() {
        upload {
            attrs {
                action = "//jsonplaceholder.typicode.com/posts/"
                onChange = handleChange
                multiple = true
                fileList = state.fileList
            }
            button {
                uploadOutlined {}
                +"Upload"
            }
        }
    }
}

fun RBuilder.myUpload() = child(MyUpload::class) {}

fun RBuilder.fileList() {
    styledDiv {
        css { +UploadStyles.fileList }
        myUpload()
    }
}
