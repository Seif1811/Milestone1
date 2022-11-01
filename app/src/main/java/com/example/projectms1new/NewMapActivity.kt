package com.example.projectms1new

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class NewMapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var mapFragment: SupportMapFragment
        lateinit var googleMap: GoogleMap
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_map)
        mapFragment= supportFragmentManager.findFragmentById(R.id.map)as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.

            }
            googleMap.isMyLocationEnabled= true
            val location1= LatLng(29.9868,31.4413)
            googleMap.addMarker(MarkerOptions().position(location1).title("My Location"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,15f))

        })
    }
}