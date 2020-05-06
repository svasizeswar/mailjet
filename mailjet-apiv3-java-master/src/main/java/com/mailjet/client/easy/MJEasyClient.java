package com.mailjet.client.easy;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.resource.Email;
import com.mailjet.client.resource.sms.SmsSend;

/**
 * Mailjet easy client
 */
public class MJEasyClient {
    private final MailjetClient client;
    
    public static final int NO_DEBUG = 0;
    public static final int VERBOSE_DEBUG = 1;
    public static final int NOCALL_DEBUG = 2;

    /**
     * Constructor with api keys
     * @param apiKeyPublic Public API Key
     * @param apiKeyPrivate Private API Key
     */
    public MJEasyClient(String apiKeyPublic, String apiKeyPrivate) {
        client = new MailjetClient(apiKeyPublic, apiKeyPrivate);
    }
    
    /**
     * Constructor with token
     * @param token V4 api token
     */
    public MJEasyClient(String token) {
        client = new MailjetClient(token, new ClientOptions("v4"));
    }

    /**
     * Constructor using the MJ_APIKEY_PUBLIC and MJ_APIKEY_PRIVATE environment variables.
     */
    public MJEasyClient() {
        client = new MailjetClient(System.getenv("MJ_APIKEY_PUBLIC"), System.getenv("MJ_APIKEY_PRIVATE"));
    }

    /**
     * Get the interal Mailjet client
     * @return MailjetClient instance
     */
    public MailjetClient getClient() {
        return client;
    }

    public MJEasyClient setDebug(int debug) {
        client.setDebug(debug);
        return this;
    }
    
    /**
     * Create an MJEasyEmail instance to prepare an email to send.
     * @return MJEasyEMail instance
     */
    public MJEasyEmail email() {
        return new MJEasyEmail(this, new MailjetRequest(Email.resource));
    }
    
    /**
     * Create an {@link MJEasySms} instance to prepare an email to send.
     * @return {@link MJEasyClient} instance
     */
    public MJEasySms sms() {
        return new MJEasySms(this, new MailjetRequest(SmsSend.resource));
    }
}
