package Model;

import java.sql.Date;
import lombok.Data;

@Data
public class Client {
    
    private int id;
    private String clientCode;
    private String clientCPF;
    private String clientName;
    private String clientDtBirth; 
    private String clientEmail;
    private String clientCellphone;
    private Date   clientDtLastBuy;
    private String clientPostcode;
    private String clientAddress;
    private String clientDistrict;
    private String clientState;
    private String clientCity;
    private String clientObs;

}
