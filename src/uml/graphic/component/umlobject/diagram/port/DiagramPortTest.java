package uml.graphic.component.umlobject.diagram.port;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class DiagramPortTest {

    @Test
    public void test_toString_contains_port_string_within_rangeOfPortSize() {
        IntStream.rangeClosed(0, 100000).forEach(i -> assertTrue(new DiagramPort(i).toString().contains("port")));
    }
}
