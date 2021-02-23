# Spring Cloud Stream Example

- reactor core 의 여러 기능들이 Deprecated 되면서 Spring Cloud Stream의 여러 Annotation, Class 등도 Deprecated 되었다.

## 본 예제는 Deprecated 된 내용들을 제외한 내용을 제외하고 사용법을 설명한다.

- 전반적으로 @EnableBinding 이나 설정용도의 @Output, @Input 등의 설정들이 간소화 되었다는 느낌이다.

### Prerequisites

```shell
docker run -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:3-management 
```

### Run

- Producer 실행 (localhost:8080/samples)

```shell
gradle :stream-producer:build :stream-producer:bootRun &
```

- Consumer 실행

```shell
gradle :stream-consumer:build :stream-consumer:bootRun &
```

## Test

[Producer]

1. Producer는 samples api를 노출한다.(SampleController)
2. http로 SampleController에 Sample을 RequestBody로 전달한다.
3. SampleController는 SampleProducer를 통해 Message를 발행한다.

[Consumer]

1. Application.yml의 function을 통해 function 을 등록한다.(해당 이름의 Bean을 Mapping한다.)

```yaml
spring:
  cloud:
  function:
    definition: sample-stream
```

2. SampleConsumer를 통해 로그를 출력한다.

```java

@Slf4j
@Component
public class SampleConsumer {

    @Bean("sample-stream")
    public Consumer<Message<Sample>> sampleStream() {
        return message -> log.info("RECV {}", message.getPayload());
    }
}
```

[POST Request to Producer]

```http request

POST localhost:8080/samples
Content-Type: application/json

{
  "id": 1,
  "message": "hello world"
}
```

[Logging at Consumer]

```log
2021-02-23 19:36:30.334  INFO 114956 --- [.potato-group-1] democonsumer.listener.SampleConsumer     : RECV Sample(id=1, message=hello world)
```