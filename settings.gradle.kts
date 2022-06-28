pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Stuff Counter"
include (":app")
include(":homeFeature")
include(":addStuffFeature")
include(":core")
include(":common:theme")
include(":stuffDecriptionFeature")
include(":common:components")
include(":local")
