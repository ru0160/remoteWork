package alex.remote.work.service;

import alex.remote.work.propery.WorkProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class EngineServiceImpl implements EngineService {
    private final ClearService clearService;
    private final CopyService copyService;
    private final GradleAddToZip gradleAddToZip;
    private final WorkProperty property;

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void process() throws IOException {
        clearAllSaveFile();
        copyService.copyFolder(property.getPathGradle(), property.getPathGradleCopy());
        gradleAddToZip.add();
        copyService.copyFolder(property.getPathGradleOut(), property.getPathCloudFolder());
    }

    private void clearAllSaveFile() throws IOException {
        clearService.clear(property.getPathGradleOut());
        clearService.clear(property.getPathGradleCopy());
        clearService.clear(property.getPathCloudFolder());
    }
}
