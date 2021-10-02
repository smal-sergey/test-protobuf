| Benchmark                                     | Mode | Cnt |    Score   |  Error | Units
| --------------------------------------------- | ---- | --- | ---------- | ------ | -------
| ProtobufBenchmark.testProtoDeserialization    | avgt |  25 |  1732.340  | 76.612 | ns/op
| ProtobufBenchmark.testProtoSerialization      | avgt |  25 |  845.939   |  9.603 | ns/op
| ProtobufBenchmark.testJacksonDeserialization  | avgt |  25 |  7497.046  | 415.660 | ns/op
| ProtobufBenchmark.testJacksonSerialization    | avgt |  25 |  4033.783  |  80.100 | ns/op

Proto serialization faster than Jackson in ~4,8 times

Proto de-serialization faster than Jackson in ~4,3 times

Size of serialized payload also differs ~ 4 times (see com.smalser.test.jmh.JmhRunner)