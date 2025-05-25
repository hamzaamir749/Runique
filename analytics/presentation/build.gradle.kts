plugins {
    alias(libs.plugins.runique.android.feature.ui)
}
android {
    namespace = "com.coderpakistan.analytics.presentation"

}

dependencies {
    implementation(projects.analytics.domain)
}