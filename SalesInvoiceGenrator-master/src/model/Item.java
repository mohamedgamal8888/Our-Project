package model;

public class Item {
    private InvoiceHeader inv;
    private String name ;
    private int count;
    private double price;
    public Item(/*InvoiceHeader inv,*/ String name, int count, double price) {
        //this.inv = inv;
        this.name = name;
        this.count = count;
        this.price = price;
    }
    public InvoiceHeader getInv() {
        return inv;
    }
    public void setInv(InvoiceHeader inv) {
        this.inv = inv;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Invoice line{" + "inv=" + inv + ", name=" + name + ", count=" + count + ", price=" + price + '}';
    }
 public double getTotal(){
    return price*count;
 }
}