package com.facebook.ads.sdk.samples;

import com.facebook.ads.sdk.*;

import java.util.Arrays;
import java.util.List;

public class Campagain {
    public static final String ACCESS_TOKEN ="EAAlgDpmUhOYBALOU5ZB0AOjkkmvuXxcHnUA4ddgZC5I2ZCeLoGLLI8EhaxMM8gekZBZANYItfEbm90JYP6kYhYOwkMw0J2umgEwwxNFLxOvl3CJmEaqcM8pYZAeZCPMX5tsInOQ2R7zEvhbO08O0YbZAVLXJqliHBHKL1itAZBgMiBgZDZD";
    public static final String ACCOUNT_ID ="318153082200920";
    public static final String APP_SECRET ="e8bde3bfc80d6c6064860032a61296f5" ;
    public static final String CAMPAIGN_ID = "23843632368410426";

    public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET);
    public Campaign campaign ;
    public static AdAccount account = new AdAccount(ACCOUNT_ID, context);

    public static void main(String[] args) {
        Campagain c = new Campagain();
//        c.createCampagain("Hello ");
//        c.createCampagain( "RTI Campagain");
////        c.createCampagain("Nepal bandai xa");
//        c.getCampagainObject();
//        c.campagainIterator();
////        c.update();
//        c.campagainIterator();
//        c.getEdgecampagain();
//       c.getCampagainObject();
        c.batchRequest(account);
    }

    public void  createCampagain(String name)
    {
        try {
            AdAccount account = new AdAccount(ACCOUNT_ID, context);
            System.out.println(context.toString());
            Campaign campaign = account.createCampaign()
                    .setName(name)
                    .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
                    .setSpendCap(10000L)
                    .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
                    .execute();
            System.out.println(campaign.fetch());
            batchRequest(account);
        } catch (APIException e) {
            e.printStackTrace();
        }
    }
     public void getCampagainObject()
     {
         try {
             Campaign campaign = Campaign.fetchById(CAMPAIGN_ID, context);
             String id = campaign.getFieldId();
             String name = campaign.getFieldName();
             System.out.println("Campagain id \n"+id+"name "+name);
         } catch (APIException e) {
             e.printStackTrace();
         }
     }
      public void update()   {

          try {
              campaign = Campaign.fetchById(CAMPAIGN_ID, context);
              campaign.update()
                      .setName("Updated Java SDK Test Campaign") // set parameter for the API call
                      .execute();
          } catch (APIException e) {
              e.printStackTrace();
          }

      }
      public void campagainIterator()
      {
          AdAccount account = new AdAccount(ACCOUNT_ID, context);
          APINodeList<Campaign> campaigns = null;
          try {
              campaigns = account.getCampaigns().requestAllFields().execute();

          for(Campaign campaign : campaigns) {
              System.out.println(campaign.fetch());
          }
          } catch (APIException e) {
              e.printStackTrace();
          }
      }


public  void batchRequest(AdAccount account)
{
    BatchRequest batch = new BatchRequest(context);
    account.createCampaign()
            .setName(" Niranjan NLC Campaign")
            .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
            .setSpendCap(10000L)
            .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
            .addToBatch(batch, "campaignRequest");
    account.createAdSet()
            .setName("niranjan  AdSet")
            .setCampaignId("{result=campaignRequest:$.id}")
            .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
            .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
            .setDailyBudget(1000L)
            .setBidAmount(100L)
            .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_IMPRESSIONS)

            .addToBatch(batch, "adsetRequest");
    account.createAdImage()

            .addToBatch(batch, "imageRequest");
    account.createAdCreative()
            .setTitle("Niranjan  Creative")
            .setBody("Niranjan Test Creative")
            .setImageHash("{result=imageRequest:$.images.*.hash}")
            .setLinkUrl("www.facebook.com")
            .setObjectUrl("www.fb.com")
            .addToBatch(batch, "creativeRequest");
    account.createAd()
            .setName("Niranjan lamichhane ad ")
            .setAdsetId("{result=adsetRequest:$.id}")
            .setCreative("{creative_id:{result=creativeRequest:$.id}}")
            .setStatus("PAUSED")
            .setBidAmount(100L)
            .addToBatch(batch);
    try {
        List<APIResponse> responses = batch.execute();
    } catch (APIException e) {
        e.printStackTrace();
    }
}
        public void getEdgecampagain()
        {
            try {
                APINodeList<Campaign> campaigns = new AdAccount(ACCOUNT_ID, context).getCampaigns()
                        .setEffectiveStatus(Arrays.asList(Campaign.EnumEffectiveStatus.VALUE_ACTIVE,Campaign.EnumEffectiveStatus.VALUE_PAUSED))
                        .requestNameField()
                        .requestObjectiveField()
                        .execute();
                for(Campaign campaign : campaigns) {
                    System.out.println(campaign.getFieldName());
                }

            } catch (APIException e) {
                e.printStackTrace();
            }
        }
}
