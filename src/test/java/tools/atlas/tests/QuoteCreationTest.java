package tools.atlas.tests;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.waiting;

public class QuoteCreationTest {

    @Test
    public void createQuote(){

        open("https://dev.atlas.tools");

//        Authorization
        $("#email").setValue("odminnevmenyaem@gmail.com");
        $("#password").setValue("fingerprint");
        $(".btn.btn-primary.pull-right").click();
        $(".fa.fa-plus").click();

//      Outbound segment
        $("#tickets_outbound [name=origin_name]").click();
        $("#tickets_outbound [name=origin_name]").setValue("NYC");
        sleep(1000);
//        waitUntil($("#tickets_outbound [name=origin_name]").shouldHave(value("NYC")), 5);
//        Wait().until(valueToBePresentInElementLocated(By.cssSelector("#tickets_outbound [name=origin_name]"), "NYC"));
        $("#tickets_outbound [name=destination_name]").click();
        $("#tickets_outbound [name=destination_name]").setValue("MOW");
        sleep(1000);
        $("#tickets_outbound [name=origin_time_orig]").setValue("12:00");
        $("#tickets_outbound [name=destination_time_orig]").setValue("12:00");
        $("#quote_outbound_tickets_attributes_0_departure_date").click();
        $(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[3]/a")).click();
        $("#quote_outbound_tickets_attributes_0_flight_number").setValue("111");
        $("#quote_outbound_tickets_attributes_0_cabin").setValue("Economy");
        $("#quote_outbound_tickets_attributes_0_airline").setValue("111");
        $("#quote_outbound_tickets_attributes_0_aircraft").setValue("111");
        $("#quote_outbound_tickets_attributes_0_mileage_info").setValue("111");
        $("#quote_outbound_tickets_attributes_0_taxes").setValue("111");

//      Inbound segment
//        $("#tickets_inbound [name=origin_name]").setValue("NYC");
        $("#tickets_inbound [name=destination_name]").setValue("NYC");
        sleep(1000);
        $("#tickets_inbound [name=origin_time_orig]").setValue("12:00");
        $("#tickets_inbound [name=destination_time_orig]").setValue("12:00");
        $("#quote_inbound_tickets_attributes_0_departure_date").click();
        $(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[3]/a")).click();
        $("#quote_inbound_tickets_attributes_0_flight_number").setValue("111");
        $("#quote_inbound_tickets_attributes_0_cabin").setValue("Economy");
        $("#quote_inbound_tickets_attributes_0_airline").setValue("111");
        $("#quote_inbound_tickets_attributes_0_aircraft").setValue("111");
        $("#quote_inbound_tickets_attributes_0_mileage_info").setValue("111");
        $("#quote_inbound_tickets_attributes_0_taxes").setValue("111");

//        Passenger Info
        $("#quote_fname").setValue("FirstName");
        $("#quote_email").setValue("test@example.com");
        $("#quote_price").setValue("5000");
        $("input[value=Send]").click();

//        Check alert
        $(".alert").shouldHave(text("Quote was successfully created."));

//        Check quote
        open("https://dev.atlas.tools/admin/quotes");
        $("tbody .list-row:nth-child(1) .fa.fa-edit").click();

//        Assertions
        $("#tickets_inbound [name=destination_name]").shouldHave(value("NYC"));
        $("#tickets_inbound [name=origin_time_orig]").shouldHave(value("12:00"));
        $("#tickets_inbound [name=destination_time_orig]").shouldHave(value("12:00"));
        $("#quote_inbound_tickets_attributes_0_departure_date").shouldHave(value("May 31, 2016"));
        $("#quote_inbound_tickets_attributes_0_flight_number").shouldHave(value("111"));
        $("#quote_inbound_tickets_attributes_0_cabin").shouldHave(value("Economy"));
        $("#quote_inbound_tickets_attributes_0_airline").shouldHave(value("111"));
        $("#quote_inbound_tickets_attributes_0_aircraft").shouldHave(value("111"));
        $("#quote_inbound_tickets_attributes_0_mileage_info").shouldHave(value("111"));
        $("#quote_inbound_tickets_attributes_0_taxes").shouldHave(value("111"));
        $("#quote_fname").shouldHave(value("FirstName"));
        $("#quote_email").shouldHave(value("test@example.com"));
        $("#quote_price").shouldHave(value("5000"));
    }
}
