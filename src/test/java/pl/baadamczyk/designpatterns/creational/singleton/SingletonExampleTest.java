package pl.baadamczyk.designpatterns.creational.singleton;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonExampleTest {

    @Test
    public void shouldReturnTheSameInstance() {
        SingletonClass firstInstance = SingletonClass.getInstance();
        SingletonClass secondInstance = SingletonClass.getInstance();

        assertThat(firstInstance == secondInstance).isEqualTo(true);
    }
}