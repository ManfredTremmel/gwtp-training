package de.baywa.tecb2bwebgwt.client.validation;

import de.baywa.tecb2bwebgwt.shared.dto.LoginDto;

import com.google.gwt.core.shared.GWT;

import javax.validation.Validator;

import de.knightsoftnet.validators.client.AbstractGwtValidatorFactory;
import de.knightsoftnet.validators.client.GwtValidation;
import de.knightsoftnet.validators.client.impl.AbstractGwtValidator;

public class ValidatorFactory extends AbstractGwtValidatorFactory {

  /**
   * Validator marker for the Validation Sample project. Only the classes and groups listed in the
   * {@link GwtValidation} annotation can be validated.
   */
  @GwtValidation(value = {LoginDto.class})
  public interface GwtValidator extends Validator {
  }

  @Override
  public final AbstractGwtValidator createValidator() {
    return GWT.create(GwtValidator.class);
  }
}
