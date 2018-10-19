package pl.baadamczyk.designpatterns.behavioral.visitor;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarPartsVisitorTest {

  private Supplier<Stream<Part>> streamSupplier;
  private PartsHandler handler;

  @BeforeEach
  public void setUp() {
    handler = new PartsHandler();
    ArrayList<Part> partsToHandle =
        Lists.newArrayList(
            new ShockAbsorber(), new TimingBelt(), new IgnitionCoil(), new MAPSensor());

    streamSupplier = partsToHandle::stream;
    streamSupplier.get().forEach(p -> handler.addPart(p));
  }

  @Test
  public void shouldDiagnoseParts() {
    handler.accept(new CarPartsDiagnosisVisitor());

    streamSupplier.get().forEach(p -> assertThat(p.isDiagnosed).isTrue());
  }

  @Test
  public void shouldFixWornParts() {
    handler.accept(new CarPartsFixVisitor());

    streamSupplier.get().forEach(p -> assertThat(p.isFixed).isTrue());
  }

  @Test
  public void shouldReplaceWornParts() {
    handler.accept(new CarPartsReplacementVisitor());

    streamSupplier.get().forEach(p -> assertThat(p.isReplaced).isTrue());
  }
}
