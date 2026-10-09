sealed trait Input
case object Coin extends Input
case object Turn extends Input

case class Machine(locked: Boolean, candies: Int, coins: Int)

def transition(input: Input): State[Machine, Unit] = 
    State { machine => 
        val newMachine = input match {
            case Coin =>
                if (machine.candies == 0) machine
                else if (machine.locked) machine.copy(locked = false, coins = machine.coins + 1)
                else machine
            case Turn =>
                if (machine.candies == 0) machine
                else if (!machine.locked) machine.copy(locked = true, candies = machine.candies - 1)
                else machine
        }
        ((), newMachine)
    }

def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)] = 
    for {
        _ <- State.sequence(inputs.map(transition))
        s <- State.get
    } yield (s.coins, s.candies)