version = "8.1.0-pre.3"

apply(plugin = "kotlin-js-wrapper")
apply(plugin = "kotlin-js-wrapper-publish")

dependencies {
    "implementation"("org.jetbrains:kotlin-react:$kotlinReactVersion-kotlin-$kotlinVersion")
}
