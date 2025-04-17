plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.coderpakistan.auth.presentation"

}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}