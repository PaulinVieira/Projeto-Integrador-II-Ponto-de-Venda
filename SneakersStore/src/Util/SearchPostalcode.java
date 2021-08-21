package Util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import Model.Client;
import java.io.IOException;
import javax.swing.JOptionPane;

public class SearchPostalcode {
    
    //Para a busca automática do CEP foi utilizada uma API, está já utilizamos em aplicações 
    //WEB no PI do 4º Semestre
    public Client Search (String postalCode, Client c){
        
        String json;        
        
        try {
            //URL, passando o CEP
            URL url = new URL("http://viacep.com.br/ws/"+ postalCode +"/json");
            
            URLConnection urlConnection = url.openConnection();
            
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();
            //bufferedreader pra ler cada linha do meu json
            //expressão lambda pra concatenar os objetos de texto usando 'append', trim somente para retirar espaços
            br.lines().forEach(l -> jsonSb.append(l.trim()));
            
            //passa o json pra string
            json = jsonSb.toString();
            
            //mesmo caso das expressões regulares para separar os valores da saida do json
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");
            
            c.setClientAddress(array[7]);            
            c.setClientDistrict(array[15]);
            c.setClientCity(array[19]); 
            c.setClientState(array[23]);
            
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Verifique o CEP informado e teste novamente.", "Erro sistema" , 0);
            throw new RuntimeException(e);
        }
        return c;
    }
    }
   
