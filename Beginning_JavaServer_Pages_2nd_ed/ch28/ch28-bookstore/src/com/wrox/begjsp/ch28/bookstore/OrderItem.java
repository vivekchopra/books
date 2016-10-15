package com.wrox.begjsp.ch28.bookstore;

public class OrderItem extends BaseEntity
{
    private Book _book;
    private CustomerOrder _order;
    private int _qty = 0;
    private float _unitPrice = 0.0f;

    public OrderItem()
    {
    }

    public Book getBook()
    {
        return _book;
    }

    public String getBookDescription()
    {
        return _book.getDescription();
    }

    public int getBookId()
    {
        return _book.getId();
    }

    public String getBookName()
    {
        return _book.getName();
    }

    public CustomerOrder getOrder()
    {
        return _order;
    }

    public int getQty()
    {
        return _qty;
    }

    public float getUnitPrice()
    {
        return _unitPrice;
    }

    public float getValue()
    {
        return _unitPrice * _qty;
    }

    public void setBook(Book book)
    {
        _book = book;
    }

    public void setOrder(CustomerOrder order)
    {
        _order = order;
    }

    public void setQty(int qty)
    {
        _qty = qty;
    }

    public void setUnitPrice(float unitPrice)
    {
        _unitPrice = unitPrice;
    }

    public int hashCode()
    {
        return getBook().getId();
    }

    public boolean equals(Object o)
    {
        OrderItem i = (OrderItem) o;

        return _book.equals(i.getBook());
    }
}
