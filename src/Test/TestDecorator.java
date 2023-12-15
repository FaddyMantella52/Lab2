package Test;

import Controller.SlotController;
import Domain.Slot;
import Patterns.BonusFeatureDecorator;
import Patterns.ThemeDecorator;
import Repo.SlotRepository;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestDecorator {

    private SlotController slotController;

    @Before
    public void setUp() {
        slotController = new SlotController(new SlotRepository());
    }

    @Test
    public void testDecorator() throws SQLException {
        Slot slot = new Slot(1, "Test Domain.Slot", 1, 1);

        slotController.addSlot(slot);

        assertEquals(1, slotController.getAllSlots().size());
        assertEquals(slot, slotController.findSlotByTitle("Test Domain.Slot"));

        BonusFeatureDecorator bonusDecorator = new BonusFeatureDecorator();
        slot.addDecorator(bonusDecorator);
        slot.decorate();

        ThemeDecorator themeDecorator = new ThemeDecorator();
        slot.addDecorator(themeDecorator);
        slot.decorate();
    }
}
