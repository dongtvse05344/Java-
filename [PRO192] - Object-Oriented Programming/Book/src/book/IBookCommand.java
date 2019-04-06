/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

/**
 *
 * @author xhunt
 */
public interface IBookCommand {
    void addBook(Book book);
    Book findBookByID(int ID);
    Book updateBook(Book book);
    void showBook();
}
