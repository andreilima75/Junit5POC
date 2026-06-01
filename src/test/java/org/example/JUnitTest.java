package org.example;

import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnitTest {

    @Test
    @Order(1)
    void simpleTest() {
        assertEquals(4, 2 + 2, "basico");
    }

    @Test
    void failingAssertion() {
        assertTrue(true, "mensagem");
    }
}
