package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

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

    @Test
    void assertionsDemo() {
        assertAll("Group of assertions",
                () -> assertEquals(5, 2 + 3),
                () -> assertNotNull("hello"),
                () -> assertTrue(2 > 1)
        );

        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Invalid");
        });

        assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(50));
    }

    @Test
    void assumptionDemo() {
        assumeTrue(System.getProperty("os.name").contains("Linux"),
                "Test only runs on Linux");

        assumingThat(System.getenv("CI") != null,
                () -> assertTrue(true));
    }

    @Nested
    @DisplayName("📁 Nested test class")
    class NestedTests {

        @Test
        void nestedTest() {
            assertTrue(true);
        }
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void onlyOnLinux() {
        assertTrue(true);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "CI", matches = "true")
    void onlyOnCI() {
        assertTrue(true);
    }

    @Test
    @DisabledIfSystemProperty(named = "java.version", matches = "1\\..*")
    void onlyOnNewJava() {
        assertTrue(true);
    }

    @Test
    @Tag("slow")
    @Tag("integration")
    void taggedTest() {
        assertTrue(true);
    }
}
