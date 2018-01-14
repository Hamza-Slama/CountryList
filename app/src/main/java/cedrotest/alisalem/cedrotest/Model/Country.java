package cedrotest.alisalem.cedrotest.Model;

/**
 * Created by hamza on 27/12/17.
 */

public class Country {
   String flag;
    String name ;
    String capital;
    String region;
    String population;

    public Country(String flag, String name, String capital,String region,  String population) {
        this.flag = flag;
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.population = population;

    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getRegion() {
        return region;
    }

    public String getPopulation() {
        return population;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String  flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
