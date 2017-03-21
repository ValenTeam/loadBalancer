package controllers;

/**
 * Created by felipeplazas on 2/9/17.
 */

import com.avaje.ebean.Model;
import com.google.inject.Inject;
import controllers.base.EPController;
import models.Hospital;
import org.jongo.Jongo;
import play.api.libs.ws.WSResponse;
import play.libs.F;
import play.libs.ws.WSClient;
import play.mvc.Result;
import scala.concurrent.java8.FuturesConvertersImpl;
import uk.co.panaxiom.playjongo.PlayJongo;
import util.EPJson;

import java.util.List;
import java.util.concurrent.CompletionStage;

public class AppController extends EPController {

    @Inject
    private WSClient ws;

    private static String BASE_PATH =  "http://hospital-arquisoft.herokuapp.com";
    private static int index = 0;

    /**
     * Finds all the hospitals
     * @return OK 200 with a list that may be empty if there are no hospitals.
     */
    public Result test() {
        ws.url("http://hospital-arquisoft.herokuapp.com/medicion").setContentType("application/json").post(request().body().asText());
        return ok();
    }

    public Result getHospitales() {
        if (++index == 500){
            BASE_PATH =  "http://hospital-arquisoft2.herokuapp.com";
            index = 0;
        }
        F.Promise<play.libs.ws.WSResponse> promise = ws.url(BASE_PATH+"/hospital").get();
        return ok(promise.get(3000).asJson().toString());
    }

    public Result loader(){
        return ok("loaderio-57cae14f62bd4c74ee353f009b94b6fe");
    }

}
