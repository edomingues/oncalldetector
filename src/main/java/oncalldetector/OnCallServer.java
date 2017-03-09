package oncalldetector;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

class OnCallServer {

    private static final String HOST = "http://192.168.2.20";

    public void setUserOnCall(String userName, boolean isOnCall) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(HOST).path("script/SetUserOnCall").queryParam("userName", userName).queryParam("onCallState", isOnCall);

        Response response = target.request().get();

        try {

            if (response.getStatusInfo().getFamily() != Response.Status.Family.SUCCESSFUL) {
                throw new RuntimeException("No success response: status = '" + response.getStatus() + "', reason = '" + response.getStatusInfo().getReasonPhrase() + "'");
            }

        } finally {
            response.close();
        }
    }
}
