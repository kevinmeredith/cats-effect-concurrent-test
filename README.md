# How to Run Example

1. Run server via `sbt run` to run program
2. `curl localhost:8080/foo`. Verify that the response is immediate
3. Check running program's output

## `curl` output

```
$time(curl -i localhost:8080/bip)
HTTP/1.1 200 OK
Date: Sun, 20 Dec 2020 03:43:02 GMT
Content-Length: 0


real	0m0.014s
user	0m0.004s
sys	0m0.006s
```

## running program's output

```
sbt:concurrent-test-http4s> run
[info] Compiling 1 Scala source to /Users/kevinmeredith/Workspace/concurrent-test-http4s/target/scala-2.12/classes ...
...
[info] Running (fork) net.Main
...
[info] >>> countdown starting @ 2020-12-20T03:42:39.543Z...
[info] >>> countdown completed @ 2020-12-20T03:42:44.567Z...
```