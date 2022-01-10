import com.afrunt.imdb.model.Name;
import com.afrunt.imdb.model.TitleBasics;
import com.afrunt.imdb.reactiveclient.IMDbClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calculator;
    private IMDbClient iMDB;

    @BeforeEach
    public void SetUp()
    {
        calculator = new Calculator();
        iMDB = new IMDbClient();
    }

        @Test
    public void CheckIfCalculatorIsNotNull()
    {
        assertNotNull(calculator);
    }

        @Test
    public void CheckCantDivideByZero()
    {
        calculator = new Calculator(2, 0);

        assertThrows(IllegalArgumentException.class, ()->{
            calculator.Divide();
        });
    }

        @Test
    public void CanSetnumber1()
    {
        calculator.number1 = 1;

        Assertions.assertEquals(calculator.number1, 1.0);
    }

        @Test
    public void CanSetnumber2()
    {
        calculator.number2 = 2;

        Assertions.assertEquals(calculator.number2, 2.0);
    }

        @Test
    public void CheckAddResultCorrect()
    {
        calculator = new Calculator(2, 2);
        float result = calculator.Add();

        Assertions.assertEquals(result, 4.0);
    }

        @Test
    public void CheckSubstractResultCorrect()
    {
        calculator = new Calculator(2, 2);
        float result = calculator.Subtract();

        Assertions.assertEquals(result, 0.0);
    }

        @Test
    public void CheckDivideResultCorrect()
    {
        calculator = new Calculator(2, 2);
        float result = calculator.Divide();

        Assertions.assertEquals(result, 1.0);
    }

        @Test
    public void CheckMultiplyResultCorrect()
    {
        calculator = new Calculator(2, 2);
        float result = calculator.Multiply();

        Assertions.assertEquals(result, 4.0);
    }

        @Test
    public void CheckCalculatorInstanceNotChange()
    {
        calculator.number1 = 2;
        calculator.number2 = 4;

        calculator.Add();

        Calculator ein = calculator;

        calculator.number1 = 5;
        calculator.number2 = 5;

        calculator.Multiply();

        Calculator zwei = calculator;

        assertEquals(ein, zwei);
    }

        @Test
    public void ResultsDiffersPerOperation()
    {
        calculator.number1 = 2;
        calculator.number2 = 4;

        float res1 = calculator.Add();

        calculator.number1 = 5;
        calculator.number2 = 5;

        float res2 = calculator.Multiply();

        assertNotSame(res1, res2);
    }

    @Test
    public void CheckPowerResultCorrect(){
        calculator.number1 = 2;
        calculator.number2 = 8;

        float result = calculator.Power();

        Assertions.assertEquals(result, 256);
    }

    @Test
    public void CheckAbsoluteResultCorrect(){
        calculator.number1 = 2;
        calculator.number2 = 8;

        float result = calculator.Absolute();

        Assertions.assertEquals(result, 6);
    }

    @Test
    public void CheckMinusPowerResult(){
        calculator.number1 = 2;
        calculator.number2 = -1;

        float result = calculator.Power();

        Assertions.assertEquals(result, 0.5);
    }

    @Test
    public void CheckPowerForZero(){
        calculator.number1 = 2;
        calculator.number2 = 0;

        float result = calculator.Power();

        Assertions.assertEquals(result, 1);
    }

    @Test
    public void AddNumberToResult(){
        calculator.number1 = 2;
        calculator.number2 = 8;

        float result = calculator.Add();

        Assertions.assertEquals(result, 10);

        calculator.number1 = 1000;

        result = calculator.Add(true);

        Assertions.assertEquals(result, 1010);
    }

    @Test
    public void AddingWrongNoDoesntAddToResult(){
        calculator.number1 = 2;
        calculator.number2 = 8;

        float result = calculator.Add();

        Assertions.assertEquals(result, 10);

        calculator.number2 = 1000;

        result = calculator.Add(true);

        Assertions.assertEquals(result, 12);
    }

    @Test
    public void MinusAfterAddition(){
        calculator.number1 = 2;
        calculator.number2 = 8;

        float result = calculator.Add();

        Assertions.assertEquals(result, 10);

        calculator.number1 = 1000;

        result = calculator.Subtract(true);

        Assertions.assertEquals(result, -990);
    }

    @Test
    public void GetHelloMovie(){
        calculator.number1 = 0.77f;
        calculator.number2 = 0.0034f;

        String result = calculator.EasterEggHello();
        //iMDB.fluxOf(TitleBasics.class).filter(name -> name.getOriginalTitle().contains("Hello")).subscribe();;

        Assertions.assertEquals(result, "Hello!");
    }

    @Test
    public void GetHelloMovieWrongOrder(){
        calculator.number1 = 0.0034f;
        calculator.number2 = 0.77f;

        String result = calculator.EasterEggHello();

        Assertions.assertNotEquals(result, "Hello!");
    }

    @Test
    public void MultiplyEasterEgg(){
        calculator.number1 = 6;
        calculator.number2 = 11;

        float result = calculator.Multiply();

        Assertions.assertEquals(result, 66);

        String resultName = calculator.EasterEggStarWars();

        Assertions.assertTrue(resultName.contains("Star Wars: Episode III - Revenge of the Sith"));
    }
}
