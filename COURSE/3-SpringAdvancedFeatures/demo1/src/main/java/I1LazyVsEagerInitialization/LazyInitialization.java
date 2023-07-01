package I1LazyVsEagerInitialization;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
class Dependency{

}


@Component
@Lazy
public class LazyInitialization {
    private final Dependency dependency;


    public LazyInitialization(Dependency dependency){
        System.out.println("INJECTION HAS MADE");
        this.dependency = dependency;
    }



}
