package com.facebook.ads.sdk.samples;


import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;

public class ExampleConfig {
  public static final String ACCESS_TOKEN = "EAAlgDpmUhOYBAJMbMbDHYcNSQilBic1uY51QZCnDv6MpsizZCFGpcy8pQ57MdPmuCREHZAECT8M44sC1VQHSOoWWAz10YhAfT5i8cRZAMGECZBAzG6GgK4K7ANjw34GceZCRtuAbLZBWaCE4BXSVqCLgDoJxKkRMOHDZA3SQNIfOnQZDZD";

  public static final String ACCOUNT_ID ="318153082200920";
  public static final String APP_SECRET ="e8bde3bfc80d6c6064860032a61296f5" ;
  public static final String IMAGE_FILE = "image.png";
  public static final String VIDEO_FILE = "video.mp4";
  public static final String PAGE_ID = "Your Page ID";
  //public static final Long BUSINESS_ID = "Your Business ID";
  public static final String DPA_FEED_FILE_PATH = "dpa-feed-example.xml";
  public static final String CAMPAIGN_ID = "23843629838130426";

  public static final APIContext context = new APIContext(ACCESS_TOKEN,APP_SECRET);
  public static AdAccount account = new AdAccount(ACCOUNT_ID, context);
}
