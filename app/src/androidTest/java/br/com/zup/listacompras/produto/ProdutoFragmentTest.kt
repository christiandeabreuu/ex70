package br.com.zup.listacompras.produto

import android.view.View
import android.widget.EditText
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.withId
import br.com.zup.listacompras.R
import org.junit.Test
import java.util.regex.Pattern.matches


internal class ProdutoFragmentTest{

     @Test
     fun checkValidationProdutoFragment_AllBarEmpty() {
         val scenario = launchFragmentInContainer<ProdutoFragment>()
         onView(ViewMatchers.withId(R.id.bvAdicionar)).perform(ViewActions.click())
         onView(hasErrorText("preencha o campo detalhe"))
             .check(ViewAssertions.matches(ViewMatchers.withId(R.id.etDetalheProduto)))
         onView(hasErrorText("preencha o campo nome"))
             .check(ViewAssertions.matches(ViewMatchers.withId(R.id.etNomeProduto)))
     }

    @Test
    fun checkValidationProdutoFragment_snackBarNameIsEmpty() {
        val scenario = launchFragmentInContainer<ProdutoFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.etNomeProduto))
            .perform(ViewActions.typeText("TesteNome"))
        Espresso.onView(ViewMatchers.withId(R.id.bvAdicionar))
            .perform(ViewActions.click())
        Espresso.onView(hasErrorText("preencha o campo detalhe"))
            .check(ViewAssertions.matches(ViewMatchers.withId(R.id.etDetalheProduto)))
    }

    @Test
    fun checkValidationProdutoFragment_snackBarDetailIsEmpty() {
        val scenario = launchFragmentInContainer<ProdutoFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.etDetalheProduto))
            .perform(ViewActions.typeText("TesteDetalhe"))
        ViewActions.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.bvAdicionar))
            .perform(ViewActions.click())
        Espresso.onView(hasErrorText("preencha o campo nome"))
            .check(ViewAssertions.matches(ViewMatchers.withId(R.id.etNomeProduto)))
    }
//felipe que fez essa funcao de teste
//    @Test
//    fun detalheShowErrorAndNomeDoesnt_whenOnlyDetalheIsEmpty(){
//        val scenario = launchFragmentInContainer<ProdutoFragment>()
//        onView(withId(R.id.etNomeProduto)).perform(typeText("jkgkjgk"))
//        onView(withId(R.id.bvAdicionar)).perform(click())
//        onView(withId(R.id.etDetalheProduto))
//            .check(matches(hasErrorText("Por favor preencha o campo de detalhe")))
//        onView(withId(R.id.etNomeProduto))
//            .check(matches(hasNoErrorText()))
//    }
//              felipe que fez essa fun que retorna um boolean pra falar se tem erro no edit text
//
//fun hasNoErrorText(): BoundedMatcher<View?, EditText> {
//    return object : BoundedMatcher<View?, EditText>(EditText::class.java) {
//
//        override fun matchesSafely(view: EditText): Boolean {
//            return view.error == null
//        }
//
//        override fun describeTo(description: org.hamcrest.Description?) {
//            description?.appendText("has no error text: ");
//        }
//    }
}


}