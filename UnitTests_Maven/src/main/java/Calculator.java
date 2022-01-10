import com.afrunt.imdb.model.Name;
import com.afrunt.imdb.model.TitleBasics;
import com.afrunt.imdb.reactiveclient.IMDbClient;

import java.util.Optional;

public class Calculator {
    public float number1;
    public float number2;
    public float result;
    public IMDbClient iMDB;
    public String movie;

    public Calculator(float number1, float number2)
    {
        this.number1 = number1;
        this.number2 = number2;
        iMDB = new IMDbClient();
    }

    public Calculator()
    {
        iMDB = new IMDbClient();
    }

    public float Add()
    {
        result = number1 + number2;
        return result;
    }

    public float Add(boolean toPreviousResult){
        result += number1;
        return result;
    }

    public float Subtract()
    {
        result = number1 - number2;
        return result;
    }

    public float Subtract(boolean toPreviousResult){
        result -= number1;
        return result;
    }

    public float Divide()
    {
        if (number1 == 0 || number2 == 0)
            throw new IllegalArgumentException("You can't divide by 0");

        result = number1 / number2;
        return result;
    }

    public float Multiply()
    {
        result = number1 * number2;
        return result;
    }

    public float Power(){
        result = (float)Math.pow(number1, number2);
        return result;
    }

    public float Absolute(){
        result = Math.abs(number1 - number2);
        return result;
    }

    public String EasterEggHello(){

        if(number1 == 0.77f && number2 == 0.0034f){
            Optional<TitleBasics> entryMovie = iMDB.fluxOf(TitleBasics.class).filter(name -> name.getOriginalTitle().equals("Hello!")).toStream().findFirst();
            movie = entryMovie.get().getOriginalTitle();
        }

        return movie;
    }

    public String EasterEggStarWars(){
        if (result == 66){
            Optional<TitleBasics> entryMovie = iMDB.fluxOf(TitleBasics.class).filter(name -> name.getOriginalTitle().contains("Revenge of the Sith")).toStream().findFirst();
            movie = entryMovie.get().getOriginalTitle();
        }

        return movie;
    }
}
