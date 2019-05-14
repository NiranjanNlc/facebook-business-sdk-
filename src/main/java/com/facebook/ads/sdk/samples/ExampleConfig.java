package com.facebook.ads.sdk.samples;


import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;



public class ExampleConfig {
  public static final String ACCESS_TOKEN ="EAAlgDpmUhOYBALOU5ZB0AOjkkmvuXxcHnUA4ddgZC5I2ZCeLoGLLI8EhaxMM8gekZBZANYItfEbm90JYP6kYhYOwkMw0J2umgEwwxNFLxOvl3CJmEaqcM8pYZAeZCPMX5tsInOQ2R7zEvhbO08O0YbZAVLXJqliHBHKL1itAZBgMiBgZDZD";
  public static final String ACCOUNT_ID ="318153082200920";
  public static final String APP_SECRET ="e8bde3bfc80d6c6064860032a61296f5" ;
  public static final String IMAGE_FILE = "src/main/image.png";
  public static final String VIDEO_FILE = "video.mp4";
  public static final String PAGE_ID = "848469472166661";
  //public static final Long BUSINESS_ID = "Your Business ID";
  public static final String DPA_FEED_FILE_PATH = "dpa-feed-example.xml";
  public static final String CAMPAIGN_ID = "23843629838130426";

  public static final APIContext context = new APIContext(ACCESS_TOKEN,APP_SECRET);
  public static AdAccount account = new AdAccount(ACCOUNT_ID, context);
}
