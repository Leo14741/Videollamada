/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Safelist extends Resource {
    private static final long serialVersionUID = 134998900253888L;

    /**
     * Create a SafelistCreator to execute create.
     *
     * @param phoneNumber The phone number to be added in SafeList.
     * @return SafelistCreator capable of executing the create
     */
    public static SafelistCreator creator(final String phoneNumber) {
        return new SafelistCreator(phoneNumber);
    }

    /**
     * Create a SafelistFetcher to execute fetch.
     *
     * @param pathPhoneNumber The phone number to be fetched from SafeList.
     * @return SafelistFetcher capable of executing the fetch
     */
    public static SafelistFetcher fetcher(final String pathPhoneNumber) {
        return new SafelistFetcher(pathPhoneNumber);
    }

    /**
     * Create a SafelistDeleter to execute delete.
     *
     * @param pathPhoneNumber The phone number to be removed from SafeList.
     * @return SafelistDeleter capable of executing the delete
     */
    public static SafelistDeleter deleter(final String pathPhoneNumber) {
        return new SafelistDeleter(pathPhoneNumber);
    }

    /**
     * Converts a JSON String into a Safelist object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Safelist object represented by the provided JSON
     */
    public static Safelist fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Safelist.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Safelist object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Safelist object represented by the provided JSON
     */
    public static Safelist fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Safelist.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String phoneNumber;
    private final URI url;

    @JsonCreator
    private Safelist(@JsonProperty("sid")
                     final String sid,
                     @JsonProperty("phone_number")
                     final String phoneNumber,
                     @JsonProperty("url")
                     final URI url) {
        this.sid = sid;
        this.phoneNumber = phoneNumber;
        this.url = url;
    }

    /**
     * Returns The unique string that identifies the resource..
     *
     * @return The unique string that identifies the resource.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The phone number in SafeList..
     *
     * @return The phone number in SafeList.
     */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Returns The absolute URL of the SafeList resource..
     *
     * @return The absolute URL of the SafeList resource.
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Safelist other = (Safelist) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(phoneNumber, other.phoneNumber) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            phoneNumber,
                            url);
    }
}