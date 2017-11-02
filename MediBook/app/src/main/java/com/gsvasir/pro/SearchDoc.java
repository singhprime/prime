package com.gsvasir.pro;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SearchDoc extends Activity {
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(getApplicationContext(),Interface.class);
        startActivity(intent);
    }
Button call,book;
    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter,adapter1;

    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> doctorsList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_doc);
        call=(Button)findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bc=new Intent(getApplicationContext(),Call.class);
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

                Intent intent = null;
                switch(position){
                    case 0:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/''/@28.5676055,77.1397067,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x390ce26f903969d7:0x8367180c6de2ecc2!2m2!1d77.209747!2d28.5676235"));
                        break;
                    case 1:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/''/@28.643486,77.1100643,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x390d029633b6af21:0x9a67323b63bcc188!2m2!1d77.1801046!2d28.643504"));
                        break;
                    case 2:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/Cancer+Institute,+Chennai,+Tamil+Nadu/@13.0084154,80.1783835,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3a526796a419e39d:0xda9df9273df26173!2m2!1d80.248424!2d13.0084248"));
                        break;
                    case 3:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/D+M+S+Hospital,+Batlagundu,+Tamil+Nadu/@10.1648772,77.6859428,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3b074f9d798503ad:0x759649b71349ef9b!2m2!1d77.7559834!2d10.1648846"));
                        break;
                    case 4:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/E.+S.+I.+S.+Hospital,+Mumbai,+Maharashtra/@19.0017439,72.7468419,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3be7ce9062abd1ab:0x4053535fcfda12f7!2m2!1d72.8168824!2d19.0017571"));
                        break;
                    case 5:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/Fortis,+Mohali,+Punjab/@30.6944707,76.6607642,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x390fee9f04ed85e1:0x63296ed41f02307d!2m2!1d76.7308044!2d30.6944895"));
                        break;
                    case 6:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/G.+T.+Padole+Hospital,+Nagpur,+Maharashtra/@21.113033,78.978468,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3bd4bf894cbb34b5:0x123de338c840d54!2m2!1d79.0485084!2d21.1130474"));
                        break;
                    case 7:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/H+T+Bhandari+Foundation+Hospital,+Bengaluru,+Karnataka/@12.9483471,77.4998626,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3bae15edf6b63d4b:0xe9d76c46a70255df!2m2!1d77.5699031!2d12.9483564"));
                        break;
                    case 8:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/''/@28.579877,77.265763,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x390ce5adaa70ef97:0xf9eaf01bf5a8fba5!2m2!1d77.3358033!2d28.579895"));
                        break;
                    case 9:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/J+M+J+Hospital,+Alto+Porvorim,+Goa/@15.5414322,73.7526262,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3bbfc019a1be45f1:0xe3510b6342c1fa64!2m2!1d73.8226667!2d15.5414433"));
                        break;
                    case 10:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/K.+K.+R.+Ent+Hospital+And+Research+Institute,+Chennai,+Tamil+Nadu/@13.0781929,80.1751579,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3a52667709b2a8db:0x648ca9837943c374!2m2!1d80.2451984!2d13.0782023"));
                        break;
                    case 11:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/L.+K+Hospitals+Pvt+Ltd.,+Hyderabad,+Telangana/@17.4514758,78.4653775,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3bcb9bc7030fabe9:0x63f603b2cf719f99!2m2!1d78.535418!2d17.451488"));
                        break;
                    case 12:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/M+G+A+Hospital,+Bengaluru,+Karnataka/@12.9569081,77.6301989,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3bae123339b6e375:0x954522f34f627e33!2m2!1d77.7002394!2d12.9569175"));
                        break;
                    case 13:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/N+M+Wadia+Institute+Of+Cardiology,+Pune,+Maharashtra/@18.5071155,73.785663,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3bc2c0f82653bf87:0xe8a9c7f4c58f1c66!2m2!1d73.8557035!2d18.5071284"));
                        break;
                    case 14:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/Oberoi+Hospital,+Gurdaspur,+Punjab/@31.3232598,75.4966816,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x391a5af11aaaaaab:0x97b27b6069c5e99!2m2!1d75.5667218!2d31.3232788"));
                        break;
                    case 15:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/Patil+Hospital,+Bengaluru,+Karnataka/@13.0090548,77.6267797,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3bae110700dc7b65:0x994db4c093eabda0!2m2!1d77.6968202!2d13.0090642"));
                        break;
                    case 16:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/Queens+Hospital,+Bengaluru,+Karnataka/@12.9072325,77.57552,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3bae14997964073f:0x1dfecaa4f6fc7b31!2m2!1d77.6455605!2d12.9072418"));
                        break;
                    case 17:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/R+K+Orthopedic+%26+Trauma+Center,+Bikaner,+Rajasthan/@28.0162293,73.2661417,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x393fdd887261667d:0x1641ff2d6c7e375d!2m2!1d73.336182!2d28.0162471"));
                        break;
                    case 18:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/S+P+S+Hospitals,+Ludhiana,+Punjab/@30.8836994,75.817555,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x391a82daad998293:0xfb700ee14b2bfd7b!2m2!1d75.8875952!2d30.8837183"));
                        break;
                    case 19:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/Talwandi+Hospital+Amritsar,+Amritsar,+Punjab/@31.6289999,74.8161168,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x39197cb2a8ca9a31:0xdee4dd22a196cfcd!2m2!1d74.886157!2d31.629019"));
                        break;
                    case 20:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/Uma+Hospital,+Rajkot,+Gujarat/@22.284318,70.7038066,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x13ff471e7448f423:0x42bc26603bfa63ea!2m2!1d70.773847!2d22.284333"));
                        break;
                    case 21:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/V+K+Global+Hospital,+Paharia,+Opp+Honda+Agency,+Varanasi,+Uttar+Pradesh+221007/@25.3581445,82.9412955,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x398e2e8bad84d223:0x3d56dcc69e934799!2m2!1d83.0113358!2d25.3581611"));
                        break;
                    case 22:
                        intent = new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/Win+Vision+Eye+Hospitals,+Hyderabad,+Telangana/@17.4349008,78.3850665,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3bcb90b7ab341289:0xc1a4a46a3bf8de15!2m2!1d78.455107!2d17.434913"));
                        break;
                    case 23:
                        intent=new Intent(intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://www.google.co.in/maps/dir/''/Yogi+Hospital,+Silvassa,+Dadra+%26+Nagar+Haveli/@20.2792711,72.9378966,12z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x3be0cb5c00000001:0x16e43503a0b158c8!2m2!1d73.007937!2d20.279285"));
                        break;
                    //add more if you have more items in listview
                    //0 is the first item 1 second and so on...
                }
                startActivity(intent);
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
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                SearchDoc.this.adapter.getFilter().filter(cs);
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
}
