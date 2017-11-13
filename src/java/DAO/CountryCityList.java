
package DAO;

import Model.City;
import Model.Country;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountryCityList extends OracleConnect implements OracleInterface{

    @Override
    public List<Country> getCountries() {
        List<Country> countrys=new ArrayList<>();
         try {
            String countryQuery="select co_id,co_name from country";
           
            open();
            
            preparedStatement=connection.prepareStatement(countryQuery);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Country c = new Country(resultSet.getInt("co_id"), resultSet.getString("co_name")); 
                countrys.add(c);
            }
            return countrys;
        } catch (SQLException ex) {
           ex.printStackTrace();
                   return null;
        }

   }

    @Override
    public List<City> getCities(int countryId) {
      
        List<City> cities =new ArrayList<>();
         try {
            String cityQuery="select c_id,c_name,co_id from city where co_id=?";
           
            open();
            
            preparedStatement=connection.prepareStatement(cityQuery);
            preparedStatement.setInt(1, countryId);
            
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                City c = new City(resultSet.getInt("c_id"), resultSet.getString("c_name"), resultSet.getInt("co_id"));
                cities.add(c);
            }
            return cities;
        } catch (SQLException ex) {
           ex.printStackTrace();
                   return null;
        }

    } 
    
}
