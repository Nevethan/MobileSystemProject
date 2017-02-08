/*
    Inspiration from:
        http://stackoverflow.com/questions/22102588/android-google-map-how-to-check-if-user-is-in-marker-circle-region
        http://stackoverflow.com/questions/31315873/android-how-to-draw-a-circle-on-google-map
        https://www.androidtutorialpoint.com/intermediate/android-map-app-showing-current-location-android/
 */


package com.example.bruger.mobilesystemproject;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.*;
import java.util.jar.Manifest;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener{


    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private Location mLastLocation;
    private Marker mCurrLocationMarker;
    private Circle circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }else{
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }

        //Lists for titles of the positions and coordinates.
        List<String> titles = new ArrayList<String>();
        List<LatLng> LatLngList = new ArrayList<LatLng>();

        //Coordinates for the Markers
        //Adding coordinates in the list.
        LatLngList.add(new LatLng(55.402873, 10.386568));
        LatLngList.add(new LatLng(55.685278, 12.579684));
        LatLngList.add(new LatLng(55.397898, 10.385338));
        LatLngList.add(new LatLng(55.397127, 10.385727));
        LatLngList.add(new LatLng(55.396880, 10.386496));
        LatLngList.add(new LatLng(55.395861, 10.383445));
        LatLngList.add(new LatLng(55.396345, 10.380868));
        LatLngList.add(new LatLng(55.395895, 10.38012));
        LatLngList.add(new LatLng(55.395078, 10.379430));
        LatLngList.add(new LatLng(55.395089, 10.384756));
        LatLngList.add(new LatLng(55.395021, 10.388651));
        LatLngList.add(new LatLng(55.394799, 10.390405));
        LatLngList.add(new LatLng(55.396179, 10.388565));
        LatLngList.add(new LatLng(55.396354, 10.391437));

        //Location titles
        //Adding titles to a list
        titles.add("HogwartsExpress - Platorm 9 3/4");
        titles.add("Internatinal Quidditch-Tournament");
        titles.add("Hogwarts");
        titles.add("Hagrid Story Telling");
        titles.add("The Magical Marketplace");
        titles.add("Diagon Alley");
        titles.add("Scribbles With Rita");
        titles.add("The Chamber of Secrets");
        titles.add("OFF to Hogwarts");
        titles.add("The Leaky Cauldron and Honeydukes");
        titles.add("The Restricted Section of the Library");
        titles.add("Broom Workshop");
        titles.add("The Enchanced Labyrinth");
        titles.add("Snape's Elixir Workshop");

        //Make two for-loops to make all the markers.


        for(int i = 0; i < LatLngList.size(); i++){
            mMap.addMarker(new MarkerOptions().position(LatLngList.get(i)).title(titles.get(i)));

            //Add a circle for the marker, based on the Center. The radius will be with the value 15, and
            // shown with color BLUE
            circle = mMap.addCircle(new CircleOptions().center(LatLngList.get(i))
                    .radius(15)
                    .strokeColor(Color.BLUE));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLngList.get(0)));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

    }


    protected synchronized void buildGoogleApiClient(){
        mGoogleApiClient = new GoogleApiClient.Builder(this).
                addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(5*1000); //Get location data every 5 sec.
        mLocationRequest.setFastestInterval(3*1000); //Fast Interval every 3 sec.
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);


        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }

    }

    @Override
    public void onConnectionSuspended(int i) {


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;

        if(mCurrLocationMarker != null){
            mCurrLocationMarker.remove();
        }

        //If you use a Android device, you can use the phone's gps, and the next line of code should be uncommented.
        //LatLng deviceLocation = new LatLng(location.getLatitude(), location.getLatitude());

        //Since we use a Emulator, the gps tracker is only for one point. We use the coordinates below to demonstrate
        //the purpose of our project.
        LatLng latlng = new LatLng(55.402877, 10.386783); //55.402836, 10.386579
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latlng);
        markerOptions.title("I'm Here");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //Moving the camera to the Location/position
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(20));

        //Check whether the CurrntMarker is inside the radius
        float[] distance = new float[2];

        Location.distanceBetween(mCurrLocationMarker.getPosition().latitude, mCurrLocationMarker.getPosition().longitude,
                circle.getCenter().latitude, circle.getCenter().longitude, distance);

        if(distance[0] > circle.getRadius()){
            Toast.makeText(getApplicationContext(), "You are within range", Toast.LENGTH_LONG).show();
        }else if(distance[0] < circle.getRadius()){
            Toast.makeText(getApplicationContext(), "You are NOT within range", Toast.LENGTH_LONG).show();
        }


        //Stoping location updates
        if(mGoogleApiClient != null){
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    public static final int MY_PERMISSION_REQUEST_LOCATION = 99;

    public void onRequestPermissionsResult(int requestCode, String permissions [], int [] grantResults){

        switch(requestCode){
            case MY_PERMISSION_REQUEST_LOCATION:{
                //The request is annulled if the result array is null
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //Permission is granted

                    if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                        if(mGoogleApiClient == null){
                            buildGoogleApiClient();
                        }

                        mMap.setMyLocationEnabled(true);
                    }
                }else{

                    //In case permission denied, we disable the functions that depends on he permission
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show();
                }
                return;

                //Make other cases, if other permissions need to be checked.
            }
        }
    }
}