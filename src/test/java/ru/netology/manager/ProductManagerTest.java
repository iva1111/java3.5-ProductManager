package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product book1 = new Book(1, "Алиса в стране чудес", 1000, "Л.Кэрролл");
    private Product book2 = new Book(2, "Приключения Буратино", 1000, "А.Н.Толстой");
    private Product book3 = new Book(3, "Алиса в Зазеркалье", 1000, "Л.Кэрролл");
    private Product smartphone1 = new Smartphone(4, "Galaxy", 10000, "Samsung");
    private Product smartphone2 = new Smartphone(5, "Redmi", 11000, "Xiaomi");
    private Product smartphone3 = new Smartphone(6, "Galaxy II", 10000, "Samsung");

    @BeforeEach
    public void addProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldFindByNameBook() {
        Product[] actual = manager.searchBy("Алиса в стране чудес");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByAuthorBook() {
        Product[] actual = manager.searchBy("А.Н.Толстой");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByNameSmartphone() {
        Product[] actual = manager.searchBy("Galaxy");
        Product[] expected = new Product[]{smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldByFindManufacturerSmartphone() {
        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = new Product[]{smartphone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldByFindSmartphoneSeveralManufacturers() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{smartphone1, smartphone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneByNotExistingManufacturer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBookByNotExistingAuthor() {
        Product[] actual = manager.searchBy("А.C.Пушкин");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldByFindBookSeveralAuthor() {
        Product[] actual = manager.searchBy("Л.Кэрролл");
        Product[] expected = new Product[]{book1, book3};
        assertArrayEquals(expected, actual);
    }

}

