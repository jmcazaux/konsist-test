import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.test.TestScope

class ArchitectureTests: FreeSpec({

    val scope = Konsist.scopeFromProject() - Konsist.scopeFromTest()
    val appLayer = Layer("app", "com.ironbird.app..")
    val libLayer = Layer("lib", "com.ironbird.lib..")

    println("*".repeat(80))
    println(scope)
    println("*".repeat(80))

    // This fails (as expected)
    // com.ironbird.app.Main.kt imports com.ironbird.lib.ia.NumberGuesser
    "app should not depend on lib" {
        scope.assertArchitecture(testName = koTestName) {
            appLayer.doesNotDependOn(libLayer)
        }
    }

    // This should fail.
    // com.ironbird.app.Main.kt imports com.ironbird.lib.ia.NumberGuesser
    "app should depend on nothing" {
        scope.assertArchitecture(testName = koTestName) {
            appLayer.dependsOnNothing()
        }
        // Or this...
        scope.files.assertArchitecture {
            appLayer.dependsOnNothing()
        }
    }

    // This should fail.
    // com.ironbird.lib.ia.NumberGuesser does NOT use anything in com.ironbird.app.* (it is the other way around)
    "lib should depend on app" {
        scope.assertArchitecture(testName = koTestName) {
            libLayer.dependsOn(appLayer)
        }
        //Or this
        scope.files.assertArchitecture {
            libLayer.dependsOn(appLayer)
        }

    }
})

val TestScope.koTestName: String
    get() = this.testCase.name.testName
