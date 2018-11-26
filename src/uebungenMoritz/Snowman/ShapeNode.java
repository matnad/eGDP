package uebungenMoritz.Snowman;

/**
 * List node for an element of class Shape.
 * Has data and next fields and selectors.
 */
public class ShapeNode {
    private Shape data;         // data of the node
    private ShapeNode next;     // pointer to the next node

    /**
     * Returns the data of this node.
     * @return Content of this node.
     */
    public Shape getData() {
        return data;
    }
    /**
     * Returns the pointer to the next node.
     * @return The next ShapeNode.
     */
    public ShapeNode getNext() {
        return next;
    }
    /**
     * Sets new data for this node.
     * @param newshape Nothing to say.
     */
    void setData(Shape newshape) {
        data=newshape;
    }
    /**
     * Sets the pointer for the next node.
     * @param nextnode Nothing to say.
     */
    void setNext(ShapeNode nextnode) {
        next=nextnode;
    }

    /**
     * Creates a new node with
     * next pointer null.
     * @param s Nothing to say.
     */
    public ShapeNode(Shape s) {
        data = s;
        next = null;
    }
    /**
     * Creates a new node with a
     * given next pointer.
     * @param s Nothing to say.
     * @param n Nothing to say.
     */
    public ShapeNode(Shape s, ShapeNode n) {
        data = s;
        next = n;
    }
}



