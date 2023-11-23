package PaooGame.Exceptions;

public class InvalidDataLoaded extends Exception{
    public InvalidDataLoaded(String message){
        super(message);
    }

    public InvalidDataLoaded(){
        super("Invalid Data input from the Database!");
    }
}
