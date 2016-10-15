package com.wrox.begjsp.ch28.bookstore;

import java.sql.Date;

import java.util.Iterator;
import java.util.Set;


public class CustomerOrder extends BaseEntity
{
    private String _firstName;
    private String _lastName;
    private String _address;
    private String _zipCode;
    private Date _orderDate;
    private OrderStatus _status;
    private String _cardNumber; //test: 4111111111111111
    private Set _orderItems;

    public String getAddress()
    {
        return _address;
    }

    public void setAddress(String address)
    {
        _address = address;
    }

    public String getFirstName()
    {
        return _firstName;
    }

    public void setFirstName(String firstName)
    {
        _firstName = firstName;
    }

    public String getLastName()
    {
        return _lastName;
    }

    public void setLastName(String lastName)
    {
        _lastName = lastName;
    }

    public Date getOrderDate()
    {
        return _orderDate;
    }

    public void setOrderDate(Date orderDate)
    {
        _orderDate = orderDate;
    }

    public OrderStatus getStatus()
    {
        return _status;
    }

    public void setStatus(OrderStatus status)
    {
        _status = status;
    }

    public String getZipCode()
    {
        return _zipCode;
    }

    public void setZipCode(String zipcode)
    {
        _zipCode = zipcode;
    }

    public String getCardNumber()
    {
        return _cardNumber;
    }

    public void setCardNumber(String cardNumber)
    {
        _cardNumber = cardNumber;
    }

    public Set getOrderItems()
    {
        return _orderItems;
    }

    public void setOrderItems(Set orderItems)
    {
        _orderItems = orderItems;
    }

    public float getValue()
    {
        Iterator it = _orderItems.iterator();
        float result = 0.0f;

        while (it.hasNext())
        {
            OrderItem item = (OrderItem) it.next();
            result += item.getValue();
        }

        return result;
    }
}
