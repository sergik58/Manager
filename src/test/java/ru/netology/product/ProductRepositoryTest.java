package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    Book book1 = new Book(10, "The Jungle Book", 500, "Kipling");
    Book book2 = new Book(5, "The Green Mile", 300, "King");
    Book book3 = new Book(7, "The Godfather", 100, "Puzo");
    Smartphone smartphone1 = new Smartphone(2, "Meizu Pro 6s", 1000, "Meizu");
    Smartphone smartphone2 = new Smartphone(4, "Nokia N 95", 500, "Nokia");


    @Test
    public void AddProduct() {
        repo.add(book2);
        repo.add(smartphone2);
        repo.add(book3);
        Product[] expected = {book2, smartphone2, book3};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void RemoveById() {
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(book2);
        repo.removeByID(7);
        Product[] expected = {smartphone1, book2};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SaveProduct() {
        repo.save(book2);
        repo.save(smartphone2);
        repo.save(book3);
        Product[] expected = {book2, smartphone2, book3};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void DeleteNoRealID() {
        ProductRepository repo = new ProductRepository();
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(book3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeByID(50);
        });
    }

    @Test
    public void DeleteRealID() {
        repo.add(book2);
        repo.add(book1);
        repo.add(smartphone1);
        repo.removeByID(5);
        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }


}

