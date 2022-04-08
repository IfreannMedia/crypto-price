package tech.donau.crypto;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CryptoCurrencyResourceTest {

    @Test
    public void testGetCurrencyByIdEndpoint() {
        given()
                .when().get("/crypto?id=1")
                .then()
                .statusCode(200)
                .body("$.size()", is(1),
                        "[0].id", is("1"),
                        "[0].name", is("Litecoin"));
    }

}