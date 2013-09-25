package it.chalmers.tendu;

import it.chalmers.tendu.network.INetworkHandler;
import it.chalmers.tendu.network.bluetooth.BluetoothHandler;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.badlogic.gdx.backends.android.AndroidApplication;

public class BluetoothActivity extends Activity {

	INetworkHandler bluetoothHandler;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bluetooth);
		
		 bluetoothHandler = new BluetoothHandler(this);
		
		
	}



	public void onHostButtonClicked(View v) {
		bluetoothHandler.hostSession();
	}
	
	public void onJoinButtonClicked(View v) {
		bluetoothHandler.joinGame();
	}

}
