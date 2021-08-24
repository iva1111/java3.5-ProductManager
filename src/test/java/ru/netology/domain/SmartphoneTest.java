package ru.netology.domain;

import org.junit.jupiter.api.Test;

public class SmartphoneTest extends Product {
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Smartphone smartphone = new Smartphone();
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new SmartphoneTest();
        if (product instanceof SmartphoneTest) {
            SmartphoneTest smartphone = (SmartphoneTest) product;
        }
    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new SmartphoneTest();
        product.toString();
    }

}
