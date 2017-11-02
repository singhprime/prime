package com.gsvasir.pro;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.onesignal.OneSignal;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Book extends AppCompatActivity {
    FirebaseUser user;
    static String LoggedIn_User_Email;
    Button call,map;

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter,adapter1;

    // Search EditText
    EditText inputSearch;
private FirebaseAuth mAuth;

    // ArrayList for Listview
    ArrayList<HashMap<String, String>> doctorsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        getSupportActionBar().hide();

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
        mAuth= FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        LoggedIn_User_Email =user.getEmail();
        OneSignal.sendTag("User_ID", LoggedIn_User_Email);

        map=(Button)findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bc=new Intent(getApplicationContext(),SearchDoc.class);
                startActivity(bc);
            }
        });
        call=(Button)findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bc=new Intent(getApplicationContext(),Call.class);
                startActivity(bc);
            }
        });
        final String doctors[] = {"AIIMS Hospital,Ansari Nagar, Near AIIMS Metro Station, New Delhi, Delhi 110029.","BLK Super Speciality Hospital,  Building No-5, Pusa Road, Rajinder Nagar, New Delhi, Delhi 110005","Cancer Institute, No 1, East Canal Bank Road, Gandhi Nagar, Adyar, Gandhi Nagar, Adyar, Chennai, Tamil Nadu 600020","DMS Hospital Centre for Women and Children, No:8, Gandhi nagar Main road,Bathalagundu, Tamil Nadu 624001","ESIS Hospital, Near Worli Naka, Behind Poddar Hospital, Ganpatrao Kadam Marg, Worli, Mumbai, Maharashtra 400018","Fortis Hospital Mohali, Sector 62, Phase - VIII, Sahibzada Ajit Singh Nagar, Punjab 160062","G.T.Padole Hospital, Deendayal Nagar, Padole Layout, Ring Road, Nagpur, Maharashtra 440022","H T Bhandary Foundation, No 31, N N Plaza, Near-Vani Vilas Road, Basavanagudi, Vanivilas Rd, Shankarapura, Bengaluru, Karnataka 560004","ICARE Eye Hospital and Post Graduate Institute, Eye Hospital, E3A, Sector-26, Near Apollo Hospital","Jesus, Mary and Joseph(JMJ) Hospital, Kamat Nagar, Porvorim, Aradi Socorro, Goa 403501","KKR ENT HOSPITAL & RESEARCH INSTITUTE, No. 274, Poonamallee High Road, Opp. KMC Hospital, Kilpauk, Chennai, Tamil Nadu 600010","LK HOSPITAL PVT LTD & L K Medical & GEN. Store, Raghavendra Theatre Rd, Geetha Nagar, Malkajgiri, Hyderabad, Telangana 500047","MGA Hospital, 59/96, Varthur Main Road, Near Marathahalli Bridge, Marathahalli Village, Bengaluru, Karnataka 560037","N.M. Wadia Institute Of Cardiology, 32, Sassoon Road, Pune, Maharashtra 411001","Oberoi Hospital, 8, Mahavir Marg, Near Mann Scanning Center, Gujral Nagar, Jalandhar, Punjab 144001","Patil Hospital, Sri Thimappa Complex, Old Madras Road, KR Puram, Below Syndicate Bank, Bengaluru, Karnataka 560036","Queen's Hospital, 11/B, 19th Main, 25th Cross Road, Sector 2, HSR Layout, Bengaluru, Karnataka 560102","R K Orthopedic and Trauma Centre, A-81, Sadulganj, Dungar College ke pas,, Jaipur Road, Milan Travel ke Pas, Bikaner, Rajasthan 334001","SPS Hospitals, Grand Trunk Rd, Sherpur Chowk, Sherpur, Ludhiana, Punjab 141003","Talwandi Hospital, No:80/113/114, Grand Trunk Rd, Opposite Pingalwara, Phoola Singh Burj, Amritsar, Punjab 143001","Uma Hospital, Near Imperial Heights, 150 Feet Ring Rd, Nalanda Society, Rajkot, Gujarat 360007","V K Global Hospital, Address: Paharia, Opp Honda Agency, Varanasi, Uttar Pradesh 221007","Win Vision Eye Hospitals, 6-3-868/2, Greenlands, Begumpet, Hyderabad, Telangana 500016","Yogi Hospital, Amli, Kilvani Road, Opp. Pramukh Gardens, Silvassa, Dadra and Nagar Haveli 396230"};

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch(position){
                    case 0:
                        sendNotification();
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 6:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 7:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 8:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 9:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 10:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 11:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 12:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 13:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 14:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 15:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 16:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 17:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 18:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 19:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 20:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 21:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 22:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;
                    case 23:
                        Toast.makeText(getApplicationContext(),"Processing Appointment Request please wait and make sure that you are on high speed connection",Toast.LENGTH_SHORT).show();
                        sendNotification();
                        break;



                    //add more if you have more items in listview
                    //0 is the first item 1 second and so on...
                }

            }
        });
        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.activity_itemlist, R.id.product_name, doctors);
        lv.setAdapter(adapter);


        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs,int arg1, int arg2, int arg3) {
                // When user changed the Text
                Book.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {

                // TODO Auto-generated method stub
            }
        });



    }
    private void sendNotification()
    {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 8) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    String send_email;

                    //This is a Simple Logic to Send Notification different Device Programmatically....
                    if (Book.LoggedIn_User_Email.equals("user2@gmail.com")) {
                        send_email = "gurpreet4416.gs@gmail.com";
                    } else {
                        send_email = "user2@gmail.com";
                    }

                    try {
                        String jsonResponse;

                        URL url = new URL("https://onesignal.com/api/v1/notifications");
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setUseCaches(false);
                        con.setDoOutput(true);
                        con.setDoInput(true);

                        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                        con.setRequestProperty("Authorization", "Basic YzA1OWI0YTktZjg1Ny00NTNhLWI2MGUtY2QxNGI3ZWJmOGRi");
                        con.setRequestMethod("POST");

                        String strJsonBody = "{"
                                + "\"app_id\": \"84404dd5-0138-4c9d-913a-c710de349c40\","

                                + "\"filters\": [{\"field\": \"tag\", \"key\": \"User_ID\", \"relation\": \"=\", \"value\": \"" + send_email + "\"}],"

                                + "\"data\": {\"foo\": \"bar\"},"
                                + "\"contents\": {\"en\": \"English Message\"}"
                                + "}";


                        System.out.println("strJsonBody:\n" + strJsonBody);

                        byte[] sendBytes = strJsonBody.getBytes("UTF-8");
                        con.setFixedLengthStreamingMode(sendBytes.length);

                        OutputStream outputStream = con.getOutputStream();
                        outputStream.write(sendBytes);

                        int httpResponse = con.getResponseCode();
                        System.out.println("httpResponse: " + httpResponse);

                        if (httpResponse >= HttpURLConnection.HTTP_OK
                                && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
                            Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                            scanner.close();
                        } else {
                            Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                            scanner.close();
                        }
                        System.out.println("jsonResponse:\n" + jsonResponse);

                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        });
    }
}

