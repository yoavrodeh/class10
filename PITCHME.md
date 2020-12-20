# JAVAFX

---
## Today
JavaFX basics:
1. `Stage` -> `Scene` -> `Node`
1. The different layout classes.
1. Automatic resizing.
1. Events
1. Properties and change listeners.
1. `ListView`


---
## Resources
1. Oracle [JavaFX Tutorials](https://docs.oracle.com/javase/8/javase-clienttechnologies.htm).
1. This is a great tutorial from [code.makery](https://code.makery.ch/library/javafx-tutorial/).
1. The [offical documentation](https://docs.oracle.com/javase/8/javafx/api/toc.htm) is always the best for exact details.



---
### JavaFx

The Standard GUI (Graphical User Interface) library for Java.

+ We will work with JavaFX 8.
+ The older library was called Swing, and it is still supported.
+ JavaFX is **HUGE**, and this lecture is an introduction. 
  + To really use its full potential, there is a lot more you can learn.




---
### Features

+ JavaFX provides a rich graphical user interface. 
+ Animation, 2D and 3D geometry, charts, special effects, color gradients, graphical controls, and easy manipulation of audio, video, and images. 
+ Can be coded just in Java, or combined with FXML - an XML language for describing the visual components of an application.
+ Provides a tool called **Scene Builder** that creates FXML files with a drag and drop interface.  


---
@code[java code-max code-noblend](class10/src/First.java)
@[7-21]


---
@img[span-50](class10/resources/First.png)



---
+ Our class is a subclass of `Application`.
+ The code goes inside the overridden `start` method.
  + Don't touch the `main`.
+ `start` gets the primary `Stage`.



---
### `Stage`
Is a window, normally having the three top buttons (minimize, close, maximize).
+ A `Stage` can hold one `Scene`.
+ Its size is normally calculated from the scene's size.
+ A JavaFX application can create additional `Stage` objects if it needs additional windows open. For instance, for dialogs, wizards etc.
+ `show()` displays the `Stage` and `hide()` makes it invisible.

---
### `Scene`
The JavaFX Scene class is the container for all content in a scene graph.
+ Each `Stage` can hold only one `Scene`,
  + but the `Scene` can be changed.
  + Like when moving from the opening screen to the actual game.
+ A scene holds all its content in a **content tree**.



---
@img[span-80](class10/resources/javafx-overview-1.png)


---
### `Node`
All components in a scene graph are subclasses of `Node`.
There are two main types:
+ Leaf nodes, like buttons, text boxes, etc. 
+ Branch nodes (containers), which can contains other nodes as children.

@css[fragment](*for example:*)




---
@img[span-25](class10/resources/Telephone.png)
@img[span-60](class10/resources/scene-graph.png)


@css[fragment](*Let's write the top part:*)




---
@code[java code-max code-noblend](class10/src/Telephone.java)
@[12-22](Standard.)
@[24-30](`getChildren` returns the list of children, and you can manipulate it like any list. Padding is the space inside the border between the border and the contents.)
@[32-39](Like `VBox`, `GridPane` is a layout component.)



---
@img[span-60 bordered](class10/resources/Telephone1.png)

We still have some more work to do...

@css[fragment](*But first let's write a fancy `Label`:*)



---
@code[java code-max code-noblend](class10/src/OneLabel.java)
@[21-32](A `StackPane` is a layout component which by default puts its children in the middle on top of each other.)
@[34-47](A `Label` can have a text and/or a picture. A background can have many `BackgroundFill`s and `BackgroundImage`s.)


---
@img[span-80 bordered](class10/resources/OneLabel.png)



---
+ `Scene` is constructed here without size - it is calculated to fit its content.
+ Each type of container has a different way of adding children, 
  + Normally you can put as many as you want in the constructor.
  + `getChilren()` returns them as an `ObservableList<Node>`. 
    + For now just think of it as a `List`.
    + You can change it to add or remove children.
+ `Insets` is used for padding.


---
@img[span-50](class10/resources/hierarchy.PNG)




---
These are some JavaFX controls.
@img[span-60](class10/resources/uicontrols.png)


---
### Layout

Javafx has automatic layout capabilities.
+ There are a few layout components, each with its own rules.
+ Most nodes are resizable, and they inform their containing component of their preferences.


---
@img[span-70](class10/resources/layouts.png)


---
### Main Layout Components

+ `Pane` does not arrange its children.
+ `VBox` arranges its children one below the other.
+ `HBox` one to the right of the other.
+ `TilePane` makes a grid with all children of equal size.
+ `GridPane` makes a flexible grid, and children can use rectangles in it.


---
+ `BorderPane` has five children: top, bottom, right, left and center. 
  + like a standard desktop application with a menu on top, etc.
+ `FlowPane` arranges children one after another, left to right, and then down a row.
+ `StackPane` puts children one on top of the other.
+ `AnchorPane` can "stick" children to one of the sides, or the center.



---
## Resizing 

JavaFX has very good support for automatic sizing and resizing of its element.
Its much better to use it than doing it yourself!

For that, each `Node` has a maximum, minimum and preferred size. Both for width and for height.


---
### Resizing of the Root
+ Everything that extends `Region` (like all the `Panes`) or `Control` (buttons, etc.) and is set as the root will automatically fit to the Scene. 
  + So setting a button to be the root will make it fit the window.
+ Anything that extends `Group` will not.
+ If you do not want the application to resize with the scene, set the root to be a `Group`.


---
### Resizing of Child Nodes
+ The size of a resizable node (`Region`, `Control`, etc.) will depend on two things:
+ It's own min/pref/max values.
+ The sizing policy of its parent:
+ Layout component size their children automatically, and they do it differently. 

@css[fragment](*for example:*)



---
### VBox
1. It's preferred width is the maximal preferred width of its children.
1. Attempts to set the width of its children to its own width.
  +  but only between their min and max widths.
1. Its minimum width is the max of its children minimum widths.
1. its maximum width is `Double.MAX_VALUE`:
  + Which means its parent may stretch it as much as it wants.
 


---
@code[java code-max code-noblend](class10/src/VBoxExample.java)
@[8-19](usual.)
@[21-29](You can also add children one by one.)





---
@img[span-25 bordered](class10/resources/VBoxExample.png)

+ The preferred width of a `Button` is the text length plus padding.
+ The minimum width is when it's just "...".
+ From the picture above, what is the maximum width?
@css[fragment](it is equal to its preferred size.)


---
@img[span-25 bordered](class10/resources/VBoxExample2.png)

Is the result of adding these lines:
```java code-noblend
b1.setMaxWidth(Double.MAX_VALUE);
b2.setMaxWidth(Double.MAX_VALUE);
b3.setMaxWidth(Double.MAX_VALUE);
```
+ `setMaxWidth(Region.USE_PREF_SIZE)` will disable a node growing beyond its preferred size.


---
We can see how each pane tries to resize its children:

@img[span-60](class10/resources/layouts2.png)

`StackPane` actually tries to make its children fit the whole space.


---
### `GridPane`
+ A child may be placed anywhere within the grid and may span multiple rows/columns.
+ Children may actually overlap.
+ Resizing is similar to `VBox`, except on height as well.
+ `setGridLinesVisible(true)` is useful for debugging.
+ You can set different constraints on columns (as well as rows)



---
Let's make the following with a `GridPane`:

@img[span-50 bordered](class10/resources/GridPaneExample.png)



---
@code[java code-max code-noblend](class10/src/GridPaneExample.java)
@[21-33](The last `add` specifies the size of the rectangle this button takes.)
@[35-38](We can create a column constraint for each column and add them all.)



---
### Constraints
+ `getColumnConstraints()` returns a list of constraints, and you can change it like any list.
+ `ColumnConstraints` has a several `set` methods:
  + `setPercentWidth(double)`, to control the column width as a percent of the grid.
  + `setHalignment(Pos)`, to control alignment.
  + etc.
+ Rows have a similar mechanism.



---
### Hiding Nodes
+ `Node` has methods:
  + `setVisible(boolean)`, if set to false, does not appear, but space is still saved for it.
  + `setManaged(boolean)`, if set to false, everything is calculated as if it's not there.
  + This applies to the node's children as well.



---
## Events
An event represents an occurrence of something of interest to the application:
+ A mouse move,
+ a key press, etc.

In JavaFX, an event is an instance of the `Event` class or any subclass of `Event`.


---
### Event Handlers.

To handle an event of type `T`, first write a class that implements:
```java code-noblend
public interface EventHandler<T extends Event> {
	void handle(T event);
}
```
Then, register an instance of this class to a specific event.

@css[fragment](*for example, a counter will be increased when we press a button:*)




---
@code[java code-max code-noblend](class10/src/OneButton.java)
@[12-22]
@[24-37](Here we make the handler a local class. Why can't `i` be a local variable?)
@[39-46](First line is where we **register** the event handler.)



---
@img[span-35 bordered](class10/resources/OneButton.gif)

@css[fragment](*Another example:*)


---
The screen changes color according to the mouse position:

@img[span-35](class10/resources/MouseMoves.gif)

@css[fragment](*Here is the code:*)




---
@code[java code-max code-noblend](class10/src/MouseMoves.java)
@[11-22]
@[24-38](The handler is an anonymous inner class. It handles `MouseEvent` - which has methods `getSceneX` and `getSceneY`.)


---


@img[span-35 bordered](class10/resources/TwoButtons.gif)

Here, we can capture when the mouse enters the button and when it leaves.



---
@code[java code-max code-noblend](class10/src/TwoButtons.java)
@[12-21]
@[23-31]
@[33-44](`getSource` returns the object where the event occurred. `setStyle` gives another way to change how nodes look.)
@[46-51](Eventually we created 4 instances of `Mouse1`. We could have created only 2.)



---
### More Event Types
+ Keyboard events: Key pressed, key released.
+ Tons of mouse related events, including drag & drop.
+ Touch events for touch-enabled devices.
+ and many more.



---
### Properties
Practically everything you would think is a private member of some javafx class is actually a **Java bean property**.
+ For example, the width of a pane is a `DoubleProperty` and not just a double. 
+ You can "listen" to changes in a property and write a handler for such a change.
+ This is just the tip of the iceberg...



---
### Example
Let's make the following slider with matching label:

@img[span-35 bordered](class10/resources/Slider.gif)

`Slider` has a `value` of type `DoubleProperty`. Therefore it has methods:
+ `setValue(double)`, `double getValue()`.
+ A getter for the property itself: `valueProperty()`.


---
To catch changes in a property (like `value`), we register a listener to it (`T` is the type of property - `Number` in this case):
```java code-noblend
interface ChangeListener<T> {
	void changed(ObservableValue<? extends T> observable, 
		T oldValue, T newValue);
}
```
+ `observable` here is `value` itself (the property).  
+ `newValue` is most likely the only thing you are going to need.



---
@code[java code-max code-noblend](class10/src/SliderExample.java)
@[11-22]
@[24-31](Creating the slider and setting how it looks.)
@[33-42](Our listener only cares about the new value.)



---
### `ListView<T>`
+ Is a component for displaying a list.
+ It contains an `ObservableList<T>` which is basically the same as `List<T>`, except we can attach listeners to it.
+ JavaFX uses this, and whenever the list changes, it automatically updates the screen.


---
@img[span-30 bordered](class10/resources/listView.gif)



---
@code[java code-max code-noblend](class10/src/ListExample.java)
@[13-24]
@[26-30]
@[32-40](The `selectedItemProperty` is the member of the list that is selected, and is a `Property`, so we can listen to changes in it.)
@[42-50](Pressing the button only adds to the inner list, but this magically appears on the screen.)


---
### CSS Styling
+ CSS is short for **Cascading Style Sheets**.
+ It is the standard way the style on Internet pages is written.
+ Very easy to use, and separates the code from the design.
+ JavaFX supports both loading of external CSS files, and setting specific nodes styles with this format.
  + Remember the `setStyle` command we saw? 


---
### Tips
+ Be careful with your `import` statements,
  + they should all start with `javafx.`
+ In eclipse **Ctrl-Shift-O** does a lot of the imports automatically,
  + and otherwise asks you which one to choose.
  + **Very** useful when working with JavaFX.
  
