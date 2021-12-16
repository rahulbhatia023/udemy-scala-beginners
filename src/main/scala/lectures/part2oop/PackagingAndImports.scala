package lectures.part2oop

import java.lang.Math.*
import java.util.{List as JavaList, *}

package lectures.part2oop.vehicle {
  class Vehicle
}

package lectures.part2oop.vehicleNew {
  class Vehicle
}

object PackagingAndImports extends App {
  class Bike extends lectures.part2oop.vehicle.Vehicle

  class Car extends lectures.part2oop.vehicleNew.Vehicle

  /**
   * Package Object Usage
   */
  sayHello()
  println(SPEED_OF_LIGHT)
}
