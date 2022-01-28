import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class SomeNewMockableClass {
    public List<String> countries;
    public RandomCountryGenerator countryGenerator;

    public SomeNewMockableClass() {
        countries = new ArrayList<>();
    }

    public String RoutineToBeMocked(int index){
        return countries.get(index);
    }

    public void AddCountry(String countryName){
        countries.add(countryName);
    }

    public void RemoveCountry(String countryName){
        countries.remove(countryName);
    }

    public Optional<String> GetFirstCountryByFirstLetter(char letter){
        return countries.stream().filter((country) -> country.charAt(0) == letter).findFirst();
    }

    public int GetCountryInBytesLength(int index){
        return countries.get(index).getBytes().length;
    }

    public List<String> GetCountriesByFirstLetter(char letter){
        return countries.stream().filter((country) -> country.charAt(0) == letter).collect(Collectors.toList());
    }

    public String MergeTwoCountryNames(String countryName1, String countryName2){
        return countryName1 + "-" + countryName2;
    }
}
