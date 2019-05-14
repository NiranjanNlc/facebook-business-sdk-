package com.facebook.ads.sdk.samples;


import java.io.File;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.APIRequest;
import com.facebook.ads.sdk.APIResponse;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.FutureCallback;

public class AsyncAdhocAPIRequestExample {

  public static final String ACCESS_TOKEN = ExampleConfig.ACCESS_TOKEN;
  public static final String ACCOUNT_ID = ExampleConfig.ACCOUNT_ID;
  public static final String APP_SECRET = ExampleConfig.APP_SECRET;
  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET).enableDebug(true);
  public static final File imageFile = new File(ExampleConfig.IMAGE_FILE);

  public static void main(String[] args) {
    try {
      APIRequest<AdAccount> request = new APIRequest<AdAccount>(context, "me", "/adaccounts", "GET", AdAccount.getParser());
      ListenableFuture<APIResponse> r = request.executeAsyncBase();
      Futures.addCallback(r, new FutureCallback<APIResponse>() {
               public void onSuccess(APIResponse result) {
                 APINodeList<AdAccount> accounts = (APINodeList<AdAccount>)result;
                  for (AdAccount account: accounts) {
                    System.out.println("account: " + account);
                  }
                  System.out.println("finished");
                                 }
                      public void onFailure(Throwable t) {
                                        }
                           });

                           r.get();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
