import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    @Test
    public void validSearch(){
        open("https://duckduckgo.com/");
        $(byId("searchbox_input")).shouldBe(visible).setValue("Java");
        $("[class*=\"searchbox_input\"]").click();
        ElementsCollection results = $$("[data-testid=\"result\"]");
        for (SelenideElement result: results) {
            result.shouldHave(text("Java"));
        }
    }
}
