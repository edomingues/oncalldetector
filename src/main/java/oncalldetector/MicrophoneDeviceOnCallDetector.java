package oncalldetector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MicrophoneDeviceOnCallDetector {
    private boolean onCall;

    public boolean isOnCall() throws IOException {
        String micDevice = "/dev/snd/pcmC0D0c";
        String[] commands = {"fuser", micDevice};

        Process process = Runtime.getRuntime().exec(commands);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(process.getInputStream()));

        boolean isMicBeingUsed = false;

        if(stdInput.readLine() != null) {
            isMicBeingUsed = true;
        }

        return isMicBeingUsed;
    }
}
