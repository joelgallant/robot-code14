package edu.first.identifiers;

/**
 * A group of outputs that act as one.
 *
 * @author Joel Gallant <joelgallant236@gmail.com>
 */
public final class OutputGroup implements Output {

    private final Output[] outputs;

    /**
     * Constructs the group with all outputs to use.
     *
     * @param outputs objects to output to
     */
    public OutputGroup(Output[] outputs) {
        this.outputs = outputs;
    }

    /**
     * Sets the value of all elements in the group.
     *
     * @param value value to use
     */
    public void set(double value) {
        for (int x = 0; x < outputs.length; x++) {
            outputs[x].set(value);
        }
    }
}
