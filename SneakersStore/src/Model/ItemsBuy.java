
package Model;

import lombok.Data;

@Data
public class ItemsBuy {
    
    int id;
    Product p;
    
    int quantidade;
    Double vlDesc;
    Double vlTotal;
    
}
