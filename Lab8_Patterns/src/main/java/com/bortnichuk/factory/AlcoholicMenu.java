package com.bortnichuk.factory;

import org.apache.log4j.Logger;

public class AlcoholicMenu implements Menu {

    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void show() {
        logger.trace("You are above 18 years old. So now you can choose a beer");
    }
}
