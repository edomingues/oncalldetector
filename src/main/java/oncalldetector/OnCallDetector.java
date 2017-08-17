package oncalldetector;

import java.io.IOException;

public interface OnCallDetector {
    boolean isOnCall() throws IOException;
}
