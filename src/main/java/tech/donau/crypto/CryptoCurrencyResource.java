package tech.donau.crypto;


import org.eclipse.microprofile.rest.client.inject.RestClient;
import tech.donau.crypto.data.Currency;
import tech.donau.crypto.data.MultiPartBody;
import tech.donau.crypto.service.CurrencyService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.concurrent.CompletionStage;

@Path("crypto")
public class CryptoCurrencyResource {

    @Inject
    @RestClient
    private CurrencyService currencyService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<Collection<Currency>> getCrypto(@QueryParam("id") String id) {
        return currencyService.getCurrency(id);
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String echoFile(String body) {
        return body;
    }


    @Path("/file")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String callEcho() {
        final MultiPartBody multiPartBody = new MultiPartBody();
        multiPartBody.setFile(new ByteArrayInputStream("HELLOW WRLD".getBytes()));
        multiPartBody.setName("file.txt");
        return currencyService.sendFile(multiPartBody);
    }
}