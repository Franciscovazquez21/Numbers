import java.io.Console;
import java.util.Scanner;
public class Main {
private static Player p1,p2;

    public static void main(String[] args) {
        //inicializacion de variables        
        Scanner scanner = new Scanner(System.in);
        p1=ingresarUsuario(scanner);
        p2=ingresarUsuario(scanner);
        String ganador="Felicitaciones-Has ganado!!";

        boolean hayGanador=false;
        boolean seguirJugando=true;
        int turno = 0;

        while(seguirJugando){
            ingresarNumero(p1,scanner);
            ingresarNumero(p2,scanner);
            while(!hayGanador){
                if(turno==0){
                    //turno p1 si acierta gana
                    if(p1.elegirNumero(p2,scanner)){
                        hayGanador=true;
                        p1.addPoint();
                    }else{
                        //cambia el turno
                        turno++;
                        p1.setMov();
                    }
                }else{
                    if(p2.elegirNumero(p1,scanner)){
                        p2.addPoint();
                        hayGanador=true;
                    }else{
                        //cambia el turno
                        turno--;
                        p2.setMov();
                    }   
                }
                if(hayGanador){
                    if(turno==0){
                        System.out.println(p1.getName()+" "+ganador+" Movimientos: "+p1.getMov()+ "NUMERO NO ADIVINADO: "+p1.getNumber().getNumber());
                        System.out.println();
                    }else{
                        System.out.println(p2.getName()+" "+ganador+" Movimientos: "+p2.getMov()+"NUMERO NO ADIVINADO: "+p2.getNumber().getNumber());
                    }
                    System.out.println("Puntaje: Jugador "+p1.getName()+"= "+p1.getPoints()+"\n"+
                                        "Puntaje: Jugador "+p2.getName()+"= "+p2.getPoints());        
                }
            }
            System.out.println("SEGUIR JUGANDO: Y / N");
                    String seguir = scanner.nextLine();    
                    if(!seguir.equals("Y")){
                        seguirJugando=false;
                        p1.resetMov();
                        p2.resetMov();
                    }
                    hayGanador=false;
        }
        scanner.close();
    }

    public static Player ingresarUsuario(Scanner scanner){
        Player p = null;
        System.out.println("Ingresar el nombre del Jugador");

        try {
            String playerName = scanner.nextLine();
            p = new Player(playerName);
        } catch (Exception e) {
            System.err.println(e);
        }
        return p;
    }

    public static void ingresarNumero(Player p, Scanner scanner){
        //hasta que no ingrese un numero valido no termina el metodo
        Number number=new Number();
        boolean eligioNumero=false;
        while(!eligioNumero){
            System.out.println(p.getName()+" ingresa 4 digitos del 1 al 9-sin repetir");
            Console console=System.console();
            char [] password=console.readPassword();
            String num = new String (password);
            if(number.isValid(num)){
                number.setNumber(num);
                p.setNumber(number);
                eligioNumero=true;
            }else{
                System.out.println("Numero incorrecto");
            }
        }
    }

}
