package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    private Book first = new Book(1, "One", 100, "Author1");
    private Book second = new Book(2, "Two", 200, "Author2");
    private Book third = new Book(3, "One", 300, "Author1");

    private Smartphone forth = new Smartphone(4, "Iphone13", 100_000, "Apple");
    private Smartphone fifth = new Smartphone(5, "Xiomi redmi note 9", 15_000, "Xiomi");
    private Smartphone sixth = new Smartphone(6, "Iphone12", 50_000, "Apple");

    @BeforeEach
    public void save() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    void shouldSearchOneBookByAuthor() {

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Author2");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchFewBookByAuthor() {

        Product[] expected = new Product[]{first, third};
        Product[] actual = manager.searchBy("Author1");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchOneBookByName() {

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Two");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchFewBookByName() {

        Product[] expected = new Product[]{first, third};
        Product[] actual = manager.searchBy("One");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchOneBookByNotExistingAuthor() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Author10");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchOneBookByNotExistingName() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Ten");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchOneSmartphoneByProduction() {

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Xiomi");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchFewSmartphonesByProduction() {

        Product[] expected = new Product[]{forth, sixth};
        Product[] actual = manager.searchBy("Apple");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Xiomi redmi note 9");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByNotExistingProduction() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByNotExistingName() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Samsung Galaxy");

        assertArrayEquals(expected, actual);
    }

}