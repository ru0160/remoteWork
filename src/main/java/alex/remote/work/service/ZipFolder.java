package alex.remote.work.service;

import java.io.IOException;

public interface ZipFolder {
    void add(String filename, String pathSource, String pathDestination) throws IOException;
}
