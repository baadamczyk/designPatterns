package pl.baadamczyk.designpatterns.structural.proxy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SecurityProxyTest {

  @Test
  public void shouldRejectPasswordOfInvalidLength_whenSetPasswordRequestIsMade() {
    CredentialService service =
        (CredentialService) SecurityProxy.newInstance(new CredentialServiceImplementation());

    assertThatExceptionOfType(Exception.class)
        .isThrownBy(() -> service.setPassword("ps"))
        .withMessage("Functionality disabled!");
  }
}
