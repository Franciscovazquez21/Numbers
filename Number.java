import java.util.HashSet;
import java.util.Set;

public class Number {
    //el numero no puede tener repetidos y el rango es del 1 al 9
    private String number;
    private Set<String>range;
    private int maxNum;
    
    public Number(){
        this.range=new HashSet<>(){{//se usa un set(conjunto para luego corroborar repetidos/rango correcto)
            add("0");add("1");add("2");add("3");add("4");add("5");
            add("6");add("7");add("8");add("9");}};
        this.maxNum=4;
    }   

    private boolean isSolution(String number){
        return this.number.equals(number);
    }

    private boolean isValid(String externalNumber){
        String [] number = externalNumber.split("");
        if(number.length==this.maxNum){
            for(int i=0; i<number.length;i++){
                if(!range.contains(number[i]))
                    return false;
            }
            return true;
        }
        return false;
    }

    private String getOcurrencies(String externalNumber){
        String result= externalNumber+"";
        int regularOcurrency=0, exactOcurrency=0;
        String [] originalNumber= this.number.split("");
        String [] userNumber= externalNumber.split("");
        
        for(int i=0; i<originalNumber.length;i++){
            for(int j=0;j<userNumber.length;i++){
                if(originalNumber[i].equals(userNumber[i])){
                    exactOcurrency++;
                }else if(originalNumber[i].equals(userNumber[j])){
                    regularOcurrency++;
                }
            }
        }
        if(exactOcurrency!=0 || regularOcurrency!=0){

            if(exactOcurrency!=0){
                result+= "-"+exactOcurrency+" Bien";
            }
            if(regularOcurrency!=0){
                result+= "-"+regularOcurrency+" Regular";
            }
        
        }else{
            result+="No hay coincidencias";
        }
        return result;
    }



}


