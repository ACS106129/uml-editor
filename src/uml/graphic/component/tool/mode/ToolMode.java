package uml.graphic.component.tool.mode;

public enum ToolMode {

    Select("Select"), AssociationLine("Association Line"), GeneralizationLine("Generalization Line"),
    CompositionLine("Composition Line"), ClassDiagram("Class Diagram"), UseCaseDiagram("Use Case Diagram");

    private final String name;

    private ToolMode(final String n) {
        name = n;
    }

    @Override
    public String toString() {
        return name;
    }
}
