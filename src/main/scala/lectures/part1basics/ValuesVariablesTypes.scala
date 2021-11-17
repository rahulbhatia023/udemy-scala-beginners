package lectures.part1basics

object ValuesVariablesTypes extends App {

  /**
   * vals are immutable. Once assigned a value cannot be reassigned.
   */
  val x: Int = 42
  println(x)

  /**
   * Will give compile error as x is being reassigned to 2
   */
  // x = 2

  /**
   * Compiler can infer types on its own
   * Semicolons are allowed in scala and is optional to use
   */
  val y = 24;
  println(y)

  /**
   * Use semicolons only when writing multiple expressions in a single line (Not recommended)
   */
  val z = 2; val a = 5

  /**
   * Compilation error: Required Int, Found String
   * Types on both sides should match
   */
  // val z: Int = "Hello"

  /**
   * Basic Data Types
   */
  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = 2
  val aShort: Short = 1234
  val aLong: Long = 12345678912L
  val aDouble: Double = 3.14
  val aFloat: Float = 3.14F

  /**
   * vars are mutable. Once assigned a value, can be reassigned.
   */
  var aVariable: Int = 42
  aVariable = 4
  println(aVariable)

  /**
   * Prefer vals over vars
   * All vals and vars have types
   * Compiler automatically infers types when omitted
   */
}
