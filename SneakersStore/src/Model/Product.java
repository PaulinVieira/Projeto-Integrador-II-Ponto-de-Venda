package Model;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String productCode;
    private String productCategory;
    private String productQuantity;
    private String productSize;
    private Double productSaleprice;
  //private String productPicture;
}
