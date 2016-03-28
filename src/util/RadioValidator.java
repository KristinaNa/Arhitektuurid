package util;

/**
 * Created by Kristina on 28/03/2016.
 */
import model.Radio;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class RadioValidator {

    private static Logger logger = Logger.getLogger(RadioValidator.class);
    private HashMap RadioErrors;

    public RadioValidator() {
    }

    public void RadioValidator() {
    }

    public HashMap Validate(Radio radio) {
        logger.info("Logger initiated");

        this.RadioErrors = new HashMap();
        int input = 0;

        try {
            input = radio.getSequence();
        } catch (NumberFormatException e) {
            this.RadioErrors.put("sequence", "vale formaat");
        }

        logger.info(input);
        if(input < 75 || input > 110) {
            this.RadioErrors.put("sequence", "peab olema vahemikus 75-110");
        }

        return this.RadioErrors;
    }
}
