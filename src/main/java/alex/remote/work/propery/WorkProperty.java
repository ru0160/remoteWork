package alex.remote.work.propery;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "work")
public class WorkProperty {
    private String pathGradle;
    private String pathGradleOut;
    private String pathGradleCopy;
}
