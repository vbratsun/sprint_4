import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.models.OrderData;
import ru.yandex.practicum.models.RentData;
import ru.yandex.practicum.pages.home.HomePage;
import ru.yandex.practicum.pages.order.OrderPage;
import ru.yandex.practicum.pages.order.RentPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(Parameterized.class)
public class TestLoginFlow extends TestBase{

    private final String name;
    private final String surname;
    private final String address;
    private final String subwayStation;
    private final String phone;
    private final int daysToAdd;
    private final String rentLengthPeriod;

    public TestLoginFlow(String name, String surname, String address, String subwayStation, String phone, int daysToAdd, String rentLengthPeriod) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phone = phone;
        this.daysToAdd = daysToAdd;
        this.rentLengthPeriod = rentLengthPeriod;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Иван", "Иванов", "ул. Каретная, д. 37", "Белокаменная", "+78001000000", 1, "сутки"},
                {"Кирилл", "Кириллов", "ул. Мира, д. 3", "Черкизовская", "+78001000000", 2, "двое суток"},
        };
    }

    @Test
    public void testPositiveLoginFromHeaderFlow() {
        OrderData orderdata = new OrderData(
                this.name,
                this.surname,
                this.address,
                this.subwayStation,
                this.phone
        );

        RentData rentData = new RentData(
                this.getDateInDaysFromNow(this.daysToAdd),
                this.rentLengthPeriod
        );

        HomePage homePage = new HomePage(this.driver);
        homePage.clickTopOrderButton();

        OrderPage orderPage = new OrderPage(this.driver);
        orderPage.fillInForm(orderdata);

        RentPage rentPage = new RentPage(this.driver);
        rentPage.fillInForm(rentData);
        rentPage.confirmOrder();

        Assert.assertTrue("Заказ не был создан", rentPage.isOrderCreated());
    }

    @Test
    public void testPositiveLoginFromBodyFlow() {
        OrderData orderdata = new OrderData(
                this.name,
                this.surname,
                this.address,
                this.subwayStation,
                this.phone
        );

        RentData rentData = new RentData(
                this.getDateInDaysFromNow(this.daysToAdd),
                this.rentLengthPeriod
        );

        HomePage homePage = new HomePage(this.driver);
        homePage.clickTopOrderButton();

        OrderPage orderPage = new OrderPage(this.driver);
        orderPage.fillInForm(orderdata);

        RentPage rentPage = new RentPage(this.driver);
        rentPage.fillInForm(rentData);
        rentPage.confirmOrder();

        Assert.assertTrue("Заказ не был создан", rentPage.isOrderCreated());
    }

    private String getDateInDaysFromNow(int daysToAdd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return LocalDate.now().plusDays(daysToAdd).format(formatter);
    }
}
