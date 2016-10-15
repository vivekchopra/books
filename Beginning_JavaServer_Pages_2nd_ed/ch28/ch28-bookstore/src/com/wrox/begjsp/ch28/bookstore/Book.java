package com.wrox.begjsp.ch28.bookstore;

public class Book extends BaseEntity
{
    private Category _category;
    private String _description;
    private String _name;
    private float _unitPrice;

    public Book()
    {
    }

    public Category getCategory()
    {
        return _category;
    }

    public String getDescription()
    {
        return _description;
    }

    public String getName()
    {
        return _name;
    }

    public float getUnitPrice()
    {
        return _unitPrice;
    }

    public void setCategory(Category category)
    {
        _category = category;
    }

    public void setDescription(String description)
    {
        _description = description;
    }

    public void setName(String name)
    {
        _name = name;
    }

    public void setUnitPrice(float price)
    {
        _unitPrice = price;
    }

    public int hashCode()
    {
        return getId();
    }

    public boolean equals(Object o)
    {
        Book b = (Book) o;

        if (getId() == b.getId())
        {
            return true;
        }

        return false;
    }
}
