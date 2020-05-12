package es.ulpgc.eite.cleancode.clickcounter.master;

import es.ulpgc.eite.cleancode.clickcounter.app.AppMediator;
import es.ulpgc.eite.cleancode.clickcounter.app.DetailToMasterState;
import es.ulpgc.eite.cleancode.clickcounter.app.MasterToDetailState;

public class MasterRouter implements MasterContract.Router {

  public static String TAG = MasterRouter.class.getSimpleName();

  private AppMediator mediator;

  public MasterRouter(AppMediator mediator) {
    this.mediator = mediator;
  }


  @Override
  public void passStateToNextScreen(MasterToDetailState state) {
    mediator.setNextMasterScreenState(state);
  }


  @Override
  public DetailToMasterState getStateFromNextScreen() {
    return mediator.getNextMasterScreenState();
  }
}
