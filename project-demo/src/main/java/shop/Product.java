package shop;

public class Product {
    private int id;
    private String productName;
    private Double price;

    public Product(int id, String productName, Double price){
        super();
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }
}