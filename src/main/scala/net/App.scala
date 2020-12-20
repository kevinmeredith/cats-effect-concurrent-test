package net

import cats.implicits._
import cats.effect.{Concurrent, IO, Timer}
import java.time.Instant
import org.http4s._
import scala.concurrent.duration._

object App {

  def app[F[_] : Timer : Concurrent]: HttpApp[F] = HttpApp.apply[F] {
    _: Request[F] =>
      fireAndForget[F].as(Response[F](status = Status.Ok))
  }

  private def fireAndForget[F[_] : Timer : Concurrent]: F[Unit] =
    Concurrent[F].start {
      for {
        before <- Concurrent[F].delay(Instant.now)
        _ <- Concurrent[F].delay(println(s">>> countdown starting @ $before..."))
        _ <- Timer[F].sleep(5.seconds)
        after <- Concurrent[F].delay(Instant.now)
        _ <- Concurrent[F].delay(println(s">>> countdown completed @ $after..."))
      } yield ()
    }.void

}
