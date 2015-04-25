package com.appsbywill.splitly;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements LoaderCallbacks<Cursor> {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        populateAutoComplete();

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void populateAutoComplete() {
        getLoaderManager().initLoader(0, null, this);
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    public void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;


        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<String>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(emails);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }


    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(LoginActivity.this,
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        mEmailView.setAdapter(adapter);
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            // TODO: attempt authentication against a network service.
            String json = "{ \"merchant\" : {" +
                    "" +
                    "\"NetworkRouting\" : \"2J\"," +
                    "" +
                    "\"CashierNumber\" : \"12345678\"," +
                    "" +
                    "\"LaneNumber\" : \"123\"," +
                    "" +
                    "\"DivisionNumber\" : \"000\"," +
                    "" +
                    "\"ChainCode\" : \"70110\"," +
                    "" +
                    "\"StoreNumber\" : \"00000001\"," +
                    "" +
                    "\"MerchantID\" : \"4445012916098\"" +
                    "" +
                    "}," +
                    "" +
                    " \"terminal\" : {" +
                    "" +
                    "\"TerminalID\" : \"1\"," +
                    "" +
                    "\"EntryMode\" : \"manual\"," +
                    "" +
                    "\"Ipv4Address\" : \"192.0.2.235\"," +
                    "" +
                    "\"TerminalEnvironmentalCode\" : \"electronic_cash_register\"," +
                    "" +
                    "\"PinEntry\" : \"none\"," +
                    "" +
                    "\"BalanceInquiry\" : \"false\"," +
                    "" +
                    "\"HostAdjustment\" : \"false\"," +
                    "" +
                    "\"DeviceType\" : \"Software\"," +
                    "" +
                    "\"CardInputCode\" : \"ManualKeyed\"" +
                    "" +
                    "" +
                    "}," +
                    "" +
                    "" +
                    " \"transaction\" : {" +
                    "" +
                    "\"TransactionID\" : \"123456\"," +
                    "" +
                    "\"PaymentType\" : \"single\"," +
                    "" +
                    "\"ReferenceNumber\" : \"100001\"," +
                    "" +
                    "\"DraftLocatorID\" : \"100000001\"," +
                    "" +
                    "\"ClerkNumber\": \"1234\"," +
                    "" +
                    "\"MarketCode\" : \"present\"," +
                    "" +
                    "\"TransactionTimestamp\" :  \"2000-12-04T14:00:00\"," +
                    "" +
                    "\"SystemTraceID\" : \"100002\"," +
                    "" +
                    "\"TokenRequested\" : \"false\"," +
                    "" +
                    "\"TransactionAmount\" : \"10.00\"," +
                    "" +
                    "\"PartialApprovalCode\": \"not_supported\"" +
                    "" +
                    "}," +
                    "" +
                    "" +
                    "  \"address\" : {" +
                    "" +
                    "    \"BillingAddress1\": \"1111 something st\"," +
                    "" +
                    "\"BillingZipcode\" : \"33606\"" +
                    "" +
                    "}," +
                    "" +
                    "" +
                    " \"card\" : {" +
                    "" +
                    "\"CardType\": \"masterCard\"," +
                    "" +
                    "\"CardNumber\": \"5444009999222205\"," +
                    "" +
                    "\"CVV\": \"322\"," +
                    "" +
                    "\"ExpirationMonth\" : \"02\"," +
                    "" +
                    "\"ExpirationYear\" : \"2017\"" +
                    "" +
                    "" +
                    "}}" +
                    "";
            sendHttpPost("https://apis.cert.vantiv.com/v1/credit/sale?sp=1", "5cd07ecb9583427ba635cbb0308b4b88$$#$$OX9Wk75ADK6AzK8gAS0PuAElPv9RwKC0$$#$$2016-04-25$$#$$dev_key$$#$$SHA512withRSA$$#$$RSA$$#$$1$$#$$71F8B24E8A0256850A2DE5DE8DE49A662D4F1D0551A0F3F6D58918B07AEA68886A8D141C9E864C9E371AEC8F6E8CCCA7B24855A9AFE49D87025936B4CE935E1C2F77EBD346E6098A9D83A678AC40AA9780427DB2C1345BF2A0364E27A369EDFB04E9B09390B7FA2DDBEE9CA9DB3AA7C739E6ED8BF44F888C3726E0E2B4902E0D9756EC99B746B167060BA4C38B4536FFF567A6FBFC63B6883D6C7882536DDFC0A2DF2DCD6C9B920EB6BEC92F8AC3F507AFB29A8D68F3ECD15045EF8348B0E7CCDB537D11EE1702FB94360B223FFBBC1F2B010410BA8C78E0BCFA83FFA1893690E6399D899F92C3D44EF8454F80004F38696C7EC779094D3634F41D46C1DA6BE4",
                    json);

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, ListViewLoader.class);
                startActivity(intent);
                //finish();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }

    public void sendHttpPost(String endPoint, String licenseid, String json){
        HttpURLConnection soapConn = null;
        try {
            URL url = new URL(endPoint);
            URLConnection connection = url.openConnection();
            soapConn = (HttpURLConnection) connection;
            soapConn.setRequestProperty("licenseid", licenseid);
            soapConn.setRequestProperty("Content-Type","application/json");
            soapConn.setRequestProperty("Content-Length", String.valueOf(json.getBytes().length));
            soapConn.setRequestMethod( "POST" );
            soapConn.setDoOutput(true);
            soapConn.setDoInput(true);
            OutputStreamWriter bw = new OutputStreamWriter(soapConn.getOutputStream());
            bw.write(json);
            bw.flush();
            bw.close();
            BufferedReader br;
            if (soapConn.getResponseCode() > 200){
                br = new BufferedReader(new InputStreamReader(soapConn.getErrorStream()));
            }else{
                br = new BufferedReader(new InputStreamReader(soapConn.getInputStream()));
            }
            String line = "";
            String lineHolder = "";
            while ((line = br.readLine()) != null){
                lineHolder+= line;
                System.out.println(line);
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace(System.err);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



