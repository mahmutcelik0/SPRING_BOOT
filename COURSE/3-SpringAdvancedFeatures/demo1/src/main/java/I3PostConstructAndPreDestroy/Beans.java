package I3PostConstructAndPreDestroy;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Beans {
    private Dependency dependency;

    public Beans(Dependency dependency) {
        this.dependency = dependency;
        System.out.println("DEPENDENCY INJECTED or INITIALIZED");
    }

    @PostConstruct
    public void dependencyWired(){
        dependency.call();
    }

    @PreDestroy
    public void beanRemoved(){
        System.out.println(getClass().getSimpleName() + " REMOVED");
    }
}



@Component
class Dependency{
    public void call(){
        System.out.println("METHOD IS READY");
    }
}
