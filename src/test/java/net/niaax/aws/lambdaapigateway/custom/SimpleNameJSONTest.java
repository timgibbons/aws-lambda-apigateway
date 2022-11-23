package net.niaax.aws.lambdaapigateway.custom;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleNameJSONTest {

    @Test
    public void getName() {
        // Given
        SimpleNameJSON nameJSON = new SimpleNameJSON("Spock");

        // When / Then
        assertThat(nameJSON.getName()).isEqualTo("Spock");
    }

    @Test
    public void setName() {
        // Given
        SimpleNameJSON nameJSON = new SimpleNameJSON();

        // When
        nameJSON.setName("Spock");

        // Then
        assertThat(nameJSON.getName()).isEqualTo("Spock");
    }
}