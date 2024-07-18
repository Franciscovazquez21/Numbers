import java.util.Scanner;

public class Player{

    private String name;
    private Number number;
    private int points;

    public Player(String name){
        this.name=name;
        this.points=0;
    }

    public String getName(){
        return name;
    }

    public Number getNumber(){
        return number;
    }

    public int getPoints(){
        return points;
    }

    public void addPoint(){
        points++;
    }

    public void resetPoints(){
        this.points=0;
    }

    public void setNumber(Number n){
        this.number=n;
    }


    public boolean elegirNumero(Player p, Scanner scanner){
        boolean eligioNumero=false;
        String number="";
        while(!eligioNumero){
            System.out.println(this.getName()+" Elegir numero: ");
            number= scanner.nextLine();
            if(p.getNumber().isValid(number)){
                eligioNumero=true;
            }else{
                System.out.println("el numero elegido es incorrecto");
            }
        }

        if(p.getNumber().isSolution(number)){
            return true;
        }else{
           System.out.println(p.getNumber().getOcurrencies(number));
        }
        return false;
    }
}