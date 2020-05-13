package es.ulpgc.eite.cleancode.clickcounter.detail;

import es.ulpgc.eite.cleancode.clickcounter.app.MasterToDetailState;

public class DetailModel implements DetailContract.Model {

  public static String TAG = DetailModel.class.getSimpleName();

  private int counter;
  private int clicks;

  @Override
  public int getStoredCounter() {
    // Log.e(TAG, "getStoredData()");
    return counter;
  }

  @Override
  public int getStoredClicks() {
    // Log.e(TAG, "getStoredData()");
    return clicks;
  }

  @Override
  public void onRestartScreenClicks(int clicks) {
    // Log.e(TAG, "onRestartScreen()");
    this.clicks = clicks;
  }

  @Override
  public void onRestartScreenCounter(int counter){
    this.counter = counter;
  }

  @Override
  public void onDataFromNextScreen(String data) {
    // Log.e(TAG, "onDataFromNextScreen()");

  }

  @Override
  public void onDataFromPreviousScreen(MasterToDetailState masterToDetailState) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
    this.counter = masterToDetailState.counter +1 ;
    this.clicks = masterToDetailState.clicks +1;
  }
}
