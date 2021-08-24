package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product book1 = new Book(1, "Алиса в стране чудес", 1000, "Л.Кэрролл");
    private Product book2 = new Book(2, "Приключения Буратино", 1000, "А.Н.Толстой");
    private Product smartphone1 = new Smartphone(3, "Galaxy", 10000, "Samsung");
    private Product smartphone2 = new Smartphone(4, "Redmi", 11000, "Xiaomi");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void shouldByNameBook() {
        Product[] actual = manager.searchBy("Алиса в стране чудес");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldByAuthorBook() {
        Product[] actual = manager.searchBy("А.Н.Толстой");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldByNameSmartphone() {
        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = new Product[]{smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldByManufacturerBook() {
        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = new Product[]{smartphone2};

        assertArrayEquals(expected, actual);
    }


}

