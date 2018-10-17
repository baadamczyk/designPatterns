package pl.baadamczyk.designpatterns.behavioral.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LawnWateringSystemTest {

  private Subject driver;

  @BeforeEach
  public void setUp() {
    // 1: Create subject object
    driver = new WateringSystemDriver();
  }

  @Test
  public void shouldTurnOnWateringSystem_whenCommandOnDriverIsExecuted() {
    // 2: Create observers and subscribe them with subject
    WateringJet jet1 = new WateringJet(driver, false);
    WateringJet jet2 = new WateringJet(driver, false);

    // 3. Modify subject's contents (in this case 'System State'
    driver.setState(SystemStatus.ON);
    // 4. Send message/event to notify observers about 'System State' change
    driver.sendStatusMessage();

    assertThat(jet1.isSpraying()).isTrue();
    assertThat(jet2.isSpraying()).isTrue();
  }

  @Test
  public void shouldTurnOffWateringSystem_whenCommandOnDriverIsExecuted() {
    WateringJet jet1 = new WateringJet(driver, true);
    WateringJet jet2 = new WateringJet(driver, true);

    driver.setState(SystemStatus.OFF);
    driver.sendStatusMessage();

    assertThat(jet1.isSpraying()).isFalse();
    assertThat(jet2.isSpraying()).isFalse();
  }

  @Test
  public void shouldTurnOffWateringSystem_whenErrorFromJetIsReported() {
      //2: Setup test environment
      WateringJet jet1 = new WateringJet(driver, false);
      WateringJet jet2 = new WateringJet(driver, false);

      driver.setState(SystemStatus.ON);
      driver.sendStatusMessage();

      //3: Report error on Watering Jet
      jet2.reportError();

      assertThat(jet1.isSpraying()).isFalse();
      assertThat(jet2.isSpraying()).isFalse();
      assertThat(driver.getState()).isEqualTo(SystemStatus.OFF);
  }
}
