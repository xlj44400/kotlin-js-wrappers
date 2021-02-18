package samples.grid

import antd.grid.*
import react.*
import styled.*

fun RBuilder.responsive() {
    styledDiv {
        css { +GridStyles.responsive }
        row {
            col {
                attrs {
                    xs = 2
                    sm = 4
                    md = 6
                    lg = 9
                    xl = 10
                }
                +"Col"
            }
            col {
                attrs {
                    xs = 20
                    sm = 16
                    md = 12
                    lg = 8
                    xl = 4
                }
                +"Col"
            }
            col {
                attrs {
                    xs = 2
                    sm = 4
                    md = 6
                    lg = 9
                    xl = 10
                }
                +"Col"
            }
        }
    }
}
