package digital.softwareshinobi.scrum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = "digital.softwareshinobi")
//@ComponentScan
@SpringBootApplication
public class SoftwareShinobiScrum {

    public static void main(final String[] commandLineArgs) {
        
        SpringApplication.run(SoftwareShinobiScrum.class, commandLineArgs);
        
    }

}
