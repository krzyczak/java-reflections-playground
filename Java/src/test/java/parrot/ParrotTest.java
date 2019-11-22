package parrot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParrotTest {

    @Test
    public void getSpeedOfEuropeanParrot() {
        Parrot parrot = Parrot.getParrot(ParrotTypeEnum.EUROPEAN, 0, 0, false);
        assertEquals(12.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_One_Coconut() {
        Parrot parrot = Parrot.getParrot(ParrotTypeEnum.AFRICAN, 1, 0, false);
        assertEquals(3.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_Two_Coconuts() {
        Parrot parrot = Parrot.getParrot(ParrotTypeEnum.AFRICAN, 2, 0, false);
        assertEquals(0.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_No_Coconuts() {
        Parrot parrot = Parrot.getParrot(ParrotTypeEnum.AFRICAN, 0, 0, false);
        assertEquals(12.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_nailed() {
        Parrot parrot = Parrot.getParrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 1.5, true);
        assertEquals(0.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_not_nailed() {
        Parrot parrot = Parrot.getParrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 1.5, false);
        assertEquals(18.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_not_nailed_high_voltage() {
        Parrot parrot = Parrot.getParrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 4, false);
        assertEquals(24.0, parrot.getSpeed(), 0.0);
    }
}
