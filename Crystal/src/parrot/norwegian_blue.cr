module Parrot
  class NorwegianBlue < European
    def speed
      (@nailed) ? 0 : compute_base_speed_for_voltage
    end

    private def compute_base_speed_for_voltage
      [24.0, @voltage * base_speed].min
    end
  end
end
