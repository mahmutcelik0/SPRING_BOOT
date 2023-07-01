package I2SingletonVsPrototypeScopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//DEFAULT SCOPE IS SINGLETON
@Component
public class SingletonClass {
}


@Component
@Scope(value = "prototype")
class PrototpyeClass{

}