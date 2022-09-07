/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.video.v1.room.participant;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class AnonymizeUpdater extends Updater<Anonymize> {
    private final String pathRoomSid;
    private final String pathSid;

    /**
     * Construct a new AnonymizeUpdater.
     *
     * @param pathRoomSid The SID of the room with the participant to update
     * @param pathSid The SID that identifies the resource to update
     */
    public AnonymizeUpdater(final String pathRoomSid,
                            final String pathSid) {
        this.pathRoomSid = pathRoomSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated Anonymize
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Anonymize update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VIDEO.toString(),
            "/v1/Rooms/" + this.pathRoomSid + "/Participants/" + this.pathSid + "/Anonymize"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Anonymize update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Anonymize.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
    }
}