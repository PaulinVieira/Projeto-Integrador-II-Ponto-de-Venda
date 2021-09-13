
package Model;

import lombok.Data;

@Data
public class ItemsSale {
    
    int id;
    Product p;
    
    int quantidade;
    Double vlTUnit;
    Double vlDesc;
    Double vlTotal;
}
