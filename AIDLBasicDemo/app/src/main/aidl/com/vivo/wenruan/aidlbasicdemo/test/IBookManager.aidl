package com.vivo.wenruan.aidlbasicdemo.test;
import com.vivo.wenruan.aidlbasicdemo.test.Book;

interface IBookManager {
    void addBook(in Book book);

    List<Book> getBookList();
}
