
package DAO;

import Model.City;
import Model.Country;
import java.util.List;

public interface OracleInterface {
    public List<Country> getCountries();
    public List<City> getCities(int countryId);
}
