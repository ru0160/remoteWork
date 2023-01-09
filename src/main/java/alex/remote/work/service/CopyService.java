package alex.remote.work.service;

import org.springframework.stereotype.Component;

@Component
public interface CopyService {
    void copyFolder(String source, String destination);
}
