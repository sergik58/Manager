package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    @Test
    public void searchProduct(){
        Book book1 = new Book(10, "The Jungle Book", 500, "Kipling");
        Book book2 = new Book(5, "The Green Mile",300,"King");
        Book book3 = new Book(7,"The Godfather", 100,"Puzo");

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Jungle");
        Product[] expected = { book1 };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void  searchProductNoMatch(){
        Book book1 = new Book(10, " The Jungle Book", 500, "Kipling");
        Book book2 = new Book(5, "The Green Mile",300,"King");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(book2);
        Product[] actual = manager.searchBy("Soccer");
        Product [] expected = {} ;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchEmptyProduct(){
        Book book1 = new Book(5, "The Green Mile", 300, "King");
        Book book2 = new Book(3, "The Green planet", 200, "Dumas");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Product[] actual = manager.searchBy("Green");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchDifferentProduct() {
        Book book1 = new Book(10, "The Jungle Book",500 , "Kipling");
        Smartphone smartphone1 = new Smartphone(2, "Meizu Pro 6s", 1000, "Meizu");
        Book book3 = new Book(7,"The Godfather", 100,"Puzo");
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book3);

        Product[] actual = manager.searchBy("The");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }
}
