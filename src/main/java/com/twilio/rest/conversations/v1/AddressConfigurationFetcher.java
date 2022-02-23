/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.conversations.v1;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class AddressConfigurationFetcher extends Fetcher<AddressConfiguration> {
    private final String pathSid;

    /**
     * Construct a new AddressConfigurationFetcher.
     *
     * @param pathSid The SID or Address of the Configuration.
     */
    public AddressConfigurationFetcher(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched AddressConfiguration
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public AddressConfiguration fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.CONVERSATIONS.toString(),
            "/v1/Configuration/Addresses/" + this.pathSid + ""
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("AddressConfiguration fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return AddressConfiguration.fromJson(response.getStream(), client.getObjectMapper());
    }
}