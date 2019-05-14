package com.facebook.ads.sdk.samples;

import java.util.Arrays;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.Targeting;
import com.facebook.ads.sdk.TargetingGeoLocation;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;

public class FetchByIdsExample {

  public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
  public static final String ACCOUNT_ID = ExampleConfig.ACCOUNT_ID;
  public static final String APP_SECRET = ExampleConfig.APP_SECRET;
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true);

  public static void main(String[] args) {
    try {
      Targeting targeting = new Targeting().setFieldGeoLocations(new TargetingGeoLocation().setFieldCountries(Arrays.asList("US")));
      AdAccount account = new AdAccount(ACCOUNT_ID, context);
      Campaign campaign = account.createCampaign()
          .setName("Niranjan Test ")
          .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
          .setSpendCap(10000L)
          .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
          .execute();
      AdSet adset1 = account.createAdSet()
          .setName("Niranjan test")
          .setCampaignId(campaign.getFieldId())
          .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
          .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
          .setDailyBudget(1000L)
          .setBidAmount(100L)
          .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_IMPRESSIONS)
          .setTargeting(targeting)
          //.setRedownload(true)
          .requestAllFields()
          .execute();
      AdSet adset2 = account.createAdSet()
          .setName("Niranjan ads")
          .setCampaignId(campaign.getFieldId())
          .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
          .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
          .setDailyBudget(1000L)
          .setBidAmount(100L)
          .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_IMPRESSIONS)
          .setTargeting(targeting)
        //  .setRedownload(true)
          .requestAllFields()
          .execute();
      AdSet adset3 = account.createAdSet()
          .setName("Niranjan ad 2 ")
          .setCampaignId(campaign.getFieldId())
          .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
          .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
          .setDailyBudget(1000L)
          .setBidAmount(100L)
          .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_IMPRESSIONS)
          .setTargeting(targeting)
      //    .setRedownload(true)
          .requestAllFields()
          .execute();
      APINodeList<AdSet> allAdSets = AdSet.fetchByIds(
          Arrays.asList(
             adset1.getId(),
             adset2.getId(),
             adset3.getId()
          ),
         Arrays.asList(
              "id",
             "name"
          ),
         context
      );
     System.out.println(allAdSets);
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
