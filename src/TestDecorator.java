import static org.junit.Assert.*;
public class TestDecorator {
    static void test_decorator() {

        SlotRepository slotRepo = new SlotRepository();
        SlotController slotController = new SlotController(slotRepo);

        Slot slot = new Slot();
        slot.setTitle("Test Slot");
        slotController.addSlot(slot);

        assertEquals(1, slotController.getAllSlots().size());
        assertEquals(slot, slotController.findSlotByTitle("Test Slot"));

        BonusFeatureDecorator bonusDecorator = new BonusFeatureDecorator();
        slot.addDecorator(bonusDecorator);
        slot.decorate();

        ThemeDecorator themeDecorator = new ThemeDecorator();
        slot.addDecorator(themeDecorator);
        slot.decorate();
    }
}
