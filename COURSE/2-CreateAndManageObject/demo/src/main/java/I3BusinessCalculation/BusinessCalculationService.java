package I3BusinessCalculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {
    private DataService dataService;

    @Autowired //NOT NECESSARY
    public BusinessCalculationService(@Qualifier("mySQLDataService") DataService dataService){
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retireveData()).max().orElse(0);
    }


}
