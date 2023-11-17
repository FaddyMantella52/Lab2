public class BonusFeatureDecorator implements SlotDecorator {
    @Override
    public void decorateSlot(Slot slot) {
        System.out.println("Bonus feature added to slot: " + slot.getTitle());
    }
}