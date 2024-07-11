import java.util.Scanner;
public class Main {
private static Player p1,p2;
    public static void main(String[] args) {
        
        ingresarUsuario(p1);
        ingresarUsuario(p2);

        System.out.println("Player1: "+p1.getName()+"-Player2: "+p2.getName());


    }

    public static void ingresarUsuario(Player p){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("ingrese el nombre del Jugador");

        try {
            String playerName = scanner.nextLine();
            p = new Player(playerName);
        } catch (Exception e) {
            System.err.println(e);
        }

        scanner.close();
    }
    
}
