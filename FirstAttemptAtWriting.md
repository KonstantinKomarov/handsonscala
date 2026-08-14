➜  handsonscala git:(v2) ✗ cat /etc/*release*
DISTRIB_ID=Zorin
DISTRIB_RELEASE=17
DISTRIB_CODENAME=jammy
DISTRIB_DESCRIPTION="Zorin OS 17.3"
PRETTY_NAME="Zorin OS 17.3"
NAME="Zorin OS"
VERSION_ID="17"
VERSION="17.3"
VERSION_CODENAME=jammy
ID=zorin
ID_LIKE="ubuntu debian"
HOME_URL="https://zorin.com/os/"
SUPPORT_URL="https://help.zorin.com/"
BUG_REPORT_URL="https://zorin.com/os/feedback/"
PRIVACY_POLICY_URL="https://zorin.com/legal/privacy/"
UBUNTU_CODENAME=jammy
➜  handsonscala git:(v2) ✗ 

---

https://adoptium.net/en-GB/temurin/releases?version=21 - Такую java нужно самому прописывать в пути, она не ставится в систему.

---

1.4 Online Materials
Не логично же сделать fork github репозитория и в нём вести все работы

---

Batch да не тот

➜  16.2 - Batch git:(v2) ✗ ../../mill TestBatch.scala
118] Batch.scala:compile0 compiling 1 Scala source to out/Batch.scala/compile0.dest/classes ...
118] [warn] there was 1 deprecation warning; re-run with -deprecation for details
118] [warn] one warning found
118] done compiling
125] TestBatch.scala:compile0 compiling 1 Scala source to out/TestBatch.scala/compile0.dest/classes ...
125] [warn] there was 1 deprecation warning; re-run with -deprecation for details
125] [warn] one warning found
125] done compiling
136] TestBatch.scala:run
sending hello
sending world
sending !
runBatch
response 200 "helloworld"
runBatch
response 200 "!"
TestBatch.scala:16 batchUploader.responseCount: 2
java.lang.AssertionError: assertion failed
        at scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:13)
        at TestBatch$package$.main(TestBatch.scala:19)
        at MillScriptMain_TestBatch_scala$.$anonfun$1(TestBatch.scala:21)
        at mainargs.Invoker$.$anonfun$2(Invoker.scala:77)
        at mainargs.Result.flatMap(Result.scala:13)
        at mainargs.Result.flatMap$(Result.scala:7)
        at mainargs.Result$Success.flatMap(Result.scala:23)
        at mainargs.Invoker$.invoke0(Invoker.scala:77)
        at mainargs.Invoker$.invoke(Invoker.scala:86)
        at mainargs.Invoker$.invokeLocal$1(Invoker.scala:106)
        at mainargs.Invoker$.groupArgs$1$$anonfun$2(Invoker.scala:121)
        at mainargs.Result.flatMap(Result.scala:13)
        at mainargs.Result.flatMap$(Result.scala:7)
        at mainargs.Result$Success.flatMap(Result.scala:23)
        at mainargs.Invoker$.groupArgs$1(Invoker.scala:121)
        at mainargs.Invoker$.runMains(Invoker.scala:126)
        at mainargs.ParserForMethods.runRaw0(Parser.scala:291)
        at mainargs.ParserForMethods.runEither(Parser.scala:179)
        at mainargs.ParserForMethods.runOrExit(Parser.scala:73)
        at MillScriptMain_TestBatch_scala$.main(TestBatch.scala:21)
        at MillScriptMain_TestBatch_scala.main(TestBatch.scala)

136/136, 1 FAILED] ../../mill TestBatch.scala 2s
136] [error] TestBatch.scala:run Subprocess failed

---

Стабилен как гражданский аэрофлот СССР

➜  18.2 - Pipelined git:(v2) ✗ ../../mill -i sync.test
268] sync.test.testForked Running Test Class sync.SyncTests
268] -------------------------------- Running Tests --------------------------------
268] INITIALIZING SRC AND DEST
268] FIRST SYNC
268] WRITING (/home/kvk/Documents/kvk/handsonscala/examples/18.2 - Pipelined/out/sync/test/testForked.dest/sandbox/5997056971817367215/folder1/hello.txt,HELLO)
268] WRITING /home/kvk/Documents/kvk/handsonscala/examples/18.2 - Pipelined/out/sync/test/testForked.dest/sandbox/5997056971817367215/folder1/nested/world.txt
268] HashActor handling: StatInfo(folder1,None)
268] HashActor handling: StatInfo(folder1/hello.txt,None)
268] HashActor handling: StatInfo(folder1/nested/world.txt,None)
268] HashActor handling: StatInfo(folder1/nested,None)
268] FIRST VALIDATION
268] UPDATE SRC
268] HashActor handling: StatInfo(folder1/hello.txt,Some(97253713))
268] HashActor handling: StatInfo(folder1/nested/world.txt,Some(141947953))
268] SECOND VALIDATION
268] + sync.SyncTests.success 3057ms  
268] Tests: 1, Passed: 1, Failed: 0
268] Exception in thread "Thread-1" java.io.EOFException
268]    at java.base/java.io.DataInputStream.readFully(DataInputStream.java:210)
268]    at java.base/java.io.DataInputStream.readInt(DataInputStream.java:385)
268]    at sync.Shared$.receive(Shared.scala:11)
268]    at sync.Sync$.$anonfun$2(Sync.scala:29)
268]    at java.base/java.lang.Thread.run(Thread.java:1583)
268/268, SUCCESS] ../../mill sync.test 5s
➜  18.2 - Pipelined git:(v2) ✗ 