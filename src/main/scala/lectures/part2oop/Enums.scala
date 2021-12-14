package lectures.part2oop

object Enums extends App {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    def openDocument(): Unit = {
      if (this == READ) println("Opening document...")
      else println("Reading not allowed !!")
    }
  }

  val readPermission: Permissions = Permissions.READ

  println(readPermission) // READ

  readPermission.openDocument() // Opening document...

  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(2)
    case EXECUTE extends PermissionsWithBits(1)
    case NONE extends PermissionsWithBits(0)
  }

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = // do your bit checking
      PermissionsWithBits.NONE
  }

  println(Permissions.READ.ordinal) // 0

  val allPermissions = Permissions.values
  println(allPermissions.mkString(",")) // READ,WRITE,EXECUTE,NONE

  println(Permissions.valueOf("READ")) // READ


  // java.lang.IllegalArgumentException: enum case not found: ABC
  println(Permissions.valueOf("ABC"))
}