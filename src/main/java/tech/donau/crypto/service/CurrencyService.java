package tech.donau.crypto.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import tech.donau.crypto.data.Currency;
import tech.donau.crypto.data.MultiPartBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.concurrent.CompletionStage;

@RegisterRestClient(configKey = "config.api.crypto")
//@Path("ticker")
@Path("crypto")
public interface CurrencyService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage<Collection<Currency>> getCurrency(@QueryParam("id")String id);

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    String sendFile(@MultipartForm MultiPartBody body);
}
