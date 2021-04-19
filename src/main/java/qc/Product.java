package qc;

public class Product {
    public String brand;
    public String generic;
    public String price;

    public void setBrand(String auto) {
        brand=auto;
    }

    public String getBrand(){
        return brand;
    }

    public void setGeneric (String generic) {
        //s=modelId;
        this.generic=generic;
    }

    public String getGeneric() {
        return generic;
    }


    public void setPrice(String price) {
        // s=modelAuto;
        this.price=price;
    }

    public String getPrice() {
        return price;
    }

  }
