package de.baywa.tecb2bwebgwt.client.ui.navigation;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.web.bindery.event.shared.EventBus;

import de.knightsoftnet.navigation.client.gatekeepers.LoggedInGatekeeper;
import de.knightsoftnet.navigation.client.gatekeepers.LoggedOutGatekeeper;
import de.knightsoftnet.navigation.client.ui.navigation.AbstractNavigationStructure;
import de.knightsoftnet.navigation.client.ui.navigation.NavigationEntry;
import de.knightsoftnet.navigation.client.ui.navigation.NavigationEntryInterface;

import javax.inject.Inject;
import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class MyNavigationStructure extends AbstractNavigationStructure {

  /**
   * gate keeper for pages which are only visible when user is logged in.
   */
  @Inject
  private LoggedInGatekeeper loggedInGatekeeper;
  /**
   * gate keeper for pages which are only visible when user is logged out.
   */
  @Inject
  private LoggedOutGatekeeper loggedOutGatekeeper;

  /**
   * default constructor.
   */
  @Inject
  public MyNavigationStructure(final EventBus peventBus) {
    super(peventBus);
  }

  @Override
  protected final List<NavigationEntryInterface> buildNavigation() {
    final List<NavigationEntryInterface> navigationEntries =
        new ArrayList<>();

    final NavigationConstants navigationConstants = GWT.create(NavigationConstants.class);

    navigationEntries
        .add(new NavigationEntry(SafeHtmlUtils.fromString(navigationConstants.menuQuckFind()),
            NameTokens.QUICKFIND, this.loggedInGatekeeper));
    navigationEntries.add(
        new NavigationEntry(SafeHtmlUtils.fromString(navigationConstants.menuDetailsAndSearch()),
            NameTokens.DETAILSANDSEARCH, this.loggedInGatekeeper));
    navigationEntries
        .add(new NavigationEntry(SafeHtmlUtils.fromString(navigationConstants.menuArticleUpload()),
            NameTokens.ARTICLEUPLOAD, this.loggedInGatekeeper));
    navigationEntries
        .add(new NavigationEntry(SafeHtmlUtils.fromString(navigationConstants.menuDealerProfile()),
            NameTokens.DEALERPROFILE, this.loggedInGatekeeper));
    navigationEntries
        .add(new NavigationEntry(SafeHtmlUtils.fromString(navigationConstants.menuSparePartsDocs()),
            NameTokens.SPAREPARTSDOCS, this.loggedInGatekeeper));
    navigationEntries
        .add(new NavigationEntry(SafeHtmlUtils.fromString(navigationConstants.menuRemindList()),
            NameTokens.REMINDLIST, this.loggedInGatekeeper));
    navigationEntries
        .add(new NavigationEntry(SafeHtmlUtils.fromString(navigationConstants.menuCart()),
            NameTokens.CART, this.loggedInGatekeeper));

    navigationEntries
        .add(new NavigationEntry(SafeHtmlUtils.fromString(navigationConstants.menuLogin()),
            NameTokens.LOGIN, this.loggedOutGatekeeper));

    navigationEntries.add(new NavigationEntry(
        SafeHtmlUtils.fromString(navigationConstants.menuSettings()), NameTokens.SETTINGS, null));

    navigationEntries
        .add(new NavigationEntry(SafeHtmlUtils.fromString(navigationConstants.menuLogout()),
            NameTokens.LOGOUT, this.loggedInGatekeeper));

    return navigationEntries;
  }
}
