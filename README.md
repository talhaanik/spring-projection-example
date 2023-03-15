# spring-projection-example
spring data jpa projection and what will happen if FetchType.LAZY in @ManyToOne Relation
1. http://localhost:8080/emp/show-all Result:Exception
2. add spring.jackson.serialization.FAIL_ON_EMPTY_BEANS=false in application.properties file
result [{"id":1,"name":"Talha","section":{"id":1,"name":"HRMS","hibernateLazyInitializer":{}}}]
3. comment spring.jackson.serialization.FAIL_ON_EMPTY_BEANS=false and add 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) top of Section class
result [{"id":1,"name":"Talha","section":{"id":1,"name":"HRMS"}}]
