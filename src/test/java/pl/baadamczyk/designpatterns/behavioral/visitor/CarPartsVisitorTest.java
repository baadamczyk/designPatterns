package pl.baadamczyk.designpatterns.behavioral.visitor;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CarPartsVisitorTest {

  private Stream<Part> partsStream;
  private PartsHandler handler;

  @BeforeEach
  public void setUp() {
    handler = new PartsHandler();
    ArrayList<Part> partsToHandle =
        Lists.newArrayList(
            new ShockAbsorber(), new TimingBelt(), new IgnitionCoil(), new MAPSensor());

    partsStream = partsToHandle.stream();
  }

  @Test
  public void shouldDiagnoseParts() {
    partsStream.forEach(p -> handler.addPart(p));

    handler.accept(new CarPartsDiagnosisVisitor());

    partsStream.forEach(p -> assertThat(p.isDiagnosed()).isTrue());
  }

  @Test
  public void shouldFixWornParts() {
    partsStream.forEach(p -> handler.addPart(p));

    handler.accept(new CarPartsDiagnosisVisitor());

    partsStream.forEach(p -> assertThat(p.isDiagnosed()).isTrue());
  }

  @Test
  public void shouldReplaceWornParts() {
    partsStream.forEach(p -> handler.addPart(p));

    handler.accept(new CarPartsDiagnosisVisitor());

    partsStream.forEach(p -> assertThat(p.isDiagnosed()).isTrue());
  }
}
