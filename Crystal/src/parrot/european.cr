module Parrot
  class European
    def initialize(@number_of_coconuts : Int32, @voltage : Float32, @nailed : Bool)
    end

    def speed
      base_speed
    end

    private def base_speed
      12.0
    end
  end
end
