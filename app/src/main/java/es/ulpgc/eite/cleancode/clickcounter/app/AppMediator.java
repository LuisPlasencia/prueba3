package es.ulpgc.eite.cleancode.clickcounter.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.clickcounter.detail.DetailState;
import es.ulpgc.eite.cleancode.clickcounter.master.MasterState;

public class AppMediator extends Application {

  private static AppMediator instance;

  private MasterState masterState;
  private DetailState detailState;

  private DetailToMasterState detailToMasterState;
  private MasterToDetailState masterToDetailState;

  @Override
  public void onCreate() {
    super.onCreate();
    detailState= new DetailState();
    masterState= new MasterState();

  }

  public static AppMediator getInstance() {
    if(instance == null){
      instance = new AppMediator();
    }

    return instance;
  }

  public static void resetInstance() {
    instance=null;
  }

  public MasterState getMasterState() {
    return masterState;
  }


  public DetailState getDetailState() {
    return detailState;
  }

  public void setPreviousDetailScreenState(DetailToMasterState state) {
    detailToMasterState=state;
  }

  public MasterToDetailState getPreviousDetailScreenState() {
    return masterToDetailState;
  }

  public void setNextMasterScreenState(MasterToDetailState state) {
    masterToDetailState=state;
  }

  public DetailToMasterState getNextMasterScreenState() {
    return detailToMasterState;
  }
}
