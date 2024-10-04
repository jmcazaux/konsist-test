import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import io.kotest.core.spec.style.FreeSpec

class ArchitectureTests: FreeSpec({

    val scope = Konsist.scopeFromProject() - Konsist.scopeFromTest()

    println("*".repeat(80))
    println(scope)
    println("*".repeat(80))

    // This should fail.
    // com.ironbird.app.Main.kt imports com.ironbird.lib.ia.NumberGuesser
    "app should depend on nothing" {
        scope.assertArchitecture {
            val appLayer = Layer("app", "com.ironbird.app..")
            appLayer.dependsOnNothing()
        }
    }

    // This should fail.
    // com.ironbird.lib.ia.NumberGuesser does NOT use anything in com.ironbird.app.* (it is the other way around)
    "lib should depend on app" {
        scope.assertArchitecture {
            val appLayer = Layer("app", "com.ironbird.app..")
            val libLayer = Layer("lib", "com.ironbird.lib..")
            libLayer.dependsOn(appLayer)
        }
    }
})
