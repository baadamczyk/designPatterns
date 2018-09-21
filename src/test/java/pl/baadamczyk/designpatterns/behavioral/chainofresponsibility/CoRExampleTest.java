package pl.baadamczyk.designpatterns.behavioral.chainofresponsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoRExampleTest {

  private Handler manager;
  private Handler director;
  private Handler ceo;

  @BeforeEach
  public void setUp() {
    ceo = new CeoHandler(null);
    director = new DirectorHandler(ceo);
    manager = new ManagerHandler(director);
  }

  @Test
  public void shouldBeApprovedByManager_givenRequestOfAmountLessThan500() {
    RequestResult result = manager.handleRequest(Request.of(400));

    assertThat(result)
        .hasFieldOrPropertyWithValue("amount", 400.0f)
        .hasFieldOrPropertyWithValue("approver", "Manager");
  }

  @Test
  public void shouldBeApprovedByDirector_givenRequestOfAmountLessThan1000() {
    RequestResult result = director.handleRequest(Request.of(900));

    assertThat(result)
        .hasFieldOrPropertyWithValue("amount", 900.0f)
        .hasFieldOrPropertyWithValue("approver", "Director");
  }

  @Test
  public void shouldBeApprovedByCEO_givenRequestGreaterThan1000() {
    RequestResult result = ceo.handleRequest(Request.of(5000));

    assertThat(result)
        .hasFieldOrPropertyWithValue("amount", 5000.0f)
        .hasFieldOrPropertyWithValue("approver", "CEO");
  }
}
