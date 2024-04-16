package bt8;
import java.io.Serializable;
public class Product implements Serializable {
    private int id;
    private String productName;
    private String manufacturer; // Changed from 'Manufacturer' to 'manufacturer'
    private int price;
    private String otherDescription;

    public Product(int id, String productName, String manufacturer, int price, String otherDescription) {
        this.id = id;
        this.productName = productName;
        this.manufacturer = manufacturer; // Changed from 'Manufacturer' to 'manufacturer'
        this.price = price;
        this.otherDescription = otherDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer; // Changed from 'Manufacturer' to 'manufacturer'
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer; // Changed from 'Manufacturer' to 'manufacturer'
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' + // Changed from 'Manufacturer' to 'manufacturer'
                ", price=" + price +
                ", otherDescription='" + otherDescription + '\'' +
                '}';
    }
}