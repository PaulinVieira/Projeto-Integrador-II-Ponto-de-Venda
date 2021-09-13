package Model;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Sale {
    
    private int idSale;
    private Client c;
    
    private char formaPgto;
    private Double vlTotal;
    private Double vlDesc;
    private Date date;
    private List<ItemsSale> itemsSale;
   
}
