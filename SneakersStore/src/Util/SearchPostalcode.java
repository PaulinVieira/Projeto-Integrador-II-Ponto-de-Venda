package Util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import Model.Client;
import javax.swing.JOptionPane;

public class SearchPostalcode {
    
    public Client Search (String postalCode, Client c){
        
        String json;        
        
        try {
            
            URL url = new URL("http://viacep.com.br/ws/"+ postalCode +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");
            
            c.setClientAddress(array[7]);            
            c.setClientDistrict(array[15]);
            c.setClientCity(array[19]); 
            c.setClientState(array[23]);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique o CEP informado e teste novamente.", "Erro sistema" , 0);
            throw new RuntimeException(e);
        }
        return c;
    }
    }
   
