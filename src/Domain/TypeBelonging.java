package Domain;

import Domain.Slot;
import Domain.Type;

public class TypeBelonging {
    private Slot slot;
    private Type type;

    public TypeBelonging(Slot slot, Type type){
        this.slot = slot;
        this.type = type;

        type.addSlot(slot);
    }
}
