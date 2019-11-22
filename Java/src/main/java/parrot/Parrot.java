package parrot;

import java.util.HashMap;

abstract class Parrot {
  public static Parrot getParrotOld(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
    switch (type) {
      case EUROPEAN:
        return new European(numberOfCoconuts, voltage, isNailed);
      case AFRICAN:
        return new African(numberOfCoconuts, voltage, isNailed);
      case NORWEGIAN_BLUE:
        return new NorwegianBlue(numberOfCoconuts, voltage, isNailed);
      default:
        throw new RuntimeException("Should be unreachable");
    }
  }

  public static HashMap<String, Class<? extends Parrot>> parrotTypes;
  static {
      parrotTypes = new HashMap<>();
      parrotTypes.put("EUROPEAN", European.class);
      parrotTypes.put("AFRICAN", African.class);
      parrotTypes.put("NORWEGIAN_BLUE", NorwegianBlue.class);
  }

  public static Parrot getParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
    // Parrot parrot = (Parrot)parrotTypes.get(type.toString()).getDeclaredConstructors()[0].newInstance(numberOfCoconuts, voltage, isNailed);
    Parrot parrot = getParrotOld(type, numberOfCoconuts, voltage, isNailed);

    return parrot;
  }

  protected int numberOfCoconuts;
  protected double voltage;
  protected boolean isNailed;

  public Parrot(int numberOfCoconuts, double voltage, boolean isNailed) {
      this.numberOfCoconuts = numberOfCoconuts;
      this.voltage = voltage;
      this.isNailed = isNailed;
  }

  protected double getBaseSpeed(double voltage) {
    return Math.min(24.0, voltage * getBaseSpeed());
  }

  protected double getLoadFactor() {
    return 9.0;
  }

  protected double getBaseSpeed() {
    return 12.0;
  }

  public abstract double getSpeed();
}

class European extends Parrot {
  public European(int numberOfCoconuts, double voltage, boolean isNailed) {
    super(numberOfCoconuts, voltage, isNailed);
  }

  public double getSpeed() {
    return getBaseSpeed();
  }
}

class African extends Parrot {
  public African(int numberOfCoconuts, double voltage, boolean isNailed) {
    super(numberOfCoconuts, voltage, isNailed);
  }

  public double getSpeed() {
    return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
  }
}

class NorwegianBlue extends Parrot {
  public NorwegianBlue(int numberOfCoconuts, double voltage, boolean isNailed) {
    super(numberOfCoconuts, voltage, isNailed);
  }

  public double getSpeed() {
    return (isNailed) ? 0 : getBaseSpeed(voltage);
  }
}
