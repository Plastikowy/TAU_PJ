import com.afrunt.imdb.reactiveclient.IMDbClient;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

public class SomeNewMockableClassTest {

    SomeNewMockableClass instance;

    @BeforeEach
    public void SetUp(){
        instance = mock(SomeNewMockableClass.class);
        instance.countryGenerator = new RandomCountryGenerator() {
            @Override
            public String GetRandomCountryName() {
                return "Francja Elegancja";
            }
        };
    }

    @Test
    public void InstaceNotNull(){
        Assertions.assertNotNull(instance);
    }

    @Test
    public void mockito_when_donothing(){
        instance.countries = new ArrayList<>();

        doNothing().when(instance).AddCountry(anyString());

        instance.AddCountry("POLAND");
        instance.AddCountry("GERMANY");

        Assertions.assertEquals(0, instance.countries.size());
    }

    @Test
    public void mockito_when_callrealmethod(){
        instance.countries = new ArrayList<>();

        doCallRealMethod().when(instance).AddCountry(anyString());
        instance.AddCountry("Burkina Faso");

        Assertions.assertEquals("Burkina Faso", instance.countries.get(0));
    }

    @Test
    public void mockito_given(){
        given(instance.MergeTwoCountryNames(anyString(), anyString())).willReturn("Nothing in return");

        assertNotEquals("Burkina-Faso", instance.MergeTwoCountryNames("Burkina", "Faso"));
    }

    @Test
    public void mockito_stub(){
        assertEquals("Francja Elegancja", instance.countryGenerator.GetRandomCountryName());
    }
}
