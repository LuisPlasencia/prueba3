package es.ulpgc.eite.cleancode.clickcounter.master;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.app.DetailToMasterState;
import es.ulpgc.eite.cleancode.clickcounter.app.MasterToDetailState;
import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;

public class MasterPresenter implements MasterContract.Presenter {

  public static String TAG = MasterPresenter.class.getSimpleName();

  private WeakReference<MasterContract.View> view;
  private MasterState state;
  private MasterContract.Model model;
  private MasterContract.Router router;

  public MasterPresenter(MasterState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new MasterState();
    }

  }

  @Override
  public void onRestart() {
    // Log.e(TAG, "onRestart()");

    // update the model if is necessary
    model.onRestartScreen(state.datasource);
  }

  @Override
  public void onResume() {
    // Log.e(TAG, "onResume()");

    // use passed state if is necessary
    DetailToMasterState savedState = router.getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromNextScreen(savedState.counter, savedState.clicks);
    }

    // call the model and update the state
    state.counter = model.getStoredCounter();
    state.clicks = model.getStoredClicks();

    if(state.datasource.size() != 0){
      state.datasource.get(state.posicion).value = state.counter;
    }

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onButtonPressed() {
    // Log.e(TAG, "onButtonPressed()");
    CounterData counterData = new CounterData();
    state.datasource.add(counterData);
    view.get().onDataUpdated(state);
  }

  @Override
  public void onDataClicked(CounterData data) {
    state.clicks++;
    for(int i = 0; i< state.datasource.size(); i++){
      if(state.datasource.get(i).id.intValue() == data.id.intValue()){
        state.posicion = i;
      }
    }
    state.counter = data.value;
    MasterToDetailState masterToDetailState= new MasterToDetailState();
    masterToDetailState.clicks = state.clicks;
    masterToDetailState.counter = state.counter;
    router.passStateToNextScreen(masterToDetailState);
    view.get().navigateToNextScreen();
  }

  @Override
  public void injectView(WeakReference<MasterContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(MasterContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(MasterContract.Router router) {
    this.router = router;
  }
}
