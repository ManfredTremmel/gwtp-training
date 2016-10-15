package de.baywa.tecb2bwebgwt.client.ui.page.settings;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

/**
 * View of the Settings.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class SettingsViewImpl extends ViewImpl implements SettingsPresenter.MyView {

  interface Binder extends UiBinder<Widget, SettingsViewImpl> {
  }

  private SettingsPresenter presenter;

  @Inject
  public SettingsViewImpl(final Binder pUiBinder) {
    super();
    this.initWidget(pUiBinder.createAndBindUi(this));
  }

  @Override
  public final void setPresenter(final SettingsPresenter pPresenter) {
    this.presenter = pPresenter;
  }

  @UiHandler("language")
  final void onChange(final ValueChangeEvent<String> pChangeEvent) {
    this.presenter.changeLanguage(pChangeEvent.getValue());
  }
}
