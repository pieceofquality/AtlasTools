package tools.atlas.tests;


import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getElement;
import static com.codeborne.selenide.Selenide.open;

public class ComissionCreationTest{

    @Test
        public void comissionManualCreation(){
        open("https://dev.atlas.tools");

        //        Authorization
        $("#email").setValue("odminnevmenyaem@gmail.com");
        $("#password").setValue("fingerprint");
        $(".btn.btn-primary.pull-right").click();

        open("https://dev.atlas.tools/admin/commissions");
        $(".fa.fa-plus").click();
        $("[name=total").setValue("5000");
        $("[name=customer").setValue("CustomerTest");
        $("[name=tax").setValue("100");
        $("[name=baseAgent").setValue("23");
        $(Selectors.byText("Charged")).click();

        $("tbody .list-row:nth-child(1) .fa.fa-edit").click();
    }

}
