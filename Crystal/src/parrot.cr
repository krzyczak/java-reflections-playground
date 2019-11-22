require "./parrot/european"
require "./parrot/african"
require "./parrot/norwegian_blue"

module Parrot
  PARROTS_TYPES = ({
    "african_parrot"        => Parrot::African,
    "norwegian_blue_parrot" => Parrot::NorwegianBlue,
  })

  def self.new(type : Symbol, number_of_coconuts : Int32, voltage : Float32, nailed : Bool)
    parrot_class = PARROTS_TYPES.fetch(type.to_s, Parrot::European)
    parrot_class.new(number_of_coconuts, voltage, nailed)
  end
end
