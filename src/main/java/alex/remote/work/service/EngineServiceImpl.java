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
public class EngineServiceImpl {
    private final ClearService clearService;
    private final CopyService copyService;
    private final ZipFolder zipFolder;
    private final WorkProperty property;
    
    @EventListener(ApplicationReadyEvent.class)
    public void processGradle() throws IOException {
        clearGradleAll();
        copyService.copyFolder(property.getPathGradle(), property.getPathGradleCopy());
        zipFolder.add("/gradle.zip", property.getPathGradleCopy(), property.getPathGradleOut());
        copyService.copyFolder(property.getPathGradleOut(), property.getPathCloudFolder());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void processM2() throws IOException {
        clearM2All();
        copyService.copyFolder(property.getPathM2(), property.getPathM2Copy());
        zipFolder.add("/m2.zip", property.getPathM2Copy(), property.getPathM2Out());
        copyService.copyFolder(property.getPathM2Out(), property.getPathM2CloudFolder());
    }

    private void clearM2All() throws IOException {
        clearService.clear(property.getPathM2Out());
        clearService.clear(property.getPathM2Copy());
        clearService.clear(property.getPathM2CloudFolder());
    }

    private void clearGradleAll() throws IOException {
        clearService.clear(property.getPathGradleOut());
        clearService.clear(property.getPathGradleCopy());
        clearService.clear(property.getPathCloudFolder());
    }
}
