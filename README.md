# myCloud
`这是一个基于SpringCloud分布式框架的Demo。`
- `eureka：注册中心`
- `config：配置中心`
- `zuul：网关`
- `provider：测试接口提供方的实例`
- `customer：测试接口调用方的实例`
- `customer-ribbon：基于ribbon的负载均衡实例`
- `customer-ribbon：基于feign的远程接口调用实例（feign默认集成了ribbon负载均衡）`
- `hystrix-dashboard：hystrix熔断器的web监控集成`
- `foo：测试从配置中心获取配置的实例，开放了actuator的refresh，可在git配置更新后手动调用进而refresh应用配置`
- `foo-cloud-bus：测试从配置中心获取配置的实例，集成了bus消息总线，可在git配置更新后自动refresh应用配置`
- `demo：other test code`

