package com.js.billing.mylibrary;

import android.content.Context;
import android.util.Log;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;

import java.util.List;

public class MyBilling {
    private static final String TAG = MyBilling.class.getName();

    private static void LOG(String message) {
        Log.i(TAG, message);
    }
    private PurchasesUpdatedListener purchasesUpdatedListener = new PurchasesUpdatedListener() {
        @Override
        public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> purchases) {
            // To be implemented in a later section.
            LOG("To be implemented in a later section.");
        }
    };
    private BillingClient billingClient = null;

    public MyBilling(Context context) {
        LOG(">>> MyBilling");
        billingClient = BillingClient.newBuilder(context)
                .setListener(purchasesUpdatedListener)
                .enablePendingPurchases()
                .build();

        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(BillingResult billingResult) {
                if (billingResult.getResponseCode() ==  BillingClient.BillingResponseCode.OK) {
                    LOG("The BillingClient is ready. You can query purchases here.");
                    // The BillingClient is ready. You can query purchases here.
                }
            }
            @Override
            public void onBillingServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
                LOG("Try to restart the connection on the next request to Google Play by calling the startConnection() method.");
            }
        });
        LOG("<<< MyBilling");
    }
}
