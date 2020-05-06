package com.mailjet.client.request;
 
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Contactslist;
import com.mailjet.client.resource.Contact;
import org.json.JSONArray;
import org.json.JSONObject;

public class ContactList {
    public static void main(String[] args) throws MailjetException, MailjetSocketTimeoutException {
      MailjetClient client;
      MailjetRequest request;
      MailjetResponse response;
      String apiPublicKey = "8fa199ba7049e99c35bd8cb8ba516164";
      String apiPrivateKey = "e9a5a1ec08e25a96535a9e796f71f82b";
      Integer ID = 18212;
      client = new MailjetClient(apiPublicKey, apiPrivateKey, new ClientOptions("v3"));
      request = new MailjetRequest(Contact.resource);
      response = client.get(request);
      System.out.println(response.getStatus());
      System.out.println(response.getData());
    }
}