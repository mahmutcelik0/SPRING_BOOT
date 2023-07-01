package I3BusinessCalculation;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService {
    @Override
    public int[] retireveData() {
        return new int[]{1,2,3,4,5};
    }
}
