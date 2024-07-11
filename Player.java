public class Player{

    private String name;
    private Number number;

    public Player(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    private void setNumber(String number){
        this.number=new Number(number);
    }
}