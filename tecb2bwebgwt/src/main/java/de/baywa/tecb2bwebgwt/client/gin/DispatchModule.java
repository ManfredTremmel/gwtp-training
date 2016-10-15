package de.baywa.tecb2bwebgwt.client.gin;

import com.google.gwt.inject.client.AbstractGinModule;
import com.gwtplatform.dispatch.rest.client.RestApplicationPath;
import com.gwtplatform.dispatch.rest.client.gin.RestDispatchAsyncModule;

public class DispatchModule extends AbstractGinModule {
  @Override
  protected void configure() {
    final RestDispatchAsyncModule.Builder dispatchBuilder = new RestDispatchAsyncModule.Builder();
    this.install(dispatchBuilder.build());

    this.bindConstant().annotatedWith(RestApplicationPath.class).to("/api/rest");
  }
}
