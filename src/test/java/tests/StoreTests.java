package tests;

import api.ApiTests;
import data.TestsData;
import io.qameta.allure.Owner;
import models.CreateOrderModel;
import models.LoginTestsResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static spec.Spec.requestSpec;
import static spec.Spec.responseSpec;

@DisplayName("Тесты оформления заказов в магазине")
@Tag("Store")
public class StoreTests extends TestBase {
    TestsData testsData = new TestsData();

    @Test
    @DisplayName("Создание заказа")
    @Owner("Тётушкин К.И.")
    void createOrderTest() {
        CreateOrderModel createOrderModel = new CreateOrderModel();
        createOrderModel.setId(testsData.id);
        createOrderModel.setPetId(testsData.petId);
        createOrderModel.setStatus(testsData.status);
        createOrderModel.setComplete(testsData.complete);
        createOrderModel.setQuantity(testsData.quantity);
        createOrderModel.setShipDate(testsData.shipDate);

        CreateOrderModel response = step("Отправка запроса на создание", () -> given(requestSpec)
                .when()
                .body(createOrderModel)
                .post("store/order")
                .then()
                .spec(responseSpec)
                .extract().as(CreateOrderModel.class));
        step("Проверка параметров в созданном заказе", () -> {
            assertEquals(testsData.id, response.getId());
            assertEquals(testsData.petId, response.getPetId());
            assertEquals(testsData.quantity, response.getQuantity());
            assertEquals(testsData.complete, response.isComplete());
        });
    }

    @Test
    @DisplayName("Получение информации о заказе")
    @Owner("Тётушкин К.И.")
    void checkCreateOrderTest() {
        step("Создание заказа", () -> ApiTests.createOrder(testsData.id, testsData.petId, testsData.quantity, testsData.shipDate, testsData.status, testsData.complete));
        CreateOrderModel response = step("Отправка запроса информации о заказе", () ->
                given(requestSpec)
                        .when()
                        .get("store/order/" + testsData.id)
                        .then()
                        .spec(responseSpec)
                        .extract().as(CreateOrderModel.class));
        step("Проверка информации о заказе", () -> assertEquals(testsData.petId, response.getPetId()));
    }

    @Test
    @DisplayName("Удаление заказа")
    @Owner("Тётушкин К.И.")
    void deleteOrderTest() {
        step("Создание заказа", () -> ApiTests.createOrder(testsData.id, testsData.petId, testsData.quantity, testsData.shipDate, testsData.status, testsData.complete));
        step("Проверка заказа", () -> ApiTests.checkOrder(testsData.id, testsData.petId));
        step("Удаление заказа", () -> given(requestSpec)
                .when()
                .delete("store/order/" + testsData.id)
                .then()
                .spec(responseSpec)
                .extract().as(LoginTestsResponseModel.class));
        step("Заказ удален", () -> ApiTests.checkDeleteOrder(testsData.id));
    }

}
