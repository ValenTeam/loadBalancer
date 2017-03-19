package controllers;

/**
 * Created by felipeplazas on 2/9/17.
 */

import com.avaje.ebean.Model;
import controllers.base.EPController;
import models.Hospital;
import org.jongo.Jongo;
import play.mvc.Result;
import scala.concurrent.java8.FuturesConvertersImpl;
import uk.co.panaxiom.playjongo.PlayJongo;
import util.EPJson;

import java.util.List;

public class AppController extends EPController {

    /**
     * Finds all the hospitals
     * @return OK 200 with a list that may be empty if there are no hospitals.
     */
    public Result test() {
        return redirect("http://hospital-arquisoft.herokuapp.com/test" );
    }

}
