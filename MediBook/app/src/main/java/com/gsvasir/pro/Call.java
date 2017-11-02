package com.gsvasir.pro;
import java.util.ArrayList;
import java.util.HashMap;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Call extends Activity {

    @Override
    public void onBackPressed() {

            Intent h=new Intent(getApplicationContext(),Interface.class);
            startActivity(h);

    }

    Button map,book;
    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> doctorsList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        map=(Button)findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bc=new Intent(getApplicationContext(),SearchDoc.class);
                startActivity(bc);
            }
        });
        book=(Button)findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bc=new Intent(getApplicationContext(),Book.class);
                startActivity(bc);
            }
        });


        // Listview Data
        final String doctors[] = {"AIIMS Hospital,Ansari Nagar, Near AIIMS Metro Station, New Delhi, Delhi 110029.","BLK Super Speciality Hospital,  Building No-5, Pusa Road, Rajinder Nagar, New Delhi, Delhi 110005","Cancer Institute, No 1, East Canal Bank Road, Gandhi Nagar, Adyar, Gandhi Nagar, Adyar, Chennai, Tamil Nadu 600020","DMS Hospital Centre for Women and Children, No:8, Gandhi nagar Main road,Bathalagundu, Tamil Nadu 624001","ESIS Hospital, Near Worli Naka, Behind Poddar Hospital, Ganpatrao Kadam Marg, Worli, Mumbai, Maharashtra 400018","Fortis Hospital Mohali, Sector 62, Phase - VIII, Sahibzada Ajit Singh Nagar, Punjab 160062","G.T.Padole Hospital, Deendayal Nagar, Padole Layout, Ring Road, Nagpur, Maharashtra 440022","H T Bhandary Foundation, No 31, N N Plaza, Near-Vani Vilas Road, Basavanagudi, Vanivilas Rd, Shankarapura, Bengaluru, Karnataka 560004","ICARE Eye Hospital and Post Graduate Institute, Eye Hospital, E3A, Sector-26, Near Apollo Hospital","Jesus, Mary and Joseph(JMJ) Hospital, Kamat Nagar, Porvorim, Aradi Socorro, Goa 403501","KKR ENT HOSPITAL & RESEARCH INSTITUTE, No. 274, Poonamallee High Road, Opp. KMC Hospital, Kilpauk, Chennai, Tamil Nadu 600010","LK HOSPITAL PVT LTD & L K Medical & GEN. Store, Raghavendra Theatre Rd, Geetha Nagar, Malkajgiri, Hyderabad, Telangana 500047","MGA Hospital, 59/96, Varthur Main Road, Near Marathahalli Bridge, Marathahalli Village, Bengaluru, Karnataka 560037","N.M. Wadia Institute Of Cardiology, 32, Sassoon Road, Pune, Maharashtra 411001","Oberoi Hospital, 8, Mahavir Marg, Near Mann Scanning Center, Gujral Nagar, Jalandhar, Punjab 144001","Patil Hospital, Sri Thimappa Complex, Old Madras Road, KR Puram, Below Syndicate Bank, Bengaluru, Karnataka 560036","Queen's Hospital, 11/B, 19th Main, 25th Cross Road, Sector 2, HSR Layout, Bengaluru, Karnataka 560102","R K Orthopedic and Trauma Centre, A-81, Sadulganj, Dungar College ke pas,, Jaipur Road, Milan Travel ke Pas, Bikaner, Rajasthan 334001","SPS Hospitals, Grand Trunk Rd, Sherpur Chowk, Sherpur, Ludhiana, Punjab 141003","Talwandi Hospital, No:80/113/114, Grand Trunk Rd, Opposite Pingalwara, Phoola Singh Burj, Amritsar, Punjab 143001","Uma Hospital, Near Imperial Heights, 150 Feet Ring Rd, Nalanda Society, Rajkot, Gujarat 360007","V K Global Hospital, Address: Paharia, Opp Honda Agency, Varanasi, Uttar Pradesh 221007","Win Vision Eye Hospitals, 6-3-868/2, Greenlands, Begumpet, Hyderabad, Telangana 500016","Yogi Hospital, Amli, Kilvani Road, Opp. Pramukh Gardens, Silvassa, Dadra and Nagar Haveli 396230"};

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch(position){
                    case 0:
                       String a1="01126588500";
                        if(isPermissionGranted()) {
                            calc(a1);
                        }
                        break;
                    case 1:
                        String b1="01130403040";
                        calc(b1);
                        break;
                    case 2:
                        String c1="04424911526";
                        calc(c1);
                        break;
                    case 3:
                        String d1="098424 06904";
                        calc(d1);
                        break;
                    case 4:
                        String e1="022 2493 3142";
                        calc(e1);
                        break;
                    case 5:
                        String f1="01724692222";
                        calc(f1);
                        break;
                    case 6:
                        String g1="07122228553";
                        calc(g1);
                        break;
                    case 7:
                        String h1="08026676434";
                        calc(h1);
                        break;
                    case 8:
                        String i1="01202477600";
                        calc(i1);
                        break;
                    case 9:
                        String j1="08322410521";
                        calc(j1);
                        break;
                    case 10:
                        String k1="04426411444";
                        calc(k1);
                        break;
                    case 11:
                        String l1="04027052200";
                        calc(l1);
                        break;
                    case 12:
                        String m1="08041264267";
                        calc(m1);
                        break;
                    case 13:
                        String n1="02026058136";
                        calc(n1);
                        break;
                    case 14:
                        String o1="01812251258";
                        calc(o1);
                        break;
                    case 15:
                        String p1="08025613891";
                        calc(p1);
                        break;
                    case 16:
                        String q1="08884557123";
                        calc(q1);
                        break;
                    case 17:
                        String r1="01512203354";
                        calc(r1);
                        break;
                    case 18:
                        String s1="08872027302";
                        calc(s1);
                        break;
                    case 19:
                        String t1="01832970033";
                        calc(t1);
                        break;
                    case 20:
                        String u1="08128987939";
                        calc(u1);
                        break;
                    case 21:
                        String v1="05422581094";
                        calc(v1);
                        break;
                    case 22:
                        String w1="04023408888";
                        calc(w1);
                        break;
                    case 23:
                        String x1="02602682401";
                        calc(x1);
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
                Call.this.adapter.getFilter().filter(cs);
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
    public void calc(String x)
    {
        final String number =x;
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Call.this);
        //setting dialog title
        alertDialog.setTitle("Confirmation");
        //setting dialog message
        alertDialog.setTitle("Confirm To Call");
        //alertdialog.setIcon(R.drawable.delete);
        alertDialog.setPositiveButton("Call", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent ic = new Intent(Intent.ACTION_CALL);
                ic.setData(Uri.parse("tel:" + number));
                //After this write startActivity , there will be an error so click alt+enter to add permission
                if (ActivityCompat.checkSelfPermission(Call.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(ic);
                Toast.makeText(getApplicationContext(),"Calling...",Toast.LENGTH_LONG).show();

            }

        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Canceled Successfully!",Toast.LENGTH_SHORT).show();
            }

        });
        alertDialog.show();

    }
    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}

