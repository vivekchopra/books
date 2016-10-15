package com.wrox.begjsp.ch28.bookstore;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class ShoppingCart
{
    private Set items = null;

    public ShoppingCart()
    {
        items = new HashSet();
    }

    public void addOrIncrementItem(OrderItem toAdd)
    {
        OrderItem existing = getItemForBook(toAdd.getBook());

        if (existing != null)
        {
            removeItem(existing);

            int qty = existing.getQty();
            toAdd.setQty(toAdd.getQty() + qty);
        }

        addItem(toAdd);
    }

    public void replaceItem(OrderItem toReplace)
    {
        OrderItem existing = getItemForBook(toReplace.getBook());

        if (existing != null)
        {
            removeItem(existing);
        }

        addItem(toReplace);
    }

    private void addItem(OrderItem item)
    {
        items.add(item);
    }

    public void removeItem(OrderItem item)
    {
        items.remove(item);
    }

    public void clear()
    {
        items.clear();
    }

    public Set getItems()
    {
        return items;
    }

    public int getItemCount()
    {
        return items.size();
    }

    private OrderItem getItemForBook(Book book)
    {
        Iterator it = items.iterator();

        while (it.hasNext())
        {
            OrderItem item = (OrderItem) it.next();

            if (item.getBook().equals(book))
            {
                return item;
            }
        }

        return null;
    }

    public float getValue()
    {
        Set items = getItems();
        float result = 0.0f;

        Iterator it = items.iterator();

        while (it.hasNext())
        {
            OrderItem i = (OrderItem) it.next();
            result += i.getValue();
        }

        return result;
    }
}
