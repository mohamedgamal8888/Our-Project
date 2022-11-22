package model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    private int num;
    private String name ;
    private Date date ;
    /**
     *
     */
    private ArrayList <Item> items;
    public InvoiceHeader(int num, String name, Date date) {
        this.num = num;
        this.name = name;
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public void setDate() {
        setDate(null);
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList <Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "num=" + num + ", name=" + name + ", date=" + date + ", item=" +"items" + '}';
    }
    public double getTotal(){
     double total=0;
    for(Item item: getItems())
    { total+=item.getTotal();
    }
    return total;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
