package de.baywa.tecb2bwebgwt.client;


import com.google.web.bindery.event.shared.EventBus;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.knightsoftnet.gwtp.spring.client.session.AbstractSession;

@Singleton
public class SessionData extends AbstractSession {

  /**
   * constructor injecting fields.
   *
   * @param peventBus event bus
   */
  @Inject
  public SessionData(final EventBus peventBus) {
    super(peventBus);
  }

  @Override
  public void readSessionData() {
    // Nothing to do
  }
}
