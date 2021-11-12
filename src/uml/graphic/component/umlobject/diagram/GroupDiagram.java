package uml.graphic.component.umlobject.diagram;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import uml.graphic.component.umlobject.diagram.content.GroupDiagramContent;

public class GroupDiagram extends Diagram {

    private List<Diagram> diagrams;

    public GroupDiagram(final List<Diagram> diagrams) {
        super(Arrays.stream(diagrams.stream().map(d -> d.portMap.values().stream().mapToInt(p -> p.size).toArray())
                .reduce((s1, s2) -> {
                    final int avg[] = new int[s1.length];
                    Arrays.setAll(avg, i -> (s1[i] + s2[i]) / 2);
                    return avg;
                }).orElseThrow()).boxed().collect(Collectors.toList()),
                diagrams.stream().map(d -> d.getContentBounds().orElseThrow().getLocation())
                        .reduce((p1, p2) -> new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y))).orElseThrow(),
                new GroupDiagramContent(diagrams.stream().map(d -> d.getContentBounds().orElseThrow())
                        .reduce((r1, r2) -> r1.union(r2)).orElseThrow().getSize()));
        this.diagrams = diagrams;
        final Point pos = getLocation();
        diagrams.forEach(d -> {
            final Point childPos = d.getLocation();
            d.setSelect(false);
            d.setLocation(childPos.x - pos.x, childPos.y - pos.y);
            GroupDiagram.this.add(d);
        });
    }

    public List<Diagram> ungroup() {
        // detach all lines which attached to this group diagram
        detachAllLines();
        final Point pos = getLocation();
        diagrams.forEach(d -> {
            final Point childPos = d.getLocation();
            d.setSelect(false);
            d.setLocation(childPos.x + pos.x, childPos.y + pos.y);
            GroupDiagram.this.remove(d);
        });
        removeAll();
        return diagrams;
    }
}
