package es.ulpgc.eite.cleancode.clickcounter.master;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;

public class MasterModel implements MasterContract.Model {

  public static String TAG = MasterModel.class.getSimpleName();

  private List<CounterData> datasource;
  private int clicks;
  private int counter;

  public MasterModel() {
    datasource = new ArrayList<>();
  }

  @Override
  public List<CounterData> getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return datasource;
  }

  @Override
  public int getStoredClicks() {
    // Log.e(TAG, "getStoredData()");
    return clicks;
  }

  @Override
  public int getStoredCounter() {
    // Log.e(TAG, "getStoredData()");
    return counter;
  }

  @Override
  public void onRestartScreen(List<CounterData> datasource) {
    // Log.e(TAG, "onRestartScreen()");
    this.datasource = datasource;
  }

  @Override
  public void onDataFromNextScreen(int counter, int clicks) {
    // Log.e(TAG, "onDataFromNextScreen()");
    this.clicks = clicks;
    this.counter = counter;
  }

  @Override
  public void onDataFromPreviousScreen(int counter, int clicks) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
    this.counter = counter;
    this.clicks = clicks;
  }
}
