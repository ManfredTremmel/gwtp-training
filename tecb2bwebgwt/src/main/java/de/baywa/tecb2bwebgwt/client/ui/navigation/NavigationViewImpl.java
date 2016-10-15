package de.baywa.tecb2bwebgwt.client.ui.navigation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import de.knightsoftnet.navigation.client.ui.navigation.NavigationEntryInterface;
import de.knightsoftnet.navigation.client.ui.navigation.NavigationPresenter;
import de.knightsoftnet.navigation.client.ui.navigation.NavigationStructure;

import javax.inject.Inject;

public class NavigationViewImpl extends ViewImpl implements NavigationPresenter.MyView {

  /**
   * view interface.
   */
  interface NavigationViewUiBinder extends UiBinder<Widget, NavigationViewImpl> {
  }

  /**
   * navigation main entry.
   */
  @UiField
  FlowPanel navigationMainPoint;

  /**
   * constructor injecting parameters.
   *
   * @param puiBinder ui binder of the page
   */
  @Inject
  public NavigationViewImpl(final NavigationViewUiBinder puiBinder) {
    super();

    this.initWidget(puiBinder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(final NavigationPresenter ppresenter) {
    // we don't need the presenter here
  }

  @Override
  public void createNavigation(final NavigationStructure pnavigation) {
    final int entrieNumber = this.navigationMainPoint.getWidgetCount();
    for (int i = entrieNumber - 1; i >= 0; i--) {
      this.navigationMainPoint.remove(i);
    }
    for (final NavigationEntryInterface entry : pnavigation.getNavigationList()) {
      final InlineHyperlink entryPoint = GWT.create(InlineHyperlink.class);
      entryPoint.setHTML(entry.getMenuValue());
      entryPoint.setTargetHistoryToken(entry.getToken());
      this.navigationMainPoint.add(entryPoint);
    }
  }

  @Override
  public void setSelectedItem(final NavigationEntryInterface pnewEntry) {
    // no highlighting of the active entry
  }
}
