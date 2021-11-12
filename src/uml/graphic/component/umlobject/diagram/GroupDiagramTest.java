package uml.graphic.component.umlobject.diagram;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.awt.Point;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import uml.graphic.component.umlobject.diagram.content.ClassDiagramContent;

public class GroupDiagramTest {

    @Test
    public void test_ungroup_with_manyAppended_no_throws() {
        final List<Diagram> diagrams = IntStream.range(0, 3000)
                .mapToObj(i -> new Diagram(10, new Point(), new ClassDiagramContent())).collect(Collectors.toList());
        final GroupDiagram testGroupDiagram1 = new GroupDiagram(diagrams);
        final GroupDiagram testGroupDiagram2 = new GroupDiagramStub(diagrams);
        assertDoesNotThrow(() -> testGroupDiagram1.ungroup());
        assertDoesNotThrow(() -> testGroupDiagram2.ungroup());
    }
}
