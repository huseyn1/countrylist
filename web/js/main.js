function getCountries(){
                $.ajax({
                    url : 'searchCountryCity?action=getCountries',
                    type: 'GET',
                    dataType: 'json',
                    success:function (data, textStatus, jqXHR) {
                        var countries = $("#country-list");
                        $.each(data, function (index, value){
                            countries.append("<option value='"+ value.countryId +"'>"+ value.countryName +"</option>");
                        });
                       
                    }
                });
           }
            
function getCities(){
    
    var country_id = $("#country-list").find("option:selected").val();
                $.ajax({
                    url : 'searchCountryCity?action=getCities&countryId=' + country_id,
                    type: 'GET',
                    dataType: 'json',
                    success: function (data, textStatus, jqXHR) {
                        
                        var state_list = $("#state-list");
                        state_list.empty();
                        $.each(data, function (index, value){
                            state_list.append("<option value='"+ value.cityId +"'>"+ value.cityName +"</option>");
                        });
                       
                    }
                });
           };
            
            $(document).ready(function (){
                alert('jquery isledi');
                getCountries();
            });


