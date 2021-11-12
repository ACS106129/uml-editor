# UML Editor

## Environment

- [Java OpenJDK 11](https://adoptium.net/?variant=openjdk11)
- [Visual Studio Code](https://code.visualstudio.com)

## Features

### Draw

#### Diagram

Can be drawed anywhere on canvas

Triggered by left mouse press

- Class diagram
- Use case diagram

#### Line

Only can be drawed start from diagram's port to another one's port

Triggered by left mouse drag to attach line

When cursor is entered destination diagram, it will be automatically selected, and vice versa

- Association line
- Composition line
- Generalization line

### Select

#### Single select

With mouse left pressing on target diagram

- It will deselected all selected diagrams except for target diagram

#### Multiple select

Dragging mouse by left button, it will generate a selected area of square

- It will deselected all selected diagrams except for diagrams which are in area
- Select / Deselect will be dynamically reflected according to the area of user dragged

### Combination

#### Group

Several of selected diagrams can be grouped into an union diagram

- It's invalid to group a single diagram

#### Ungroup

Destruct a selected union diagram into several of diagrams

- It's invalid to ungroup lots of diagrams in meantime
- If there is/are line(s) attached to this union diagram, it will be detached and deleted

### Drag

Selected diagram(s) which drawed on canvas can be dragged

- If there is/are line(s) attached on those diagrams, it will be updated same time

### Rename

Selected diagram(s) can be renamed

### Delete

Selected diagram(s) can be deleted

- If there is/are line(s) attached on those diagrams, it will be detached and deleted
- If there is/are union diagram(s) selected, its content(s) will also be deleted

### Exit

Quit program
