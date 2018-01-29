package com.hefu.application.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.rokid.mobile.lib.base.util.Logger;
import com.rokid.mobile.lib.xbase.account.callback.ILoginResultCallback;
import com.rokid.mobile.sdk.RokidMobileSDK;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class SDKIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_LOGIN = "com.hefu.application.com.hefu.application.service.action.LOGIN";
    private static final String ACTION_BAZ = "com.hefu.application.com.hefu.application.service.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.hefu.application.com.hefu.application.service.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.hefu.application.com.hefu.application.service.extra.PARAM2";

    public SDKIntentService() {
        super("SDKIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionLogin(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SDKIntentService.class);
        intent.setAction(ACTION_LOGIN);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SDKIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_LOGIN.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionLogin(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionLogin(String param1, String param2) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                RokidMobileSDK.account.tokenLogin(EXTRA_PARAM1, new ILoginResultCallback() {
                    @Override
                    public void onLoginSucceed() {
                        Logger.d("onLoginSuccess is called.");
                        // do something
                    }
                    @Override
                    public void onLoginFailed(String errorCode, String errorMsg) {
                        Logger.e("onLoginFailed errorCode=" + errorCode + " errorMsg=" + errorMsg)
                        ;
                        // do something
                    }
                });
            }
        }).start();



    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
