package com.tools.constants;

import com.tools.persistence.PropertyFileReader;

import java.io.File;

public class EnvironmentConstants {
    public static final String BASE_URL = PropertyFileReader.getEnvConstantsItem("BASE_URL");
    public static final String EMAIL = PropertyFileReader.getEnvConstantsItem("EMAILADDRESS");
    public static final String PASS = PropertyFileReader.getEnvConstantsItem("PASSWORD");
    public static final double CART_TAX_RATE = 0.0825;
    public static final String ADMINEMAIL = PropertyFileReader.getEnvConstantsItem("ADMINEMAIL");
    public static final String ADMINPASS = PropertyFileReader.getEnvConstantsItem("ADMINPASS");
    public static final String ADMIN_URL = PropertyFileReader.getEnvConstantsItem("ADMIN_URL");




}
