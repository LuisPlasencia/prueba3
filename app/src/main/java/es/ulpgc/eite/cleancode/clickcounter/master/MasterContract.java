package es.ulpgc.eite.cleancode.clickcounter.master;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.clickcounter.app.DetailToMasterState;
import es.ulpgc.eite.cleancode.clickcounter.app.MasterToDetailState;
import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;

public interface MasterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(MasterViewModel viewModel);
    void navigateToNextScreen();

  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void onResume();

    void onStart();

    void onRestart();

    void onBackPressed();

    void onPause();

    void onDestroy();

    void onButtonPressed();

      void onDataClicked(CounterData data);
  }

  interface Model {
    List<CounterData> getStoredData();

    int getStoredClicks();

    int getStoredCounter();

    void onDataFromNextScreen(int counter, int clicks);

    void onRestartScreen(List<CounterData> datasource);

    void onDataFromPreviousScreen(int counter, int clicks);


  }

  interface Router {

    void passStateToNextScreen(MasterToDetailState state);

    DetailToMasterState getStateFromNextScreen();

  }
}
