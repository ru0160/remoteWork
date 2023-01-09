package alex.remote.work.controller;

import alex.remote.work.service.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final EngineService service;

    @GetMapping("gradle/zip")
    public void confirm() throws IOException {
        service.process();
    }

}
