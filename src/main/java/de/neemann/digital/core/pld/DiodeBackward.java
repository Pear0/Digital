package de.neemann.digital.core.pld;

import de.neemann.digital.core.ObservableValue;
import de.neemann.digital.core.element.ElementAttributes;
import de.neemann.digital.core.element.ElementTypeDescription;
import de.neemann.digital.core.element.Keys;

import static de.neemann.digital.core.element.PinInfo.input;

/**
 * A diode needed to pull a wire to ground.
 * Used to build a wired AND.
 */
public class DiodeBackward extends DiodeForeward {

    /**
     * The description
     */
    public static final ElementTypeDescription DESCRIPTION = new ElementTypeDescription(DiodeBackward.class, input("in"))
            .addAttribute(Keys.ROTATE)
            .addAttribute(Keys.BLOWN);


    /**
     * Vreates a new instance
     *
     * @param attr the elements attributes
     */
    public DiodeBackward(ElementAttributes attr) {
        super(attr);
    }

    @Override
    protected void setOutValue(ObservableValue output, boolean in) {
        output.set(in ? 1 : 0, in);
    }

}