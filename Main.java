import java.io.Console;
import java.util.Scanner;
public class Main {
private static Player p1,p2;

    public static void main(String[] args) {
        //inicializacion de variables        
        Scanner scanner = new Scanner(System.in);
        p1=ingresarUsuario(scanner);
        ingresarNumero(p1,scanner);
        p2=ingresarUsuario(scanner);
        ingresarNumero(p2,scanner);
        String ganador="Felicitaciones-Has ganado!!";

        boolean hayGanador=false;
        int turno = 0;
        //mientras no haya ganador
        //jugar turnos
        while(!hayGanador){
            if(turno==0){
                //turno p1 si acierta gana
                if(p1.elegirNumero(p2,scanner)){
                    hayGanador=true;
                }else{
                    //cambia el turno
                    turno++;
                }
            }else{
                if(p2.elegirNumero(p1,scanner)){
                    hayGanador=true;
                }else{
                    //cambia el turno
                    turno--;
                }
                
            }
        }

        if(turno==0){
            System.out.println(p1.getName()+" "+ganador);
        }else{
            System.out.println(p2.getName()+" "+ganador);
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
