import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SearchTest {

    //Java
    //Python
    //bicycle

    @ParameterizedTest
    @MethodSource("validData")
    public void validSearch(String query){
        open("https://duckduckgo.com/");
        $(byId("searchbox_input")).shouldBe(visible).setValue(query);
        $("[class*=\"searchbox_input\"]").click();
        ElementsCollection queryResults = $$("[data-testid=\"result\"]");
        for (SelenideElement result: queryResults) {
            result.shouldHave(text(query));
        }
    }
    static Stream<Arguments> validData () {
        return Stream.of(
                arguments("java"),
                arguments("python"),
                arguments("bicycle")
        );
    }
}
