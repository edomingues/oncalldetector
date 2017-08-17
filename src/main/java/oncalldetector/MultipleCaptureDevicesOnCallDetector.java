package oncalldetector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class MultipleCaptureDevicesOnCallDetector implements OnCallDetector {

    private final String glob;

    public MultipleCaptureDevicesOnCallDetector(String glob) {
        this.glob = glob != null ? glob : "pcmC?D?c";
    }

    public boolean isOnCall() throws IOException {

        for (Path file : Files.newDirectoryStream(Paths.get("/dev/snd"), glob)) {

            System.out.println("Running fuser against file '" + file.toString() + "'");

            String[] commands = {"fuser", file.toString()};

            Process process = Runtime.getRuntime().exec(commands);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));


            String line;
            if ((line = stdInput.readLine()) != null) {
                return true;
            }
        }

        return false;
    }
}
