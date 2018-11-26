package uebungenMoritz.Snowman;


/**
 * This is the container class for a list
 * of Shape objects. It has the head of the list
 * and list manipulating methods.
 */
public class ShapeList {
    private ShapeNode head;    // the head of the list

    /**
     * Creates an empty list.
     */
    public ShapeList() {
        head = null;    // null represents the empty list
    }

    /**
     * Returns the first node of the list
     * @return The head of the list
     */
    public ShapeNode getHead() {
        return head;
    }

    /**
     * Adds an element at the top of the list
     * @param elem Nothing to say.
     */
    public void insertFirst(Shape elem)
    {
        // Create a new list cell
        // with next pointe on the old head
        ShapeNode tmp = new ShapeNode(elem, head);
        // set new head
        head = tmp;
    }
}



