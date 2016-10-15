package de.baywa.tecb2bwebgwt.client.gin;

import de.baywa.tecb2bwebgwt.client.SessionData;
import de.baywa.tecb2bwebgwt.client.ui.basepage.BasePagePresenter;
import de.baywa.tecb2bwebgwt.client.ui.basepage.BasePageViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.basepage.footer.BasePageFooterImpl;
import de.baywa.tecb2bwebgwt.client.ui.basepage.footer.BasePageFooterPresenter;
import de.baywa.tecb2bwebgwt.client.ui.basepage.header.BasePageHeaderImpl;
import de.baywa.tecb2bwebgwt.client.ui.basepage.header.BasePageHeaderPresenter;
import de.baywa.tecb2bwebgwt.client.ui.navigation.MyNavigationStructure;
import de.baywa.tecb2bwebgwt.client.ui.navigation.NavigationViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.articleupload.ArticleUploadPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.articleupload.ArticleUploadViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.cart.CartPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.cart.CartViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.dealerprofile.DealerProfilePresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.dealerprofile.DealerProfileViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.detailsandsearch.DetailsAndSearchPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.detailsandsearch.DetailsAndSearchViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.gtc.GtcPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.gtc.GtcViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.imprint.ImprintPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.imprint.ImprintViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.login.LoginPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.login.LoginViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.logout.LogoutPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.logout.LogoutView;
import de.baywa.tecb2bwebgwt.client.ui.page.overview.OverviewPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.overview.OverviewViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.privacy.PrivacyPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.privacy.PrivacyViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.quickfind.QuickFindPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.quickfind.QuickFindViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.remindlist.RemindListPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.remindlist.RemindListViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.settings.SettingsPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.settings.SettingsViewImpl;
import de.baywa.tecb2bwebgwt.client.ui.page.sparepartsdocs.SparePartsDocsPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.sparepartsdocs.SparePartsDocsViewImpl;
import de.baywa.tecb2bwebgwt.shared.rpc.LoginLogoutRemoteServiceAsync;

import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import de.knightsoftnet.navigation.client.session.Session;
import de.knightsoftnet.navigation.client.ui.navigation.NavigationPresenter;
import de.knightsoftnet.navigation.client.ui.navigation.NavigationStructure;

public class ApplicationModule extends AbstractPresenterModule {

  @Override
  protected void configure() {
    this.bindPresenter(BasePagePresenter.class, BasePagePresenter.MyView.class,
        BasePageViewImpl.class, BasePagePresenter.MyProxy.class);

    this.bindPresenter(BasePageHeaderPresenter.class, BasePageHeaderPresenter.MyView.class,
        BasePageHeaderImpl.class, BasePageHeaderPresenter.MyProxy.class);
    this.bindPresenter(BasePageFooterPresenter.class, BasePageFooterPresenter.MyView.class,
        BasePageFooterImpl.class, BasePageFooterPresenter.MyProxy.class);

    this.bindPresenter(NavigationPresenter.class, NavigationPresenter.MyView.class,
        NavigationViewImpl.class, NavigationPresenter.MyProxy.class);

    this.bindPresenter(LoginPresenter.class, LoginPresenter.MyView.class, LoginViewImpl.class,
        LoginPresenter.MyProxy.class);
    this.bindPresenter(LogoutPresenter.class, LogoutPresenter.MyView.class, LogoutView.class,
        LogoutPresenter.MyProxy.class);
    this.bindPresenter(ArticleUploadPresenter.class, ArticleUploadPresenter.MyView.class,
        ArticleUploadViewImpl.class, ArticleUploadPresenter.MyProxy.class);
    this.bindPresenter(CartPresenter.class, CartPresenter.MyView.class, CartViewImpl.class,
        CartPresenter.MyProxy.class);
    this.bindPresenter(DealerProfilePresenter.class, DealerProfilePresenter.MyView.class,
        DealerProfileViewImpl.class, DealerProfilePresenter.MyProxy.class);
    this.bindPresenter(DetailsAndSearchPresenter.class, DetailsAndSearchPresenter.MyView.class,
        DetailsAndSearchViewImpl.class, DetailsAndSearchPresenter.MyProxy.class);
    this.bindPresenter(GtcPresenter.class, GtcPresenter.MyView.class, GtcViewImpl.class,
        GtcPresenter.MyProxy.class);
    this.bindPresenter(ImprintPresenter.class, ImprintPresenter.MyView.class, ImprintViewImpl.class,
        ImprintPresenter.MyProxy.class);
    this.bindPresenter(OverviewPresenter.class, OverviewPresenter.MyView.class,
        OverviewViewImpl.class, OverviewPresenter.MyProxy.class);
    this.bindPresenter(PrivacyPresenter.class, PrivacyPresenter.MyView.class, PrivacyViewImpl.class,
        PrivacyPresenter.MyProxy.class);
    this.bindPresenter(QuickFindPresenter.class, QuickFindPresenter.MyView.class,
        QuickFindViewImpl.class, QuickFindPresenter.MyProxy.class);
    this.bindPresenter(RemindListPresenter.class, RemindListPresenter.MyView.class,
        RemindListViewImpl.class, RemindListPresenter.MyProxy.class);
    this.bindPresenter(SettingsPresenter.class, SettingsPresenter.MyView.class,
        SettingsViewImpl.class, SettingsPresenter.MyProxy.class);
    this.bindPresenter(SparePartsDocsPresenter.class, SparePartsDocsPresenter.MyView.class,
        SparePartsDocsViewImpl.class, SparePartsDocsPresenter.MyProxy.class);

    this.bind(NavigationStructure.class).to(MyNavigationStructure.class).in(Singleton.class);

    this.bind(LoginLogoutRemoteServiceAsync.class).in(Singleton.class);
    this.bind(Session.class).to(SessionData.class).in(Singleton.class);
  }
}
