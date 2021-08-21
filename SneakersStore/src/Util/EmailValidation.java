package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
    
    //Para não utilizar API externa, foi utilizada uma expressão regular, apenas para 
    // validar que o usuário não digite um e-mail inválido. -> Este código não foi nossa autoria.
    //mas, os comentários sim, para demonstrar o entendimento.
    
    //Aqui utilizamos regex (expressão regular), basicamente é uma sequência de caracteres
    
    //https://receitasdecodigo.com.br/java/validar-email-em-java
    public boolean isValidEmail(String email) {
        
        
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            
            //Dados que são permitidos para o e-mail
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            
            //aqui compila a expressão regular criada -> passo minha expressão (padrão)
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            
            //encontra o correspodente (padrão criado), no caso é o e-mail recebido
            Matcher matcher = pattern.matcher(email);
            
            //verifica se está dentro dos requisitos da expressão regular, se estiver eu valido o e-mail
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
}
