public class ThemeDecorator implements SlotDecorator {
    @Override
    public void decorateSlot(Slot slot) {
        System.out.println("Theme decoration added to slot: " + slot.getTitle());
    }
}
