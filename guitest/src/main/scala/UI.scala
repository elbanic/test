import scala.swing._
import java.awt.{Font,Color}

class UI extends MainFrame {
  title = "Clock #1"
  preferredSize = new Dimension(320, 160)
  private var lastTime = Time.current
  private val clock = new Label(lastTime) {
    foreground = new Color(0, 0, 160)
    font = new Font("SansSerif", Font.PLAIN, 64)
  }
  contents = clock
  Timer(200) { tick() }
  Timer(10000, false) { println("Clock has been running for 10 seconds!") }

  def tick() {
    // this method is called every 100 milliseconds
    val newTime = Time.current
    if (newTime != lastTime) {
      clock.text = newTime
      lastTime = newTime
    }
  }
}