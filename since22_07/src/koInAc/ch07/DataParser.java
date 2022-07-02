package koInAc.ch07;

import java.io.File;
import java.util.List;

public interface DataParser<T> {
    void parseData(String input,
                   List<T> output,
                   List<String> errors);
}
/*
package koInAc.ch07;

        import java.io.File;
        import java.util.List;

interface FileContentProcessor {
    void processContents(File path,
                         byte[] binaryContents,
                         List<String> textContents);
}*/
