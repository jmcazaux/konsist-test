import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.verify.assertTrue
import io.kotest.core.spec.style.FreeSpec

class NestedPropertiesTest: FreeSpec({
    val scope = Konsist.scopeFromProject() - Konsist.scopeFromTest()

    "!Print all classes in the scope" {
        scope.classes().forEach {
            println("${it.fullyQualifiedName ?: it.name} in ${it.moduleName}")
        }
    }

    "klass.properties(includeNested = true) should list Bar" {
        scope.classes().filter { it.name.contains("Foo") }.assertTrue(
            testName = this.testCase.name.testName,
            additionalMessage = "Aggregates and read models should not include any field of type Valid*Phone"
        ) { klass ->

            println(" Class -> $klass")

            klass.properties(includeNested = true).forEach { prop ->
                println(
                    "   Property:  ${prop.name} -> ${prop.type}"
                )
                // FIXME: Should this drill down into Bar? That is the class of the 'bar' property of Foo.
            }

            return@assertTrue true
        }
    }
})
