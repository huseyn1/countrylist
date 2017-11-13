
package Controller;

import DAO.CountryCityList;
import DAO.OracleInterface;
import Model.City;
import Model.Country;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Countrylist extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
                   throws ServletException, IOException {
        
    } 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String action = req.getParameter("action");
        if (action.equals("getCountries")){
            
            OracleInterface countryList=new CountryCityList();
            List<Country> countries= countryList.getCountries();
            ServletOutputStream outputStream = resp.getOutputStream();
            ObjectMapper mapper = new ObjectMapper(); 
            
            mapper.writeValue(outputStream, countries);
            
            
        } 
        else if (action.equals("getCities")){
            OracleInterface cityList = new CountryCityList();
            int countryId = Integer.parseInt(req.getParameter("countryId"));
            
            List<City> citys= cityList.getCities(countryId);
            ServletOutputStream outputStream = resp.getOutputStream();
            ObjectMapper mapper = new ObjectMapper(); 
            
            mapper.writeValue(outputStream, citys);
        
        }
    }
    
    private void myMethod(HttpServletRequest req, HttpServletResponse resp){
    
    
    
    }

}
