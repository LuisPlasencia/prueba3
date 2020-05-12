package es.ulpgc.eite.cleancode.clickcounter.master;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.app.AppMediator;

public class MasterScreen {

  public static void configure(MasterContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = AppMediator.getInstance();
    MasterState state = mediator.getMasterState();

    MasterContract.Router router = new MasterRouter(mediator);
    MasterContract.Presenter presenter = new MasterPresenter(state);
    MasterContract.Model model = new MasterModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
