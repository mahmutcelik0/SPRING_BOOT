package I2DependencyInjectionTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessClass{
    //OUTPUT WILL BE USING: NULL --- USING: NULL BECAUSE WE DIDN'T INJECT BEANS
    //TO INJECT THEM WE CAN USE @AUTOWIRED - 1)TO CONSTRUCTOR , 2)TO SETTER , 3)TO FIELD (not recommended)


    /*
    //CONSTRUCTOR INJECTION
    DependencyOne dep1;
    DependencyTwo dep2;

    @Autowired
    public BusinessClass(DependencyOne dep1 , DependencyTwo dep2){
        this.dep1 = dep1;
        this.dep2 = dep2;
    }*/

    //SETTER INJECTION
    DependencyOne dep1;
    DependencyTwo dep2;

    @Autowired
    public void setDep1(DependencyOne dep1) {
        this.dep1 = dep1;
    }

    @Autowired
    public void setDep2(DependencyTwo dep2) {
        this.dep2 = dep2;
    }

    /*
    // FIELD INJECTION
    @Autowired
    DependencyOne dep1;
    @Autowired
    DependencyTwo dep2;
    */

    @Override
    public String toString(){
        return "USING: "+ dep1 + "\t --- \t USING: "+ dep2;
    }

}

@Component
class DependencyOne{

}

@Component
class DependencyTwo{

}

