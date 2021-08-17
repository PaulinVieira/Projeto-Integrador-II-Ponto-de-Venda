package Model;

import java.util.Date;
import lombok.Data;

@Data
public class Product {

    private int id;
    private String productCode;
    private String productCategory;
    private int productQuantity;
    private final int productQTDInitial = 0;
    private String productActive;
    private Double productPrice;
    private String productDescription;
    private Date productDtRegistration;
    private String productLocation;
  //private productPicture;
}
