package koInAc.ch07;

import java.io.File;
import java.util.List;

interface FileContentProcessor {
    void processContents(File path,
                         byte[] binaryContents,
                         List<String> textContents);
}
