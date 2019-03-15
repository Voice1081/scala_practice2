package exercises

import examples.States._

//  Написать крестики-нолики
//  На вход список клетка - игрок
//  По списку проходим последовательно
//  Если клетка, на которую пытаемся сходить - занята,
//  ничего не происходит, ход сгорает, идём дальше
//  Пустой инпут - ничья
//  Вывести рез-т игры для заданных входных данных
//  while, return и var запрещены
//  try catch не использовать
//  5 баллов

object States {

  sealed trait Player

  case object X extends Player

  case object O extends Player

  sealed trait Cell

  case object AA extends Cell

  case object AB extends Cell

  case object AC extends Cell

  case object BA extends Cell

  case object BB extends Cell

  case object BC extends Cell

  case object CA extends Cell

  case object CB extends Cell

  case object CC extends Cell

  case class Game(cells: Map[Cell, Player] = Map())

  type GameState = State[Game, (Cell, Player)]

  val winMsg = (plr: Player) => s"Der Spieler $plr hat gewonnen"
  val standOffMsg = "Unentschieden"

  def play(input: List[(Cell, Player)]): GameState = ???

  def result(g: Game): String = ???

  def main(args: Array[String]): Unit = {
    val game = Game()

    val p = List((AA, O), (CB, X), (BB, O), (AC, X), (BB, O), (CA, X), (CC, O))

    val (_, gm) = play(p).run(game)

    result(gm) == winMsg(O)

    val p2 = List()

    val (_, gm2) = play(p2).run(game)

    result(gm2) == standOffMsg

  }


}