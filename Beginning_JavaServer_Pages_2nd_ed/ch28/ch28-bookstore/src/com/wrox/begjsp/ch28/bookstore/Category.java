package com.wrox.begjsp.ch28.bookstore;

import java.util.List;


public class Category extends BaseEntity
{
    private List _books;
    private String _description;
    private String _name;

    public Category()
    {
    }

    public int getBookCount()
    {
        return _books.size();
    }

    public List getBooks()
    {
        return _books;
    }

    public String getDescription()
    {
        return _description;
    }

    public String getName()
    {
        return _name;
    }

    public void setBooks(List books)
    {
        _books = books;
    }

    public void setDescription(String description)
    {
        _description = description;
    }

    public void setName(String name)
    {
        _name = name;
    }
}
