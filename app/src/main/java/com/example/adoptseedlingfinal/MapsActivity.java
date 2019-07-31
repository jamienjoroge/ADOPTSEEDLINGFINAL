package com.example.adoptseedlingfinal;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import androidx.fragment.app.FragmentActivity;
import android.view.Window;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

  private GoogleMap mMap;
  private HeatmapTileProvider mProvider;
  private TileOverlay mOverlay;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_maps);

    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
      .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
    //addHeatMap();
  }

  @Override
  protected void onResume(){
    super.onResume();
    //addHeatMap();
  }


  /**
   * Manipulates the map once available.
   * This callback is triggered when the map is ready to be used.
   * This is where we can add markers or lines, add listeners or move the camera. In this case,
   * we just add a marker near Sydney, Australia.
   * If Google Play services is not installed on the device, the user will be prompted to install
   * it inside the SupportMapFragment. This method will only be triggered once the user has
   * installed Google Play services and returned to the app.
   */


  @Override
  public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;


    BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.mipmap.tree2);
    Bitmap b=bitmapdraw.getBitmap();
    Bitmap smallMarker = Bitmap.createScaledBitmap(b, 84, 84, false);


    // Add a marker in whichever location
    LatLng nairobi = new LatLng(-1.2921, 36.8219);
    LatLng karura = new LatLng(-1.2509, 36.8459);
    LatLng kakamega = new LatLng(0.2917, 34.8561);
    LatLng arabukoSokoke = new LatLng(-3.3301, 39.8785);
    LatLng aberdareForest = new LatLng(4, 34);
    LatLng  kayaKinondo  = new LatLng(4.3935,39.5471);
    LatLng  gatamaiyu  = new LatLng(-1,36.44);
    LatLng  kaya  = new LatLng(-3.9333,39.5963);
    LatLng  tigoniWaterfalls  = new LatLng(-1.107778,36.642778);
    LatLng  marsabitNationalPark  = new LatLng(2.1753,37.9573);
    LatLng  ragatiConservancy  = new LatLng(-0.3390,37.2306);


    //view maker on map
    mMap.addMarker(new MarkerOptions().position(nairobi).title( "My Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

    mMap.addMarker(new MarkerOptions().position(karura).title("KARURA FOREST")
      .snippet("36% of the forest contains indigenous upland forest tree species.\n " +
        "The forest is home to some 200 species of bird as well as suni, Harveys Duiker, bushbucks, bush pigs, genets, civets, honey badgers, bush babies, porcupines, Syke's monkeys, bush squirrels, hares, fruit bats, and various reptiles and butterflies." +
        "Plant species typical to the forest include Olea europaea (var. africana), Croton megalocarpus, Warburgia ugandensis, Brachyleana huillensis and the Uvaridendron anisatum")
      .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));

    mMap.addMarker(new MarkerOptions().position(kakamega).title("KAKAMEGA FOREST")
      .snippet(" It is Kenya's only tropical rainforest and is said to be Kenya's last remnant of the ancient Guineo-Congolian rainforest that once spanned the continent.\n" +
      "There are 380 recorded species of plants. This includes 60 species of ferns, 150 species of trees and shrubs, and 170 species of flowering plants including 60 species of orchids with 9 species found only in this forest." +
        "The forest is famous for its birds, bird species have been recorded in the forest such as the west African Great blue turaco and black-and-white-casqued hornbill. At least 9 birds are not found anywhere else.")
      .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));

    mMap.addMarker(new MarkerOptions().position(arabukoSokoke).title("ARABUKO SOKOKE FOREST")
      .snippet("Arabuko-Sokoke Forest Reserve is a 420 km2 coastal forest in Kenya managed by Kenya Forest Service (KFS). It is the largest and most intact coastal forest in East Africa, with 20% of Kenya's bird species, 30% butterfly species and at least 24 rare and endemic bird, mammal and butterfly species." +
        "Arabuko-Sokoke forest is made up of three different forest types;\n" +
        "\n" +
        "Cynometra-dominated forests and thickets: These cover more than half of Arabuko-Sokoke Forest Reserve. Sightings of Caracal, Civet, Genet, Suni and other mammals are more common on tracks in this forest type. Sokoke Scops Owls are also found here.\n" +
        "\n" +
        "Brachystegia-dominated woodlands: Also known as Miombo woodlands, this forest type is airy and beautiful to walk through. Birds and butterflies are more visible here due to the open canopy.\n" +
        "\n" +
        "Mixed Forests: Dominated by species like Hymenaea verrucosa and Manilkara sansibarensis. The dense vegetation in this forest type creates a tropical atmosphere as one walks or drives through, the real feel of being “in the woods”. Animals commonly sighted here include the Golden-rumped Elephant Shrew, East Coast Akalat and Tiny Greenbuls.")
      .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));

    mMap.addMarker(new MarkerOptions().position(aberdareForest).title("ABERDARE FOREST")
      .snippet("This is a 160 km long mountain range of upland, north of Kenya's capital Nairobi with an average elevation of 3,500 metres (11,480 ft)."+
        "\n" +
        "This belt is mostly dominated by pioneer species Macaranga capensis and Newbutonia macrocalyx and runs to the east side of the range. The region is also host to the valuable commercial species including Aningeria adolfi-friederici, Ocotea usambarensis and Syzygium guineense, which are the most conspicuous forest in the Kikuyu escarpment.")
      .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));

    mMap.addMarker(new MarkerOptions().position(kayaKinondo).title("KAYA KINONDO FOREST")
      .snippet("The Kayas today stand as small isolated patches of forest ranging in size from 2ha to 200ha.\n"+
        "The forest is found close to Diani beach, one of the most intensively developed tourists resort on the Kenyan coast.\n"+
        "The forest has more than 187 plant species (all indigenous except one, and two species being rare and endemic to the site), 38 butterfly species among other insects, 42 bird species (migrants, rare and endangered species), a variety of small mammals including the endangered black and white Angolan colobus monkey and the rare zanj elephant shrew")
      .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));

    mMap.addMarker(new MarkerOptions().position(gatamaiyu).title("GATAMAIYU FOREST")
      .snippet("Gatamaiyu Forest covers an area of 4,720 ha, of which 75 % is indigenous forest, 8 % is exotic forest,the rest being bamboo, scrublands and some herbaceous croplands.")
      .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));

    mMap.addMarker(new MarkerOptions().position(kaya).title("KAYA FOREST")
      .snippet("Plant species identified are 187 plant, bird species are 48, and butterflies 45 species.Colobus monkey and Golden-rumped elephant shrew are also reported.")
      .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));

    mMap.addMarker(new MarkerOptions().position(tigoniWaterfalls).title("TIGONI WATERFALLS")
      .snippet("")
      .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));

    mMap.addMarker(new MarkerOptions().position(marsabitNationalPark).title("MARSABIT NATIONAL PARK")
      .snippet("Vegetation: arid thorny bush dominates the lower zone, merging into acacia grassland. Brown olive forest dominates the higher ground. \n" +
        "Wildlife: includes; elephant, buffalo, greater kudu, hyena, Grevy's zebra, dik-dik, reticulated giraffe, lion, leopard and baboon. \n" +
        "Birds: 400 recorded species including 52 of birds of prey.\n" +
        "Roads: use of 2WD is possible during the dry seasons but 4WD is necessary during the rainy seasons.")
      .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));

    mMap.addMarker(new MarkerOptions().position(ragatiConservancy).title("RAGATI CONSERVANCY")
      .snippet("It’s ecosystem includes the Ragati river and its tributaries, and is home to an abundance of wildlife; elephant, buffalo, leopard as well as the rare mountain bongo, crowned eagle and African clawless otter. Home also to some amazing birdlife.")
      .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));


    //move the camera to its location
    mMap.moveCamera(CameraUpdateFactory.newLatLng(nairobi));

    //zoom google map
    mMap.animateCamera(CameraUpdateFactory.zoomTo(7));
  }



  /*
    private void addHeatMap(){
      List<LatLng> list = null;

      // Get the data: latitude/longitude positions of police stations.
      try {
        list = readItems(R.raw.planting_locations);
      } catch (JSONException e) {
        Toast.makeText(this, "Problem reading list of locations.", Toast.LENGTH_LONG).show();
      }

      // Create a heat map tile provider, passing it the latlngs of the police stations.
      mProvider = new HeatmapTileProvider.Builder()
        .data(list)
        .build();
      mProvider.setRadius(HeatmapTileProvider.DEFAULT_RADIUS);


      // Add a tile overlay to the map, using the heat map tile provider.
      mOverlay = mMap.addTileOverlay(new TileOverlayOptions().tileProvider(mProvider));
    }

    private ArrayList<LatLng> readItems ( int resource) throws JSONException {
      ArrayList<LatLng> list = new ArrayList<LatLng>();
      InputStream inputStream = getResources().openRawResource(resource);
      @SuppressWarnings("resource")
      String json = new Scanner(inputStream).useDelimiter("\\A").next();
      JSONArray array = new JSONArray(json);
      for (int i = 0; i < array.length(); i++) {
        JSONObject object = array.getJSONObject(i);
        double lat = object.getDouble("lat");
        double lng = object.getDouble("lng");
        list.add(new LatLng(lat, lng));
      }
      return list;
    }
    */

}
